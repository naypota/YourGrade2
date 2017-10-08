package com.example.user.yourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String score = intent.getStringExtra("score");
        String name0 = intent.getStringExtra("name");
        TextView name1 = (TextView)findViewById(R.id.Name_TextView);
        TextView score1 = (TextView)findViewById(R.id.score_TextView);
        name1.setText(name0);
        score1.setText(score);
    }
}
