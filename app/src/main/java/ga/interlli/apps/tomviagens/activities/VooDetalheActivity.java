package ga.interlli.apps.tomviagens.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import ga.interlli.apps.tomviagens.R;
import ga.interlli.apps.tomviagens.models.Usuario;
import ga.interlli.apps.tomviagens.models.Voo;

public class VooDetalheActivity extends AppCompatActivity {

    private Usuario usuario; private Voo voo;

    @BindView(R.id.tvDetVooCidadeOrigem) TextView tvDetVooCidadeOrigem;
    @BindView(R.id.tvDetVooAeroportoOrigem) TextView tvDetVooAeroportoOrigem;
    @BindView(R.id.tvDetVooCidadeDestino) TextView tvDetVooCidadeDestino;
    @BindView(R.id.tvDetVooAeroportoDestino) TextView tvDetVooAeroportoDestino;
    @BindView(R.id.tvDetVooDataVoo) TextView tvDetVooDataVoo;
    @BindView(R.id.tvDetVooValorPassagem) TextView tvDetVooValorPassagem;
    @BindView(R.id.tvDetVooPrefixoAviao) TextView tvDetVooPrefixoAviao;
    @BindView(R.id.tvDetVooModeloAviao) TextView tvDetVooModeloAviao;
    @BindView(R.id.tvDetVooAssentosAviao) TextView tvDetVooAssentosAviao;
    @BindView(R.id.btnDetVooComprarPassagem) Button btnDetVooComprarPassagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo_detalhe);
        ButterKnife.bind(this);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        voo = (Voo) getIntent().getSerializableExtra("voo");

        tvDetVooCidadeOrigem.setText(voo.getOrigem().getCidade().toString());
        tvDetVooAeroportoOrigem.setText(voo.getOrigem().getAeroporto().toString());
        tvDetVooCidadeDestino.setText(voo.getDestino().getCidade().toString());
        tvDetVooAeroportoDestino.setText(voo.getDestino().getAeroporto().toString());
        tvDetVooDataVoo.setText(voo.getDataVoo().toString());
        tvDetVooValorPassagem.setText(String.valueOf(voo.getValorPassagem()));
        tvDetVooPrefixoAviao.setText(voo.getAviao().getPrefixo().toString());
        tvDetVooModeloAviao.setText(voo.getAviao().getModelo().toString());
        tvDetVooAssentosAviao.setText(String.valueOf(voo.getAviao().getCapacidade()));

        //btnDetVooComprarPassagem.setText(voo.getOrigem().getCidade().toString());
    }
}
