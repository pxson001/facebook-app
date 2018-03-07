package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zza;

public final class BitmapDescriptorFactory {
    private static zza f6719a;

    private BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor m9649a(Bitmap bitmap) {
        try {
            return new BitmapDescriptor(m9650a().mo740a(bitmap));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static zza m9650a() {
        return (zza) zzx.a(f6719a, "IBitmapDescriptorFactory is not initialized");
    }

    public static void m9651a(zza com_google_android_gms_maps_model_internal_zza) {
        if (f6719a == null) {
            f6719a = (zza) zzx.a(com_google_android_gms_maps_model_internal_zza);
        }
    }
}
