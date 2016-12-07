package com.example.student1.myapplication;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent j=getIntent();
        final int pos[]={j.getIntExtra("pos",0)};

        final Question[] qu={new Question(true,"2X2=4?"),
                new Question(false,"3+3X3=18?"),
                new Question(true,"4X6=3X8?"),
                new Question(false,"144/12=11?"),
                new Question(true, "You win?")};
        final boolean ch[];
        if(j.hasExtra("ch"))
            ch = j.getBooleanArrayExtra("ch");
        else
            ch = new boolean[qu.length];
        ch[pos[0]%ch.length]=j.getBooleanExtra("cheat",false);
        final TextView tw=(TextView)findViewById(R.id.quest);
        final Intent i=new Intent(MainActivity.this,Main2Activity.class);
        Button btnT= (Button)findViewById(R.id.btT);
        tw.setText(qu[pos[0]%qu.length].geta());
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch[pos[0]%ch.length])
                    Toast.makeText(MainActivity.this, "You cheat", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, Check(qu[pos[0]%qu.length],true), Toast.LENGTH_SHORT).show();
            }
        });

        Button btnF= (Button)findViewById(R.id.btF);
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch[pos[0]%ch.length])
                    Toast.makeText(MainActivity.this, "You cheat", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, Check(qu[pos[0]%qu.length],false), Toast.LENGTH_SHORT).show();
            }
        });

        Button btnP= (Button)findViewById(R.id.btP);
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos[0]--;
                pos[0]=(pos[0]>=0?pos[0]:pos[0]+qu.length);
                tw.setText(qu[pos[0]%qu.length].geta());
            }
        });

        Button btnN= (Button)findViewById(R.id.btN);
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos[0]++;
                tw.setText(qu[pos[0]%qu.length].geta());
            }
        });

        Button btc=(Button)findViewById(R.id.btCheat);
        btc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("ch",ch);
                i.putExtra("pos",pos[0]%qu.length);
                i.putExtra("question",qu[pos[0]%qu.length].geta());
                i.putExtra("answer",qu[pos[0]%qu.length].getb());
                startActivity(i);
            }
        });

    }


    String Check(Question q, boolean f){
        return (f==q.getb()?"You win":"You lose");
    }

}
