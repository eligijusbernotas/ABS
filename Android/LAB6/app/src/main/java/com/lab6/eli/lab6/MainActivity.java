package com.lab6.eli.lab6;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> studID = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GautiStudentus studentus = new GautiStudentus();
        studentus.execute("f");
    }

    public void login(View view){
        EditText studentoID =(EditText)findViewById(R.id.studIDText);
        String id = studentoID.getText().toString();
        for(String o : studID){
            Toast.makeText(this, o, Toast.LENGTH_LONG).show();
            if(id.equals(o)){
                Intent naujas = new Intent(this, StudKursai.class);
                naujas.putExtra("studID", id);
                startActivity(naujas);
                return;
            }
        }


    }

    private class GautiStudentus extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... ID){
            String result = "";
            try{
                HttpURLConnection s = (HttpURLConnection) new URL("http://192.168.8.100:8080/5LAB/GetStudentai").openConnection();
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
                final ArrayList<String> listID = new ArrayList<>();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject obj = json.getJSONObject(i);
                    String id = obj.getString("id");
                    listID.add(id);
                }
                studID = listID;

            }catch(Exception e) {

            }
        }
    }
}
