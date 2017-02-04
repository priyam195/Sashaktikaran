package com.example.priyamkumar.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;

public class Call extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        //ListView callListView= (ListView) findViewById(R.id.calllist);
        ListView lv=(ListView) findViewById(R.id.calllist);
        LinkedList<Restro> res=new LinkedList<Restro>();
        res.add(new Restro("Sukh sagar","7415152391"));
        res.add(new Restro("KFC","7714075310"));
        res.add(new Restro("bhagat tarachand","9691607080"));
        res.add(new Restro("Madrasi","7716530005"));
        Myadp aa=new Myadp(Call.this, R.layout.custcall, R.id.topic, res);
        lv.setAdapter(aa);





    }
}
