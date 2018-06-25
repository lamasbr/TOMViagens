package ga.interlli.apps.tomviagens.api;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import ga.interlli.apps.tomviagens.models.Usuario;
import ga.interlli.apps.tomviagens.utils.CadastroData;

/**
 * Created by lincoln.lamas on 25/06/2018.
 */

public class UsuarioCadastroService extends AsyncTask<String, Void, Usuario>{

    private Usuario usuario;
    private final String API = "https://service.davesmartins.com.br/api/usuarios/";

    @Override
    protected Usuario doInBackground(String... strings) {
        try {
            URL url = new URL(API);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setReadTimeout(1000);
            httpsURLConnection.setConnectTimeout(1000);

            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestProperty("Accept", "application/json");
            httpsURLConnection.setRequestMethod("POST");

            // Usa classe POJO CadastroData para converter para JSON (nome, email, login, senha)
            CadastroData cadastroData = new CadastroData(strings[0], strings[1], strings[2], strings[3]);
            String cadastroDataJson = new Gson().toJson(cadastroData);

            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.getOutputStream().write(cadastroDataJson.getBytes());
            httpsURLConnection.connect();

            if(httpsURLConnection.getResponseCode() == 200){
                InputStream responseBody = httpsURLConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                BufferedReader reader = new BufferedReader(responseBodyReader);
                StringBuffer buffer = new StringBuffer();
                String line = "";

                while((line = reader.readLine()) != null){
                    buffer.append(line);
                }

                // Converte JSON retornado pela API para objeto usuario
                usuario = new Gson().fromJson(buffer.toString(), Usuario.class);
                Log.d("JSON API", buffer.toString());
            } else {
                Log.e("ERRO API", String.valueOf(httpsURLConnection.getResponseCode()) + httpsURLConnection.getResponseMessage());
                return null;
            }

        } catch (IOException e){
            Log.e("ERRO API", e.toString());
            return null;
        }

        return usuario;
    }
}
