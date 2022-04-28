package com.example.easycalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText num1,num2;
private TextView op,ans;
private Button equal,plus,minus,into,div;
private int option=0;
private int k=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        op=findViewById(R.id.op);
        ans=findViewById(R.id.ans);
        equal=findViewById(R.id.equal);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        into=findViewById(R.id.into);
        div=findViewById(R.id.div);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("+");
                option=1;
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("-");
                option=2;
            }
        });
        into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("X");
                option=3;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("%");
                option=4;
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float res=0;
               float a=Float.parseFloat(num1.getText().toString());
               float b=Float.parseFloat(num2.getText().toString());
               if(option==1)
                   res=a+b;
               else if(option==2)
                   res=a-b;
               else if(option==3)
                   res=a*b;
               else if(option==4) {
                   if(b==0) {
                       Toast.makeText(MainActivity.this, "divide by zero invalid", Toast.LENGTH_SHORT).show();
                   k=0;
                   ans.setText("inf");
                   }
                   else
                   res = a / b;
               }
                   else {
                   Toast.makeText(MainActivity.this, "enter a valid operator", Toast.LENGTH_SHORT).show();
               k=0;
                   }
                   if(k==1)
                   ans.setText(""+res);


            }
        });
    }
}