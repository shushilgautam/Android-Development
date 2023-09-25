package com.example.csitmentor;

public class DataModel {
    String id;
    String sub_id;
    String sub_name;

    public DataModel(String id, String sub_id, String sub_name) {
        this.id = id;
        this.sub_id = sub_id;
        this.sub_name = sub_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public DataModel(){

    }

}
