package com.facebook.analytics.anrwatchdog;

/* compiled from: enablePullToRefresh */
public class ANRDetectorRunnable implements Runnable {
    public volatile int f14491a = 0;

    public void run() {
        this.f14491a = (this.f14491a + 1) % 10;
    }
}
