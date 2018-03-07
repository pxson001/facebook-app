package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.wearable.internal.zzbb.zza;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzbl<T> {
    private final Map<T, zzcf<T>> f13384a = new HashMap();

    zzbl() {
    }

    public final void m13565a(IBinder iBinder) {
        synchronized (this.f13384a) {
            zzbb a = zza.m13560a(iBinder);
            zzaz com_google_android_gms_wearable_internal_zzcd_zzo = new zzcd$zzo();
            for (Entry entry : this.f13384a.entrySet()) {
                zzcf com_google_android_gms_wearable_internal_zzcf = (zzcf) entry.getValue();
                try {
                    a.mo626a(com_google_android_gms_wearable_internal_zzcd_zzo, new AddListenerRequest(com_google_android_gms_wearable_internal_zzcf));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzcf);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzcf);
                }
            }
        }
    }

    public final void m13566a(zzce com_google_android_gms_wearable_internal_zzce) {
        synchronized (this.f13384a) {
            zzaz com_google_android_gms_wearable_internal_zzcd_zzo = new zzcd$zzo();
            for (Entry entry : this.f13384a.entrySet()) {
                zzcf com_google_android_gms_wearable_internal_zzcf = (zzcf) entry.getValue();
                if (com_google_android_gms_wearable_internal_zzcf != null) {
                    com_google_android_gms_wearable_internal_zzcf.m13612a();
                    if (com_google_android_gms_wearable_internal_zzce.b()) {
                        try {
                            ((zzbb) com_google_android_gms_wearable_internal_zzce.q()).mo631a(com_google_android_gms_wearable_internal_zzcd_zzo, new RemoveListenerRequest(com_google_android_gms_wearable_internal_zzcf));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzcf);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzcf);
                        }
                    }
                }
            }
            this.f13384a.clear();
        }
    }
}
