package com.facebook.selfupdate;

/* compiled from: has_logged_first_scroll */
public class SelfUpdateManager$2 implements Runnable {
    final /* synthetic */ long f9998a;
    final /* synthetic */ SelfUpdateManager f9999b;

    public SelfUpdateManager$2(SelfUpdateManager selfUpdateManager, long j) {
        this.f9999b = selfUpdateManager;
        this.f9998a = j;
    }

    public void run() {
        SelfUpdateManager.a(this.f9999b, this.f9998a);
    }
}
