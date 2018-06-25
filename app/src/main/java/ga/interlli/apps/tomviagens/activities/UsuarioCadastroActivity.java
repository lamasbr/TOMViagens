package ga.interlli.apps.tomviagens.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import ga.interlli.apps.tomviagens.R;
import ga.interlli.apps.tomviagens.api.UsuarioCadastroService;
import ga.interlli.apps.tomviagens.models.Usuario;

public class UsuarioCadastroActivity extends AppCompatActivity {

    @BindView(R.id.edtNomeCad) TextInputEditText edtNomeCad;
    @BindView(R.id.edtEmailCad) TextInputEditText edtEmailCad;
    @BindView(R.id.edtLoginCad) TextInputEditText edtLoginCad;
    @BindView(R.id.edtSenhaCad) TextInputEditText edtSenhaCad;
    @BindView(R.id.btnCadastrar) Button btnCadastrar;
    @BindView(R.id.btnItnLogin) Button btnItnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_cadastro);
        ButterKnife.bind(this);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNomeCad.getText().toString().isEmpty() || edtEmailCad.getText().toString().isEmpty() ||
                        edtLoginCad.getText().toString().isEmpty() || edtSenhaCad.getText().toString().isEmpty()){
                    Toast.makeText(UsuarioCadastroActivity.this, "Preencha as informações para o cadastro!", Toast.LENGTH_SHORT).show();
                    Log.e("ERRO CADASTRO", "Tentou fazer cadastro sem preencher os campos obrigatórios");
                } else {
                    UsuarioCadastroService usuarioCadastroService = new UsuarioCadastroService();

                    try {
                        Usuario usuario = usuarioCadastroService.execute(edtNomeCad.getText().toString(), edtEmailCad.getText().toString(),
                                edtLoginCad.getText().toString(), edtSenhaCad.getText().toString()).get();

                        if (usuario != null){
                            Log.d("DADOS CADASTRO", "---------");
                            Log.d("ID", String.valueOf(usuario.getId()));
                            Log.d("Nome", usuario.getNome());
                            Log.d("E-mail", usuario.getEmail());
                            Log.d("Login", usuario.getLogin());
                            Log.d("Senha:", usuario.getSenha());
                            Log.d("DADOS CADASTRO", "---------");

                            Toast.makeText(UsuarioCadastroActivity.this, "Cadastro efetuado, faça seu login!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(UsuarioCadastroActivity.this, "Erro ao efetuar cadastro, tente novamente!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e){
                        Log.e("ERRO CADASTRO", e.toString());
                        Toast.makeText(UsuarioCadastroActivity.this, "Erro ao efetuar o cadastro!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnItnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
