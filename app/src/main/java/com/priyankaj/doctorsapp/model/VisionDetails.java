package com.priyankaj.doctorsapp.model;


import java.util.ArrayList;

public class VisionDetails {

    public ArrayList<Vision> getVision() {
        return Vision;
    }

    public void setVision(ArrayList<Vision> vision) {
        this.Vision = vision;
    }

    private ArrayList<Vision> Vision;

    public class Vision{
        private String mission_text;

        public String getDetail() {
            return mission_text;
        }

        public void setDetail(String detail) {
            this.mission_text = detail;
        }

    }

}