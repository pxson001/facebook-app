package com.facebook.android.maps;

import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: background_image */
public class Cluster<T extends ClusterItem> implements Iterable<T> {
    InternalClusterItem<T>[] f8052a = new InternalClusterItem[2];
    public int f8053b = 0;
    private LatLng f8054c;
    private boolean f8055d = false;
    private final double[] f8056e = new double[2];
    private final double[] f8057f = new double[2];
    private int f8058g;
    private boolean f8059h = false;
    private boolean f8060i = false;
    private double f8061j;
    private double f8062k;
    private double f8063l;
    private double f8064m;
    private LatLngBounds f8065n;
    private boolean f8066o = false;
    public Cluster f8067p;
    public MapDrawable f8068q;

    /* compiled from: background_image */
    class C09061 implements Iterator<T> {
        final /* synthetic */ Cluster f8050a;
        private int f8051b = 0;

        C09061(Cluster cluster) {
            this.f8050a = cluster;
        }

        public boolean hasNext() {
            return this.f8051b < this.f8050a.f8053b;
        }

        public Object next() {
            InternalClusterItem[] internalClusterItemArr = this.f8050a.f8052a;
            int i = this.f8051b;
            this.f8051b = i + 1;
            return internalClusterItemArr[i].f8169d;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public final LatLng m14212a() {
        m14209e();
        if (this.f8054c == null) {
            this.f8054c = new LatLng(Projection.a(this.f8056e[1]), Projection.c(this.f8056e[0]));
        }
        return this.f8054c;
    }

    public final void m14213a(double[] dArr) {
        m14209e();
        dArr[0] = this.f8056e[0];
        dArr[1] = this.f8056e[1];
    }

    public Iterator<T> iterator() {
        m14211g();
        return new C09061(this);
    }

    public static double m14207a(double d) {
        int i = d < 0.0d ? 1 : d > 1.0d ? -1 : 0;
        return ((double) i) + d;
    }

    public static double m14208b(double d) {
        int i = d < -180.0d ? 360 : d > 180.0d ? -360 : 0;
        return ((double) i) + d;
    }

    private void m14209e() {
        if (!this.f8055d) {
            int i = this.f8053b;
            if (i == 0) {
                AnalyticsEvent.s.a("Cannot compute centroid of an empty cluster");
                return;
            }
            m14210f();
            if (i == 1) {
                this.f8056e[0] = this.f8063l;
                this.f8056e[1] = this.f8061j;
                this.f8055d = true;
                this.f8054c = null;
                return;
            }
            Object obj = this.f8063l > this.f8064m ? 1 : null;
            double d = 0.0d;
            double d2 = 0.0d;
            for (int i2 = 0; i2 < this.f8053b; i2++) {
                this.f8052a[i2].m14313a(this.f8057f);
                d2 += this.f8057f[1];
                double a = m14207a(this.f8057f[0]);
                if (obj != null && 0.0d <= a && a <= this.f8064m) {
                    a += 1.0d;
                }
                d += a;
            }
            this.f8056e[0] = m14207a(d / ((double) i));
            this.f8056e[1] = d2 / ((double) i);
            this.f8055d = true;
            this.f8054c = null;
        }
    }

    private void m14210f() {
        if (!this.f8066o) {
            if (this.f8053b == 0) {
                AnalyticsEvent.s.a("Cannot compute bounds of an empty cluster");
            } else if (this.f8053b == 1) {
                this.f8052a[0].m14313a(this.f8057f);
                this.f8061j = this.f8057f[1];
                this.f8063l = m14207a(this.f8057f[0]);
                this.f8062k = this.f8061j;
                this.f8064m = this.f8063l;
                this.f8065n = null;
                this.f8066o = true;
            } else {
                int i;
                double d;
                double d2;
                this.f8061j = 1.0d;
                this.f8062k = 0.0d;
                double[] dArr = new double[this.f8053b];
                for (i = 0; i < this.f8053b; i++) {
                    this.f8052a[i].m14313a(this.f8057f);
                    d = this.f8057f[0];
                    d2 = this.f8057f[1];
                    if (d2 < this.f8061j) {
                        this.f8061j = d2;
                    }
                    if (d2 > this.f8062k) {
                        this.f8062k = d2;
                    }
                    dArr[i] = m14207a(d);
                }
                Arrays.sort(dArr);
                double d3 = dArr[this.f8053b - 1];
                d2 = dArr[0];
                d = 1.0d + (d2 - d3);
                for (i = 1; i < this.f8053b; i++) {
                    double d4 = dArr[i - 1];
                    double d5 = dArr[i];
                    double d6 = d5 - d4;
                    if (d6 > d) {
                        d = d6;
                        d2 = d5;
                        d3 = d4;
                    }
                }
                this.f8063l = d2;
                this.f8064m = d3;
                this.f8065n = null;
                this.f8066o = true;
            }
        }
    }

    private void m14211g() {
        if (!this.f8060i) {
            Arrays.sort(this.f8052a, 0, this.f8053b);
            this.f8060i = true;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cluster)) {
            return false;
        }
        Cluster cluster = (Cluster) obj;
        if (this.f8053b != cluster.f8053b) {
            return false;
        }
        m14211g();
        cluster.m14211g();
        for (int i = 0; i < this.f8053b; i++) {
            if (!this.f8052a[i].equals(cluster.f8052a[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        if (!this.f8059h) {
            this.f8058g = 0;
            while (i < this.f8053b) {
                this.f8058g += this.f8052a[i].hashCode();
                i++;
            }
            this.f8059h = true;
        }
        return this.f8058g;
    }
}
