package com.priyankaj.doctorsapp.model;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public class Logo {

    private String logo_id;
    private String logo_text;
    private String status;

    public String getLogo_id() {
        return logo_id;
    }

    public void setLogo_id(String logo_id) {
        this.logo_id = logo_id;
    }

    public String getLogo_text() {
        return logo_text;
    }

    public void setLogo_text(String logo_text) {
        this.logo_text = logo_text;
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
