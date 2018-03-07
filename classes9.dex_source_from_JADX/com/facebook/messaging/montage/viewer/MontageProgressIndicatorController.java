package com.facebook.messaging.montage.viewer;

import android.support.v4.view.ViewCompat;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.common.time.Clock;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.Assisted;
import com.facebook.messaging.montage.model.MontageMessageInfo;
import com.facebook.messaging.montage.model.MontagePlayQueue;
import com.facebook.messaging.montage.viewer.MontageProgressIndicatorView.LayoutCoordinator;
import com.facebook.orca.threadview.montage.MontageViewActivity;
import com.facebook.orca.threadview.montage.MontageViewActivity.2;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: is_eligible */
public class MontageProgressIndicatorController implements LayoutCoordinator {
    public static final AccelerateDecelerateInterpolator f12586a = new AccelerateDecelerateInterpolator();
    public final MontageProgressIndicatorView f12587b;
    public final Clock f12588c;
    public final Runnable f12589d = new C14111(this);
    private long f12590e;
    private long f12591f;
    private long f12592g;
    private long f12593h;
    public long f12594i;
    private boolean f12595j;
    private boolean f12596k;
    public 2 f12597l;

    /* compiled from: is_eligible */
    class C14111 implements Runnable {
        final /* synthetic */ MontageProgressIndicatorController f12585a;

        C14111(MontageProgressIndicatorController montageProgressIndicatorController) {
            this.f12585a = montageProgressIndicatorController;
        }

        public void run() {
            this.f12585a.m13052c();
            ViewCompat.a(this.f12585a.f12587b, this.f12585a.f12589d, 16);
        }
    }

    @Inject
    public MontageProgressIndicatorController(@Assisted MontageProgressIndicatorView montageProgressIndicatorView, Clock clock) {
        this.f12587b = montageProgressIndicatorView;
        this.f12588c = clock;
        this.f12587b.f12601d = this;
        this.f12587b.setTrackPaintAlpha(25);
    }

    public final void m13046a() {
        this.f12596k = false;
        this.f12587b.removeCallbacks(this.f12589d);
    }

    public final void m13050b() {
        this.f12596k = true;
        m13042d();
    }

    private void m13042d() {
        if (this.f12596k && this.f12595j) {
            ViewCompat.a(this.f12587b, this.f12589d, 16);
        }
    }

    public final void m13047a(long j) {
        Preconditions.checkArgument(j > 0);
        this.f12590e = j;
        this.f12591f = 0;
        this.f12592g = 0;
        this.f12593h = j;
        this.f12594i = this.f12588c.a();
        this.f12595j = true;
        m13044f();
        m13042d();
    }

    public final void m13048a(long j, long j2) {
        boolean z = true;
        Preconditions.checkArgument(this.f12595j);
        boolean z2 = j > 0 && j <= this.f12590e;
        Preconditions.checkArgument(z2);
        if (j2 < 0 || j2 >= this.f12590e) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.f12591f = j;
        this.f12592g = j;
        this.f12593h = (this.f12590e - j2) - j;
        if (this.f12593h < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f12594i = this.f12588c.a();
        m13043e();
    }

    protected final void m13052c() {
        long j;
        Preconditions.checkArgument(this.f12595j);
        if (this.f12597l == null) {
            j = this.f12591f;
        } else {
            long as;
            2 2 = this.f12597l;
            AbstractMontageItemFragment n = MontageViewActivity.n(2.a);
            if (n != null) {
                as = n.as();
            } else if (2.a.F == null) {
                as = 0;
            } else {
                MontagePlayQueue montagePlayQueue = 2.a.F;
                int i = 2.a.G.k;
                Preconditions.checkElementIndex(i, montagePlayQueue.f12557a.size());
                as = ((MontageMessageInfo) montagePlayQueue.f12557a.get(i)).f12556c;
            }
            j = as;
        }
        this.f12592g = j;
        m13043e();
    }

    private void m13043e() {
        if (this.f12595j) {
            m13044f();
        }
    }

    private void m13044f() {
        MontageProgressIndicatorView montageProgressIndicatorView = this.f12587b;
        int i = 127;
        float min = Math.min(1.0f, ((float) (this.f12588c.a() - this.f12594i)) / 250.0f);
        if (min < 1.0f) {
            i = MathUtil.a(25, 127, f12586a.getInterpolation(min));
        }
        montageProgressIndicatorView.setActiveRemainingPaintAlpha(i);
        this.f12587b.invalidate();
    }

    public final int mo498a(int i) {
        return MathUtil.a(i, 0, ((float) (this.f12591f + this.f12593h)) / ((float) this.f12590e));
    }

    public final int mo499b(int i) {
        return MathUtil.a(i, 0, ((float) this.f12593h) / ((float) this.f12590e));
    }

    public final int mo500c(int i) {
        return MathUtil.a(i, 0, ((float) (this.f12592g + this.f12593h)) / ((float) this.f12590e));
    }
}
