package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzd.zza;

class zzk$zzc extends zza {
    private Handler f6403a;

    zzk$zzc(LocationListener locationListener, Looper looper) {
        if (looper == null) {
            zzx.a(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        }
        this.f6403a = looper == null ? new zzk$zzb(locationListener) : new zzk$zzb(locationListener, looper);
    }

    public final void mo487a(Location location) {
        if (this.f6403a == null) {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = location;
        this.f6403a.sendMessage(obtain);
    }
}
