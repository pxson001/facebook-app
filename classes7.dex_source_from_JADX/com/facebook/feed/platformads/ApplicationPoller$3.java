package com.facebook.feed.platformads;

import java.util.Date;

/* compiled from: admin_click_message */
public class ApplicationPoller$3 implements Runnable {
    final /* synthetic */ TrackedPackage f19815a;
    final /* synthetic */ ApplicationPoller f19816b;

    public ApplicationPoller$3(ApplicationPoller applicationPoller, TrackedPackage trackedPackage) {
        this.f19816b = applicationPoller;
        this.f19815a = trackedPackage;
    }

    public void run() {
        if (!this.f19816b.l.containsKey(this.f19815a.fbid)) {
            this.f19815a.trackUntil = new Date(System.currentTimeMillis() + this.f19816b.j);
            this.f19816b.l.put(this.f19815a.fbid, this.f19815a);
            ApplicationPoller.e(this.f19816b);
        }
    }
}
