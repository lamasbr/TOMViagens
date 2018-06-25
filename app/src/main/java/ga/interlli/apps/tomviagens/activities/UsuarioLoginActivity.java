package ga.interlli.apps.tomviagens.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import ga.interlli.apps.tomviagens.R;
import ga.interlli.apps.tomviagens.api.UsuarioLoginService;
import ga.interlli.apps.tomviagens.models.Usuario;


public class UsuarioLoginActivity extends AppCompatActivity {

    @BindView(R.id.edtLogin) TextInputEditText edtLogin;
    @BindView(R.id.edtSenha) TextInputEditText edtSenha;
    @BindView(R.id.btnFazerLogin) Button btnFazerLogin;
    @BindView(R.id.btnFazerCadastro) Button btnFazerCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_login);
        ButterKnife.bind(this);

        btnFazerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtLogin.getText().toString().isEmpty() || edtSenha.getText().toString().isEmpty()){
                    Toast.makeText(UsuarioLoginActivity.this, "Preencha as informações de login!", Toast.LENGTH_SHORT).show();
                    Log.e("ERRO LOGIN", "Tentou fazer login sem preencher login/senha");
                } else {
                    UsuarioLoginService usuarioLoginService = new UsuarioLoginService();

                    try {
                        Usuario usuario = usuarioLoginService.execute(edtLogin.getText().toString(), edtSenha.getText().toString()).get();

                        if (usuario != null){
                            Log.d("DADOS LOGIN", "---------");
                            Log.d("ID", String.valueOf(usuario.getId()));
                            Log.d("Nome", usuario.getNome());
                            Log.d("E-mail", usuario.getEmail());
                            Log.d("Token", usuario.getToken());
                            Log.d("DADOS LOGIN", "---------");

                            Intent itn = new Intent(getApplicationContext(), MainActivity.class);
                            itn.putExtra("usuario", usuario);
                            startActivity(itn);
                        } else {
                            Toast.makeText(UsuarioLoginActivity.this, "Login ou senha inválidos!", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e){
                        Log.e("ERRO LOGIN", e.toString());
                        Toast.makeText(UsuarioLoginActivity.this, "Erro ao efetuar o login!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
