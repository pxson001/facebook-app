package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private static boolean f6661a = false;

    private MapsInitializer() {
    }

    public static synchronized int m9215a(Context context) {
        int i = 0;
        synchronized (MapsInitializer.class) {
            zzx.a(context, "Context is null");
            if (!f6661a) {
                try {
                    m9216a(zzy.m9641a(context));
                    f6661a = true;
                } catch (GooglePlayServicesNotAvailableException e) {
                    i = e.errorCode;
                }
            }
        }
        return i;
    }

    private static void m9216a(zzc com_google_android_gms_maps_internal_zzc) {
        try {
            CameraUpdateFactory.m9152a(com_google_android_gms_maps_internal_zzc.mo695a());
            BitmapDescriptorFactory.m9651a(com_google_android_gms_maps_internal_zzc.mo701b());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
