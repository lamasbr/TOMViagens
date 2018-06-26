package ga.interlli.apps.tomviagens.api;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import ga.interlli.apps.tomviagens.activities.UsuarioLoginActivity;
import ga.interlli.apps.tomviagens.models.Usuario;
import ga.interlli.apps.tomviagens.utils.LoginData;

public class UsuarioLoginService extends AsyncTask<String, Void, Usuario> {

    ProgressDialog dialog;
    Usuario usuario;
    private final String API = "https://service.davesmartins.com.br/api/usuarios/login";

//    @Override
//    protected void onPreExecute(){
//        super.onPreExecute();
//        dialog = ProgressDialog.show(UsuarioLoginActivity.this, "Aguarde", "Efetuando login");
//    }

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

            // Usa classe POJO LoginData para converter para JSON
            LoginData loginData = new LoginData(strings[0], strings[1]);
            String loginDataJson = new Gson().toJson(loginData);

            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.getOutputStream().write(loginDataJson.getBytes());
            httpsURLConnection.connect();

            if (httpsURLConnection.getResponseCode() == 200){
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
                Log.d("API USU RETORNO", buffer.toString());
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
