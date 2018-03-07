package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

/* compiled from: rtc_snake_gk */
public class EdgeEffectCompat {
    private static final EdgeEffectImpl f6432b;
    private Object f6433a;

    /* compiled from: rtc_snake_gk */
    class EdgeEffectIcsImpl implements EdgeEffectImpl {
        public final Object mo1494a(Context context) {
            return new EdgeEffect(context);
        }

        EdgeEffectIcsImpl() {
        }

        public final void mo1495a(Object obj, int i, int i2) {
            EdgeEffectCompatIcs.m13829a(obj, i, i2);
        }

        public final boolean mo1496a(Object obj) {
            return EdgeEffectCompatIcs.m13830a(obj);
        }

        public final void mo1500b(Object obj) {
            EdgeEffectCompatIcs.m13834b(obj);
        }

        public final boolean mo1497a(Object obj, float f) {
            return EdgeEffectCompatIcs.m13831a(obj, f);
        }

        public final boolean mo1502c(Object obj) {
            return EdgeEffectCompatIcs.m13835c(obj);
        }

        public final boolean mo1498a(Object obj, int i) {
            return EdgeEffectCompatIcs.m13832a(obj, i);
        }

        public final boolean mo1499a(Object obj, Canvas canvas) {
            return EdgeEffectCompatIcs.m13833a(obj, canvas);
        }

        public final boolean mo1501b(Object obj, float f) {
            return EdgeEffectCompatIcs.m13831a(obj, f);
        }
    }

    /* compiled from: rtc_snake_gk */
    interface EdgeEffectImpl {
        Object mo1494a(Context context);

        void mo1495a(Object obj, int i, int i2);

        boolean mo1496a(Object obj);

        boolean mo1497a(Object obj, float f);

        boolean mo1498a(Object obj, int i);

        boolean mo1499a(Object obj, Canvas canvas);

        void mo1500b(Object obj);

        boolean mo1501b(Object obj, float f);

        boolean mo1502c(Object obj);
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f6432b = new EdgeEffectIcsImpl();
        } else {
            f6432b = new BaseEdgeEffectImpl();
        }
    }

    public EdgeEffectCompat(Context context) {
        this.f6433a = f6432b.mo1494a(context);
    }

    public final void m10836a(int i, int i2) {
        f6432b.mo1495a(this.f6433a, i, i2);
    }

    public final boolean m10837a() {
        return f6432b.mo1496a(this.f6433a);
    }

    public final void m10842b() {
        f6432b.mo1500b(this.f6433a);
    }

    public final boolean m10838a(float f) {
        return f6432b.mo1497a(this.f6433a, f);
    }

    public final boolean m10839a(float f, float f2) {
        return f6432b.mo1501b(this.f6433a, f);
    }

    public final boolean m10843c() {
        return f6432b.mo1502c(this.f6433a);
    }

    public final boolean m10840a(int i) {
        return f6432b.mo1498a(this.f6433a, i);
    }

    public final boolean m10841a(Canvas canvas) {
        return f6432b.mo1499a(this.f6433a, canvas);
    }
}
