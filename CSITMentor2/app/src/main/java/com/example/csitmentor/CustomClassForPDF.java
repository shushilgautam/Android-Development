package com.example.csitmentor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class CustomClassForPDF extends BaseAdapter {
    Context c;
    ArrayList<String> datalist;
    FirebaseStorage fireStorage;
    String folder;
    public CustomClassForPDF(PDFListActivity pdfListActivity, ArrayList<String> data,String intentSubId) {
        c=pdfListActivity;
        datalist=data;
        folder=intentSubId;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myview= LayoutInflater.from(c).inflate(R.layout.custom_pdf_list,null);
        TextView name=myview.findViewById(R.id.sub_name);
        name.setText(datalist.get(i));
        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireStorage.getInstance().getReference("modelquestion/"+folder).child(name.getText().toString()).getDownloadUrl()
                        .addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Intent i=new Intent(c,PdfViewerActivity.class);
                                i.putExtra("link",uri.toString());
                                c.startActivity(i);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("onFailaure",e.getMessage());
                            }
                        });
            }
        });
        return myview;
    }
}
