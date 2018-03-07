package com.facebook.messaging.analytics.perf;

import android.content.Intent;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.facebook.common.classmarkers.ClassMarkerLoader;

/* compiled from: p2p_history_get_success */
public class MessagingPerformanceLogger$1 implements Runnable {
    final /* synthetic */ MessagingPerformanceLogger f7646a;

    /* compiled from: p2p_history_get_success */
    class C08501 implements IdleHandler {
        final /* synthetic */ MessagingPerformanceLogger$1 f7645a;

        C08501(MessagingPerformanceLogger$1 messagingPerformanceLogger$1) {
            this.f7645a = messagingPerformanceLogger$1;
        }

        public boolean queueIdle() {
            Object obj;
            MessagingPerformanceLogger messagingPerformanceLogger = this.f7645a.f7646a;
            if (messagingPerformanceLogger.b.c() && messagingPerformanceLogger.b.a() && !messagingPerformanceLogger.b.b()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return true;
            }
            this.f7645a.f7646a.d.a((short) 84, "caught_on_idle");
            MessagingPerformanceLogger.c(this.f7645a.f7646a, 5505026, "ui_idle");
            MessagingPerformanceLogger.c(this.f7645a.f7646a, 5505028, "ui_idle");
            if (this.f7645a.f7646a.d.f(5505027)) {
                this.f7645a.f7646a.j = true;
                this.f7645a.f7646a.e.a(new Intent("background_started"));
            }
            this.f7645a.f7646a.d.d(5505027);
            ClassMarkerLoader.loadIsNotColdStartRunMarker();
            this.f7645a.f7646a.d.i(5505025, 600000);
            this.f7645a.f7646a.d.b(5505034, this.f7645a.f7646a.g, (short) 12);
            this.f7645a.f7646a.d.b(5505032, (short) 12);
            this.f7645a.f7646a.d.a((short) 84);
            this.f7645a.f7646a.f = false;
            return false;
        }
    }

    public MessagingPerformanceLogger$1(MessagingPerformanceLogger messagingPerformanceLogger) {
        this.f7646a = messagingPerformanceLogger;
    }

    public void run() {
        this.f7646a.a.a();
        Looper.myQueue().addIdleHandler(new C08501(this));
        this.f7646a.f = true;
    }
}
