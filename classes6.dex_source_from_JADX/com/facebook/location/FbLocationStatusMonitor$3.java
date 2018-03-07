package com.facebook.location;

/* compiled from: ₡ */
class FbLocationStatusMonitor$3 implements Runnable {
    final /* synthetic */ FbLocationStatus f20a;
    final /* synthetic */ FbLocationStatusMonitor f21b;

    FbLocationStatusMonitor$3(FbLocationStatusMonitor fbLocationStatusMonitor, FbLocationStatus fbLocationStatus) {
        this.f21b = fbLocationStatusMonitor;
        this.f20a = fbLocationStatus;
    }

    public void run() {
        FbLocationStatusMonitor.a(this.f21b, this.f20a);
        this.f21b.m = null;
    }
}
