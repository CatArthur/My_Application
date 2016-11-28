package com.example.student1.myapplication;

public class Question {
    protected boolean b;
    protected String a;
    Question(){
        b=false;
        a="";
    }
    Question(boolean bb, String aa){
        b=bb;
        a=aa;
    }
    boolean getb(){return b;}
    String geta(){return a;}
}
