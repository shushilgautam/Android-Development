package com.example.csitmentor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChapterListActivity extends AppCompatActivity {
    TextView sub_name,sub_id;
    ArrayList<DataModelForChapter> chapterlist=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_list_layout);
        Intent intent=getIntent();
        String intentName=intent.getStringExtra("subName");
        String intentSubId=intent.getStringExtra("subId");
        sub_name=findViewById(R.id.subName);
        sub_id=findViewById(R.id.subId);
        sub_id.setText(intentSubId);
        sub_name.setText(intentName);
        ListView list=findViewById(R.id.listview);
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("csit/chapters/"+intentSubId);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataModelForChapter value=new DataModelForChapter();
                for(DataSnapshot ds:snapshot.getChildren()){
                    value=ds.getValue(DataModelForChapter.class);
                    chapterlist.add(value);
                }
                list.setAdapter(new CustomClassForChapters(ChapterListActivity.this,chapterlist));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        Log.i("Chapter:Size of array is :",""+chapterlist.size());

    }
}
