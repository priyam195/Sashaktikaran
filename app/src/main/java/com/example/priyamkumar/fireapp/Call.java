package com.example.priyamkumar.fireapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import java.util.LinkedList;

public class Call extends AppCompatActivity {

    RequestQueue requestQueue;
    JSONArray users;
    JSONObject student;

    LinkedList<Restro> res=new LinkedList<Restro>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        //ListView callListView= (ListView) findViewById(R.id.calllist);

        final ListView lv=(ListView) findViewById(R.id.calllist);


        String surl="http://rasiya.esy.es/codeutsav/calldetails.php";
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, surl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {


                    users = response.getJSONArray("user");
                    for (int i = 0; i < users.length(); i++) {
                        student = users.getJSONObject(i);
                        String head = student.getString("phoneno");
                        //sb.append((i+1)+head);

                        String right = student.getString("description");

                        res.add(new Restro(right,head));
                       // res.add(new Restro("Sukh sagar","7415152391"));
                        //es.add(new Restro("KFC","7714075310"));
                       // res.add(new Restro("bhagat tarachand","9691607080"));
                       // res.add(new Restro("Madrasi","7716530005"));

                        // sb.append(right);
                        //your code
                    }
                    Myadp aa=new Myadp(Call.this, R.layout.custcall, R.id.topic, res);
                    lv.setAdapter(aa);



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






    }
}
