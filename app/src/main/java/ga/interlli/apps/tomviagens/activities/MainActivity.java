package ga.interlli.apps.tomviagens.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import ga.interlli.apps.tomviagens.R;

public class MainActivity extends AppCompatActivity {

    private final int TELA_LOGIN = 1;
    private final int TELA_CADASTRO = 2;

    @BindView(R.id.btnLogin) Button btnLogin;
    @BindView(R.id.btnCadastro) Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), UsuarioLoginActivity.class);
                startActivity(it);
            }
        });

    }
}
