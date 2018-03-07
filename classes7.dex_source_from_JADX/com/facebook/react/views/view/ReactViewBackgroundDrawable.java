package com.facebook.react.views.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.FloatUtil;
import com.facebook.csslayout.Spacing;
import com.facebook.react.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: first_tab_ */
public class ReactViewBackgroundDrawable extends Drawable {
    @Nullable
    private Spacing f11944a;
    @Nullable
    private Spacing f11945b;
    @Nullable
    private BorderStyle f11946c;
    @Nullable
    private PathEffect f11947d;
    @Nullable
    private Path f11948e;
    @Nullable
    private Path f11949f;
    @Nullable
    private Path f11950g;
    @Nullable
    private RectF f11951h;
    @Nullable
    private RectF f11952i;
    private boolean f11953j = false;
    private float f11954k = Float.NaN;
    private final Paint f11955l = new Paint(1);
    public int f11956m = 0;
    private int f11957n = 255;
    @Nullable
    private float[] f11958o;

    /* compiled from: first_tab_ */
    enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED;

        @Nullable
        public final PathEffect getPathEffect(float f) {
            switch (this) {
                case SOLID:
                    return null;
                case DASHED:
                    return new DashPathEffect(new float[]{f * 3.0f, f * 3.0f, f * 3.0f, 3.0f * f}, 0.0f);
                case DOTTED:
                    return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
                default:
                    return null;
            }
        }
    }

    ReactViewBackgroundDrawable() {
    }

    public void draw(Canvas canvas) {
        m14208c();
        Object obj = (this.f11958o != null || (!CSSConstants.a(this.f11954k) && this.f11954k > 0.0f)) ? 1 : null;
        if ((this.f11946c == null || this.f11946c == BorderStyle.SOLID) && obj == null) {
            m14206b(canvas);
        } else {
            m14203a(canvas);
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f11953j = true;
    }

    public void setAlpha(int i) {
        if (i != this.f11957n) {
            this.f11957n = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f11957n;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return ColorUtil.m14197a(ColorUtil.m14198a(this.f11956m, this.f11957n));
    }

    public void getOutline(Outline outline) {
        if (VERSION.SDK_INT < 21) {
            super.getOutline(outline);
        } else if ((CSSConstants.a(this.f11954k) || this.f11954k <= 0.0f) && this.f11958o == null) {
            outline.setRect(getBounds());
        } else {
            m14205b();
            outline.setConvexPath(this.f11949f);
        }
    }

    public final void m14215a(int i, float f) {
        if (this.f11944a == null) {
            this.f11944a = new Spacing();
        }
        if (!FloatUtil.a(this.f11944a.b(i), f)) {
            this.f11944a.a(i, f);
            if (i == 8) {
                this.f11953j = true;
            }
            invalidateSelf();
        }
    }

    public final void m14217b(int i, float f) {
        if (this.f11945b == null) {
            this.f11945b = new Spacing();
            this.f11945b.b(0, -1.6777216E7f);
            this.f11945b.b(1, -1.6777216E7f);
            this.f11945b.b(2, -1.6777216E7f);
            this.f11945b.b(3, -1.6777216E7f);
        }
        if (!FloatUtil.a(this.f11945b.b(i), f)) {
            this.f11945b.a(i, f);
            invalidateSelf();
        }
    }

    public final void m14216a(@Nullable String str) {
        BorderStyle valueOf = str == null ? null : BorderStyle.valueOf(str.toUpperCase(Locale.US));
        if (this.f11946c != valueOf) {
            this.f11946c = valueOf;
            this.f11953j = true;
            invalidateSelf();
        }
    }

    public final void m14212a(float f) {
        if (!FloatUtil.a(this.f11954k, f)) {
            this.f11954k = f;
            this.f11953j = true;
            invalidateSelf();
        }
    }

    public final void m14213a(float f, int i) {
        if (this.f11958o == null) {
            this.f11958o = new float[4];
            Arrays.fill(this.f11958o, Float.NaN);
        }
        if (!FloatUtil.a(this.f11958o[i], f)) {
            this.f11958o[i] = f;
            this.f11953j = true;
            invalidateSelf();
        }
    }

    public final void m14214a(int i) {
        this.f11956m = i;
        invalidateSelf();
    }

    @VisibleForTesting
    public final int m14211a() {
        return this.f11956m;
    }

    private void m14203a(Canvas canvas) {
        m14205b();
        int a = ColorUtil.m14198a(this.f11956m, this.f11957n);
        if ((a >>> 24) != 0) {
            this.f11955l.setColor(a);
            this.f11955l.setStyle(Style.FILL);
            canvas.drawPath(this.f11948e, this.f11955l);
        }
        float d = m14209d();
        if (d > 0.0f) {
            this.f11955l.setColor(ColorUtil.m14198a(m14210e(), this.f11957n));
            this.f11955l.setStyle(Style.STROKE);
            this.f11955l.setStrokeWidth(d);
            canvas.drawPath(this.f11948e, this.f11955l);
        }
    }

    private void m14205b() {
        float f = 0.0f;
        if (this.f11953j) {
            float f2;
            float f3;
            float f4;
            this.f11953j = false;
            if (this.f11948e == null) {
                this.f11948e = new Path();
                this.f11951h = new RectF();
                this.f11949f = new Path();
                this.f11952i = new RectF();
            }
            this.f11948e.reset();
            this.f11949f.reset();
            this.f11951h.set(getBounds());
            this.f11952i.set(getBounds());
            float d = m14209d();
            if (d > 0.0f) {
                this.f11951h.inset(0.5f * d, d * 0.5f);
            }
            d = !CSSConstants.a(this.f11954k) ? this.f11954k : 0.0f;
            if (this.f11958o == null || CSSConstants.a(this.f11958o[0])) {
                f2 = d;
            } else {
                f2 = this.f11958o[0];
            }
            if (this.f11958o == null || CSSConstants.a(this.f11958o[1])) {
                f3 = d;
            } else {
                f3 = this.f11958o[1];
            }
            if (this.f11958o == null || CSSConstants.a(this.f11958o[2])) {
                f4 = d;
            } else {
                f4 = this.f11958o[2];
            }
            if (!(this.f11958o == null || CSSConstants.a(this.f11958o[3]))) {
                d = this.f11958o[3];
            }
            this.f11948e.addRoundRect(this.f11951h, new float[]{f2, f2, f3, f3, f4, f4, d, d}, Direction.CW);
            if (this.f11944a != null) {
                f = this.f11944a.a(8) / 2.0f;
            }
            this.f11949f.addRoundRect(this.f11952i, new float[]{f2 + f, f2 + f, f3 + f, f3 + f, f4 + f, f4 + f, d + f, d + f}, Direction.CW);
        }
    }

    private void m14208c() {
        this.f11947d = this.f11946c != null ? this.f11946c.getPathEffect(m14209d()) : null;
        this.f11955l.setPathEffect(this.f11947d);
    }

    private float m14209d() {
        return (this.f11944a == null || CSSConstants.a(this.f11944a.b(8))) ? 0.0f : this.f11944a.b(8);
    }

    private int m14210e() {
        return (this.f11945b == null || CSSConstants.a(this.f11945b.b(8))) ? -16777216 : (int) ((long) this.f11945b.b(8));
    }

    private void m14206b(Canvas canvas) {
        int a = ColorUtil.m14198a(this.f11956m, this.f11957n);
        if ((a >>> 24) != 0) {
            this.f11955l.setColor(a);
            this.f11955l.setStyle(Style.FILL);
            canvas.drawRect(getBounds(), this.f11955l);
        }
        if (m14204b(0) > 0 || m14204b(1) > 0 || m14204b(2) > 0 || m14204b(3) > 0) {
            a = m14204b(0);
            int b = m14204b(1);
            int b2 = m14204b(2);
            int b3 = m14204b(3);
            int c = m14207c(0);
            int c2 = m14207c(1);
            int c3 = m14207c(2);
            int c4 = m14207c(3);
            int width = getBounds().width();
            int height = getBounds().height();
            this.f11955l.setAntiAlias(false);
            if (this.f11950g == null) {
                this.f11950g = new Path();
            }
            if (a > 0 && c != 0) {
                this.f11955l.setColor(c);
                this.f11950g.reset();
                this.f11950g.moveTo(0.0f, 0.0f);
                this.f11950g.lineTo((float) a, (float) b);
                this.f11950g.lineTo((float) a, (float) (height - b3));
                this.f11950g.lineTo(0.0f, (float) height);
                this.f11950g.lineTo(0.0f, 0.0f);
                canvas.drawPath(this.f11950g, this.f11955l);
            }
            if (b > 0 && c2 != 0) {
                this.f11955l.setColor(c2);
                this.f11950g.reset();
                this.f11950g.moveTo(0.0f, 0.0f);
                this.f11950g.lineTo((float) a, (float) b);
                this.f11950g.lineTo((float) (width - b2), (float) b);
                this.f11950g.lineTo((float) width, 0.0f);
                this.f11950g.lineTo(0.0f, 0.0f);
                canvas.drawPath(this.f11950g, this.f11955l);
            }
            if (b2 > 0 && c3 != 0) {
                this.f11955l.setColor(c3);
                this.f11950g.reset();
                this.f11950g.moveTo((float) width, 0.0f);
                this.f11950g.lineTo((float) width, (float) height);
                this.f11950g.lineTo((float) (width - b2), (float) (height - b3));
                this.f11950g.lineTo((float) (width - b2), (float) b);
                this.f11950g.lineTo((float) width, 0.0f);
                canvas.drawPath(this.f11950g, this.f11955l);
            }
            if (b3 > 0 && c4 != 0) {
                this.f11955l.setColor(c4);
                this.f11950g.reset();
                this.f11950g.moveTo(0.0f, (float) height);
                this.f11950g.lineTo((float) width, (float) height);
                this.f11950g.lineTo((float) (width - b2), (float) (height - b3));
                this.f11950g.lineTo((float) a, (float) (height - b3));
                this.f11950g.lineTo(0.0f, (float) height);
                canvas.drawPath(this.f11950g, this.f11955l);
            }
            this.f11955l.setAntiAlias(true);
        }
    }

    private int m14204b(int i) {
        return this.f11944a != null ? Math.round(this.f11944a.a(i)) : 0;
    }

    private int m14207c(int i) {
        return this.f11945b != null ? (int) ((long) this.f11945b.a(i)) : -16777216;
    }
}
