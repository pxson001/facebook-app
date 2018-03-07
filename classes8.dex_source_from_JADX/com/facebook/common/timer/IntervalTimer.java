package com.facebook.common.timer;

import android.os.CountDownTimer;
import com.facebook.inject.Assisted;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: local_serp_abandon */
public class IntervalTimer {
    public CountDownTimer f10691a;
    protected long f10692b;
    protected long f10693c;
    public IntervalTimerListener f10694d = new TimerListener(this);

    /* compiled from: local_serp_abandon */
    public interface IntervalTimerListener {
        void mo676a();

        void mo677a(long j);
    }

    @Inject
    public IntervalTimer(@Assisted Long l, @Assisted Long l2) {
        this.f10692b = l.longValue();
        this.f10693c = l2.longValue();
    }

    public final void m12619c() {
        m12620d();
        this.f10691a = new CountDownTimer(this, this.f10692b, this.f10693c) {
            final /* synthetic */ IntervalTimer f10690a;

            public void onTick(long j) {
                this.f10690a.f10694d.mo677a(j);
            }

            public void onFinish() {
                IntervalTimer intervalTimer = this.f10690a;
                intervalTimer.f10691a = null;
                intervalTimer.f10694d.mo676a();
            }
        }.start();
    }

    public final void m12620d() {
        if (this.f10691a != null) {
            this.f10691a.cancel();
            this.f10691a = null;
        }
    }
}
