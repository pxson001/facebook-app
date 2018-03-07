package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl;
import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: view_path */
class C0019x9d614594 implements ConnectivityManagerCompatImpl {
    C0019x9d614594() {
    }

    public final boolean m280a(ConnectivityManager connectivityManager) {
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
                    z = false;
                    break;
                default:
                    break;
            }
        }
        return z;
    }
}
