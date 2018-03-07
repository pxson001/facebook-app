package android.support.v4.widget;

import android.content.Context;
import android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: user_create_dialog */
class ScrollerCompat$ScrollerCompatImplBase implements ScrollerCompatImpl {
    ScrollerCompat$ScrollerCompatImplBase() {
    }

    public final Object m995a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public final boolean m1000a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public final int m1001b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public final int m1002c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public final float m1003d(Object obj) {
        return 0.0f;
    }

    public final boolean m1004e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public final void m996a(Object obj, int i, int i2, int i3, int i4) {
        ((Scroller) obj).startScroll(i, i2, i3, i4);
    }

    public final void m997a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public final void m998a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public final void m999a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public final void m1005f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public final int m1006g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public final int m1007h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
