package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.messaging.photos.editing.SceneLayersPresenter.C19043;

/* compiled from: did_tap_notyou_message */
public class RotateGestureDetector {
    private int f16118A;
    private int f16119B;
    private float f16120C;
    private float f16121D;
    private float f16122E;
    private int f16123F;
    private long f16124G;
    private int f16125H;
    public MotionEvent f16126I;
    public int f16127J = 0;
    public final Handler f16128K;
    public GestureDetector f16129L;
    public final Context f16130a;
    private final SimpleOnRotateGestureListener f16131b;
    public C19043 f16132c;
    public float f16133d;
    public float f16134e;
    public boolean f16135f;
    public boolean f16136g;
    private float f16137h;
    private float f16138i;
    private float f16139j;
    private float f16140k;
    private float f16141l;
    public float f16142m;
    public float f16143n;
    private float f16144o;
    private float f16145p;
    public float f16146q;
    public float f16147r;
    private float f16148s;
    private float f16149t;
    private long f16150u;
    private long f16151v;
    public boolean f16152w;
    private int f16153x;
    private int f16154y;
    private int f16155z;

    /* compiled from: did_tap_notyou_message */
    public class C19001 extends SimpleOnGestureListener {
        final /* synthetic */ RotateGestureDetector f16117a;

        public C19001(RotateGestureDetector rotateGestureDetector) {
            this.f16117a = rotateGestureDetector;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            this.f16117a.f16126I = motionEvent;
            this.f16117a.f16127J = 1;
            return true;
        }
    }

    /* compiled from: did_tap_notyou_message */
    public class SimpleOnRotateGestureListener {
        public boolean mo670a(RotateGestureDetector rotateGestureDetector) {
            return false;
        }

        public boolean mo671b(RotateGestureDetector rotateGestureDetector) {
            return true;
        }
    }

    public RotateGestureDetector(Context context, SimpleOnRotateGestureListener simpleOnRotateGestureListener) {
        this.f16130a = context;
        this.f16131b = simpleOnRotateGestureListener;
        this.f16153x = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        this.f16154y = 3;
        this.f16128K = null;
        Resources resources = context.getResources();
        this.f16125H = resources.getDimensionPixelSize(2131427950);
        this.f16155z = resources.getDimensionPixelSize(2131427951);
        this.f16118A = resources.getDimensionPixelOffset(2131427961);
        this.f16119B = resources.getDimensionPixelOffset(2131427962);
    }

