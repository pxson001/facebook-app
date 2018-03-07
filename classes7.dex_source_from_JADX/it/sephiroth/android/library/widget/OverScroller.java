package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: view_save_action */
public class OverScroller {
    private static float f536f = 8.0f;
    private static float f537g;
    private int f538a;
    public final SplineOverScroller f539b;
    public final SplineOverScroller f540c;
    public Interpolator f541d;
    private final boolean f542e;

    /* compiled from: view_save_action */
    public class SplineOverScroller {
        private static float f518p = ((float) (Math.log(0.78d) / Math.log(0.9d)));
        private static final float[] f519q = new float[101];
        private static final float[] f520r = new float[101];
        public int f521a;
        public int f522b;
        public int f523c;
        public int f524d;
        public float f525e;
        public float f526f;
        public long f527g;
        public int f528h;
        private int f529i;
        private int f530j;
        public boolean f531k = true;
        private int f532l;
        public float f533m = ViewConfiguration.getScrollFriction();
        private int f534n = 0;
        private float f535o;

        static {
            float f = 0.0f;
            int i = 0;
            float f2 = 0.0f;
            while (i < 100) {
                float f3;
                float f4 = ((float) i) / 100.0f;
                float f5 = 1.0f;
                float f6 = f2;
                while (true) {
                    f2 = ((f5 - f6) / 2.0f) + f6;
                    f3 = (3.0f * f2) * (1.0f - f2);
                    float f7 = ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3) + ((f2 * f2) * f2);
                    if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                        break;
                    } else if (f7 > f4) {
                        f5 = f2;
                    } else {
                        f6 = f2;
                    }
                }
                f519q[i] = (f2 * (f2 * f2)) + (f3 * (((1.0f - f2) * 0.5f) + f2));
                f5 = 1.0f;
                while (true) {
                    f2 = ((f5 - f) / 2.0f) + f;
                    f3 = (3.0f * f2) * (1.0f - f2);
                    f7 = ((((1.0f - f2) * 0.5f) + f2) * f3) + ((f2 * f2) * f2);
                    if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                        break;
                    } else if (f7 > f4) {
                        f5 = f2;
                    } else {
                        f = f2;
                    }
                }
                f520r[i] = (f2 * (f2 * f2)) + ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3);
                i++;
                f2 = f6;
            }
            float[] fArr = f519q;
            f520r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        SplineOverScroller(Context context) {
            this.f535o = ((context.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        }

        final void m550b(float f) {
            this.f522b = this.f521a + Math.round(((float) (this.f523c - this.f521a)) * f);
        }

        private static float m538a(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void m545d(int i, int i2, int i3) {
            float abs = Math.abs(((float) (i3 - i)) / ((float) (i2 - i)));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = ((float) i4) / 100.0f;
                float f2 = ((float) (i4 + 1)) / 100.0f;
                float f3 = f520r[i4];
                this.f528h = (int) (((((abs - f) / (f2 - f)) * (f520r[i4 + 1] - f3)) + f3) * ((float) this.f528h));
            }
        }

        final void m548a(int i, int i2, int i3) {
            this.f531k = false;
            this.f521a = i;
            this.f523c = i + i2;
            this.f527g = AnimationUtils.currentAnimationTimeMillis();
            this.f528h = i3;
            this.f526f = 0.0f;
            this.f524d = 0;
        }

        final void m547a() {
            this.f522b = this.f523c;
            this.f531k = true;
        }

        final boolean m552b(int i, int i2, int i3) {
            this.f531k = true;
            this.f523c = i;
            this.f521a = i;
            this.f524d = 0;
            this.f527g = AnimationUtils.currentAnimationTimeMillis();
            this.f528h = 0;
            if (i < i2) {
                m539a(i, i2);
            } else if (i > i3) {
                m539a(i, i3);
            }
            if (this.f531k) {
                return false;
            }
            return true;
        }

        private void m539a(int i, int i2) {
            this.f531k = false;
            this.f534n = 1;
            this.f521a = i;
            this.f523c = i2;
            int i3 = i - i2;
            this.f526f = m538a(i3);
            this.f524d = -i3;
            this.f532l = Math.abs(i3);
            this.f528h = (int) (Math.sqrt((((double) i3) * -2.0d) / ((double) this.f526f)) * 1000.0d);
        }

        final void m549a(int i, int i2, int i3, int i4, int i5) {
            this.f532l = i5;
            this.f531k = false;
            this.f524d = i2;
            this.f525e = (float) i2;
            this.f529i = 0;
            this.f528h = 0;
            this.f527g = AnimationUtils.currentAnimationTimeMillis();
            this.f521a = i;
            this.f522b = i;
            if (i > i4 || i < i3) {
                m540a(i, i3, i4, i2);
                return;
            }
            this.f534n = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int d2 = m543d(i2);
                this.f529i = d2;
                this.f528h = d2;
                d = m542c(i2);
            }
            this.f530j = (int) (d * ((double) Math.signum((float) i2)));
            this.f523c = this.f530j + i;
            if (this.f523c < i3) {
                m545d(this.f521a, this.f523c, i3);
                this.f523c = i3;
            }
            if (this.f523c > i4) {
                m545d(this.f521a, this.f523c, i4);
                this.f523c = i4;
            }
        }

        private double m541b(int i) {
            return Math.log((double) ((0.35f * ((float) Math.abs(i))) / (this.f533m * this.f535o)));
        }

        private double m542c(int i) {
            return Math.exp(m541b(i) * (((double) f518p) / (((double) f518p) - 1.0d))) * ((double) (this.f533m * this.f535o));
        }

        private int m543d(int i) {
            return (int) (Math.exp(m541b(i) / (((double) f518p) - 1.0d)) * 1000.0d);
        }

        private void m546f(int i, int i2, int i3) {
            int i4;
            if (i3 == 0) {
                i4 = i - i2;
            } else {
                i4 = i3;
            }
            this.f526f = m538a(i4);
            float sqrt = (float) Math.sqrt((((double) (((((float) (i3 * i3)) / 2.0f) / Math.abs(this.f526f)) + ((float) Math.abs(i2 - i)))) * 2.0d) / ((double) Math.abs(this.f526f)));
            this.f527g -= (long) ((int) ((sqrt - (((float) (-i3)) / this.f526f)) * 1000.0f));
            this.f521a = i2;
            this.f524d = (int) ((-this.f526f) * sqrt);
            m544d();
        }

        private void m540a(int i, int i2, int i3, int i4) {
            boolean z = true;
            if (i <= i2 || i >= i3) {
                int i5;
                boolean z2 = i > i3;
                if (z2) {
                    i5 = i3;
                } else {
                    i5 = i2;
                }
                int i6 = i - i5;
                if (i6 * i4 < 0) {
                    z = false;
                }
                if (z) {
                    m546f(i, i5, i4);
                    return;
                } else if (m542c(i4) > ((double) Math.abs(i6))) {
                    m549a(i, i4, z2 ? i2 : i, z2 ? i : i3, this.f532l);
                    return;
                } else {
                    m539a(i, i5);
                    return;
                }
            }
            Log.e("OverScroller", "startAfterEdge called from a valid position");
            this.f531k = true;
        }

        public final void m553c(int i, int i2, int i3) {
            if (this.f534n == 0) {
                this.f532l = i3;
                this.f527g = AnimationUtils.currentAnimationTimeMillis();
                m540a(i, i2, i2, (int) this.f525e);
            }
        }

        private void m544d() {
            float abs = ((float) (this.f524d * this.f524d)) / (Math.abs(this.f526f) * 2.0f);
            float signum = Math.signum((float) this.f524d);
            if (abs > ((float) this.f532l)) {
                this.f526f = (((-signum) * ((float) this.f524d)) * ((float) this.f524d)) / (((float) this.f532l) * 2.0f);
                abs = (float) this.f532l;
            }
            this.f532l = (int) abs;
            this.f534n = 2;
            int i = this.f521a;
            if (this.f524d <= 0) {
                abs = -abs;
            }
            this.f523c = ((int) abs) + i;
            this.f528h = -((int) ((1000.0f * ((float) this.f524d)) / this.f526f));
        }

        final boolean m551b() {
            switch (this.f534n) {
                case 0:
                    if (this.f528h < this.f529i) {
                        this.f521a = this.f523c;
                        this.f524d = (int) this.f525e;
                        this.f526f = m538a(this.f524d);
                        this.f527g += (long) this.f528h;
                        m544d();
                        break;
                    }
                    return false;
                case 1:
                    return false;
                case 2:
                    this.f527g += (long) this.f528h;
                    m539a(this.f523c, this.f521a);
                    break;
            }
            m554c();
            return true;
        }

        final boolean m554c() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f527g;
            if (currentAnimationTimeMillis > ((long) this.f528h)) {
                return false;
            }
            double d = 0.0d;
            float f;
            float f2;
            float f3;
            switch (this.f534n) {
                case 0:
                    f = ((float) currentAnimationTimeMillis) / ((float) this.f529i);
                    int i = (int) (100.0f * f);
                    float f4 = 1.0f;
                    f2 = 0.0f;
                    if (i < 100) {
                        f4 = ((float) i) / 100.0f;
                        f2 = ((float) (i + 1)) / 100.0f;
                        f3 = f519q[i];
                        f2 = (f519q[i + 1] - f3) / (f2 - f4);
                        f4 = ((f - f4) * f2) + f3;
                    }
                    double d2 = (double) (f4 * ((float) this.f530j));
                    this.f525e = ((f2 * ((float) this.f530j)) / ((float) this.f529i)) * 1000.0f;
                    d = d2;
                    break;
                case 1:
                    f = ((float) currentAnimationTimeMillis) / ((float) this.f528h);
                    float f5 = f * f;
                    f3 = Math.signum((float) this.f524d);
                    d = (double) ((((float) this.f532l) * f3) * ((3.0f * f5) - ((2.0f * f) * f5)));
                    this.f525e = ((-f) + f5) * ((f3 * ((float) this.f532l)) * 6.0f);
                    break;
                case 2:
                    f2 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.f525e = ((float) this.f524d) + (this.f526f * f2);
                    d = (double) (((f2 * (this.f526f * f2)) / 2.0f) + (((float) this.f524d) * f2));
                    break;
            }
            this.f522b = ((int) Math.round(d)) + this.f521a;
            return true;
        }
    }

    static {
        f537g = 1.0f;
        f537g = 1.0f / m555b(1.0f);
    }

    public OverScroller(Context context) {
        this(context, null);
    }

    private static float m555b(float f) {
        float f2 = f536f * f;
        if (f2 < 1.0f) {
            f2 -= 1.0f - ((float) Math.exp((double) (-f2)));
        } else {
            f2 = ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f) + 0.36787945f;
        }
        return f2 * f537g;
    }

    private OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    private OverScroller(Context context, Interpolator interpolator, boolean z) {
        this.f541d = interpolator;
        this.f542e = z;
        this.f539b = new SplineOverScroller(context);
        this.f540c = new SplineOverScroller(context);
    }

    public final boolean m559a() {
        return this.f539b.f531k && this.f540c.f531k;
    }

    public final int m561b() {
        return this.f539b.f522b;
    }

    public final float m562c() {
        return (float) Math.sqrt((double) ((this.f539b.f525e * this.f539b.f525e) + (this.f540c.f525e * this.f540c.f525e)));
    }

    public final boolean m563d() {
        if (m559a()) {
            return false;
        }
        switch (this.f538a) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f539b.f527g;
                int i = this.f539b.f528h;
                if (currentAnimationTimeMillis >= ((long) i)) {
                    m564e();
                    break;
                }
                float f = ((float) currentAnimationTimeMillis) / ((float) i);
                if (this.f541d == null) {
                    f = m555b(f);
                } else {
                    f = this.f541d.getInterpolation(f);
                }
                this.f539b.m550b(f);
                this.f540c.m550b(f);
                break;
            case 1:
                if (!(this.f539b.f531k || this.f539b.m554c() || this.f539b.m551b())) {
                    this.f539b.m547a();
                }
                if (!(this.f540c.f531k || this.f540c.m554c() || this.f540c.m551b())) {
                    this.f540c.m547a();
                    break;
                }
        }
        return true;
    }

    public final void m556a(int i, int i2, int i3, int i4, int i5) {
        this.f538a = 0;
        this.f539b.m548a(i, i3, i5);
        this.f540c.m548a(i2, i4, i5);
    }

    public final boolean m560a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f538a = 1;
        boolean b = this.f539b.m552b(i, i3, i4);
        boolean b2 = this.f540c.m552b(i2, i5, i6);
        if (b || b2) {
            return true;
        }
        return false;
    }

    public final void m557a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m558a(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public final void m558a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.f542e && !m559a()) {
            float f = this.f539b.f525e;
            float f2 = this.f540c.f525e;
            if (Math.signum((float) i3) == Math.signum(f) && Math.signum((float) i4) == Math.signum(f2)) {
                i4 = (int) (((float) i4) + f2);
                i11 = (int) (f + ((float) i3));
                this.f538a = 1;
                this.f539b.m549a(i, i11, i5, i6, i9);
                this.f540c.m549a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.f538a = 1;
        this.f539b.m549a(i, i11, i5, i6, i9);
        this.f540c.m549a(i2, i4, i7, i8, i10);
    }

    public final void m564e() {
        this.f539b.m547a();
        this.f540c.m547a();
    }
}
