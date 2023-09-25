package com.example.csitmentor;

public class DataModelForChapter {
    int id;
    String chapter_name;

    public DataModelForChapter(int id, String chapter_name) {
        this.id = id;
        this.chapter_name = chapter_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }
    public DataModelForChapter(){

    }
}
