package com.facebook.rtc.models;

/* compiled from: application/vnd.wap.multipart.* */
public class RecentCallsDb$5 implements Runnable {
    final /* synthetic */ String f19814a;
    final /* synthetic */ RecentCallsDb f19815b;

    public RecentCallsDb$5(RecentCallsDb recentCallsDb, String str) {
        this.f19815b = recentCallsDb;
        this.f19814a = str;
    }

    public void run() {
        if (RecentCallsDb.b(this.f19815b, this.f19814a) > 0) {
            this.f19815b.k = 0;
            RecentCallsDb.g(this.f19815b);
        }
    }
}
