package com.priyankaj.doctorsapp.model;


import java.util.ArrayList;

public class DoctorDetails {

    public ArrayList<Doctors> getDoctors() {
        return Doctors;
    }

    public void setDoctors(ArrayList<Doctors> doctors) {
        Doctors = doctors;
    }

    private ArrayList<Doctors> Doctors;



}