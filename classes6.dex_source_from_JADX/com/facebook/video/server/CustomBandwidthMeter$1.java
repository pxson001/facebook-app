package com.facebook.video.server;

import com.google.android.exoplayer.upstream.BandwidthMeter.EventListener;

/* compiled from: commerce_product_item_create */
class CustomBandwidthMeter$1 implements Runnable {
    final /* synthetic */ int f19466a;
    final /* synthetic */ long f19467b;
    final /* synthetic */ long f19468c;
    final /* synthetic */ CustomBandwidthMeter f19469d;

    CustomBandwidthMeter$1(CustomBandwidthMeter customBandwidthMeter, int i, long j, long j2) {
        this.f19469d = customBandwidthMeter;
        this.f19466a = i;
        this.f19467b = j;
        this.f19468c = j2;
    }

    public void run() {
        EventListener eventListener = this.f19469d.c;
    }
}
