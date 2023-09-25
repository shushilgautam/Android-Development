package com.example.csitmentor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class PDFListActivity extends AppCompatActivity {
    TextView sub_name,sub_id;
    ListView list;
    FirebaseStorage fireStorage;
    ArrayList<String> data=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_list_layout);
        Intent intent=getIntent();
        String intentName=intent.getStringExtra("subName");
        String intentSubId=intent.getStringExtra("subId");
        sub_name=findViewById(R.id.subName);
        sub_id=findViewById(R.id.subId);
        sub_id.setText(intentSubId);
        sub_name.setText(intentName);
        list =findViewById(R.id.listview);
        fireStorage.getInstance().getReference("modelquestion/"+intentSubId).listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference sr:listResult.getItems()){
                            data.add(sr.getName());
                        }
                        list.setAdapter(new CustomClassForPDF(PDFListActivity.this,data,intentSubId));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PDFListActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
