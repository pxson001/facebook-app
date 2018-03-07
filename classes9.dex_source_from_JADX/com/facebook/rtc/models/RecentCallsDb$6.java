package com.facebook.rtc.models;

/* compiled from: application/vnd.wap.multipart.* */
public class RecentCallsDb$6 implements Runnable {
    final /* synthetic */ int f19816a;
    final /* synthetic */ RecentCallsDb f19817b;

    public RecentCallsDb$6(RecentCallsDb recentCallsDb, int i) {
        this.f19817b = recentCallsDb;
        this.f19816a = i;
    }

    public void run() {
        if (!RecentCallsDb.b.getAndSet(true)) {
            this.f19817b.a(this.f19816a);
            RecentCallsDb.b.set(false);
        }
    }
}
