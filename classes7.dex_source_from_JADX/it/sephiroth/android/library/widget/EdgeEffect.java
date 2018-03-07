package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: viewed_page_post */
public class EdgeEffect {
    private final int f474A;
    private final int f475B;
    private final int f476C;
    private final int f477D;
    private final int f478a;
    private final Drawable f479b;
    private final Drawable f480c;
    private int f481d;
    private int f482e;
    public int f483f;
    public int f484g;
    private final int f485h;
    private float f486i;
    private float f487j;
    private float f488k;
    private float f489l;
    private float f490m;
    private float f491n;
    private float f492o;
    private float f493p;
    private float f494q;
    private float f495r;
    private float f496s;
    private float f497t;
    private long f498u;
    private float f499v;
    private final Interpolator f500w;
    private int f501x = 0;
    private float f502y;
    private final Rect f503z = new Rect();

    public EdgeEffect(Context context, int i) {
        Resources resources = context.getResources();
        this.f479b = resources.getDrawable(2130844081);
        this.f480c = resources.getDrawable(2130844080);
        this.f478a = i;
        this.f474A = this.f479b.getIntrinsicHeight();
        this.f475B = this.f480c.getIntrinsicHeight();
        this.f476C = this.f480c.getIntrinsicWidth();
        this.f477D = (int) (Math.min((((((float) this.f475B) * 4.0f) * ((float) this.f475B)) / ((float) this.f476C)) * 0.6f, ((float) this.f475B) * 4.0f) + 0.5f);
        this.f485h = (int) ((resources.getDisplayMetrics().density * 300.0f) + 0.5f);
        this.f500w = new DecelerateInterpolator();
    }

    public final void m472a(int i, int i2) {
        this.f481d = i;
        this.f482e = i2;
    }

    public final boolean m473a() {
        return this.f501x == 0;
    }

    public final void m475b() {
        this.f501x = 0;
    }

