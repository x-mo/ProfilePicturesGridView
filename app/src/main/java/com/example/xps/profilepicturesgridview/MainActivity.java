package com.example.xps.profilepicturesgridview;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gv);
        //, "100002065838195", "738177636", "662932523", "1371382318","100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318","100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318","100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318","100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318","100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318"
        final String[] IDs = {"100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318", "100001143923761", "1388374798", "1224696470", "100002065838195", "738177636", "662932523", "1371382318", "100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318", "100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318", "100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318", "100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318", "100001143923761", "1388374798", "1224696470", "725725727", "100002065838195", "738177636", "662932523", "1371382318"};
        //gv.setAdapter(new ImageAdapter(getApplicationContext(), IDs));

        final ImageAdapter IA = new ImageAdapter(getApplicationContext(), IDs);
        Button butt = (Button) findViewById(R.id.butt);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gv.setAdapter(IA);
                /*try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            IA.notifyDataSetChanged();
                        }
                    }).sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                /*while(IA.getCount()<IDs.length){

                }
                IA.notifyDataSetChanged();*/
            }
        });

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                gv.setAdapter(IA);
                            }
                        }).sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    IA.notifyDataSetChanged();
                }
            }).sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Button butt2 = (Button) findViewById(R.id.butt2);
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IA.notifyDataSetChanged();

            }
        });

    }
}
