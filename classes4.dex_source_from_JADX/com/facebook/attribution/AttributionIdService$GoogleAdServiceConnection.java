package com.facebook.attribution;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: selfupdate_start_operation_task */
final class AttributionIdService$GoogleAdServiceConnection implements ServiceConnection {
    private final AtomicBoolean f3165a;
    private final BlockingQueue<IBinder> f3166b;

    public AttributionIdService$GoogleAdServiceConnection() {
        this.f3165a = new AtomicBoolean(false);
        this.f3166b = new LinkedBlockingDeque();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f3166b.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }

    public final IBinder m3406a() {
        if (!this.f3165a.compareAndSet(true, true)) {
            return (IBinder) this.f3166b.take();
        }
        throw new IllegalStateException("Binder already consumed");
    }
}
