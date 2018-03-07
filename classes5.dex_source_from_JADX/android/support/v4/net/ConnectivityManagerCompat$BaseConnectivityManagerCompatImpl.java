package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl;

/* compiled from: view_path */
class ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
    ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl() {
    }

    public final boolean m279a(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return true;
        }
    }
}
