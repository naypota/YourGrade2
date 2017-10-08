package com.example.user.yourgrade;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button find,exit;
    private EditText score,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find = (Button)findViewById(R.id.Find_Button);
        exit = (Button)findViewById(R.id.Exit_Button);
        score = (EditText)findViewById(R.id.score_EditText);
        name  = (EditText)findViewById(R.id.name_EditText);
        if(name.getText().length()==0){
            name.setError("ป้อนชื่อ");
        }
        if(score.getText().length()==0){
            score.setError("ป้อนคะแนน");
        }
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double n = Double.valueOf(score.getText().toString());
                String score = getGrade(n);
                String name2 = name.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("score",score);
                intent.putExtra("name",name2);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                });
                dialog.show();
            }
        });
    }

    public String getGrade(Double n){
        String score = "";
        if(n<50){
            score="F";
        }else if(n<60){
            score="D";
        }else if(n<70){
            score="C";
        }else if(n<80){
            score="B";
        }else{
            score="A";
        }
        return score;
    }
}
