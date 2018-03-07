package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class AdvertisingIdClient$zza extends Thread {
    CountDownLatch f6330a = new CountDownLatch(1);
    boolean f6331b = false;
    private WeakReference<AdvertisingIdClient> f6332c;
    private long f6333d;

    public AdvertisingIdClient$zza(AdvertisingIdClient advertisingIdClient, long j) {
        this.f6332c = new WeakReference(advertisingIdClient);
        this.f6333d = j;
        start();
    }

    private void m12049c() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f6332c.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.a();
            this.f6331b = true;
        }
    }

    public final void m12050a() {
        this.f6330a.countDown();
    }

    public final boolean m12051b() {
        return this.f6331b;
    }

    public void run() {
        try {
            if (!this.f6330a.await(this.f6333d, TimeUnit.MILLISECONDS)) {
                m12049c();
            }
        } catch (InterruptedException e) {
            m12049c();
        }
    }
}
