package com.priyankaj.doctorsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vibhuti on 5/19/2018.
 */

public class Doctors implements Parcelable{

    private String did;
    private String category_id;
    private String qualification;
    private String about;
    private String name;
    private String email;
    private String mobile;
    private String detail;
    private String status;
    private String regdate;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(getDid());
        dest.writeString(getCategory_id());
        dest.writeString(getQualification());
        dest.writeString(getAbout());
        dest.writeString(getName());
        dest.writeString(getEmail());
        dest.writeString(getMobile());
        dest.writeString(getDetail());
        dest.writeString(getStatus());
        dest.writeString(getRegdate());
        dest.writeString(getCategory());
    }

    private Doctors(Parcel in) {
       did = in.readString();
       category_id = in.readString();
       qualification = in.readString();
        about = in.readString();
        name = in.readString();
        email = in.readString();
        mobile = in.readString();
        detail = in.readString();
        status = in.readString();
        regdate = in.readString();
        category = in.readString();

    }


    public static final Parcelable.Creator<Doctors> CREATOR
            = new Parcelable.Creator<Doctors>() {
        public Doctors createFromParcel(Parcel in) {
            return new Doctors(in);
        }

        public Doctors[] newArray(int size) {
            return new Doctors[size];
        }
    };


}
