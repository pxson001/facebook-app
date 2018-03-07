package com.facebook.debug.watchdog;

/* compiled from: photosync_help */
class UiThreadWatchdog$6 implements Runnable {
    final /* synthetic */ UiThreadWatchdog f6599a;

    UiThreadWatchdog$6(UiThreadWatchdog uiThreadWatchdog) {
        this.f6599a = uiThreadWatchdog;
    }

    public void run() {
        synchronized (this.f6599a) {
            UiThreadWatchdog.f(this.f6599a);
            UiThreadWatchdog.d(this.f6599a);
        }
    }
}
