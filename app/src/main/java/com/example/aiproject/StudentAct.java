package com.example.aiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentAct extends AppCompatActivity {

    Button checkMate,Chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        checkMate = findViewById(R.id.checkMate);
        Chat = findViewById(R.id.TchatBtn);
        checkMate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(),pdfActivity.class);
                startActivity(intent1);
            }
        });

        Chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentAct.this,GroupChat.class);
                startActivity(intent);
            }
        });

    }
}