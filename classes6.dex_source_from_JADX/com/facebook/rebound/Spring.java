package com.facebook.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: f8387ecb4252b1cbf108988aaf02bbcb */
public class Spring {
    private static int f15426a = 0;
    private SpringConfig f15427b;
    public boolean f15428c;
    public final String f15429d;
    public final PhysicsState f15430e = new PhysicsState();
    private final PhysicsState f15431f = new PhysicsState();
    private final PhysicsState f15432g = new PhysicsState();
    public double f15433h;
    public double f15434i;
    public boolean f15435j = true;
    public double f15436k = 0.005d;
    public double f15437l = 0.005d;
    public CopyOnWriteArraySet<SpringListener> f15438m = new CopyOnWriteArraySet();
    private double f15439n = 0.0d;
    public final BaseSpringSystem f15440o;

    /* compiled from: f8387ecb4252b1cbf108988aaf02bbcb */
    public class PhysicsState {
        public double f15424a;
        double f15425b;
    }

    Spring(BaseSpringSystem baseSpringSystem) {
        if (baseSpringSystem == null) {
            throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
        }
        this.f15440o = baseSpringSystem;
        StringBuilder stringBuilder = new StringBuilder("spring:");
        int i = f15426a;
        f15426a = i + 1;
        this.f15429d = stringBuilder.append(i).toString();
        m23050a(SpringConfig.f15441c);
    }

    public final Spring m23050a(SpringConfig springConfig) {
        if (springConfig == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.f15427b = springConfig;
        return this;
    }

    public final Spring m23049a(double d) {
        this.f15433h = d;
        this.f15430e.f15424a = d;
        this.f15440o.m23037a(this.f15429d);
        Iterator it = this.f15438m.iterator();
        while (it.hasNext()) {
            ((SpringListener) it.next()).mo1220a(this);
        }
        if (1 != 0) {
            m23056f();
        }
        return this;
    }

    public final double m23052b() {
        return this.f15430e.f15424a;
    }

    public final Spring m23053b(double d) {
        if (!(this.f15434i == d && m23055e())) {
            this.f15433h = m23052b();
            this.f15434i = d;
            this.f15440o.m23037a(this.f15429d);
            Iterator it = this.f15438m.iterator();
            while (it.hasNext()) {
                ((SpringListener) it.next()).mo1222b(this);
            }
        }
        return this;
    }

    public final Spring m23054c(double d) {
        if (d != this.f15430e.f15425b) {
            this.f15430e.f15425b = d;
            this.f15440o.m23037a(this.f15429d);
        }
        return this;
    }

    private boolean m23048h() {
        return this.f15427b.f15443b > 0.0d && ((this.f15433h < this.f15434i && m23052b() > this.f15434i) || (this.f15433h > this.f15434i && m23052b() < this.f15434i));
    }

    public final void m23057f(double d) {
        boolean e = m23055e();
        if (!e || !this.f15435j) {
            boolean z;
            Object obj;
            if (d > 0.064d) {
                d = 0.064d;
            }
            this.f15439n += d;
            double d2 = this.f15427b.f15443b;
            double d3 = this.f15427b.f15442a;
            double d4 = this.f15430e.f15424a;
            double d5 = this.f15430e.f15425b;
            double d6 = this.f15432g.f15424a;
            double d7 = this.f15432g.f15425b;
            while (this.f15439n >= 0.001d) {
                this.f15439n -= 0.001d;
                if (this.f15439n < 0.001d) {
                    this.f15431f.f15424a = d4;
                    this.f15431f.f15425b = d5;
                }
                double d8 = ((this.f15434i - d6) * d2) - (d3 * d5);
                double d9 = d5 + ((0.001d * d8) * 0.5d);
                double d10 = ((this.f15434i - (((0.001d * d5) * 0.5d) + d4)) * d2) - (d3 * d9);
                double d11 = d5 + ((0.001d * d10) * 0.5d);
                double d12 = ((this.f15434i - (((0.001d * d9) * 0.5d) + d4)) * d2) - (d3 * d11);
                d6 = d4 + (0.001d * d11);
                d7 = (0.001d * d12) + d5;
                d4 += (((((d9 + d11) * 2.0d) + d5) + d7) * 0.16666666666666666d) * 0.001d;
                d5 += (((d8 + ((d10 + d12) * 2.0d)) + (((this.f15434i - d6) * d2) - (d3 * d7))) * 0.16666666666666666d) * 0.001d;
            }
            this.f15432g.f15424a = d6;
            this.f15432g.f15425b = d7;
            this.f15430e.f15424a = d4;
            this.f15430e.f15425b = d5;
            if (this.f15439n > 0.0d) {
                m23047g(this.f15439n / 0.001d);
            }
            if (m23055e() || (this.f15428c && m23048h())) {
                if (d2 > 0.0d) {
                    this.f15433h = this.f15434i;
                    this.f15430e.f15424a = this.f15434i;
                } else {
                    this.f15434i = this.f15430e.f15424a;
                    this.f15433h = this.f15434i;
                }
                m23054c(0.0d);
                z = true;
            } else {
                z = e;
            }
            if (this.f15435j) {
                this.f15435j = false;
                obj = 1;
            } else {
                obj = null;
            }
            Object obj2 = null;
            if (z) {
                this.f15435j = true;
                obj2 = 1;
            }
            Iterator it = this.f15438m.iterator();
            while (it.hasNext()) {
                SpringListener springListener = (SpringListener) it.next();
                if (obj != null) {
                    springListener.mo1221b();
                }
                springListener.mo1220a(this);
                if (obj2 != null) {
                    springListener.mo1219a();
                }
            }
        }
    }

    public final boolean m23055e() {
        if (Math.abs(this.f15430e.f15425b) <= this.f15436k) {
            if (Math.abs(this.f15434i - this.f15430e.f15424a) <= this.f15437l || this.f15427b.f15443b == 0.0d) {
                return true;
            }
        }
        return false;
    }

    public final Spring m23056f() {
        this.f15434i = this.f15430e.f15424a;
        this.f15432g.f15424a = this.f15430e.f15424a;
        this.f15430e.f15425b = 0.0d;
        return this;
    }

    private void m23047g(double d) {
        this.f15430e.f15424a = (this.f15430e.f15424a * d) + (this.f15431f.f15424a * (1.0d - d));
        this.f15430e.f15425b = (this.f15430e.f15425b * d) + (this.f15431f.f15425b * (1.0d - d));
    }

    public final Spring m23051a(SpringListener springListener) {
        if (springListener == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.f15438m.add(springListener);
        return this;
    }
}
