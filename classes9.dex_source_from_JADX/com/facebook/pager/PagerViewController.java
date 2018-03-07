package com.facebook.pager;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.pager.renderers.PagerViewRenderer;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: ccu_setting_enable_disable_event */
public class PagerViewController<T> {
    private int f18376A;
    public int f18377B;
    public T f18378C;
    private ImmutableList<Object<T>> f18379D;
    private int f18380E;
    private boolean f18381F;
    private boolean f18382G = false;
    private float f18383H;
    public int f18384I;
    public final PagerDataSetObserver<T> f18385a;
    public final PagerViewFilteringDataAdapter<T> f18386b;
    public final float[] f18387c = new float[]{0.0f, 0.0f};
    private final List<RenderInfo<T, Void>> f18388d = Lists.a();
    private final List<RenderInfo<T, Void>> f18389e = Lists.a();
    private final List<RenderInfo<T, Void>> f18390f = Lists.a();
    public float f18391g;
    public float f18392h;
    private float f18393i;
    private final float f18394j;
    private final int f18395k;
    private final int f18396l;
    public final int f18397m;
    public final Spring f18398n;
    public final PagerViewControllerSpringListener f18399o;
    private final int[] f18400p;
    private final int[] f18401q;
    private final int[] f18402r;
    public float f18403s;
    private PagerViewRenderer<T> f18404t;
    private AbstractFbErrorReporter f18405u;
    public float f18406v;
    public float f18407w;
    public float f18408x;
    public boolean f18409y;
    public ScrollState f18410z;

    /* compiled from: ccu_setting_enable_disable_event */
    public class C21281 {
        final /* synthetic */ PagerViewController f18374a;

        C21281(PagerViewController pagerViewController) {
            this.f18374a = pagerViewController;
        }
    }

    /* compiled from: ccu_setting_enable_disable_event */
    class PagerViewControllerSpringListener extends SimpleSpringListener {
        final /* synthetic */ PagerViewController f18375a;

        public PagerViewControllerSpringListener(PagerViewController pagerViewController) {
            this.f18375a = pagerViewController;
        }

        public final void m18372a(Spring spring) {
            if (this.f18375a.f18410z == ScrollState.SETTLING) {
                this.f18375a.m18388c((float) spring.d());
            }
        }

        public final void m18373b(Spring spring) {
            if (this.f18375a.f18410z == ScrollState.SETTLING) {
                PagerViewController.m18375a(this.f18375a, (float) spring.i, true);
                PagerViewController.m18376a(this.f18375a, ScrollState.IDLE);
            }
        }
    }

    /* compiled from: ccu_setting_enable_disable_event */
    public enum ScrollState {
        DRAGGING,
        SETTLING,
        IDLE
    }

    public PagerViewController(PagerViewDataAdapter<T> pagerViewDataAdapter, PagerViewRenderer<T> pagerViewRenderer, FbErrorReporter fbErrorReporter, Spring spring, float f, float f2, int i, int i2, boolean z) {
        this.f18386b = new PagerViewFilteringDataAdapter(pagerViewDataAdapter);
        this.f18404t = pagerViewRenderer;
        this.f18405u = fbErrorReporter;
        this.f18398n = spring;
        this.f18399o = new PagerViewControllerSpringListener(this);
        this.f18398n.a(this.f18399o);
        this.f18395k = i2;
        this.f18396l = i;
        this.f18397m = i2 + i;
        this.f18406v = f;
        this.f18407w = 0.0f;
        this.f18408x = this.f18406v - 1.0f;
        this.f18403s = this.f18406v * 0.5f;
        this.f18394j = f2;
        this.f18409y = z;
        int i3 = ((this.f18397m * 2) + 1) + 1;
        this.f18401q = new int[i3];
        this.f18400p = new int[i3];
        this.f18402r = new int[i3];
        this.f18379D = RegularImmutableList.a;
        this.f18385a = new C21281(this);
        this.f18386b.mo714a(this.f18385a);
        this.f18383H = 0.0f;
        m18376a(this, ScrollState.IDLE);
        m18375a(this, 0.0f, true);
    }

    private float m18379f() {
        if (this.f18409y) {
            return -3.4028235E38f;
        }
        return this.f18383H;
    }

    @VisibleForTesting
    private float m18380g() {
        if (this.f18409y) {
            return Float.MAX_VALUE;
        }
        return Math.max(((float) (this.f18386b.mo712a() - 1)) * this.f18406v, 0.0f);
    }

    public final void m18384a(float f) {
        m18376a(this, ScrollState.DRAGGING);
        if (!(this.f18409y || m18378e(this.f18391g + f))) {
            f *= 0.25f;
        }
        m18388c(this.f18391g + f);
    }

