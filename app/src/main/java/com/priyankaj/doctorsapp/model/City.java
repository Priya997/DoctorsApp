package com.priyankaj.doctorsapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Vibhuti on 5/28/2018.
 */

public class City implements Parcelable,Comparable{
    private String city_ids;

    public String getCity_ids() {
        return city_ids;
    }

    public void setCity_ids(String city_ids) {
        this.city_ids = city_ids;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    private String city_name;
    private int doctorCount;

    public int getDoctorCount() {
        return doctorCount;
    }

    public void setDoctorCount(int doctorCount) {
        this.doctorCount = doctorCount;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getCity_ids());
        dest.writeString(getCity_name());
        dest.writeInt(getDoctorCount());
    }

    private City(Parcel in){
        city_ids = in.readString();
        city_name = in.readString();
        doctorCount = in.readInt();
    }

    public static final Parcelable.Creator<City> CREATOR
            = new Parcelable.Creator<City>() {
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        public City[] newArray(int size) {
            return new City[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return city_ids.equals(((City)o).getCity_ids())?1:0;
    }
}
