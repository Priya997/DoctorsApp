package com.priyankaj.doctorsapp.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Vishal Sehgal on 07-06-2018.
 */

public class MyFireBaseInstanceIdService extends FirebaseInstanceIdService {


    private static final String TAG = "MyFirebaseIIDService";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        storeFcmToken(refreshedToken);
        Log.d(TAG, "Refreshed token: " + refreshedToken);

    }

    public void storeFcmToken(String fcmToken) {
        SharedPreferences sharedPreferences = getSharedPreferences("AppLaunch", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_fcm_token", fcmToken);
        editor.commit();
        editor.apply();
    }


}
