package com.facebook.video.player.plugins;

import android.os.CountDownTimer;

/* compiled from: composer_attach_photo_ready */
public class CommercialBreakVideoPlugin$CommercialBreakCountdownTimer extends CountDownTimer {
    final /* synthetic */ CommercialBreakVideoPlugin f19314a;
    private final long f19315b;

    public CommercialBreakVideoPlugin$CommercialBreakCountdownTimer(CommercialBreakVideoPlugin commercialBreakVideoPlugin, long j) {
        this.f19314a = commercialBreakVideoPlugin;
        super(j, 42);
        this.f19315b = j;
    }

    public void onTick(long j) {
        this.f19314a.c.setProgress(Math.min(Math.max(0, (int) (this.f19315b - j)), (int) this.f19315b));
        CharSequence valueOf = String.valueOf(j / 1000);
        if (!this.f19314a.d.getText().equals(valueOf)) {
            this.f19314a.d.setText(valueOf);
        }
    }

    public void onFinish() {
        this.f19314a.b.setVisibility(8);
    }
}
