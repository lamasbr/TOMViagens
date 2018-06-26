package ga.interlli.apps.tomviagens.api;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import ga.interlli.apps.tomviagens.models.Voo;

public class VooDetalheService extends AsyncTask<String, Void, Voo> {

    private Voo voo;
    private final String API = "https://service.davesmartins.com.br/api/voo/";

    @Override
    protected Voo doInBackground(String... strings) {
        try{
            URL url = new URL(API + strings[0]);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setReadTimeout(1000);
            httpsURLConnection.setConnectTimeout(1000);

            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestProperty("Accept", "application/json");
            httpsURLConnection.setRequestProperty("code", strings[1]);
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

                // Converte o JSON retornado pela API em um objeto voo
                voo = new Gson().fromJson(buffer.toString(), Voo.class);
                Log.d("API VOO RETORNO", buffer.toString());
            } else {
                Log.e("ERRO API", String.valueOf(httpsURLConnection.getResponseCode()) + httpsURLConnection.getResponseMessage());
                return null;
            }

        }catch (IOException e){
            Log.e("ERRO API", e.toString());
            return null;
        }

        return voo;
    }
}
