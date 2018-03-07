package com.facebook.feed.data;

import android.content.SharedPreferences.Editor;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;

/* compiled from: application/vobsub */
public class FeedDataLoader$9 implements Runnable {
    final /* synthetic */ long f19165a;
    final /* synthetic */ int f19166b;
    final /* synthetic */ FeedDataLoader f19167c;

    public void run() {
        ColdStartPrimingInformation coldStartPrimingInformation = ColdStartPrimingInformation.a;
        long j = this.f19165a;
        int i = this.f19166b;
        if (coldStartPrimingInformation.c == null) {
            return;
        }
        if (j != coldStartPrimingInformation.f || i != coldStartPrimingInformation.h) {
            Editor edit = coldStartPrimingInformation.c.edit();
            if (j != coldStartPrimingInformation.f) {
                coldStartPrimingInformation.f = j;
                edit.putLong("COLD_START_PRIME_INFO/LAST_HEAD_FETCH_TIME", coldStartPrimingInformation.f);
            }
            if (i != coldStartPrimingInformation.h) {
                coldStartPrimingInformation.h = i;
                edit.putInt("COLD_START_PRIME_INFO/FROZEN_FEED_TIME", coldStartPrimingInformation.h);
            }
            edit.commit();
        }
    }

    public FeedDataLoader$9(FeedDataLoader feedDataLoader, long j, int i) {
        this.f19167c = feedDataLoader;
        this.f19165a = j;
        this.f19166b = i;
    }
}
