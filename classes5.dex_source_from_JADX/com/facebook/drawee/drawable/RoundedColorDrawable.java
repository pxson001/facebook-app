package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

/* compiled from: [PreAndSuffixTransformer(' */
public class RoundedColorDrawable extends Drawable implements Rounded {
    @VisibleForTesting
    final float[] f11931a;
    @VisibleForTesting
    final Paint f11932b;
    @VisibleForTesting
    final Path f11933c;
    @VisibleForTesting
    final Path f11934d;
    private final float[] f11935e;
    private boolean f11936f;
    private float f11937g;
    private float f11938h;
    private int f11939i;
    public int f11940j;
    private final RectF f11941k;
    private int f11942l;

    public RoundedColorDrawable(int i) {
        this.f11935e = new float[8];
        this.f11931a = new float[8];
        this.f11932b = new Paint(1);
        this.f11936f = false;
        this.f11937g = 0.0f;
        this.f11938h = 0.0f;
        this.f11939i = 0;
        this.f11933c = new Path();
        this.f11934d = new Path();
        this.f11940j = 0;
        this.f11941k = new RectF();
        this.f11942l = 255;
        if (this.f11940j != i) {
            this.f11940j = i;
            invalidateSelf();
        }
    }

    public RoundedColorDrawable(float f, int i) {
        this(i);
        m19957a(f);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m19956a();
    }

    public void draw(Canvas canvas) {
        this.f11932b.setColor(DrawableUtils.a(this.f11940j, this.f11942l));
        this.f11932b.setStyle(Style.FILL);
        canvas.drawPath(this.f11933c, this.f11932b);
        if (this.f11937g != 0.0f) {
            this.f11932b.setColor(DrawableUtils.a(this.f11939i, this.f11942l));
            this.f11932b.setStyle(Style.STROKE);
            this.f11932b.setStrokeWidth(this.f11937g);
            canvas.drawPath(this.f11934d, this.f11932b);
        }
    }

    public final void m19959a(boolean z) {
        this.f11936f = z;
        m19956a();
        invalidateSelf();
    }

    public final void m19960a(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f11935e, 0.0f);
        } else {
            boolean z;
            if (fArr.length == 8) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.a(z, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f11935e, 0, 8);
        }
        m19956a();
        invalidateSelf();
    }

    public final void m19957a(float f) {
        Preconditions.a(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.f11935e, f);
        m19956a();
        invalidateSelf();
    }

    public final void m19958a(int i, float f) {
        if (this.f11939i != i) {
            this.f11939i = i;
            invalidateSelf();
        }
        if (this.f11937g != f) {
            this.f11937g = f;
            m19956a();
            invalidateSelf();
        }
    }

    public final void m19961b(float f) {
        if (this.f11938h != f) {
            this.f11938h = f;
            m19956a();
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
        if (i != this.f11942l) {
            this.f11942l = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f11942l;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        int a = DrawableUtils.a(this.f11940j, this.f11942l) >>> 24;
        if (a == 255) {
            a = -1;
        } else if (a == 0) {
            a = -2;
        } else {
            a = -3;
        }
        return a;
    }

    private void m19956a() {
        this.f11933c.reset();
        this.f11934d.reset();
        this.f11941k.set(getBounds());
        this.f11941k.inset(this.f11937g / 2.0f, this.f11937g / 2.0f);
        if (this.f11936f) {
            this.f11934d.addCircle(this.f11941k.centerX(), this.f11941k.centerY(), Math.min(this.f11941k.width(), this.f11941k.height()) / 2.0f, Direction.CW);
        } else {
            for (int i = 0; i < this.f11931a.length; i++) {
                this.f11931a[i] = (this.f11935e[i] + this.f11938h) - (this.f11937g / 2.0f);
            }
            this.f11934d.addRoundRect(this.f11941k, this.f11931a, Direction.CW);
        }
        this.f11941k.inset((-this.f11937g) / 2.0f, (-this.f11937g) / 2.0f);
        this.f11941k.inset(this.f11938h, this.f11938h);
        if (this.f11936f) {
            this.f11933c.addCircle(this.f11941k.centerX(), this.f11941k.centerY(), Math.min(this.f11941k.width(), this.f11941k.height()) / 2.0f, Direction.CW);
        } else {
            this.f11933c.addRoundRect(this.f11941k, this.f11935e, Direction.CW);
        }
        this.f11941k.inset(-this.f11938h, -this.f11938h);
    }
}