    public final void m470a(float f) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f501x != 4 || ((float) (currentAnimationTimeMillis - this.f498u)) >= this.f499v) {
            if (this.f501x != 1) {
                this.f489l = 1.0f;
            }
            this.f501x = 1;
            this.f498u = currentAnimationTimeMillis;
            this.f499v = 167.0f;
            this.f502y += f;
            float abs = Math.abs(this.f502y);
            float max = Math.max(0.6f, Math.min(abs, 1.0f));
            this.f490m = max;
            this.f486i = max;
            abs = Math.max(0.5f, Math.min(abs * 7.0f, 1.0f));
            this.f492o = abs;
            this.f487j = abs;
            abs = Math.min(1.0f, this.f488k + (Math.abs(f) * 1.1f));
            this.f494q = abs;
            this.f488k = abs;
            abs = Math.abs(f);
            if (f > 0.0f && this.f502y < 0.0f) {
                abs = -abs;
            }
            if (this.f502y == 0.0f) {
                this.f489l = 0.0f;
            }
            abs = Math.min(4.0f, Math.max(0.0f, (abs * 7.0f) + this.f489l));
            this.f496s = abs;
            this.f489l = abs;
            this.f491n = this.f486i;
            this.f493p = this.f487j;
            this.f495r = this.f488k;
            this.f497t = this.f489l;
        }
    }

    public final void m476c() {
        this.f502y = 0.0f;
        if (this.f501x == 1 || this.f501x == 4) {
            this.f501x = 3;
            this.f490m = this.f486i;
            this.f492o = this.f487j;
            this.f494q = this.f488k;
            this.f496s = this.f489l;
            this.f491n = 0.0f;
            this.f493p = 0.0f;
            this.f495r = 0.0f;
            this.f497t = 0.0f;
            this.f498u = AnimationUtils.currentAnimationTimeMillis();
            this.f499v = 1000.0f;
        }
    }

    public final void m471a(int i) {
        this.f501x = 2;
        int max = Math.max(100, Math.abs(i));
        this.f498u = AnimationUtils.currentAnimationTimeMillis();
        this.f499v = 0.1f + (((float) max) * 0.03f);
        this.f490m = 0.0f;
        this.f492o = 0.0f;
        this.f487j = 0.0f;
        this.f494q = 0.5f;
        this.f496s = 0.0f;
        this.f491n = (float) Math.max(0, Math.min(max * 8, 1));
        this.f493p = Math.max(0.5f, Math.min((float) (max * 8), 1.0f));
        this.f497t = Math.min(0.025f + (((float) ((max / 100) * max)) * 1.5E-4f), 1.75f);
        this.f495r = Math.max(this.f494q, Math.min(((float) (max * 16)) * 1.0E-5f, 1.0f));
    }

    public final boolean m474a(Canvas canvas) {
        m468d();
        this.f480c.setAlpha((int) (Math.max(0.0f, Math.min(this.f488k, 1.0f)) * 255.0f));
        int min = (int) Math.min((((((float) this.f475B) * this.f489l) * ((float) this.f475B)) / ((float) this.f476C)) * 0.6f, ((float) this.f475B) * 4.0f);
        int i = this.f478a;
        this.f480c.setBounds(0, 0, this.f481d, min);
        this.f480c.draw(canvas);
        this.f479b.setAlpha((int) (Math.max(0.0f, Math.min(this.f486i, 1.0f)) * 255.0f));
        i = (int) (((float) this.f474A) * this.f487j);
        int i2 = this.f478a;
        this.f479b.setBounds(0, 0, this.f481d, i);
        this.f479b.draw(canvas);
        if (this.f501x == 3 && min == 0 && i == 0) {
            this.f501x = 0;
        }
        if (this.f501x != 0) {
            return true;
        }
        return false;
    }

    public final Rect m469a(boolean z) {
        int i = 0;
        this.f503z.set(0, 0, this.f481d, this.f477D);
        Rect rect = this.f503z;
        int i2 = this.f483f;
        int i3 = this.f484g;
        if (z) {
            i = this.f477D;
        }
        rect.offset(i2, i3 - i);
        return this.f503z;
    }

    private void m468d() {
        float min = Math.min(((float) (AnimationUtils.currentAnimationTimeMillis() - this.f498u)) / this.f499v, 1.0f);
        float interpolation = this.f500w.getInterpolation(min);
        this.f486i = this.f490m + ((this.f491n - this.f490m) * interpolation);
        this.f487j = this.f492o + ((this.f493p - this.f492o) * interpolation);
        this.f488k = this.f494q + ((this.f495r - this.f494q) * interpolation);
        this.f489l = this.f496s + ((this.f497t - this.f496s) * interpolation);
        if (min >= 0.999f) {
            switch (this.f501x) {
                case 1:
                    this.f501x = 4;
                    this.f498u = AnimationUtils.currentAnimationTimeMillis();
                    this.f499v = 1000.0f;
                    this.f490m = this.f486i;
                    this.f492o = this.f487j;
                    this.f494q = this.f488k;
                    this.f496s = this.f489l;
                    this.f491n = 0.0f;
                    this.f493p = 0.0f;
                    this.f495r = 0.0f;
                    this.f497t = 0.0f;
                    return;
                case 2:
                    this.f501x = 3;
                    this.f498u = AnimationUtils.currentAnimationTimeMillis();
                    this.f499v = 1000.0f;
                    this.f490m = this.f486i;
                    this.f492o = this.f487j;
                    this.f494q = this.f488k;
                    this.f496s = this.f489l;
                    this.f491n = 0.0f;
                    this.f493p = 0.0f;
                    this.f495r = 0.0f;
                    this.f497t = 0.0f;
                    return;
                case 3:
                    this.f501x = 0;
                    return;
                case 4:
                    this.f487j = ((this.f497t != 0.0f ? 1.0f / (this.f497t * this.f497t) : Float.MAX_VALUE) * (interpolation * (this.f493p - this.f492o))) + this.f492o;
                    this.f501x = 3;
                    return;
                default:
                    return;
            }
        }
    }
}
