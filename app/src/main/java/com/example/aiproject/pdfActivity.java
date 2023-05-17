package com.example.aiproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class pdfActivity extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<pdfClass> uploadedPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        listView = findViewById(R.id.ListView);
        uploadedPDF=new ArrayList<>();
        retrievePDFFiles();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pdfClass pdfClass = uploadedPDF.get(i);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("application/pdf");
                intent.setData(Uri.parse(pdfClass.getUrl()));
                startActivity(intent);

            }
        });
    }

    private void retrievePDFFiles() {
        databaseReference= FirebaseDatabase.getInstance().getReference("Uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds: snapshot.getChildren())
                {
                    pdfClass pdfClass = ds.getValue(com.example.aiproject.pdfClass.class);
                    uploadedPDF.add(pdfClass);
                }
                String[] uploadsUrl = new String[uploadedPDF.size()];
                        for(int i = 0; i<uploadsUrl.length; i++){
                            uploadsUrl[i]= uploadedPDF.get(i).getUrl();
                        }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,uploadsUrl){

                            @NonNull
                            @Override
                            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

                                View view = super.getView(position,convertView,parent);
                                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                                textView.setTextColor(Color.WHITE);
                                textView.setTextSize(20);
                                return view;

                            }
                };
                        listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}