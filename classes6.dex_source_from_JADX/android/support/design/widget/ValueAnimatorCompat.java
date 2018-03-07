package android.support.design.widget;

import android.view.animation.Interpolator;

/* compiled from: pymk_ref */
public class ValueAnimatorCompat {
    private final Impl f7121a;

    /* compiled from: pymk_ref */
    interface AnimatorUpdateListener {
        void mo847a(ValueAnimatorCompat valueAnimatorCompat);
    }

    /* compiled from: pymk_ref */
    interface Creator {
        ValueAnimatorCompat mo893a();
    }

    /* compiled from: pymk_ref */
    abstract class Impl {

        /* compiled from: pymk_ref */
        public interface AnimatorUpdateListenerProxy {
            void mo881a();
        }

        abstract void mo882a();

        abstract void mo883a(float f, float f2);

        abstract void mo884a(int i);

        abstract void mo885a(int i, int i2);

        abstract void mo886a(AnimatorUpdateListenerProxy animatorUpdateListenerProxy);

        abstract void mo887a(Interpolator interpolator);

        abstract boolean mo888b();

        abstract int mo889c();

        abstract float mo890d();

        abstract void mo891e();

        Impl() {
        }
    }

    ValueAnimatorCompat(Impl impl) {
        this.f7121a = impl;
    }

    public final void m10235a() {
        this.f7121a.mo882a();
    }

    public final boolean m10241b() {
        return this.f7121a.mo888b();
    }

    public final void m10240a(Interpolator interpolator) {
        this.f7121a.mo887a(interpolator);
    }

    public final void m10239a(final AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            this.f7121a.mo886a(new AnimatorUpdateListenerProxy(this) {
                final /* synthetic */ ValueAnimatorCompat f7120b;

                public final void mo881a() {
                    animatorUpdateListener.mo847a(this.f7120b);
                }
            });
        } else {
            this.f7121a.mo886a(null);
        }
    }

    public final void m10238a(int i, int i2) {
        this.f7121a.mo885a(i, i2);
    }

    public final int m10242c() {
        return this.f7121a.mo889c();
    }

    public final void m10236a(float f, float f2) {
        this.f7121a.mo883a(f, f2);
    }

    public final float m10243d() {
        return this.f7121a.mo890d();
    }

    public final void m10237a(int i) {
        this.f7121a.mo884a(i);
    }

    public final void m10244e() {
        this.f7121a.mo891e();
    }
}
