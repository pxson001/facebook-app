package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.messaging.photos.editing.SceneLayersPresenter.C19032;

/* compiled from: did_tap_change_shipping_button */
public class ScaleGestureDetector {
    private int f16158A;
    public MotionEvent f16159B;
    public int f16160C;
    private final Handler f16161D;
    private GestureDetector f16162E;
    private boolean f16163F;
    private final Context f16164a;
    private final SimpleOnScaleGestureListener f16165b;
    private C19032 f16166c;
    public float f16167d;
    public float f16168e;
    private boolean f16169f;
    private boolean f16170g;
    private float f16171h;
    private float f16172i;
    private float f16173j;
    private float f16174k;
    private float f16175l;
    private float f16176m;
    private float f16177n;
    private long f16178o;
    private long f16179p;
    public boolean f16180q;
    private int f16181r;
    private int f16182s;
    private int f16183t;
    private int f16184u;
    private float f16185v;
    private float f16186w;
    private float f16187x;
    private int f16188y;
    private long f16189z;

    /* compiled from: did_tap_change_shipping_button */
    class C19011 extends SimpleOnGestureListener {
        final /* synthetic */ ScaleGestureDetector f16157a;

        C19011(ScaleGestureDetector scaleGestureDetector) {
            this.f16157a = scaleGestureDetector;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            this.f16157a.f16159B = motionEvent;
            this.f16157a.f16160C = 1;
            return true;
        }
    }

    /* compiled from: did_tap_change_shipping_button */
    public class SimpleOnScaleGestureListener {
        public boolean mo672a(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public boolean mo673b(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }
    }

    public ScaleGestureDetector(Context context, SimpleOnScaleGestureListener simpleOnScaleGestureListener) {
        this(context, simpleOnScaleGestureListener, null);
    }

    private ScaleGestureDetector(Context context, SimpleOnScaleGestureListener simpleOnScaleGestureListener, Handler handler) {
        this.f16160C = 0;
        this.f16164a = context;
        this.f16165b = simpleOnScaleGestureListener;
        this.f16181r = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        Resources resources = context.getResources();
        this.f16158A = resources.getDimensionPixelSize(2131427950);
        this.f16182s = resources.getDimensionPixelSize(2131427951);
        this.f16183t = resources.getDimensionPixelOffset(2131427959);
        this.f16184u = resources.getDimensionPixelOffset(2131427960);
        this.f16161D = handler;
        if (context.getApplicationInfo().targetSdkVersion > 18) {
            m16291a(true, false, null);
        }
    }

