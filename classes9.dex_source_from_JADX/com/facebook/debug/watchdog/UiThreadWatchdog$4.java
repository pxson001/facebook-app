package com.facebook.debug.watchdog;

import android.os.MessageQueue.IdleHandler;

/* compiled from: photosync_help */
class UiThreadWatchdog$4 implements IdleHandler {
    final /* synthetic */ UiThreadWatchdog f6597a;

    UiThreadWatchdog$4(UiThreadWatchdog uiThreadWatchdog) {
        this.f6597a = uiThreadWatchdog;
    }

    public boolean queueIdle() {
        UiThreadWatchdog.f(this.f6597a);
        return this.f6597a.m;
    }
}
