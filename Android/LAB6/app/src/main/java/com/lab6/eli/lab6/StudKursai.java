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

public class StudKursai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_kursai);
        String studentoID = this.getIntent().getStringExtra("studID");
        GautiKursus kursus = new GautiKursus();
        kursus.execute(studentoID);
//        HttpURLConnection s = (HttpURLConnection) new URL();
//        BufferedReader bufRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        String out;
//        while((out = bufRead.readLine()) != null){
//            rez +=out;
//        }
//        bufRead.close();
    }

    private class GautiKursus extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... ID){
            String result = "";
            try{
                String studentoID = ID[0];
                System.out.println(studentoID);
                HttpURLConnection s = (HttpURLConnection) new URL("http://192.168.8.100:8080/5LAB/GetStudentoKursai?stud_id=" + studentoID + "&getKursai=Submit+Query").openConnection();
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
                final ArrayList<String> listKodai = new ArrayList<>();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject obj = json.getJSONObject(i);
                    String kodas = obj.getString("kodas");
                    Toast.makeText(StudKursai.this, kodas, Toast.LENGTH_LONG).show();
                    String pav = obj.getString("pavadinimas");
                    listPav.add(pav);
                    listKodai.add(kodas);
                }
                ListView w = (ListView) findViewById(R.id.kursuSarasas);
                ArrayAdapter adapter = new ArrayAdapter (StudKursai.this, android.R.layout.simple_list_item_1, listPav);
                w.setAdapter(adapter);
                w.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        Intent naujas = new Intent(StudKursai.this, KursuUzd.class);
                        naujas.putExtra("kursoKodas", listKodai.get(position));
                        startActivity(naujas);
                    }
                });
            }catch(Exception e) {

            }
        }
    }
}
