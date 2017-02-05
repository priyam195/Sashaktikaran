package com.example.priyamkumar.fireapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

public class rig extends AppCompatActivity {
    RequestQueue requestQueue;
    JSONArray users;
    JSONObject student;
    TextView adhikaarText;
     String heading;
    String desc;
    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rig);
        Intent intent = getIntent();
        String stiurl = intent.getExtras().getString("url");
        heading=intent.getExtras().getString("key1");
         desc=intent.getExtras().getString("key2");
        lv1 = (ListView) findViewById(R.id.listheading);
        final ArrayList<String> mylist = new ArrayList<String>();

        final ArrayList<String> subheadlist = new ArrayList<String>();
        //adhikaarText= (TextView) findViewById(R.id.adiTextView);
       // String showUrl = "http://rasiya.esy.es/codeutsav/rights.php";


        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, stiurl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {


                    users = response.getJSONArray("user");
                    for (int i = 0; i < users.length(); i++) {
                        student = users.getJSONObject(i);
                        String head = student.getString(heading);
                        //sb.append((i+1)+head);
                        mylist.add(head);
                        String right = student.getString(desc);
                        subheadlist.add(right);
                        // sb.append(right);
                        //your code
                    }
                   // ArrayAdapter<String> aa=new ArrayAdapter<String>(rig.this, android.R.layout.simple_list_item_1,mylist);
                   // lv1.setAdapter(aa);
                    ArrayAdapter<String> aa=new ArrayAdapter<String>(rig.this, android.R.layout.simple_list_item_1, mylist){
                        @Override
                        public View getView(int position, View convertView,
                                            ViewGroup parent) {
                            // TODO Auto-generated method stub
                            View v1= super.getView(position, convertView, parent);
                            TextView txt1=(TextView) v1.findViewById(android.R.id.text1);
                            txt1.setTextColor(Color.parseColor("#145A32"));
                            return v1;
                        }};
                    lv1.setAdapter(aa);



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
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ij = new Intent(rig.this, show.class);
                ij.putExtra("epuzzle",subheadlist.get(i)) ;
                startActivity(ij);
            }
        });


        Toast.makeText(this,"ued",Toast.LENGTH_SHORT);

    }

}