    private void m16288b(MotionEvent motionEvent) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = uptimeMillis - this.f16189z >= 128 ? 1 : 0;
        while (i < pointerCount) {
            int i4;
            if (Float.isNaN(this.f16187x)) {
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
                if (f < ((float) this.f16158A)) {
                    f = (float) this.f16158A;
                }
                float f3 = f2 + f;
                if (Float.isNaN(this.f16185v) || f > this.f16185v) {
                    this.f16185v = f;
                }
                if (Float.isNaN(this.f16186w) || f < this.f16186w) {
                    this.f16186w = f;
                }
                if (i4 != 0) {
                    signum = (int) Math.signum(f - this.f16187x);
                    if (signum != this.f16188y || (signum == 0 && this.f16188y == 0)) {
                        this.f16188y = signum;
                        this.f16189z = i6 < historySize ? motionEvent.getHistoricalEventTime(i6) : motionEvent.getEventTime();
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
            f4 = (f4 + (this.f16185v + this.f16186w)) / 3.0f;
            this.f16185v = (this.f16185v + f4) / 2.0f;
            this.f16186w = (this.f16186w + f4) / 2.0f;
            this.f16187x = f4;
            this.f16188y = 0;
            this.f16189z = motionEvent.getEventTime();
        }
    }

    private void m16289e() {
        this.f16185v = Float.NaN;
        this.f16186w = Float.NaN;
        this.f16187x = Float.NaN;
        this.f16188y = 0;
        this.f16189z = 0;
    }

    public final boolean m16292a(MotionEvent motionEvent) {
        int i;
        float c;
        float b;
        float f;
        this.f16178o = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f16169f) {
            this.f16162E.onTouchEvent(motionEvent);
        }
        Object obj = (actionMasked == 1 || actionMasked == 3) ? 1 : null;
        if (actionMasked == 0 || obj != null) {
            if (this.f16180q) {
                this.f16180q = false;
                this.f16173j = 0.0f;
                this.f16160C = 0;
            } else if (this.f16160C == 1 && obj != null) {
                this.f16180q = false;
                this.f16173j = 0.0f;
                this.f16160C = 0;
            }
            if (obj != null) {
                m16289e();
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
        if (this.f16160C == 1) {
            if (this.f16166c != null) {
                c = SceneLayersPresenter.m16313c(this.f16166c.f16198a);
                b = this.f16166c.m16299b();
            } else {
                c = this.f16159B.getX();
                b = this.f16159B.getY();
            }
            if (motionEvent.getY() < b) {
                this.f16163F = true;
            } else {
                this.f16163F = false;
            }
        } else {
            b = 0.0f;
            c = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    c += motionEvent.getX(i2);
                    b += motionEvent.getY(i2);
                }
            }
            c /= (float) i;
            b /= (float) i;
        }
        m16288b(motionEvent);
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                float f4 = this.f16187x / 2.0f;
                f3 += Math.abs(motionEvent.getX(i3) - c) + f4;
                f2 += f4 + Math.abs(motionEvent.getY(i3) - b);
            }
        }
        float f5 = f2 / ((float) i);
        f2 = (f3 / ((float) i)) * 2.0f;
        f5 *= 2.0f;
        if (m16290f()) {
            f = f5;
        } else {
            f = (float) Math.sqrt((double) ((f2 * f2) + (f5 * f5)));
        }
        boolean z = this.f16180q;
        this.f16167d = c;
        this.f16168e = b;
        if (!m16290f() && this.f16180q && (f < ((float) this.f16182s) || obj2 != null)) {
            this.f16180q = false;
            this.f16173j = f;
            this.f16160C = 0;
        }
        if (obj2 != null) {
            this.f16174k = f2;
            this.f16176m = f2;
            this.f16175l = f5;
            this.f16177n = f5;
            this.f16171h = f;
            this.f16172i = f;
            this.f16173j = f;
        }
        pointerCount = m16290f() ? this.f16181r : this.f16182s;
        if (!this.f16180q && f >= ((float) pointerCount) && (z || Math.abs(f - this.f16173j) > ((float) this.f16181r))) {
            this.f16174k = f2;
            this.f16176m = f2;
            this.f16175l = f5;
            this.f16177n = f5;
            this.f16171h = f;
            this.f16172i = f;
            this.f16179p = this.f16178o;
            this.f16180q = this.f16165b.mo673b(this);
        }
        if (actionMasked == 2) {
            this.f16174k = f2;
            this.f16175l = f5;
            this.f16171h = f;
            boolean z2 = true;
            if (m16290f() && this.f16170g) {
                f5 = MathUtil.m16202b((float) this.f16184u, (float) this.f16183t, Math.abs(this.f16167d - motionEvent.getX()));
                this.f16176m = MathUtil.m16201a(this.f16174k, this.f16176m, f5);
                this.f16177n = MathUtil.m16201a(this.f16175l, this.f16177n, f5);
                this.f16172i = MathUtil.m16201a(this.f16171h, this.f16172i, f5);
            }
            if (this.f16180q) {
                z2 = this.f16165b.mo672a(this);
            }
            if (z2) {
                this.f16176m = this.f16174k;
                this.f16177n = this.f16175l;
                this.f16172i = this.f16171h;
                this.f16179p = this.f16178o;
            }
        }
        return true;
    }

    private boolean m16290f() {
        return this.f16160C == 1;
    }

    public final void m16291a(boolean z, boolean z2, C19032 c19032) {
        this.f16169f = z;
        this.f16166c = c19032;
        this.f16170g = z2;
        if (this.f16169f && this.f16162E == null) {
            this.f16162E = new GestureDetector(this.f16164a, new C19011(this), this.f16161D);
        }
    }

    public final float m16293d() {
        if (!m16290f()) {
            return this.f16172i > 0.0f ? this.f16171h / this.f16172i : 1.0f;
        } else {
            Object obj = ((!this.f16163F || this.f16171h >= this.f16172i) && (this.f16163F || this.f16171h <= this.f16172i)) ? null : 1;
            float abs = Math.abs(1.0f - (this.f16171h / this.f16172i)) * 0.5f;
            if (this.f16172i <= 0.0f) {
                return 1.0f;
            }
            return obj != null ? 1.0f + abs : 1.0f - abs;
        }
    }
}
