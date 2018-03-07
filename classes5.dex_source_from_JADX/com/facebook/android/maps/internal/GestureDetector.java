package com.facebook.android.maps.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;

/* compiled from: aymt_log_event */
public class GestureDetector {
    private final float[] f8401A = new float[2];
    private VelocityTracker f8402B;
    private float f8403C;
    private boolean f8404D;
    public float f8405E = 1.0f;
    public float f8406F = 1.0f;
    private float f8407G = 1.0f;
    private final Dispatchable f8408H = new C09281(this);
    private final Dispatchable f8409I = new C09292(this);
    public Listener f8410a;
    public Matrix f8411b;
    private int f8412c;
    private long f8413d;
    private float f8414e;
    private float f8415f;
    private float f8416g;
    private float f8417h;
    private boolean f8418i;
    private float f8419j = 1.0f;
    private float f8420k;
    private boolean f8421l;
    public float f8422m;
    public float f8423n;
    private final int f8424o;
    private long f8425p;
    public boolean f8426q;
    private final long f8427r;
    private float f8428s;
    private float f8429t;
    private long f8430u;
    private boolean f8431v;
    private int f8432w;
    private int f8433x;
    private float f8434y;
    private boolean f8435z;

    /* compiled from: aymt_log_event */
    public interface Listener {
        void mo1047a(float f, float f2);

        void mo1048a(float f, float f2, float f3);

        void mo1049a(float f, float f2, float f3, float f4);

        void mo1051b(float f, float f2);

        void mo1052b(float f, float f2, float f3);

        void mo1054c(float f, float f2);

        void mo1055d(float f, float f2);

        void mo1056e();

        void mo1057e(float f, float f2);

        void mo1058f();

        void mo1059f(float f, float f2);

        void mo1060g();
    }

    /* compiled from: aymt_log_event */
    class C09281 extends Dispatchable {
        final /* synthetic */ GestureDetector f8399a;

        C09281(GestureDetector gestureDetector) {
            this.f8399a = gestureDetector;
        }

        public void run() {
            this.f8399a.f8410a.mo1054c(this.f8399a.f8422m, this.f8399a.f8423n);
        }
    }

    /* compiled from: aymt_log_event */
    class C09292 extends Dispatchable {
        final /* synthetic */ GestureDetector f8400a;

        C09292(GestureDetector gestureDetector) {
            this.f8400a = gestureDetector;
        }

        public void run() {
            this.f8400a.f8426q = false;
            this.f8400a.f8410a.mo1055d(this.f8400a.f8422m, this.f8400a.f8423n);
        }
    }

    public GestureDetector(Context context, Listener listener) {
        this.f8410a = listener;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f8424o = viewConfiguration.getScaledTouchSlop();
        this.f8427r = (long) ViewConfiguration.getLongPressTimeout();
        this.f8432w = ViewConfiguration.getDoubleTapTimeout();
        this.f8433x = viewConfiguration.getScaledDoubleTapSlop();
        this.f8403C = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8404D = context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct");
    }

