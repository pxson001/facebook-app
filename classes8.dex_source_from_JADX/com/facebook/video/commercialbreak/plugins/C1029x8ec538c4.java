package com.facebook.video.commercialbreak.plugins;

import android.os.CountDownTimer;

/* compiled from: location_title */
class C1029x8ec538c4 extends CountDownTimer {
    final /* synthetic */ CommercialBreakTransitionPlugin f9758a;

    public C1029x8ec538c4(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin, long j) {
        this.f9758a = commercialBreakTransitionPlugin;
        super(j, 200);
    }

    public void onTick(long j) {
    }

    public void onFinish() {
        CommercialBreakTransitionPlugin commercialBreakTransitionPlugin = this.f9758a;
        CommercialBreakTransitionPlugin.d(commercialBreakTransitionPlugin.r);
        CommercialBreakTransitionPlugin.d(commercialBreakTransitionPlugin.s);
        CommercialBreakTransitionPlugin.d(commercialBreakTransitionPlugin.t);
    }
}
