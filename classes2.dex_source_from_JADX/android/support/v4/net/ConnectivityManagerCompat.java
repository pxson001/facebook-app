package android.support.v4.net;

import android.net.ConnectivityManager;
import android.os.Build.VERSION;

/* compiled from: rtc_force_enable_software_agc */
public class ConnectivityManagerCompat {
    private static final ConnectivityManagerCompatImpl f6455a;

    /* compiled from: rtc_force_enable_software_agc */
    class JellyBeanConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        public final boolean mo1592a(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }

        JellyBeanConnectivityManagerCompatImpl() {
        }
    }

    /* compiled from: rtc_force_enable_software_agc */
    interface ConnectivityManagerCompatImpl {
        boolean mo1592a(ConnectivityManager connectivityManager);
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f6455a = new JellyBeanConnectivityManagerCompatImpl();
        } else if (VERSION.SDK_INT >= 13) {
            f6455a = new HoneycombMR2ConnectivityManagerCompatImpl();
        } else if (VERSION.SDK_INT >= 8) {
            f6455a = new GingerbreadConnectivityManagerCompatImpl();
        } else {
            f6455a = new BaseConnectivityManagerCompatImpl();
        }
    }

    public static boolean m11177a(ConnectivityManager connectivityManager) {
        return f6455a.mo1592a(connectivityManager);
    }
}
