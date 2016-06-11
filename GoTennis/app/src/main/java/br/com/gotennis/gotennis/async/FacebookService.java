package br.com.gotennis.gotennis.async;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by Luis on 10/04/2016.
 */
public class FacebookService extends AsyncTask<String, Void, Boolean> {

    @Override
    protected Boolean doInBackground(String... params) {

        String URL = "http://gotennis.com.br/API/Server/adduser";
        Boolean executed = false;
        JSONObject jsonobj = new JSONObject();

        try {

            jsonobj.put("id", "null");
            jsonobj.put("idfacebook", "66712");
            jsonobj.put("name", "testeFromApp");
            jsonobj.put("score", "655");

            System.out.println(jsonobj.toString());

            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httppostreq = new HttpPost(URL);

            StringEntity se = new StringEntity(jsonobj.toString());

            httppostreq.setEntity(se);
            HttpResponse httpresponse = httpclient.execute(httppostreq);

            System.out.println("CELESTINO DEBUG");
            System.out.print(EntityUtils.toString(httpresponse.getEntity()));

            executed = true;
        } catch (Exception e) {
            executed = false;
        }
        return executed;
    }
}
