package com.facebook.backstage.ui;

import android.view.View;
import com.facebook.backstage.StacksConstants;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;
import java.util.HashMap;

/* compiled from: search_result_page? */
public class ViewAnimator extends SimpleSpringListener {
    public static final HashMap<View, ViewAnimator> f5523a = new HashMap();
    public int f5524A = -1;
    public final Spring f5525b = SpringSystem.b().a().a(StacksConstants.f4251a).a(new SpringListener(this));
    public final View f5526c;
    public OnProgressListener f5527d;
    public OnFinishListener f5528e;
    public boolean f5529f = false;
    public float f5530g;
    public float f5531h;
    public boolean f5532i = false;
    public float f5533j;
    public float f5534k;
    public boolean f5535l = false;
    public float f5536m;
    public float f5537n;
    public float f5538o;
    public boolean f5539p = false;
    public float f5540q;
    public float f5541r;
    public float f5542s;
    public boolean f5543t = false;
    public float f5544u;
    public float f5545v;
    public boolean f5546w = false;
    public float f5547x;
    public float f5548y;
    public int f5549z = -1;

    /* compiled from: search_result_page? */
    public interface OnFinishListener {
        void mo142a();
    }

    /* compiled from: search_result_page? */
    public interface OnProgressListener {
    }

    /* compiled from: search_result_page? */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ ViewAnimator f5522a;

        public SpringListener(ViewAnimator viewAnimator) {
            this.f5522a = viewAnimator;
        }

        public final void m5751b() {
            if (this.f5522a.f5549z != -1) {
                this.f5522a.f5526c.setVisibility(this.f5522a.f5549z);
            }
        }

        public final void m5750a(Spring spring) {
            float b = (float) spring.b();
            if (this.f5522a.f5529f) {
                this.f5522a.f5526c.setX(ViewAnimator.m5753b(this.f5522a.f5530g, this.f5522a.f5531h, b));
            }
            if (this.f5522a.f5532i) {
                this.f5522a.f5526c.setY(ViewAnimator.m5753b(this.f5522a.f5533j, this.f5522a.f5534k, b));
            }
            if (this.f5522a.f5535l) {
                this.f5522a.f5526c.setPivotX(this.f5522a.f5538o);
                this.f5522a.f5526c.setScaleX(ViewAnimator.m5753b(this.f5522a.f5536m, this.f5522a.f5537n, b));
            }
            if (this.f5522a.f5539p) {
                this.f5522a.f5526c.setPivotY(this.f5522a.f5542s);
                this.f5522a.f5526c.setScaleY(ViewAnimator.m5753b(this.f5522a.f5540q, this.f5522a.f5541r, b));
            }
            if (this.f5522a.f5543t) {
                this.f5522a.f5526c.setAlpha(Math.max(0.0f, Math.min(ViewAnimator.m5753b(this.f5522a.f5544u, this.f5522a.f5545v, b), 1.0f)));
            }
            if (this.f5522a.f5546w) {
                this.f5522a.f5526c.setRotation(ViewAnimator.m5753b(this.f5522a.f5547x, this.f5522a.f5548y, b));
            }
            if (this.f5522a.f5527d != null) {
                OnProgressListener onProgressListener = this.f5522a.f5527d;
            }
        }

        public final void m5749a() {
            ViewAnimator.f5523a.remove(this.f5522a.f5526c);
            if (this.f5522a.f5524A != -1) {
                this.f5522a.f5526c.setVisibility(this.f5522a.f5524A);
            }
            if (this.f5522a.f5528e != null) {
                this.f5522a.f5528e.mo142a();
            }
        }
    }

    private ViewAnimator(View view) {
        this.f5526c = view;
    }

    public static ViewAnimator m5752a(View view) {
        if (f5523a.containsKey(view)) {
            return (ViewAnimator) f5523a.get(view);
        }
        ViewAnimator viewAnimator = new ViewAnimator(view);
        f5523a.put(view, viewAnimator);
        return viewAnimator;
    }

    public final boolean m5758c() {
        return !this.f5525b.e();
    }

    public final ViewAnimator m5756b(float f, float f2) {
        this.f5529f = true;
        this.f5530g = f;
        this.f5531h = f2;
        return this;
    }

    public final ViewAnimator m5754a(float f) {
        this.f5529f = true;
        this.f5530g = this.f5526c.getX();
        this.f5531h = this.f5526c.getX() + f;
        return this;
    }

    public final ViewAnimator m5755b(float f) {
        this.f5532i = true;
        this.f5533j = this.f5526c.getY();
        this.f5534k = this.f5526c.getY() + f;
        return this;
    }

    public final ViewAnimator m5757c(float f, float f2) {
        this.f5532i = true;
        this.f5533j = f;
        this.f5534k = f2;
        return this;
    }

    public final ViewAnimator m5760d(float f, float f2) {
        this.f5543t = true;
        this.f5544u = f;
        this.f5545v = f2;
        return this;
    }

    public final ViewAnimator m5759d() {
        f5523a.put(this.f5526c, this);
        this.f5525b.f().a(0.0d).b(1.0d);
        return this;
    }

    public final ViewAnimator m5761e() {
        this.f5525b.f();
        this.f5525b.a(StacksConstants.f4251a);
        this.f5525b.k = 0.005d;
        this.f5525b.l = 0.005d;
        this.f5525b.c = false;
        this.f5529f = false;
        this.f5532i = false;
        this.f5543t = false;
        this.f5546w = false;
        this.f5549z = -1;
        this.f5524A = -1;
        this.f5527d = null;
        this.f5528e = null;
        return this;
    }

    public static float m5753b(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }
}
