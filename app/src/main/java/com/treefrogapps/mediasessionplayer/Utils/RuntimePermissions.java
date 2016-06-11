package com.treefrogapps.mediasessionplayer.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Runtime Permissions Util Class
 */
public class RuntimePermissions {

    private static final String TAG = RuntimePermissions.class.getSimpleName();


    public static boolean checkPermissions(@NonNull Context context, @NonNull String[] permissions)
            throws IllegalArgumentException {

        boolean granted = true;

        if(permissions.length == 0){
            throw new IllegalArgumentException("String array empty - no permissions to grant");
        }

        for(String permission : permissions) {
            if(ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED){
                Log.i(TAG, "Missing Permission to obtain : " + permission);
                granted = false;
            }
        }

        return granted;
    }

    /**
     * Gain Permissions - Activity passed in must override OnRequestPermissionsResultCallback
     * @param activity activity to callback to
     * @param permissions permissions to gain
     * @param taskRequestCode the task requestCode - when called back to activity use this to define
     *                        what we were trying to do before requesting the permissions and continue
     * @throws IllegalArgumentException
     */
    public static void gainPermissions(@NonNull Activity activity, @NonNull String[] permissions,
                                       int taskRequestCode) throws IllegalArgumentException {

        if(permissions.length == 0){
            throw new IllegalArgumentException("String array empty - no permissions to grant");
        }

        ActivityCompat.requestPermissions(activity, permissions, taskRequestCode);
    }

}
