package com.facebook.debug.watchdog;

/* compiled from: photosync_help */
class UiThreadWatchdog$5 implements Runnable {
    final /* synthetic */ UiThreadWatchdog f6598a;

    UiThreadWatchdog$5(UiThreadWatchdog uiThreadWatchdog) {
        this.f6598a = uiThreadWatchdog;
    }

    public void run() {
        UiThreadWatchdog.g(this.f6598a);
        UiThreadWatchdog.c(this.f6598a);
    }
}
