package com.example.csitmentor;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomClassForChapters extends BaseAdapter {
    Context c;
    ArrayList<DataModelForChapter> data;
    public CustomClassForChapters(Activity chapterListActivity, ArrayList<DataModelForChapter> chapterList) {
        c=chapterListActivity;
        data=chapterList;
    }

    @Override
    public int getCount() {
        return data.size();
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
        View myview= LayoutInflater.from(c).inflate(R.layout.custom_chapter_list,null);
        TextView chapter=myview.findViewById(R.id.sub_name);

        TextView id=myview.findViewById(R.id.id);
        chapter.setText(data.get(i).chapter_name);
        id.setText(""+data.get(i).id);
        return myview;
    }
}
