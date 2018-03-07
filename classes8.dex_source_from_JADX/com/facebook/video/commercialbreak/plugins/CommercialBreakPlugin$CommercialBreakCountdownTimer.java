package com.facebook.video.commercialbreak.plugins;

import android.os.CountDownTimer;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker;

/* compiled from: location_trigger */
class CommercialBreakPlugin$CommercialBreakCountdownTimer extends CountDownTimer {
    final /* synthetic */ CommercialBreakPlugin f9754a;

    public void onFinish() {
        String str = CommercialBreakPlugin.q;
        this.f9754a.t.sendEmptyMessage(8);
    }

    public CommercialBreakPlugin$CommercialBreakCountdownTimer(CommercialBreakPlugin commercialBreakPlugin, long j) {
        this.f9754a = commercialBreakPlugin;
        super(j, 50);
    }

    public void onTick(long j) {
        CommercialBreakInfoTracker.o(this.f9754a.b, this.f9754a.x).f9722g = j;
    }
}
