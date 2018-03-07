package com.facebook.rtc.models;

import com.google.common.collect.ImmutableList;

/* compiled from: application/vnd.wap.multipart.* */
class RecentCallsDb$7 implements Runnable {
    final /* synthetic */ ImmutableList f19818a;
    final /* synthetic */ RecentCallsDb f19819b;

    RecentCallsDb$7(RecentCallsDb recentCallsDb, ImmutableList immutableList) {
        this.f19819b = recentCallsDb;
        this.f19818a = immutableList;
    }

    public void run() {
        this.f19819b.h = this.f19818a;
    }
}
