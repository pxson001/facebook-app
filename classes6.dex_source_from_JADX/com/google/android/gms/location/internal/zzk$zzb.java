package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationListener;

class zzk$zzb extends Handler {
    private final LocationListener f6402a;

    public zzk$zzb(LocationListener locationListener) {
        this.f6402a = locationListener;
    }

    public zzk$zzb(LocationListener locationListener, Looper looper) {
        super(looper);
        this.f6402a = locationListener;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f6402a.a(new Location((Location) message.obj));
                return;
            default:
                Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                return;
        }
    }
}
