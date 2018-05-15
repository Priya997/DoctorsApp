package com.priyankaj.doctorsapp.model;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public class Slider {

    private String slider_id;

    public String getSlider_id() {
        return slider_id;
    }

    public void setSlider_id(String slider_id) {
        this.slider_id = slider_id;
    }

    public String getSlider_text() {
        return slider_text;
    }

    public void setSlider_text(String slider_text) {
        this.slider_text = slider_text;
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

    private String slider_text;
    private String status;
    private String create_date;
}
