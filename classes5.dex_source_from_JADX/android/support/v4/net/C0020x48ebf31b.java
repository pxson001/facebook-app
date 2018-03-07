package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl;
import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: view_path */
class C0020x48ebf31b implements ConnectivityManagerCompatImpl {
    C0020x48ebf31b() {
    }

    public final boolean m281a(ConnectivityManager connectivityManager) {
        boolean z = true;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                case 3:
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                case 5:
                case 6:
                    break;
                case 1:
                case 7:
                case 9:
                    z = false;
                    break;
                default:
                    break;
            }
        }
        return z;
    }
}
