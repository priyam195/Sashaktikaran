package com.example.priyamkumar.fireapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Priyam Kumar on 2/4/2017.
 */

public class Myadp extends ArrayAdapter<Restro> {
    Context ctx;
    List<Restro> restlist;

    public Myadp(Context context, int resource, int textViewResourceId,
                 List<Restro> objects) {
        super(context, resource, textViewResourceId, objects);
        ctx = context;
        restlist = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inf = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View row = inf.inflate(R.layout.custcall, null);
        final TextView tv1 = (TextView) row.findViewById(R.id.topic);
        final TextView tv2 = (TextView) row.findViewById(R.id.phone);
        Button b1 = (Button) row.findViewById(R.id.call);
        Restro r1 = restlist.get(position);
        tv1.setText(r1.name);
        tv2.setText(r1.phoneNo);


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i1 = new Intent(Intent.ACTION_CALL);
                Uri u1 = Uri.parse("tel:" + tv2.getText());
                i1.setData(u1);
//			i1.putExtra("com.android.phone.extra.slot", 0);
                if (ActivityCompat.checkSelfPermission(ctx, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                ctx.startActivity(i1);


            }});
        return row;
    }

}
