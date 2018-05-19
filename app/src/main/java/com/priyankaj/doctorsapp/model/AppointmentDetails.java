package com.priyankaj.doctorsapp.model;

/**
 * Created by Vibhuti on 5/19/2018.
 */

public class AppointmentDetails {

    public AppointmentDetails.Appointments getAppointments() {
        return Appointments;
    }

    public void setAppointments(AppointmentDetails.Appointments appointments) {
        Appointments = appointments;
    }

    private Appointments Appointments;

    public class Appointments{

    }
}
