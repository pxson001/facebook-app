package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: num_redirects */
public class ScrollerCompat {
    Object f11932a;
    ScrollerCompatImpl f11933b;

    /* compiled from: num_redirects */
    class ScrollerCompatImplIcs extends ScrollerCompatImplGingerbread {
        ScrollerCompatImplIcs() {
        }

        public final float mo2243d(Object obj) {
            return ScrollerCompatIcs.a(obj);
        }
    }

    /* compiled from: num_redirects */
    class ScrollerCompatImplGingerbread implements ScrollerCompatImpl {
        public final Object mo2244a(Context context, Interpolator interpolator) {
            return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
        }

        ScrollerCompatImplGingerbread() {
        }

        public final boolean mo2249a(Object obj) {
            return ScrollerCompatGingerbread.a(obj);
        }

        public final int mo2250b(Object obj) {
            return ScrollerCompatGingerbread.b(obj);
        }

        public final int mo2251c(Object obj) {
            return ScrollerCompatGingerbread.c(obj);
        }

        public float mo2243d(Object obj) {
            return 0.0f;
        }

        public final boolean mo2252e(Object obj) {
            return ScrollerCompatGingerbread.d(obj);
        }

        public final void mo2245a(Object obj, int i, int i2, int i3, int i4) {
            ScrollerCompatGingerbread.a(obj, i, i2, i3, i4);
        }

        public final void mo2246a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ScrollerCompatGingerbread.a(obj, i, i2, i3, i4, i5);
        }

        public final void mo2247a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ScrollerCompatGingerbread.a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        public final void mo2248a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ScrollerCompatGingerbread.a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public final void mo2253f(Object obj) {
            ScrollerCompatGingerbread.e(obj);
        }

        public final int mo2254g(Object obj) {
            return ScrollerCompatGingerbread.f(obj);
        }

        public final int mo2255h(Object obj) {
            return ScrollerCompatGingerbread.g(obj);
        }
    }

    /* compiled from: num_redirects */
    interface ScrollerCompatImpl {
        Object mo2244a(Context context, Interpolator interpolator);

        void mo2245a(Object obj, int i, int i2, int i3, int i4);

        void mo2246a(Object obj, int i, int i2, int i3, int i4, int i5);

        void mo2247a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void mo2248a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean mo2249a(Object obj);

        int mo2250b(Object obj);

        int mo2251c(Object obj);

        float mo2243d(Object obj);

        boolean mo2252e(Object obj);

        void mo2253f(Object obj);

        int mo2254g(Object obj);

        int mo2255h(Object obj);
    }

    public static ScrollerCompat m17493a(Context context) {
        return m17494a(context, null);
    }

    public static ScrollerCompat m17494a(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    ScrollerCompat(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    private ScrollerCompat(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f11933b = new ScrollerCompatImplIcs();
        } else if (i >= 9) {
            this.f11933b = new ScrollerCompatImplGingerbread();
        } else {
            this.f11933b = new ScrollerCompatImplBase();
        }
        this.f11932a = this.f11933b.mo2244a(context, interpolator);
    }

    public final boolean m17499a() {
        return this.f11933b.mo2249a(this.f11932a);
    }

    public final int m17500b() {
        return this.f11933b.mo2250b(this.f11932a);
    }

    public final int m17501c() {
        return this.f11933b.mo2251c(this.f11932a);
    }

    public final int m17502d() {
        return this.f11933b.mo2254g(this.f11932a);
    }

    public final int m17503e() {
        return this.f11933b.mo2255h(this.f11932a);
    }

    public final float m17504f() {
        return this.f11933b.mo2243d(this.f11932a);
    }

    public final boolean m17505g() {
        return this.f11933b.mo2252e(this.f11932a);
    }

    public final void m17495a(int i, int i2, int i3, int i4) {
        this.f11933b.mo2245a(this.f11932a, i, i2, i3, i4);
    }

    public final void m17496a(int i, int i2, int i3, int i4, int i5) {
        this.f11933b.mo2246a(this.f11932a, i, i2, i3, i4, i5);
    }

    public final void m17497a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f11933b.mo2247a(this.f11932a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public final void m17498a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f11933b.mo2248a(this.f11932a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public final void m17506h() {
        this.f11933b.mo2253f(this.f11932a);
    }
}
