package com.facebook.springs;

import com.facebook.common.collect.ReentrantCallback;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import javax.annotation.Nonnull;

/* compiled from: sponsored_impressions_log_insertion_enabled */
public class Spring {
    private static int f4214a = 0;
    public SpringConfig f4215b;
    public boolean f4216c;
    public final String f4217d;
    public final PhysicsState f4218e = new PhysicsState();
    private final PhysicsState f4219f = new PhysicsState();
    private final PhysicsState f4220g = new PhysicsState();
    private double f4221h;
    public double f4222i;
    public boolean f4223j = true;
    public double f4224k = 1.0E-4d;
    public double f4225l = 1.0E-4d;
    private ReentrantCallback<SpringListener> f4226m = new ReentrantCallback();
    private double f4227n = 0.0d;
    private final SpringSystem f4228o;

    /* compiled from: sponsored_impressions_log_insertion_enabled */
    public class PhysicsState {
        double f6973a;
        public double f6974b;
    }

    @VisibleForTesting
    public Spring(@Nonnull SpringSystem springSystem) {
        Preconditions.checkNotNull(springSystem, "Spring cannot be created outside of a SpringSystem");
        this.f4228o = springSystem;
        StringBuilder stringBuilder = new StringBuilder("spring:");
        int i = f4214a;
        f4214a = i + 1;
        this.f4217d = stringBuilder.append(i).toString();
    }

    public final void m7817a() {
        this.f4226m.m8895b();
        this.f4228o.m7839a(this);
    }

    public final Spring m7814a(SpringConfig springConfig) {
        this.f4215b = (SpringConfig) Preconditions.checkNotNull(springConfig);
        return this;
    }

    public final Spring m7813a(double d) {
        this.f4221h = d;
        this.f4218e.f6973a = d;
        Iterator it = this.f4226m.iterator();
        while (it.hasNext()) {
            ((SpringListener) it.next()).mo1160a(this);
        }
        return this;
    }

    public final double m7821d() {
        return this.f4218e.f6973a;
    }

    public final double m7823e() {
        return m7811a(this.f4218e);
    }

    private double m7811a(PhysicsState physicsState) {
        return Math.abs(this.f4222i - physicsState.f6973a);
    }

    public final Spring m7818b(double d) {
        if (!(this.f4222i == d && m7829k())) {
            this.f4221h = m7821d();
            this.f4222i = d;
            this.f4228o.m7840a(this.f4217d);
            Iterator it = this.f4226m.iterator();
            while (it.hasNext()) {
                ((SpringListener) it.next()).mo1163d(this);
            }
        }
        return this;
    }

    public final double m7825f() {
        return this.f4222i;
    }

    public final Spring m7820c(double d) {
        this.f4218e.f6974b = d;
        if (d != 0.0d) {
            this.f4228o.m7840a(this.f4217d);
        }
        return this;
    }

    public final Spring m7822d(double d) {
        this.f4224k = d;
        return this;
    }

    public final Spring m7824e(double d) {
        this.f4225l = d;
        return this;
    }

    public final Spring m7816a(boolean z) {
        this.f4216c = z;
        return this;
    }

    public final boolean m7828i() {
        return (this.f4221h < this.f4222i && m7821d() > this.f4222i) || (this.f4221h > this.f4222i && m7821d() < this.f4222i);
    }

    @VisibleForTesting
    public final void m7826f(double d) {
        boolean k = m7829k();
        if (!k || !this.f4223j) {
            boolean z;
            Object obj;
            if (d > 0.064d) {
                d = 0.064d;
            }
            this.f4227n += d;
            double d2 = this.f4215b.f4246b;
            double d3 = this.f4215b.f4245a;
            double d4 = this.f4218e.f6973a;
            double d5 = this.f4218e.f6974b;
            double d6 = this.f4220g.f6973a;
            double d7 = this.f4220g.f6974b;
            while (this.f4227n >= 0.001d) {
                this.f4227n -= 0.001d;
                if (this.f4227n < 0.001d) {
                    this.f4219f.f6973a = d4;
                    this.f4219f.f6974b = d5;
                }
                double d8 = ((this.f4222i - d6) * d2) - (d3 * d5);
                double d9 = d5 + ((0.001d * d8) * 0.5d);
                double d10 = ((this.f4222i - (((0.001d * d5) * 0.5d) + d4)) * d2) - (d3 * d9);
                double d11 = d5 + ((0.001d * d10) * 0.5d);
                double d12 = ((this.f4222i - (((0.001d * d9) * 0.5d) + d4)) * d2) - (d3 * d11);
                d6 = d4 + (0.001d * d11);
                d7 = (0.001d * d12) + d5;
                d4 += (((((d9 + d11) * 2.0d) + d5) + d7) * 0.16666666666666666d) * 0.001d;
                d5 += (((d8 + ((d10 + d12) * 2.0d)) + (((this.f4222i - d6) * d2) - (d3 * d7))) * 0.16666666666666666d) * 0.001d;
            }
            this.f4220g.f6973a = d6;
            this.f4220g.f6974b = d7;
            this.f4218e.f6973a = d4;
            this.f4218e.f6974b = d5;
            if (this.f4227n > 0.0d) {
                m7812h(this.f4227n / 0.001d);
            }
            if (m7829k() || (this.f4216c && m7828i())) {
                this.f4221h = this.f4222i;
                this.f4218e.f6973a = this.f4222i;
                m7820c(0.0d);
                z = true;
            } else {
                z = k;
            }
            if (this.f4223j) {
                this.f4223j = false;
                obj = 1;
            } else {
                obj = null;
            }
            Object obj2 = null;
            if (z) {
                this.f4223j = true;
                obj2 = 1;
            }
            Iterator it = this.f4226m.iterator();
            while (it.hasNext()) {
                SpringListener springListener = (SpringListener) it.next();
                if (obj != null) {
                    springListener.mo1162c(this);
                }
                springListener.mo1160a(this);
                if (obj2 != null) {
                    springListener.mo1161b(this);
                }
            }
        }
    }

    public final boolean m7829k() {
        return Math.abs(this.f4218e.f6974b) <= this.f4224k && m7811a(this.f4218e) <= this.f4225l;
    }

    public final Spring m7830l() {
        this.f4222i = this.f4218e.f6973a;
        this.f4220g.f6973a = this.f4218e.f6973a;
        this.f4218e.f6974b = 0.0d;
        return this;
    }

    private void m7812h(double d) {
        this.f4218e.f6973a = (this.f4218e.f6973a * d) + (this.f4219f.f6973a * (1.0d - d));
        this.f4218e.f6974b = (this.f4218e.f6974b * d) + (this.f4219f.f6974b * (1.0d - d));
    }

    public final Spring m7815a(SpringListener springListener) {
        Preconditions.checkNotNull(springListener);
        this.f4226m.m8894a(springListener);
        return this;
    }

    public final Spring m7819b(SpringListener springListener) {
        Preconditions.checkNotNull(springListener);
        this.f4226m.m8896b(springListener);
        return this;
    }

    public final Spring m7831m() {
        this.f4226m.m8895b();
        return this;
    }

    public final boolean m7827g(double d) {
        return Math.abs(m7821d() - d) <= this.f4225l;
    }
}
