package com.priyankaj.doctorsapp.model;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public class MissionAndVision {

    private String mission_id;
    private String mission_text;
    private String status;

    public String getMission_id() {
        return mission_id;
    }

    public void setMission_id(String mission_id) {
        this.mission_id = mission_id;
    }

    public String getMission_text() {
        return mission_text;
    }

    public void setMission_text(String mission_text) {
        this.mission_text = mission_text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    private String create_date;
}
