package com.priyankaj.doctorsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public class DoctorAppDetails{

    @SerializedName("Doctor")
    private ArrayList<DoctorDetails> doctorDetails;
    private ArrayList<Appointment> appointment;
    private ArrayList<CategoryDetails> categoryDetails;
    private ArrayList<Logo> logo;

    public ArrayList<DoctorDetails> getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(ArrayList<DoctorDetails> doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public ArrayList<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(ArrayList<Appointment> appointment) {
        this.appointment = appointment;
    }

    public ArrayList<CategoryDetails> getCategoryDetails() {
        return categoryDetails;
    }

    public void setCategoryDetails(ArrayList<CategoryDetails> categoryDetails) {
        this.categoryDetails = categoryDetails;
    }

    public ArrayList<Logo> getLogo() {
        return logo;
    }

    public void setLogo(ArrayList<Logo> logo) {
        this.logo = logo;
    }

    public ArrayList<MissionAndVision> getMissionAndVision() {
        return missionAndVision;
    }

    public void setMissionAndVision(ArrayList<MissionAndVision> missionAndVision) {
        this.missionAndVision = missionAndVision;
    }

    public ArrayList<Slider> getSlider() {
        return slider;
    }

    public void setSlider(ArrayList<Slider> slider) {
        this.slider = slider;
    }

    private ArrayList<MissionAndVision> missionAndVision;
    private ArrayList<Slider> slider;
}
