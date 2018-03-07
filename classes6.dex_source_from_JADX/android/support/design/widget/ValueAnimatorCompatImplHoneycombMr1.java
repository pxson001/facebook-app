package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy;
import android.view.animation.Interpolator;

/* compiled from: publish ignored as client has been closed */
class ValueAnimatorCompatImplHoneycombMr1 extends Impl {
    final ValueAnimator f7135a = new ValueAnimator();

    ValueAnimatorCompatImplHoneycombMr1() {
    }

    public final void mo882a() {
        this.f7135a.start();
    }

    public final boolean mo888b() {
        return this.f7135a.isRunning();
    }

    public final void mo887a(Interpolator interpolator) {
        this.f7135a.setInterpolator(interpolator);
    }

    public final void mo886a(final AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        this.f7135a.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ ValueAnimatorCompatImplHoneycombMr1 f7134b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatorUpdateListenerProxy.mo881a();
            }
        });
    }

    public final void mo885a(int i, int i2) {
        this.f7135a.setIntValues(new int[]{i, i2});
    }

    public final int mo889c() {
        return ((Integer) this.f7135a.getAnimatedValue()).intValue();
    }

    public final void mo883a(float f, float f2) {
        this.f7135a.setFloatValues(new float[]{f, f2});
    }

    public final float mo890d() {
        return ((Float) this.f7135a.getAnimatedValue()).floatValue();
    }

    public final void mo884a(int i) {
        this.f7135a.setDuration((long) i);
    }

    public final void mo891e() {
        this.f7135a.cancel();
    }
}
