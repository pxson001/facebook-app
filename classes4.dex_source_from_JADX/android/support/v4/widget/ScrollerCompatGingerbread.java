package android.support.v4.widget;

import android.widget.OverScroller;

/* compiled from: val$callback */
class ScrollerCompatGingerbread {
    ScrollerCompatGingerbread() {
    }

    public static boolean m672a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m673b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m674c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m675d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m668a(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void m669a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m670a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static void m671a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static void m676e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m677f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m678g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
