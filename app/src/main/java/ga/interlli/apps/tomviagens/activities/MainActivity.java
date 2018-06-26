package ga.interlli.apps.tomviagens.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import ga.interlli.apps.tomviagens.R;
import ga.interlli.apps.tomviagens.adapter.TodosVoosAdapter;
import ga.interlli.apps.tomviagens.api.TodosVooService;
import ga.interlli.apps.tomviagens.models.Usuario;
import ga.interlli.apps.tomviagens.models.Voo;

public class MainActivity extends AppCompatActivity {

    private final int TELA_PASSAGENS_USUARIO = 1;
    private final int TELA_PASSAGENS_DETALHE = 2;
    private Usuario usuario; private Voo voo;
    private List<Voo> voos;

    @BindView(R.id.btnPassagensUsuario) Button btnPassagensUsuario;
    @BindView(R.id.lvTodosVoos) ListView lvTodosVoos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        TodosVooService todosVooService = new TodosVooService();
        try{
            voos = todosVooService.execute(usuario.getToken()).get();
            Log.d("API VOOS", "List de voos recebida da API");
        } catch (InterruptedException e){
            Toast.makeText(this, "Erro ao obter listagem de voos!", Toast.LENGTH_SHORT).show();
            Log.e("ERRO API", e.toString());
        } catch (ExecutionException e){
            Toast.makeText(this, "Erro ao obter listagem de voos!", Toast.LENGTH_SHORT).show();
            Log.e("ERRO API", e.toString());
        }

        TodosVoosAdapter todosVoosAdapter = new TodosVoosAdapter(this, voos);
        View lvTodosVoosHeader = getLayoutInflater().inflate(R.layout.listview_todosvoos_header, null);
        lvTodosVoos.addHeaderView(lvTodosVoosHeader);
        lvTodosVoos.setAdapter(todosVoosAdapter);

        lvTodosVoos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent itn = new Intent(getApplicationContext(), VooDetalheActivity.class);
                voo = voos.get(position-1);
                itn.putExtra("voo", voo);
                itn.putExtra("usuario", usuario);
                startActivity(itn);
            }
        });

    }
}
