package com.facebook.photos.progressiveimagequality.datausage;

import android.net.Uri;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;

/* compiled from: subscribed_event_take_negative_action */
class CompressionSavingsAnalyticsLogger$2 implements Runnable {
    final /* synthetic */ Uri f3869a;
    final /* synthetic */ CallerContext f3870b;
    final /* synthetic */ String f3871c;
    final /* synthetic */ String f3872d;
    final /* synthetic */ long f3873e;
    final /* synthetic */ long f3874f;
    final /* synthetic */ CompressionSavingsAnalyticsLogger f3875g;

    CompressionSavingsAnalyticsLogger$2(CompressionSavingsAnalyticsLogger compressionSavingsAnalyticsLogger, Uri uri, CallerContext callerContext, String str, String str2, long j, long j2) {
        this.f3875g = compressionSavingsAnalyticsLogger;
        this.f3869a = uri;
        this.f3870b = callerContext;
        this.f3871c = str;
        this.f3872d = str2;
        this.f3873e = j;
        this.f3874f = j2;
    }

    public void run() {
        HoneyClientEvent a = new HoneyClientEvent("android_dsm_image_stats").b("uri", this.f3869a.toString()).b("calling_class", this.f3870b.b).b("analytics_tag", this.f3870b.c()).b("network_type", this.f3871c).b("network_subtype", this.f3872d).a("fetched_bytes", this.f3873e).a("original_bytes", this.f3874f);
        a.c = "data_sensitivity";
        this.f3875g.a.a(a);
    }
}
