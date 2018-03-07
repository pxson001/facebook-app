package com.facebook.selfupdate;

/* compiled from: has_logged_first_scroll */
class SelfUpdateManager$1 implements Runnable {
    final /* synthetic */ long f9996a;
    final /* synthetic */ SelfUpdateManager f9997b;

    SelfUpdateManager$1(SelfUpdateManager selfUpdateManager, long j) {
        this.f9997b = selfUpdateManager;
        this.f9996a = j;
    }

    public void run() {
        SelfUpdateManager.a(this.f9997b, this.f9996a);
    }
}
