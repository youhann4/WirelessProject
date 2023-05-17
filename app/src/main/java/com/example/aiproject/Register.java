package com.example.aiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText Username,email,password;
    Button registerBtn;
    TextView signInBtn;
    RadioButton staff,student;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         Username = findViewById(R.id.FullName);
         email = findViewById(R.id.emailREG);
         password = findViewById(R.id.passwordREG);
         registerBtn = findViewById(R.id.registerBtn);
         signInBtn = findViewById(R.id.signInBtn);
         staff = findViewById(R.id.radioButton3);
         student = findViewById(R.id.radioButton4);





        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });



        registerBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = Username.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                String staff1 = staff.getText().toString();
                String student1 = student.getText().toString();



                if(staff.isChecked()){
                    HelperClass helperClass = new HelperClass(name,email1,password1,staff1);
                    reference.child(name).setValue(helperClass);


                } else {

                    HelperClass helperClass = new HelperClass(name,email1,password1,student1);
                    reference.child(name).setValue(helperClass);

                }


                Toast.makeText(Register.this, "You have signed up successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);



            }
        });



    }
    private TextWatcher registerWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String emailinput = email.getText().toString().trim();
            String passinput = password.getText().toString().trim();
            String nameinput = Username.getText().toString().trim();
            registerBtn.setEnabled(!emailinput.isEmpty() && !passinput.isEmpty() && !nameinput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}