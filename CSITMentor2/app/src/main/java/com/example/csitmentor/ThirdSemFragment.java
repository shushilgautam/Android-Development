package com.example.csitmentor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ThirdSemFragment extends Fragment {

    public ThirdSemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview= inflater.inflate(R.layout.fragment_third_sem, container, false);
        ListView list=myview.findViewById(R.id.listview3);
        ArrayList<DataModel> data =new ArrayList<DataModel>();
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("csit/sem3");
        // Inflate the layout for this fragment
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataModel value=new DataModel();
                for(DataSnapshot ds:snapshot.getChildren()){
                    value=ds.getValue(DataModel.class);
                    data.add(value);
                }
                list.setAdapter(new CustomClass(getActivity(), data));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return myview;
    }
}