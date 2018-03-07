package com.facebook.vault.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: thread state =  */
public class UploadManagerConnectivity {
    public static boolean m1959a(Context context) {
        return m1960b(context) != null;
    }

    public static NetworkInfo m1960b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? null : activeNetworkInfo;
    }
}
