package com.priyankaj.doctorsapp.model;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public class Appointment {

    private String appointments_id;
    private String name;
    private String mobile;
    private String date;
    private String time;

    public String getAppointments_id() {
        return appointments_id;
    }

    public void setAppointments_id(String appointments_id) {
        this.appointments_id = appointments_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    private String remarks;
    private String regdate;
}
