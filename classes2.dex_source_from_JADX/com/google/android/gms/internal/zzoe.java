package com.google.android.gms.internal;

import android.os.Process;

class zzoe implements Runnable {
    private final Runnable f19124a;
    private final int f19125b;

    public zzoe(Runnable runnable, int i) {
        this.f19124a = runnable;
        this.f19125b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f19125b);
        this.f19124a.run();
    }
}
