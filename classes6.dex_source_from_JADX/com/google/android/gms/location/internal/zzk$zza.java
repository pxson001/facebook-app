package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzc.zza;

class zzk$zza extends zza {
    private Handler f6401a;

    private void m8941a(int i, Object obj) {
        if (this.f6401a == null) {
            Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        this.f6401a.sendMessage(obtain);
    }

    public final void mo485a(LocationAvailability locationAvailability) {
        m8941a(1, locationAvailability);
    }

    public final void mo486a(LocationResult locationResult) {
        m8941a(0, locationResult);
    }
}
