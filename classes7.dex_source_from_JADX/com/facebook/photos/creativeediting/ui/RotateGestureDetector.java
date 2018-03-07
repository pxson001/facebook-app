package com.facebook.photos.creativeediting.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: live_video_viewers */
public class RotateGestureDetector {
    private int f10034A;
    private long f10035B;
    private int f10036C;
    private final Context f10037a;
    private final SimpleOnRotateGestureListener f10038b;
    public float f10039c;
    public float f10040d;
    private float f10041e;
    private float f10042f;
    private float f10043g;
    private float f10044h;
    private float f10045i;
    public float f10046j;
    public float f10047k;
    private float f10048l;
    private float f10049m;
    public float f10050n;
    public float f10051o;
    private float f10052p;
    private float f10053q;
    private long f10054r;
    private long f10055s;
    private boolean f10056t;
    private int f10057u;
    private int f10058v = 3;
    private int f10059w;
    private float f10060x;
    private float f10061y;
    private float f10062z;

    /* compiled from: live_video_viewers */
    public class SimpleOnRotateGestureListener {
        public boolean mo543b(RotateGestureDetector rotateGestureDetector) {
            return false;
        }

        public boolean mo542a(RotateGestureDetector rotateGestureDetector) {
            return true;
        }

        public void mo541a() {
        }
    }

    public RotateGestureDetector(Context context, SimpleOnRotateGestureListener simpleOnRotateGestureListener) {
        this.f10037a = context;
        this.f10038b = simpleOnRotateGestureListener;
        this.f10057u = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        Resources resources = context.getResources();
        this.f10036C = resources.getDimensionPixelSize(2131427950);
        this.f10059w = resources.getDimensionPixelSize(2131427951);
    }

    private void m11966b(MotionEvent motionEvent) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = uptimeMillis - this.f10035B >= 128 ? 1 : 0;
        while (i < pointerCount) {
            int i4;
            if (Float.isNaN(this.f10062z)) {
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
                if (f < ((float) this.f10036C)) {
                    f = (float) this.f10036C;
                }
                float f3 = f2 + f;
                if (Float.isNaN(this.f10060x) || f > this.f10060x) {
                    this.f10060x = f;
                }
                if (Float.isNaN(this.f10061y) || f < this.f10061y) {
                    this.f10061y = f;
                }
                if (i4 != 0) {
                    signum = (int) Math.signum(f - this.f10062z);
                    if (signum != this.f10034A || (signum == 0 && this.f10034A == 0)) {
                        this.f10034A = signum;
                        this.f10035B = i6 < historySize ? motionEvent.getHistoricalEventTime(i6) : motionEvent.getEventTime();
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
            f4 = (f4 + (this.f10060x + this.f10061y)) / 3.0f;
            this.f10060x = (this.f10060x + f4) / 2.0f;
            this.f10061y = (this.f10061y + f4) / 2.0f;
            this.f10062z = f4;
            this.f10034A = 0;
            this.f10035B = motionEvent.getEventTime();
        }
    }

    private void m11967d() {
        this.f10060x = Float.NaN;
        this.f10061y = Float.NaN;
        this.f10062z = Float.NaN;
        this.f10034A = 0;
        this.f10035B = 0;
    }

    public final boolean m11968a(MotionEvent motionEvent) {
        int i;
        int i2;
        this.f10054r = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        Object obj = (actionMasked == 1 || actionMasked == 3) ? 1 : null;
        if (actionMasked == 0 || obj != null) {
            if (this.f10056t) {
                this.f10038b.mo541a();
                this.f10056t = false;
                this.f10043g = 0.0f;
            }
            if (obj != null) {
                m11967d();
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
        float f = 0.0f;
        float f2 = 0.0f;
        for (i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                f2 += motionEvent.getX(i2);
                f += motionEvent.getY(i2);
            }
        }
        float f3 = f2 / ((float) i);
        float f4 = f / ((float) i);
        m11966b(motionEvent);
        f = 0.0f;
        f2 = 0.0f;
        for (i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                float f5 = this.f10062z / 2.0f;
                f2 += Math.abs(motionEvent.getX(i2) - f3) + f5;
                f += f5 + Math.abs(motionEvent.getY(i2) - f4);
            }
        }
        f2 /= (float) i;
        f /= (float) i;
        float x = pointerCount > 1 ? motionEvent.getX(1) - motionEvent.getX(0) : 0.0f;
        float y = pointerCount > 1 ? motionEvent.getY(1) - motionEvent.getY(0) : 0.0f;
        float f6 = 2.0f * f2;
        f *= 2.0f;
        f2 = (float) Math.sqrt((double) ((f6 * f6) + (f * f)));
        boolean z = this.f10056t;
        this.f10039c = f3;
        this.f10040d = f4;
        if (this.f10056t && (f2 < ((float) this.f10059w) || obj2 != null)) {
            this.f10038b.mo541a();
            this.f10056t = false;
            this.f10043g = f2;
        }
        if (obj2 != null) {
            this.f10044h = f6;
            this.f10048l = f6;
            this.f10045i = f;
            this.f10049m = f;
            this.f10046j = x;
            this.f10050n = x;
            this.f10052p = x;
            this.f10047k = y;
            this.f10051o = y;
            this.f10053q = y;
            this.f10041e = f2;
            this.f10042f = f2;
            this.f10043g = f2;
        }
        int i3 = this.f10059w;
        if (!this.f10056t && f2 >= ((float) i3) && (z || Math.abs(m11965a(this.f10053q, this.f10052p, y, x)) > ((float) this.f10058v))) {
            this.f10044h = f6;
            this.f10048l = f6;
            this.f10045i = f;
            this.f10049m = f;
            this.f10046j = x;
            this.f10050n = x;
            this.f10047k = y;
            this.f10051o = y;
            this.f10041e = f2;
            this.f10042f = f2;
            this.f10055s = this.f10054r;
            this.f10056t = this.f10038b.mo542a(this);
        }
        if (actionMasked == 2) {
            this.f10044h = f6;
            this.f10045i = f;
            this.f10041e = f2;
            this.f10046j = x;
            this.f10047k = y;
            boolean z2 = true;
            if (this.f10056t) {
                z2 = this.f10038b.mo543b(this);
            }
            if (z2) {
                this.f10048l = this.f10044h;
                this.f10049m = this.f10045i;
                this.f10050n = this.f10046j;
                this.f10051o = this.f10047k;
                this.f10042f = this.f10041e;
                this.f10055s = this.f10054r;
            }
        }
        return true;
    }

    public static float m11965a(float f, float f2, float f3, float f4) {
        return (float) (((Math.atan2((double) f, (double) f2) - Math.atan2((double) f3, (double) f4)) * 180.0d) / 3.141592653589793d);
    }
}
