package com.example.aiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;
    TextView signUpBtn;

    RadioButton staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.UserLOG);
        password = findViewById(R.id.passwordLOG);
        loginBtn = findViewById(R.id.LoginBtn);
        signUpBtn = findViewById(R.id.signUpBtn);


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()) {

                } else {
                    checkUser();
                }
            }
        });


    }

    public Boolean validateUsername() {
        String val = username.getText().toString();
        if (val.isEmpty()) {
            username.setError("Username cannot be empty");
            return false;

        } else {
            username.setError(null);
            return true;
        }

    }

    public Boolean validatePassword() {
        String val = password.getText().toString();
        if (val.isEmpty()) {
            password.setError("Password cannot be empty");
            return false;

        } else {
            password.setError(null);
            return true;
        }

    }

    public void checkUser() {
        String userName1 = username.getText().toString().trim();
        String userPassword = password.getText().toString().trim();
        String s = "Staff";

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("name").equalTo(userName1);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    username.setError(null);
                    String passwordFromDB = snapshot.child(userName1).child("password").getValue(String.class);
                    String position = snapshot.child(userName1).child("position").getValue(String.class);

                    if (passwordFromDB.equals(userPassword)) {
                        username.setError(null);
                        if (position.equals(s)){
                            username.setError(null);
                            Intent intent = new Intent(Login.this, StaffAct.class);
                            startActivity(intent);

                        } else {
                            Intent intent = new Intent(Login.this, StudentAct.class);
                            startActivity(intent);
                        }



                    } else {
                        password.setError("Invalid credentials");
                        password.requestFocus();
                    }
                } else {
                    username.setError("User doesn't exist");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




}


