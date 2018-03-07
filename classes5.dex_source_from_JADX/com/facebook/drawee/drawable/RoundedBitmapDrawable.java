package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: [PrefixTransformer(' */
public class RoundedBitmapDrawable extends BitmapDrawable implements Rounded, TransformAwareDrawable {
    @VisibleForTesting
    final float[] f11906a = new float[8];
    @VisibleForTesting
    public final RectF f11907b = new RectF();
    @VisibleForTesting
    public final RectF f11908c = new RectF();
    @VisibleForTesting
    public final RectF f11909d = new RectF();
    @VisibleForTesting
    public final RectF f11910e = new RectF();
    @VisibleForTesting
    public final Matrix f11911f = new Matrix();
    @VisibleForTesting
    public final Matrix f11912g = new Matrix();
    @VisibleForTesting
    public final Matrix f11913h = new Matrix();
    @VisibleForTesting
    public final Matrix f11914i = new Matrix();
    @VisibleForTesting
    public final Matrix f11915j = new Matrix();
    @VisibleForTesting
    public final Matrix f11916k = new Matrix();
    public boolean f11917l = false;
    public boolean f11918m = false;
    private final float[] f11919n = new float[8];
    public float f11920o = 0.0f;
    private int f11921p = 0;
    private float f11922q = 0.0f;
    private final Path f11923r = new Path();
    private final Path f11924s = new Path();
    public boolean f11925t = true;
    public final Paint f11926u = new Paint();
    private final Paint f11927v = new Paint(1);
    public boolean f11928w = true;
    public WeakReference<Bitmap> f11929x;
    @Nullable
    public TransformCallback f11930y;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap);
        if (paint != null) {
            this.f11926u.set(paint);
        }
        this.f11926u.setFlags(1);
        this.f11927v.setStyle(Style.STROKE);
    }

    public final void m19953a(boolean z) {
        this.f11917l = z;
        this.f11925t = true;
        invalidateSelf();
    }

    public final void m19950a(float f) {
        boolean z = false;
        Preconditions.b(f >= 0.0f);
        Arrays.fill(this.f11919n, f);
        if (f != 0.0f) {
            z = true;
        }
        this.f11918m = z;
        this.f11925t = true;
        invalidateSelf();
    }

    public final void m19954a(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f11919n, 0.0f);
            this.f11918m = false;
        } else {
            boolean z;
            if (fArr.length == 8) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.a(z, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f11919n, 0, 8);
            this.f11918m = false;
            for (int i = 0; i < 8; i++) {
                int i2;
                boolean z2 = this.f11918m;
                if (fArr[i] > 0.0f) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.f11918m = i2 | z2;
            }
        }
        this.f11925t = true;
        invalidateSelf();
    }

    public final void m19951a(int i, float f) {
        if (this.f11921p != i || this.f11920o != f) {
            this.f11921p = i;
            this.f11920o = f;
            this.f11925t = true;
            invalidateSelf();
        }
    }

    public final void m19955b(float f) {
        if (this.f11922q != f) {
            this.f11922q = f;
            this.f11925t = true;
            invalidateSelf();
        }
    }

    public final void m19952a(@Nullable TransformCallback transformCallback) {
        this.f11930y = transformCallback;
    }

    public void setAlpha(int i) {
        if (i != this.f11926u.getAlpha()) {
            this.f11926u.setAlpha(i);
            super.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11926u.setColorFilter(colorFilter);
        super.setColorFilter(colorFilter);
    }

    public void draw(Canvas canvas) {
        Object obj;
        if (this.f11917l || this.f11918m || this.f11920o > 0.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            super.draw(canvas);
            return;
        }
        if (this.f11930y != null) {
            this.f11930y.a(this.f11913h);
            this.f11930y.a(this.f11907b);
        } else {
            this.f11913h.reset();
            this.f11907b.set(getBounds());
        }
        this.f11909d.set(0.0f, 0.0f, (float) getBitmap().getWidth(), (float) getBitmap().getHeight());
        this.f11910e.set(getBounds());
        this.f11911f.setRectToRect(this.f11909d, this.f11910e, ScaleToFit.FILL);
        if (!(this.f11913h.equals(this.f11914i) && this.f11911f.equals(this.f11912g))) {
            this.f11928w = true;
            this.f11913h.invert(this.f11915j);
            this.f11916k.set(this.f11913h);
            this.f11916k.preConcat(this.f11911f);
            this.f11914i.set(this.f11913h);
            this.f11912g.set(this.f11911f);
        }
        if (!this.f11907b.equals(this.f11908c)) {
            this.f11925t = true;
            this.f11908c.set(this.f11907b);
        }
        m19949c();
        Bitmap bitmap = getBitmap();
        if (this.f11929x == null || this.f11929x.get() != bitmap) {
            this.f11929x = new WeakReference(bitmap);
            this.f11926u.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
            this.f11928w = true;
        }
        if (this.f11928w) {
            this.f11926u.getShader().setLocalMatrix(this.f11916k);
            this.f11928w = false;
        }
        int save = canvas.save();
        canvas.concat(this.f11915j);
        canvas.drawPath(this.f11923r, this.f11926u);
        if (this.f11920o > 0.0f) {
            this.f11927v.setStrokeWidth(this.f11920o);
            this.f11927v.setColor(DrawableUtils.a(this.f11921p, this.f11926u.getAlpha()));
            canvas.drawPath(this.f11924s, this.f11927v);
        }
        canvas.restoreToCount(save);
    }

    private void m19949c() {
        if (this.f11925t) {
            this.f11924s.reset();
            this.f11907b.inset(this.f11920o / 2.0f, this.f11920o / 2.0f);
            if (this.f11917l) {
                this.f11924s.addCircle(this.f11907b.centerX(), this.f11907b.centerY(), Math.min(this.f11907b.width(), this.f11907b.height()) / 2.0f, Direction.CW);
            } else {
                for (int i = 0; i < this.f11906a.length; i++) {
                    this.f11906a[i] = (this.f11919n[i] + this.f11922q) - (this.f11920o / 2.0f);
                }
                this.f11924s.addRoundRect(this.f11907b, this.f11906a, Direction.CW);
            }
            this.f11907b.inset((-this.f11920o) / 2.0f, (-this.f11920o) / 2.0f);
            this.f11923r.reset();
            this.f11907b.inset(this.f11922q, this.f11922q);
            if (this.f11917l) {
                this.f11923r.addCircle(this.f11907b.centerX(), this.f11907b.centerY(), Math.min(this.f11907b.width(), this.f11907b.height()) / 2.0f, Direction.CW);
            } else {
                this.f11923r.addRoundRect(this.f11907b, this.f11919n, Direction.CW);
            }
            this.f11907b.inset(-this.f11922q, -this.f11922q);
            this.f11923r.setFillType(FillType.WINDING);
            this.f11925t = false;
        }
    }
}
