package com.example.csitmentor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Tag;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class SubjectActivity extends AppCompatActivity {
    TextView sub_name,sub_id;
    ArrayList<String> data=new ArrayList<>();
    Button notes,questions,syllabus,chapters,menu;
    FirebaseStorage fireStorage;
    String link;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_layout);
        Intent intent=getIntent();
        String intentName=intent.getStringExtra("subName");
        String intentSubId=intent.getStringExtra("subId");
        sub_name=findViewById(R.id.subName);
        sub_id=findViewById(R.id.subId);
        sub_id.setText(intentSubId);
        sub_name.setText(intentName);
        notes=findViewById(R.id.notes);
        syllabus=findViewById(R.id.syllabus);
        questions=findViewById(R.id.qsnBank);
        chapters=findViewById(R.id.chapters);
        menu=findViewById(R.id.intentMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SubjectActivity.this,MenuActivity.class);
                startActivity(i);
            }
        });
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String folder="notes";
                loadDataFromFirebase(folder,intentSubId);
            }
        });
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String folder="syllabus";
                loadDataFromFirebase(folder,intentSubId);
            }
        });
        chapters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SubjectActivity.this,ChapterListActivity.class);
                i.putExtra("subName",intentName);
                i.putExtra("subId",intentSubId);
                startActivity(i);
            }
        });
        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SubjectActivity.this,PDFListActivity.class);
                i.putExtra("subName",intentName);
                i.putExtra("subId",intentSubId);
                startActivity(i);

            }
        });

    }

    private void loadDataFromFirebase(String folder, String intentSubId) {
        fireStorage.getInstance().getReference(folder).child(intentSubId+".pdf").getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Intent i=new Intent(SubjectActivity.this,PdfViewerActivity.class);
                        i.putExtra("link",uri.toString());
                        startActivity(i);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("onFailaure",e.getMessage());
                    }
                });

    }
}
