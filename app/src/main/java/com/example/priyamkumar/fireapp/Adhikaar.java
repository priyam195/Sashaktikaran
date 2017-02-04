package com.example.priyamkumar.fireapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Adhikaar extends AppCompatActivity {
    RequestQueue requestQueue;
    JSONArray users;
    JSONObject student;
    TextView adhikaarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhikaar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        adhikaarText= (TextView) findViewById(R.id.adhikaarText);
        String showUrl="http://rasiya.esy.es/codeutsav/fetchdata.php";


        requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, showUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    StringBuffer sb = new StringBuffer("");

                    users = response.getJSONArray("user");
                    for(int i=0;i<users.length();i++){
                        student = users.getJSONObject(i);
                        String sug = student.getString("suggestion");
                        sb.append(sug);
                        //your code
                    }
                    adhikaarText.setText(sb.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);




        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