    public final void m18386a(int i, float f) {
        m18374a(((float) i) * this.f18406v, (double) f, true);
    }

    public final void m18385a(float f, int i) {
        if (this.f18393i < 0.0f) {
            i--;
        }
        float f2 = ((-this.f18393i) + (this.f18406v * ((float) i))) + this.f18391g;
        m18374a(f2, (double) f, true);
        if (f2 != this.f18392h) {
            int size = this.f18379D.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f18379D.get(i2);
            }
        }
    }

    public final void m18387b(float f, int i) {
        if (this.f18393i < 0.0f) {
            i++;
        }
        float f2 = this.f18391g - ((this.f18406v * ((float) i)) - (this.f18406v - this.f18393i));
        m18374a(f2, (double) f, true);
        if (f2 != this.f18392h) {
            int size = this.f18379D.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f18379D.get(i2);
            }
        }
    }

    public final void m18388c(float f) {
        if (m18378e(f) || this.f18410z == ScrollState.SETTLING || this.f18410z == ScrollState.DRAGGING) {
            m18375a(this, f, false);
        }
    }

    public static void m18375a(PagerViewController pagerViewController, float f, boolean z) {
        int i = 0;
        if (!pagerViewController.f18382G) {
            float round = (float) Math.round(f);
            if (z || round != pagerViewController.f18391g) {
                int i2;
                pagerViewController.f18404t.m18413a();
                pagerViewController.f18391g = round;
                int i3 = 0;
                while (true) {
                    int g;
                    int i4;
                    pagerViewController.m18381i();
                    int i5 = 0;
                    i2 = i3;
                    while (i5 < pagerViewController.f18389e.size()) {
                        RenderInfo renderInfo = (RenderInfo) pagerViewController.f18389e.get(i5);
                        Object d = renderInfo.m18405d();
                        try {
                            float j = renderInfo.m18410j();
                            g = renderInfo.m18407g();
                            float h = renderInfo.m18408h();
                            float i6 = renderInfo.m18409i();
                            round = (pagerViewController.f18406v + j) - 1.0f;
                            boolean z2 = (j >= pagerViewController.f18407w && j <= pagerViewController.f18408x) || (round <= pagerViewController.f18408x && round >= pagerViewController.f18407w);
                            pagerViewController.f18404t.m18416a(d, g, j, h, i6, z2);
                            i5++;
                            i2 = 1;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            pagerViewController.f18405u.a(SoftError.a("PAGER_VIEW_RENDERING_ERROR", "Error rendering " + (d == null ? "Unknown" : d.getClass().getSimpleName())).a(th2).g());
                            if (pagerViewController.f18381F) {
                                RuntimeException runtimeException = new RuntimeException(th2);
                            } else {
                                pagerViewController.f18386b.m18399b(renderInfo.m18406f());
                                i4 = 1;
                            }
                        }
                    }
                    i4 = 0;
                    for (g = 0; g < pagerViewController.f18388d.size(); g++) {
                        RenderInfo renderInfo2 = (RenderInfo) pagerViewController.f18388d.get(g);
                        pagerViewController.f18404t.m18415a(renderInfo2.m18405d(), renderInfo2.m18407g());
                    }
                    if (i4 == 0) {
                        break;
                    }
                    i3 = i2;
                }
                if (i2 != 0) {
                    pagerViewController.m18383l();
                }
                pagerViewController.f18404t.m18417b();
                while (i < pagerViewController.f18379D.size()) {
                    pagerViewController.f18379D.get(i);
                    i++;
                }
            }
        }
    }

    private boolean m18378e(float f) {
        return f >= m18379f() && f <= m18380g();
    }

    public static void m18376a(PagerViewController pagerViewController, ScrollState scrollState) {
        if (scrollState != pagerViewController.f18410z) {
            pagerViewController.f18410z = scrollState;
            for (int i = 0; i < pagerViewController.f18379D.size(); i++) {
                pagerViewController.f18379D.get(i);
            }
        }
    }

    private void m18381i() {
        this.f18387c[0] = this.f18391g - (((float) this.f18397m) * this.f18406v);
        this.f18387c[1] = (this.f18391g + (((float) this.f18397m) * this.f18406v)) + this.f18406v;
        m18382k();
        while (this.f18390f.size() > 0) {
            ((RenderInfo) this.f18390f.remove(0)).m18404b();
        }
        while (this.f18389e.size() > 0) {
            this.f18390f.add(this.f18389e.remove(0));
        }
        if (this.f18380E > 0) {
            this.f18393i = this.f18387c[0] - (((float) this.f18400p[0]) * this.f18406v);
            float f = (-this.f18393i) - (((float) this.f18397m) * this.f18406v);
            for (int i = 0; i < this.f18380E; i++) {
                int i2 = this.f18401q[i];
                int i3 = this.f18400p[i];
                float f2 = (((float) i) * this.f18406v) + f;
                if (i2 < this.f18386b.mo712a() && m18377a(i3)) {
                    Object a = this.f18386b.mo713a(i2);
                    RenderInfo a2 = RenderInfo.m18403a();
                    a2.f18416b = a;
                    RenderInfo renderInfo = a2;
                    renderInfo.f18419e = i2;
                    RenderInfo renderInfo2 = renderInfo;
                    renderInfo2.f18418d = i3;
                    renderInfo2 = renderInfo2;
                    renderInfo2.f18421g = this.f18406v;
                    renderInfo2 = renderInfo2;
                    renderInfo2.f18422h = this.f18394j;
                    renderInfo2.f18420f = f2;
                    this.f18389e.add(a2);
                }
            }
        }
        this.f18388d.clear();
        this.f18388d.addAll(this.f18390f);
        this.f18388d.removeAll(this.f18389e);
    }

    private boolean m18377a(int i) {
        if (!this.f18409y && (i < 0 || i >= this.f18386b.mo712a())) {
            return false;
        }
        boolean z;
        float f = ((float) i) * this.f18406v;
        float f2;
        float f3;
        if (this.f18410z == ScrollState.IDLE) {
            f2 = this.f18387c[0];
            f3 = this.f18387c[1];
            z = false;
        } else {
            float f4 = this.f18387c[0] + (((float) this.f18395k) * this.f18406v);
            f2 = this.f18387c[1] - (((float) this.f18395k) * this.f18406v);
            for (int i2 : this.f18402r) {
                if (i == i2) {
                    f3 = f2;
                    f2 = f4;
                    z = true;
                    break;
                }
            }
            f3 = f2;
            f2 = f4;
            z = false;
        }
        float f5 = this.f18406v + f;
        if (z || ((f >= r2 && f <= r0) || (f5 <= r0 && f5 >= r2))) {
            return true;
        }
        return false;
    }

    private void m18382k() {
        int i = 0;
        if (this.f18386b.mo712a() != 0) {
            int floor = (int) Math.floor((double) (this.f18387c[0] / this.f18406v));
            while (i < this.f18401q.length && ((float) floor) * this.f18406v < this.f18387c[1]) {
                this.f18400p[i] = floor;
                if (this.f18410z == ScrollState.IDLE) {
                    this.f18402r[i] = floor;
                }
                int[] iArr = this.f18401q;
                int a = this.f18386b.mo712a();
                int i2 = floor % a;
                if (i2 < 0) {
                    i2 += a;
                }
                iArr[i] = i2;
                this.f18380E = i + 1;
                i++;
                floor++;
            }
        }
    }

    private void m18383l() {
        int i;
        int i2;
        float f = this.f18387c[0] % this.f18406v;
        if (f < 0.0f) {
            f += this.f18406v;
        }
        if (f > this.f18403s) {
            i = this.f18401q[this.f18397m + 1];
            i2 = this.f18400p[this.f18397m + 1];
        } else {
            i = this.f18401q[this.f18397m];
            i2 = this.f18400p[this.f18397m];
        }
        Object obj = null;
        if (this.f18386b.mo712a() > i) {
            obj = this.f18386b.mo713a(i);
        }
        if (obj == null) {
            return;
        }
        if (obj != this.f18378C || i != this.f18376A || i2 != this.f18377B) {
            this.f18378C = obj;
            this.f18376A = i;
            this.f18377B = i2;
            this.f18404t.m18414a(this.f18377B, this.f18378C);
            for (i2 = 0; i2 < this.f18379D.size(); i2++) {
                this.f18379D.get(i2);
            }
        }
    }

    private void m18374a(float f, double d, boolean z) {
        int i = 0;
        if (!this.f18409y) {
            int size;
            if (f < m18379f()) {
                f = m18379f();
                size = this.f18379D.size();
                while (i < size) {
                    this.f18379D.get(i);
                    i++;
                }
            } else if (f > m18380g()) {
                f = m18380g();
                size = this.f18379D.size();
                while (i < size) {
                    this.f18379D.get(i);
                    i++;
                }
            }
        }
        if (z) {
            m18376a(this, ScrollState.SETTLING);
            this.f18398n.a((double) this.f18391g);
            this.f18398n.c(-d);
            this.f18398n.b((double) f);
        } else {
            m18376a(this, ScrollState.SETTLING);
            this.f18398n.a((double) f).l();
        }
        if (this.f18398n.k()) {
            m18376a(this, ScrollState.IDLE);
        }
    }
}
