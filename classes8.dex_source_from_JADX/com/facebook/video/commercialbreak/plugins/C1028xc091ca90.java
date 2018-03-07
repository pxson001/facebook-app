package com.facebook.video.commercialbreak.plugins;

import android.os.CountDownTimer;

/* compiled from: location_title */
public class C1028xc091ca90 extends CountDownTimer {
    final /* synthetic */ CommercialBreakTransitionPlugin f9757a;

    public C1028xc091ca90(CommercialBreakTransitionPlugin commercialBreakTransitionPlugin, long j) {
        this.f9757a = commercialBreakTransitionPlugin;
        super(j, 500);
    }

    public void onTick(long j) {
        CharSequence valueOf = String.valueOf(j / 1000);
        if (this.f9757a.u != null && !this.f9757a.u.getText().equals(valueOf)) {
            this.f9757a.u.setText(valueOf);
        }
    }

    public void onFinish() {
        CommercialBreakTransitionPlugin commercialBreakTransitionPlugin = this.f9757a;
        CommercialBreakTransitionPlugin.b(commercialBreakTransitionPlugin.r);
        CommercialBreakTransitionPlugin.b(commercialBreakTransitionPlugin.s);
        CommercialBreakTransitionPlugin.b(commercialBreakTransitionPlugin.t);
    }
}
