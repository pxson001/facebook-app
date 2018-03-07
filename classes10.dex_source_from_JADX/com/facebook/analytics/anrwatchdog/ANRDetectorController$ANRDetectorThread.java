package com.facebook.analytics.anrwatchdog;

import android.annotation.SuppressLint;
import java.util.concurrent.TimeUnit;

/* compiled from: enable_attach_to_album */
class ANRDetectorController$ANRDetectorThread extends Thread {
    final /* synthetic */ ANRDetectorController f14487a;
    private final ANRDetector f14488b;
    private final long f14489c;
    private boolean f14490d;

    public ANRDetectorController$ANRDetectorThread(ANRDetectorController aNRDetectorController, ANRDetector aNRDetector, long j) {
        this.f14487a = aNRDetectorController;
        this.f14488b = aNRDetector;
        this.f14489c = j;
        setName("ANRDetector");
        setPriority(10);
    }

    @SuppressLint({"BadMethodUse-java.lang.Thread.start"})
    public synchronized void start() {
        super.start();
        this.f14488b.m14661a();
        this.f14490d = true;
    }

    public void run() {
        while (this.f14490d) {
            try {
                this.f14488b.m14662b();
            } catch (Throwable e) {
                this.f14487a.a(e);
            }
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(this.f14489c));
            } catch (InterruptedException e2) {
            }
        }
    }

    public final synchronized void m14663a() {
        this.f14490d = false;
        interrupt();
    }
}
