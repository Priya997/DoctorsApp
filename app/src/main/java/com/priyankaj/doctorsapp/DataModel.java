package com.priyankaj.doctorsapp;


public class DataModel {


    String name;
    String number;
    int id_;
   // int image;

    public DataModel(String name, String number, int id_) {
        this.name = name;
        this.number = number;
        this.id_ = id_;
        //this.image=image;
    }


    public String getName() {
        return name;
    }


    public String getNumber() {
        return number;
    }

    //public int getImage() {return image;}

    public int getId() {
        return id_;
    }
}