package com.example.student1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Intent i=getIntent();
        TextView twQ=(TextView)findViewById(R.id.textView);
        twQ.setText(i.getStringExtra("question"));
        Button bt=(Button)findViewById(R.id.btb);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Main2Activity.this,MainActivity.class);
                j.putExtra("pos",i.getIntExtra("pos",0));
                j.putExtra("cheat",true);
                j.putExtra("ch",i.getBooleanArrayExtra("ch"));
                startActivity(j);
            }
        });
        Button bt2=(Button)findViewById(R.id.btA);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, (i.getBooleanExtra("answer",true)?"true":"false"),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
