package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza implements ServiceConnection {
    boolean f6669a = false;
    private final BlockingQueue<IBinder> f6670b = new LinkedBlockingQueue();

    public final IBinder m12453a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.f6669a) {
            throw new IllegalStateException();
        } else {
            this.f6669a = true;
            return (IBinder) this.f6670b.take();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f6670b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
