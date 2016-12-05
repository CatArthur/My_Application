package com.example.student1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getIntent().getBooleanExtra("question",false);
        Intent i=getIntent();
        TextView twQ=(TextView)findViewById(R.id.textView);
        TextView twA=(TextView)findViewById(R.id.textView2);
        twA.setText((i.getBooleanExtra("answer",false)?"true":"false"));
        twQ.setText(i.getStringExtra("question"));
        Button bt=(Button)findViewById(R.id.btb);
        Button btc=(Button)findViewById(R.id.btCheat);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(j);
            }
        });
    }
}