    private void m16278b(MotionEvent motionEvent) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = uptimeMillis - this.f16124G >= 128 ? 1 : 0;
        while (i < pointerCount) {
            int i4;
            if (Float.isNaN(this.f16122E)) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            int historySize = motionEvent.getHistorySize();
            int i5 = historySize + 1;
            int i6 = 0;
            float f2 = f;
            while (i6 < i5) {
                int signum;
                if (i6 < historySize) {
                    f = motionEvent.getHistoricalTouchMajor(i, i6);
                } else {
                    f = motionEvent.getTouchMajor(i);
                }
                if (f < ((float) this.f16125H)) {
                    f = (float) this.f16125H;
                }
                float f3 = f2 + f;
                if (Float.isNaN(this.f16120C) || f > this.f16120C) {
                    this.f16120C = f;
                }
                if (Float.isNaN(this.f16121D) || f < this.f16121D) {
                    this.f16121D = f;
                }
                if (i4 != 0) {
                    signum = (int) Math.signum(f - this.f16122E);
                    if (signum != this.f16123F || (signum == 0 && this.f16123F == 0)) {
                        this.f16123F = signum;
                        this.f16124G = i6 < historySize ? motionEvent.getHistoricalEventTime(i6) : motionEvent.getEventTime();
                        signum = 0;
                        i6++;
                        f2 = f3;
                        i3 = signum;
                    }
                }
                signum = i3;
                i6++;
                f2 = f3;
                i3 = signum;
            }
            i++;
            i2 += i5;
            f = f2;
        }
        float f4 = f / ((float) i2);
        if (i3 != 0) {
            f4 = (f4 + (this.f16120C + this.f16121D)) / 3.0f;
            this.f16120C = (this.f16120C + f4) / 2.0f;
            this.f16121D = (this.f16121D + f4) / 2.0f;
            this.f16122E = f4;
            this.f16123F = 0;
            this.f16124G = motionEvent.getEventTime();
        }
    }

    private void m16279e() {
        this.f16120C = Float.NaN;
        this.f16121D = Float.NaN;
        this.f16122E = Float.NaN;
        this.f16123F = 0;
        this.f16124G = 0;
    }

    public final boolean m16281a(MotionEvent motionEvent) {
        int i;
        float f;
        float f2;
        float f3;
        this.f16150u = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f16135f) {
            this.f16129L.onTouchEvent(motionEvent);
        }
        Object obj = (actionMasked == 1 || actionMasked == 3) ? 1 : null;
        if (actionMasked == 0 || obj != null) {
            if (this.f16152w) {
                this.f16152w = false;
                this.f16139j = 0.0f;
                this.f16127J = 0;
            } else if (this.f16127J == 1 && obj != null) {
                this.f16152w = false;
                this.f16139j = 0.0f;
                this.f16127J = 0;
            }
            if (obj != null) {
                m16279e();
                return true;
            }
        }
        Object obj2 = (actionMasked == 0 || actionMasked == 6 || actionMasked == 5) ? 1 : null;
        Object obj3 = actionMasked == 6 ? 1 : null;
        int actionIndex = obj3 != null ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        if (obj3 != null) {
            i = pointerCount - 1;
        } else {
            i = pointerCount;
        }
        if (this.f16127J != 1) {
            f = 0.0f;
            f2 = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    f2 += motionEvent.getX(i2);
                    f += motionEvent.getY(i2);
                }
            }
            f2 /= (float) i;
            f /= (float) i;
        } else if (this.f16132c != null) {
            f2 = this.f16132c.m16300a();
            f = this.f16132c.m16301b();
        } else {
            f2 = this.f16126I.getX();
            f = this.f16126I.getY();
        }
        m16278b(motionEvent);
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                float f6 = this.f16122E / 2.0f;
                f5 += Math.abs(motionEvent.getX(i3) - f2) + f6;
                f4 += f6 + Math.abs(motionEvent.getY(i3) - f);
            }
        }
        f5 /= (float) i;
        f4 /= (float) i;
        float x = m16280f() ? motionEvent.getX(0) - this.f16132c.m16300a() : pointerCount > 1 ? motionEvent.getX(1) - motionEvent.getX(0) : 0.0f;
        float y = m16280f() ? motionEvent.getY(0) - this.f16132c.m16301b() : pointerCount > 1 ? motionEvent.getY(1) - motionEvent.getY(0) : 0.0f;
        f5 *= 2.0f;
        f4 *= 2.0f;
        if (m16280f()) {
            f3 = f4;
        } else {
            f3 = (float) Math.sqrt((double) ((f5 * f5) + (f4 * f4)));
        }
        boolean z = this.f16152w;
        this.f16133d = f2;
        this.f16134e = f;
        if (!m16280f() && this.f16152w && (f3 < ((float) this.f16155z) || obj2 != null)) {
            this.f16152w = false;
            this.f16139j = f3;
            this.f16127J = 0;
        }
        if (obj2 != null) {
            this.f16140k = f5;
            this.f16144o = f5;
            this.f16141l = f4;
            this.f16145p = f4;
            this.f16142m = x;
            this.f16146q = x;
            this.f16148s = x;
            this.f16143n = y;
            this.f16147r = y;
            this.f16149t = y;
            this.f16137h = f3;
            this.f16138i = f3;
            this.f16139j = f3;
        }
        int i4 = m16280f() ? this.f16153x : this.f16155z;
        if (!this.f16152w && f3 >= ((float) i4) && (z || Math.abs(m16277a(this.f16149t, this.f16148s, y, x)) > ((float) this.f16154y))) {
            this.f16140k = f5;
            this.f16144o = f5;
            this.f16141l = f4;
            this.f16145p = f4;
            this.f16142m = x;
            this.f16146q = x;
            this.f16143n = y;
            this.f16147r = y;
            this.f16137h = f3;
            this.f16138i = f3;
            this.f16151v = this.f16150u;
            this.f16152w = this.f16131b.mo671b(this);
        }
        if (actionMasked == 2) {
            boolean a;
            this.f16140k = f5;
            this.f16141l = f4;
            this.f16137h = f3;
            this.f16142m = x;
            this.f16143n = y;
            if (m16280f() && this.f16136g) {
                x = MathUtil.m16202b((float) this.f16119B, (float) this.f16118A, (float) Math.sqrt((double) ((x * x) + (y * y))));
                this.f16144o = MathUtil.m16201a(this.f16140k, this.f16144o, x);
                this.f16145p = MathUtil.m16201a(this.f16141l, this.f16145p, x);
                this.f16146q = MathUtil.m16201a(this.f16142m, this.f16146q, x);
                this.f16147r = MathUtil.m16201a(this.f16143n, this.f16147r, x);
                this.f16138i = MathUtil.m16201a(this.f16137h, this.f16138i, x);
            }
            if (this.f16152w) {
                a = this.f16131b.mo670a(this);
            } else {
                a = true;
            }
            if (a) {
                this.f16144o = this.f16140k;
                this.f16145p = this.f16141l;
                this.f16146q = this.f16142m;
                this.f16147r = this.f16143n;
                this.f16138i = this.f16137h;
                this.f16151v = this.f16150u;
            }
        }
        return true;
    }

    private boolean m16280f() {
        return this.f16127J == 1;
    }

    public static float m16277a(float f, float f2, float f3, float f4) {
        return (float) (((Math.atan2((double) f, (double) f2) - Math.atan2((double) f3, (double) f4)) * 180.0d) / 3.141592653589793d);
    }
}
