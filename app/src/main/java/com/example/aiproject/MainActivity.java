package com.example.aiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   // private CustomAdapter mAdpter;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String fromUseridentify;
   // private static ArrayList<FriendlyMessage> mFMessages;
    private String currentUser;
    private RecyclerView mRecyclerView;
    private ImageButton msgBtn;
    private EditText msgText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  msgBtn = findViewById(R.id.msgsendbtn);
       // msgBtn.setOnClickListener(this);

        //msgText = findViewById(R.id.msgedittext);

       // mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
       // LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
      //  mRecyclerView.setLayoutManager(mLinearLayoutManager);



    }
}