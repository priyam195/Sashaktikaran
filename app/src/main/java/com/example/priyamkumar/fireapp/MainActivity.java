package com.example.priyamkumar.fireapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
      Button suny,foogy;
    TextView tv;
    DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference();;
   DatabaseReference mcondition=mDatabase.child("condition");
    String s="आईपीएल नीलामी 20 को, खरीदे जाएंगे अधिकतम 76 खिलाड़ी";

    // ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gv= (GridView) findViewById(R.id.gridview);
        suny= (Button) findViewById(R.id.button2);
        foogy= (Button) findViewById(R.id.button3);
       tv= (TextView) findViewById(R.id.tt);

        final ArrayList<Grid> gift=new ArrayList<Grid>();

        gift.add(new Grid(R.drawable.right128, "अधिकार", false,"#C7D0D6"));
        gift.add(new Grid(R.drawable.policy, "योजनाएं", false,"#C7D0D6"));
        gift.add(new Grid(R.drawable.farm, "खेती", false,"#C7D0D6"));
        gift.add(new Grid(R.drawable.health, "स्वास्थ्य/शिक्षा", false,"#C7D0D6"));
        gift.add(new Grid(R.drawable.pottery4, "व्यापार", false,"#C7D0D6"));
        gift.add(new Grid(R.drawable.women, "महिलाएं", false,"#C7D0D6"));
        gift.add(new Grid(R.drawable.job, "नौकरियां", false,"#C7D0D6"));
        gift.add(new Grid(R.drawable.idea, "सुझाव", false,"#C7D0D6"));


        GridAdapter ia=new GridAdapter(MainActivity.this, gift);
        gv.setAdapter(ia);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if(gift.get(arg2).checked==false){
                    gift.get(arg2).checked=true;
                   // LinearLayout all= (LinearLayout) arg1.findViewById(R.id.al);

                    //all.setBackgroundColor(Color.parseColor("#550000FF"));
                }
                else if(gift.get(arg2).checked==true){
                    gift.get(arg2).checked=false;
                   // LinearLayout all=  (LinearLayout) arg1.findViewById(R.id.al);

                   // all.setBackgroundColor(Color.parseColor("#ffffff"));
                }

                if(gift.get(7).checked==true){
                    gift.get(arg2).checked=false;
                    startActivity(new Intent(MainActivity.this,Suggestion.class));
                }

            }

        });





        suny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcondition.setValue("sunny");
            }
        });
        foogy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mcondition.setValue("foogy");
                tv.setText(s);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mcondition.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                tv.setText(text);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
