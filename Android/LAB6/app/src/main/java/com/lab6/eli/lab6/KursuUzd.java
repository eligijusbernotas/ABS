package com.lab6.eli.lab6;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class KursuUzd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kursu_uzd);
        String kursoKodas = this.getIntent().getStringExtra("kursoKodas");
        GautiUzd uzd = new GautiUzd();
        uzd.execute(kursoKodas);
    }

    private class GautiUzd extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... kodas){
            String result = "";
            try{
                String kursoKodas = kodas[0];
                HttpURLConnection s = (HttpURLConnection) new URL("http://192.168.8.100:8080/5LAB/GetKursoUzduotis?kursoKodas=" + kursoKodas + "&getUzduotys=Submit+Query").openConnection();
                BufferedReader bufRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String out;
                while((out = bufRead.readLine()) != null){
                    result +=out;
                }
                bufRead.close();

            } catch (Exception e){
                e.printStackTrace();
            }
            return result;
        }

        protected  void onPostExecute(String result){
            try {
                JSONArray json = new JSONArray(result);
                ArrayList<String> listPav = new ArrayList<>();
                final ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject obj = json.getJSONObject(i);
                    String pav = obj.getString("pavadinimas");
                    String salyga = obj.getString("salyga");
                    String vertinimoTvarka = obj.getString("vertinimoTvarka");
                    String maxBalai = obj.getString("maxBalai");
                    String terminas = obj.getString("terminas");
                    String galimaIkelti = obj.getString("galimaIkelti");
                    String kursoKodasJ = obj.getString("kursoKodas");
                    listPav.add(pav);
                }
                ListView w = (ListView) findViewById(R.id.UzdList);
                ArrayAdapter adapter = new ArrayAdapter (KursuUzd.this, android.R.layout.simple_list_item_1, listPav);
                w.setAdapter(adapter);
                w.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                    }
                });
            }catch(Exception e) {

            }
        }
}


}

