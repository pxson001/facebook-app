package com.facebook.goodwill.analytics;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: {rule} */
class GoodwillAnalyticsLogger$1 implements ActionReceiver {
    final /* synthetic */ String f32a;
    final /* synthetic */ String f33b;
    final /* synthetic */ String f34c;
    final /* synthetic */ String f35d;
    final /* synthetic */ String f36e;
    final /* synthetic */ String f37f;
    final /* synthetic */ GoodwillAnalyticsLogger f38g;

    GoodwillAnalyticsLogger$1(GoodwillAnalyticsLogger goodwillAnalyticsLogger, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f38g = goodwillAnalyticsLogger;
        this.f32a = str;
        this.f33b = str2;
        this.f34c = str3;
        this.f35d = str4;
        this.f36e = str5;
        this.f37f = str6;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 742226438);
        if ("com.facebook.STREAM_PUBLISH_COMPLETE".equals(intent.getAction())) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(GoodwillAnalyticsLogger$Events.GOODWILL_THROWBACK_SHARE_COMPOSER_POST.name);
            honeyClientEvent.c = "goodwill";
            this.f38g.a.a(honeyClientEvent.b("campaign_id", this.f32a).b("source", this.f33b).b("story_id", this.f34c).b("story_type", this.f35d).b("share_source", this.f36e).b("render_style", this.f37f));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1840922179, a);
            return;
        }
        LogUtils.e(-1334478703, a);
    }
}
