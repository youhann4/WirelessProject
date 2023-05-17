package com.example.aiproject;




import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;

import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;


public class GroupChat extends AppCompatActivity {

    Button b1;
    ListView lv;
    EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);
        b1 = findViewById(R.id.sendBtn);
        msg = findViewById(R.id.msg);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        ArrayList al = new ArrayList();
        lv=findViewById(R.id.lv);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(GroupChat.this,"Message Added", Toast.LENGTH_SHORT).show();
                    al.add(msg.getText().toString());
                    ArrayAdapter adapter = new ArrayAdapter(GroupChat.this, android.R.layout.simple_list_item_1,al);
                    lv.setAdapter(adapter);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    Task<Void> ref = database.getReference("messages").setValue(msg.getText().toString());



                }









            });
        };
    }
