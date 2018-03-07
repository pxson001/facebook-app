package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: v\d+\.\d+\/ */
public abstract class AutoScrollHelper implements OnTouchListener {
    private static final int f403r = ViewConfiguration.getTapTimeout();
    public final ClampedScroller f404a = new ClampedScroller();
    private final Interpolator f405b = new AccelerateInterpolator();
    public final View f406c;
    public Runnable f407d;
    public float[] f408e = new float[]{0.0f, 0.0f};
    public float[] f409f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    public int f410g;
    public int f411h;
    private float[] f412i = new float[]{0.0f, 0.0f};
    private float[] f413j = new float[]{0.0f, 0.0f};
    public float[] f414k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    public boolean f415l;
    public boolean f416m;
    public boolean f417n;
    public boolean f418o;
    private boolean f419p;
    private boolean f420q;

    /* compiled from: v\d+\.\d+\/ */
    public class ClampedScroller {
        public int f391a;
        public int f392b;
        public float f393c;
        public float f394d;
        public long f395e = Long.MIN_VALUE;
        public long f396f = 0;
        public int f397g = 0;
        public int f398h = 0;
        public long f399i = -1;
        public float f400j;
        public int f401k;

        public final void m838b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f401k = AutoScrollHelper.m843b((int) (currentAnimationTimeMillis - this.f395e), 0, this.f392b);
            this.f400j = m837a(currentAnimationTimeMillis);
            this.f399i = currentAnimationTimeMillis;
        }

        private float m837a(long j) {
            if (j < this.f395e) {
                return 0.0f;
            }
            if (this.f399i < 0 || j < this.f399i) {
                return AutoScrollHelper.m842b(((float) (j - this.f395e)) / ((float) this.f391a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f399i;
            return (AutoScrollHelper.m842b(((float) j2) / ((float) this.f401k), 0.0f, 1.0f) * this.f400j) + (1.0f - this.f400j);
        }

        public final void m839d() {
            if (this.f396f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m837a(currentAnimationTimeMillis);
            a = ((-4.0f * a) * a) + (4.0f * a);
            long j = currentAnimationTimeMillis - this.f396f;
            this.f396f = currentAnimationTimeMillis;
            this.f397g = (int) ((((float) j) * a) * this.f393c);
            this.f398h = (int) ((((float) j) * a) * this.f394d);
        }
    }

    /* compiled from: v\d+\.\d+\/ */
    public class ScrollAnimationRunnable implements Runnable {
        final /* synthetic */ AutoScrollHelper f402a;

        public ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
            this.f402a = autoScrollHelper;
        }

        public void run() {
            if (this.f402a.f418o) {
                ClampedScroller clampedScroller;
                Object obj;
                if (this.f402a.f416m) {
                    this.f402a.f416m = false;
                    clampedScroller = this.f402a.f404a;
                    clampedScroller.f395e = AnimationUtils.currentAnimationTimeMillis();
                    clampedScroller.f399i = -1;
                    clampedScroller.f396f = clampedScroller.f395e;
                    clampedScroller.f400j = 0.5f;
                    clampedScroller.f397g = 0;
                    clampedScroller.f398h = 0;
                }
                clampedScroller = this.f402a.f404a;
                if (clampedScroller.f399i <= 0 || AnimationUtils.currentAnimationTimeMillis() <= clampedScroller.f399i + ((long) clampedScroller.f401k)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null && AutoScrollHelper.m845b(this.f402a)) {
                    if (this.f402a.f417n) {
                        this.f402a.f417n = false;
                        AutoScrollHelper.m848e(this.f402a);
                    }
                    clampedScroller.m839d();
                    this.f402a.mo189a(clampedScroller.f398h);
                    ViewCompat.a(this.f402a.f406c, this);
                    return;
                }
                this.f402a.f418o = false;
            }
        }
    }

    public abstract void mo189a(int i);

    public abstract boolean mo190a();

    public abstract boolean mo191b(int i);

    public AutoScrollHelper(View view) {
        this.f406c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        float f2 = (float) i;
        this.f414k[0] = f / 1000.0f;
        this.f414k[1] = f2 / 1000.0f;
        m844b((float) i2, (float) i2);
        this.f410g = 1;
        this.f409f[0] = Float.MAX_VALUE;
        this.f409f[1] = Float.MAX_VALUE;
        this.f408e[0] = 0.2f;
        this.f408e[1] = 0.2f;
        m846c(1.0f, 1.0f);
        this.f411h = f403r;
        this.f404a.f391a = 500;
        this.f404a.f392b = 500;
    }

    public final AutoScrollHelper m850a(boolean z) {
        if (this.f419p && !z) {
            m847d();
        }
        this.f419p = z;
        return this;
    }

    private AutoScrollHelper m844b(float f, float f2) {
        this.f413j[0] = f / 1000.0f;
        this.f413j[1] = f2 / 1000.0f;
        return this;
    }

    private AutoScrollHelper m846c(float f, float f2) {
        this.f412i[0] = f / 1000.0f;
        this.f412i[1] = f2 / 1000.0f;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f419p) {
            return false;
        }
        switch (MotionEventCompat.a(motionEvent)) {
            case 0:
                this.f417n = true;
                this.f415l = false;
                break;
            case 1:
            case 3:
                m847d();
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                break;
        }
        float a = m841a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f406c.getWidth());
        float a2 = m841a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f406c.getHeight());
        ClampedScroller clampedScroller = this.f404a;
        clampedScroller.f393c = a;
        clampedScroller.f394d = a2;
        if (!this.f418o && m845b(this)) {
            if (this.f407d == null) {
                this.f407d = new ScrollAnimationRunnable(this);
            }
            this.f418o = true;
            this.f416m = true;
            if (this.f415l || this.f411h <= 0) {
                this.f407d.run();
            } else {
                ViewCompat.a(this.f406c, this.f407d, (long) this.f411h);
            }
            this.f415l = true;
        }
        if (this.f420q && this.f418o) {
            return true;
        }
        return false;
    }

    public static boolean m845b(AutoScrollHelper autoScrollHelper) {
        ClampedScroller clampedScroller = autoScrollHelper.f404a;
        int abs = (int) (clampedScroller.f394d / Math.abs(clampedScroller.f394d));
        return (abs != 0 && autoScrollHelper.mo191b(abs)) || (((int) (clampedScroller.f393c / Math.abs(clampedScroller.f393c))) != 0 && autoScrollHelper.mo190a());
    }

    private void m847d() {
        if (this.f416m) {
            this.f418o = false;
        } else {
            this.f404a.m838b();
        }
    }

    private float m841a(int i, float f, float f2, float f3) {
        float a = m840a(this.f408e[i], f2, this.f409f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f412i[i];
        float f5 = this.f413j[i];
        float f6 = this.f414k[i];
        f4 *= f3;
        if (a > 0.0f) {
            return m842b(a * f4, f5, f6);
        }
        return -m842b((-a) * f4, f5, f6);
    }

    private float m840a(float f, float f2, float f3, float f4) {
        float f5;
        float b = m842b(f * f2, 0.0f, f3);
        b = m849f(f2 - f4, b) - m849f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f405b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f405b.getInterpolation(b);
        }
        return m842b(f5, -1.0f, 1.0f);
    }

    private float m849f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f410g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f418o && this.f410g == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    public static int m843b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    public static float m842b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    public static void m848e(AutoScrollHelper autoScrollHelper) {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        autoScrollHelper.f406c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
