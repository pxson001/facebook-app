package com.facebook.ads.internal.adapters;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.C1945h;
import com.facebook.ads.internal.C1945h.C19417;
import com.facebook.ads.internal.util.C1994r;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

public class C1897d extends BroadcastReceiver {
    public String f13987a;
    public Context f13988b;
    private C19417 f13989c;
    private InterstitialAdapter f13990d;

    public C1897d(Context context, String str, InterstitialAdapter interstitialAdapter, C19417 c19417) {
        this.f13988b = context;
        this.f13987a = str;
        this.f13989c = c19417;
        this.f13990d = interstitialAdapter;
    }

    public final void m14234b() {
        try {
            LocalBroadcastManager.a(this.f13988b).a(this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -201183237);
        Object obj = intent.getAction().split(":")[0];
        if (this.f13989c == null || obj == null) {
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 406325530, a);
            return;
        }
        C1945h c1945h;
        if ("com.facebook.ads.interstitial.clicked".equals(obj)) {
            String stringExtra = intent.getStringExtra("com.facebook.ads.interstitial.ad.click.url");
            boolean booleanExtra = intent.getBooleanExtra("com.facebook.ads.interstitial.ad.player.handles.click", true);
            C19417 c19417 = this.f13989c;
            c1945h = c19417.f14212b;
            C1945h.m14362b();
            c19417.f14212b.f14218a.m14206a();
            Object obj2 = !C1994r.m14486a(stringExtra) ? 1 : null;
            if (booleanExtra && obj2 != null) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                if (!(c19417.f14212b.f14229m.f14157d instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                intent2.setData(Uri.parse(stringExtra));
                c19417.f14212b.f14229m.f14157d.startActivity(intent2);
            }
        } else if ("com.facebook.ads.interstitial.dismissed".equals(obj)) {
            r1 = this.f13989c;
            c1945h = r1.f14212b;
            C1945h.m14362b();
            r4 = r1.f14212b.f14218a;
        } else if ("com.facebook.ads.interstitial.displayed".equals(obj)) {
            r1 = this.f13989c;
            c1945h = r1.f14212b;
            C1945h.m14362b();
            r4 = r1.f14212b.f14218a;
        } else if ("com.facebook.ads.interstitial.impression.logged".equals(obj)) {
            r1 = this.f13989c;
            c1945h = r1.f14212b;
            C1945h.m14362b();
            r1.f14212b.f14218a.m14208b();
        } else if ("com.facebook.ads.interstitial.error".equals(obj)) {
            r1 = this.f13989c;
            InterstitialAdapter interstitialAdapter = this.f13990d;
            AdError adError = AdError.f13886e;
            r1.m14357b(interstitialAdapter);
        }
        LogUtils.a(intent, -364783615, a);
    }
}