    public final boolean m14485a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int pointerCount = motionEvent.getPointerCount();
        long eventTime = motionEvent.getEventTime();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.f8426q && (actionMasked != 2 || pointerCount > 1 || Math.abs(x - this.f8422m) > ((float) this.f8424o) || Math.abs(y - this.f8423n) > ((float) this.f8424o))) {
            this.f8426q = false;
            GrandCentralDispatch.b("longPressTimeout");
        }
        float f;
        float f2;
        if (actionMasked == 2) {
            float x2;
            actionMasked = 0;
            f = 0.0f;
            float f3 = 0.0f;
            while (actionMasked < pointerCount) {
                x2 = motionEvent.getX(actionMasked) + f;
                actionMasked++;
                f3 = motionEvent.getY(actionMasked) + f3;
                f = x2;
            }
            f /= (float) pointerCount;
            f2 = f3 / ((float) pointerCount);
            x2 = 0.0f;
            for (int i = 0; i < pointerCount; i++) {
                x2 += (float) Math.hypot((double) (motionEvent.getX(i) - f), (double) (motionEvent.getY(i) - f2));
            }
            x2 /= (float) pointerCount;
            this.f8416g = f;
            this.f8417h = f2;
            if (this.f8411b != null) {
                this.f8401A[0] = f;
                this.f8401A[1] = f2;
                this.f8411b.mapPoints(this.f8401A);
                f = this.f8401A[0];
                f2 = this.f8401A[1];
            }
            if (pointerCount != this.f8412c) {
                this.f8420k = x2;
                this.f8419j = 1.0f;
                if (pointerCount > 1) {
                    this.f8434y = (float) Math.toDegrees(Math.atan2((double) (y - motionEvent.getY(1)), (double) (x - motionEvent.getX(1))));
                }
                if (this.f8402B != null) {
                    this.f8402B.clear();
                }
            } else {
                f3 = f - this.f8414e;
                float f4 = f2 - this.f8415f;
                if ((!this.f8418i && (Math.abs(this.f8416g - this.f8422m) > ((float) this.f8424o) || Math.abs(this.f8417h - this.f8423n) > ((float) this.f8424o))) || (this.f8418i && ((this.f8404D || !this.f8421l) && !(f3 == 0.0f && f4 == 0.0f)))) {
                    this.f8410a.mo1049a(this.f8416g, this.f8417h, f3 * this.f8405E, f4 * this.f8405E);
                    if (this.f8402B != null) {
                        this.f8402B.addMovement(motionEvent);
                    }
                    this.f8418i = true;
                }
                if (pointerCount > 1) {
                    f3 = this.f8420k != 0.0f ? x2 / this.f8420k : 1.0f;
                    this.f8410a.mo1048a((f3 / this.f8419j) * this.f8407G, this.f8416g, this.f8417h);
                    this.f8419j = f3;
                    this.f8421l = true;
                    if (this.f8404D) {
                        x = (float) Math.toDegrees(Math.atan2((double) (y - motionEvent.getY(1)), (double) (x - motionEvent.getX(1))));
                        if (this.f8412c != pointerCount) {
                            this.f8434y = x;
                        }
                        f3 = x - this.f8434y;
                        if (f3 > 180.0f) {
                            f3 -= 360.0f;
                        } else if (f3 < -180.0f) {
                            f3 += 360.0f;
                        }
                        this.f8434y = x;
                        if (-30.0f < f3 && f3 < 30.0f) {
                            this.f8410a.mo1052b(this.f8406F * f3, this.f8416g, this.f8417h);
                            this.f8435z = true;
                        }
                        if (((double) Math.abs(f3)) > 0.5d) {
                            this.f8425p = 0;
                        }
                    }
                    if (Math.abs(x2 - this.f8420k) > ((float) this.f8424o)) {
                        this.f8425p = 0;
                    }
                }
            }
            this.f8414e = f;
            this.f8415f = f2;
            this.f8412c = pointerCount;
        } else if (actionMasked == 0) {
            this.f8418i = false;
            this.f8421l = false;
            this.f8435z = false;
            if (!this.f8431v || eventTime - this.f8430u > ((long) this.f8432w) || Math.abs(x - this.f8428s) > ((float) this.f8433x) || Math.abs(y - this.f8429t) > ((float) this.f8433x)) {
                this.f8431v = false;
                this.f8428s = x;
                this.f8429t = y;
                this.f8430u = eventTime;
            }
            this.f8422m = x;
            this.f8423n = y;
            this.f8426q = true;
            GrandCentralDispatch.a(this.f8409I, "longPressTimeout", this.f8427r);
            if (this.f8402B == null) {
                this.f8402B = VelocityTracker.obtain();
            } else {
                this.f8402B.clear();
            }
            this.f8402B.addMovement(motionEvent);
            this.f8410a.mo1047a(x, y);
        } else if (actionMasked == 1) {
            this.f8412c = 0;
            if (eventTime - this.f8425p < ((long) ViewConfiguration.getTapTimeout())) {
                this.f8410a.mo1056e();
            } else if (this.f8431v && eventTime - this.f8430u < ((long) this.f8432w) && Math.abs(x - this.f8428s) < ((float) this.f8433x) && Math.abs(y - this.f8429t) < ((float) this.f8433x)) {
                GrandCentralDispatch.b("clickTimeout");
                this.f8410a.mo1057e(this.f8428s, this.f8429t);
            } else if (this.f8418i) {
                if (eventTime - this.f8413d < ((long) ViewConfiguration.getDoubleTapTimeout())) {
                    if (this.f8435z) {
                        this.f8410a.mo1060g();
                    }
                    if (this.f8421l) {
                        this.f8410a.mo1058f();
                    }
                }
                if (this.f8418i) {
                    this.f8402B.addMovement(motionEvent);
                    this.f8402B.computeCurrentVelocity(1000);
                    f2 = this.f8402B.getXVelocity();
                    f = this.f8402B.getYVelocity();
                    if (Math.max(Math.abs(f2), Math.abs(f)) >= this.f8403C) {
                        this.f8410a.mo1059f(f2 * this.f8405E, f * this.f8405E);
                    }
                }
            } else {
                GrandCentralDispatch.a(this.f8408H, "clickTimeout", (long) this.f8432w);
            }
            this.f8431v = !this.f8431v;
            this.f8410a.mo1051b(this.f8422m, this.f8423n);
        } else if (actionMasked == 5) {
            this.f8425p = eventTime;
        } else if (actionMasked == 6) {
            if (pointerCount == 2) {
                this.f8413d = eventTime;
                if (!this.f8404D) {
                    this.f8421l = false;
                    this.f8435z = false;
                }
            }
        } else if (actionMasked == 3) {
            this.f8412c = 0;
            if (this.f8402B != null) {
                this.f8402B.recycle();
                this.f8402B = null;
            }
        }
        return true;
    }
}
