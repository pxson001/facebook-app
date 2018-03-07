package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: publish-photo */
public class ValueAnimatorCompatImplEclairMr1 extends Impl {
    public static final Handler f7123a = new Handler(Looper.getMainLooper());
    public long f7124b;
    public boolean f7125c;
    private final int[] f7126d = new int[2];
    private final float[] f7127e = new float[2];
    public int f7128f = 200;
    public Interpolator f7129g;
    public AnimatorUpdateListenerProxy f7130h;
    public float f7131i;
    public final Runnable f7132j = new C04181(this);

    /* compiled from: publish-photo */
    class C04181 implements Runnable {
        final /* synthetic */ ValueAnimatorCompatImplEclairMr1 f7122a;

        C04181(ValueAnimatorCompatImplEclairMr1 valueAnimatorCompatImplEclairMr1) {
            this.f7122a = valueAnimatorCompatImplEclairMr1;
        }

        public void run() {
            ValueAnimatorCompatImplEclairMr1 valueAnimatorCompatImplEclairMr1 = this.f7122a;
            if (valueAnimatorCompatImplEclairMr1.f7125c) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - valueAnimatorCompatImplEclairMr1.f7124b)) / ((float) valueAnimatorCompatImplEclairMr1.f7128f);
                if (valueAnimatorCompatImplEclairMr1.f7129g != null) {
                    uptimeMillis = valueAnimatorCompatImplEclairMr1.f7129g.getInterpolation(uptimeMillis);
                }
                valueAnimatorCompatImplEclairMr1.f7131i = uptimeMillis;
                if (valueAnimatorCompatImplEclairMr1.f7130h != null) {
                    valueAnimatorCompatImplEclairMr1.f7130h.mo881a();
                }
                if (SystemClock.uptimeMillis() >= valueAnimatorCompatImplEclairMr1.f7124b + ((long) valueAnimatorCompatImplEclairMr1.f7128f)) {
                    valueAnimatorCompatImplEclairMr1.f7125c = false;
                }
            }
            if (valueAnimatorCompatImplEclairMr1.f7125c) {
                HandlerDetour.b(ValueAnimatorCompatImplEclairMr1.f7123a, valueAnimatorCompatImplEclairMr1.f7132j, 10, 1302200240);
            }
        }
    }

    ValueAnimatorCompatImplEclairMr1() {
    }

    public final void mo882a() {
        if (!this.f7125c) {
            if (this.f7129g == null) {
                this.f7129g = new AccelerateDecelerateInterpolator();
            }
            this.f7124b = SystemClock.uptimeMillis();
            this.f7125c = true;
            HandlerDetour.b(f7123a, this.f7132j, 10, -1481053173);
        }
    }

    public final boolean mo888b() {
        return this.f7125c;
    }

    public final void mo887a(Interpolator interpolator) {
        this.f7129g = interpolator;
    }

    public final void mo886a(AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        this.f7130h = animatorUpdateListenerProxy;
    }

    public final void mo885a(int i, int i2) {
        this.f7126d[0] = i;
        this.f7126d[1] = i2;
    }

    public final int mo889c() {
        int i = this.f7126d[0];
        int i2 = this.f7126d[1];
        return Math.round(((float) (i2 - i)) * this.f7131i) + i;
    }

    public final void mo883a(float f, float f2) {
        this.f7127e[0] = f;
        this.f7127e[1] = f2;
    }

    public final float mo890d() {
        return AnimationUtils.m9978a(this.f7127e[0], this.f7127e[1], this.f7131i);
    }

    public final void mo884a(int i) {
        this.f7128f = i;
    }

    public final void mo891e() {
        this.f7125c = false;
        HandlerDetour.a(f7123a, this.f7132j);
    }
}
