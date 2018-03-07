package com.facebook.feed.platformads;

/* compiled from: admin_click_message */
class ApplicationPoller$1 implements Runnable {
    final /* synthetic */ ApplicationPoller f19813a;

    ApplicationPoller$1(ApplicationPoller applicationPoller) {
        this.f19813a = applicationPoller;
    }

    public void run() {
        ApplicationPoller.f(this.f19813a);
    }
}
