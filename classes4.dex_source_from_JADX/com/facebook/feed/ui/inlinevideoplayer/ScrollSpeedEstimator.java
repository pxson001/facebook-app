package com.facebook.feed.ui.inlinevideoplayer;

import android.graphics.Rect;
import android.view.View;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import javax.inject.Inject;

/* compiled from: phatRank */
public class ScrollSpeedEstimator {
    public final QeAccessor f5026a;
    public final Rect f5027b = new Rect(0, 0, 0, 0);
    private final ScreenUtil f5028c;
    private final MonotonicClock f5029d;
    private long f5030e;
    public int f5031f;
    public int f5032g;
    public int f5033h;
    public int f5034i;
    public boolean f5035j;
    public int f5036k;
    public int f5037l;
    public int f5038m;

    public static ScrollSpeedEstimator m5411b(InjectorLike injectorLike) {
        return new ScrollSpeedEstimator((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ScreenUtil.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ScrollSpeedEstimator(QeAccessor qeAccessor, ScreenUtil screenUtil, MonotonicClock monotonicClock) {
        this.f5026a = qeAccessor;
        this.f5028c = screenUtil;
        this.f5029d = monotonicClock;
    }

    public final void m5412a(View view) {
        this.f5035j = this.f5026a.a(ExperimentsForVideoAbTestModule.f, false);
        if (this.f5035j) {
            this.f5036k = this.f5026a.a(ExperimentsForVideoAbTestModule.g, 100);
            this.f5037l = this.f5026a.a(ExperimentsForVideoAbTestModule.h, 100000);
            this.f5038m = this.f5026a.a(ExperimentsForVideoAbTestModule.i, 100000);
        }
        if (this.f5035j) {
            if (view != null) {
                view.getGlobalVisibleRect(this.f5027b);
                m5410a(this.f5029d.now());
            }
            this.f5033h = 0;
            this.f5034i = 0;
        }
    }

    public final void m5414b(View view) {
        if (this.f5035j) {
            long now = this.f5029d.now();
            int i = (int) (now - this.f5030e);
            if (i >= this.f5036k) {
                view.getGlobalVisibleRect(this.f5027b);
                int i2 = this.f5027b.top - this.f5031f;
                int i3 = this.f5027b.bottom - this.f5032g;
                if (Math.abs(i3) <= Math.abs(i2)) {
                    i3 = i2;
                }
                i3 = (i3 * 1000) / i;
                this.f5034i = ((i3 - this.f5033h) * 1000) / i;
                this.f5033h = i3;
                m5410a(now);
            }
        }
    }

    public final boolean m5413a() {
        if (!this.f5035j) {
            return false;
        }
        int abs = Math.abs(this.f5033h) / this.f5028c.a();
        if (abs > this.f5037l || (abs > this.f5038m && Math.signum((float) this.f5033h) * Math.signum((float) this.f5034i) > 0.0f)) {
            return true;
        }
        return false;
    }

    private void m5410a(long j) {
        this.f5031f = this.f5027b.top;
        this.f5032g = this.f5027b.bottom;
        this.f5030e = j;
    }
}
