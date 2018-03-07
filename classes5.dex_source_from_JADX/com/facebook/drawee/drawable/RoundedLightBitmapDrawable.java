package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: [ChainedTransformer( */
public class RoundedLightBitmapDrawable extends LightBitmapDrawable implements Rounded, TransformAwareDrawable {
    @VisibleForTesting
    final float[] f11944a = new float[8];
    @VisibleForTesting
    public final RectF f11945b = new RectF();
    @VisibleForTesting
    public final RectF f11946c = new RectF();
    @VisibleForTesting
    public final RectF f11947d = new RectF();
    @VisibleForTesting
    public final RectF f11948e = new RectF();
    @VisibleForTesting
    public final Matrix f11949f = new Matrix();
    @VisibleForTesting
    public final Matrix f11950g = new Matrix();
    @VisibleForTesting
    public final Matrix f11951h = new Matrix();
    @VisibleForTesting
    public final Matrix f11952i = new Matrix();
    @VisibleForTesting
    public final Matrix f11953j = new Matrix();
    @VisibleForTesting
    public final Matrix f11954k = new Matrix();
    public boolean f11955l = false;
    public boolean f11956m = false;
    private final float[] f11957n = new float[8];
    public float f11958o = 0.0f;
    private int f11959p = 0;
    private float f11960q = 0.0f;
    private final Path f11961r = new Path();
    private final Path f11962s = new Path();
    public boolean f11963t = true;
    private final Paint f11964u = new Paint(1);
    public boolean f11965v = true;
    private WeakReference<Bitmap> f11966w;
    private Shader f11967x;
    @Nullable
    public TransformCallback f11968y;

    private void m19962b(Bitmap bitmap) {
        Paint paint = this.f11901e;
        if (this.f11966w == null || this.f11966w.get() != bitmap) {
            this.f11966w = new WeakReference(bitmap);
            this.f11967x = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.f11965v = true;
        }
        if (this.f11965v) {
            this.f11967x.setLocalMatrix(this.f11954k);
            this.f11965v = false;
        }
        if (paint.getShader() != this.f11967x) {
            paint.setShader(this.f11967x);
        }
    }

    public RoundedLightBitmapDrawable(Resources resources, Bitmap bitmap, @Nullable Paint paint) {
        super(resources, bitmap, paint);
        this.f11901e.setFlags(1);
        this.f11964u.setStyle(Style.STROKE);
    }

    public final void m19967a(boolean z) {
        this.f11955l = z;
        this.f11963t = true;
        invalidateSelf();
    }

    public final void m19964a(float f) {
        boolean z = false;
        Preconditions.b(f >= 0.0f);
        Arrays.fill(this.f11957n, f);
        if (f != 0.0f) {
            z = true;
        }
        this.f11956m = z;
        this.f11963t = true;
        invalidateSelf();
    }

    public final void m19968a(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f11957n, 0.0f);
            this.f11956m = false;
        } else {
            boolean z;
            if (fArr.length == 8) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.a(z, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f11957n, 0, 8);
            this.f11956m = false;
            for (int i = 0; i < 8; i++) {
                int i2;
                boolean z2 = this.f11956m;
                if (fArr[i] > 0.0f) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.f11956m = i2 | z2;
            }
        }
        this.f11963t = true;
        invalidateSelf();
    }

    public final void m19965a(int i, float f) {
        if (this.f11959p != i || this.f11958o != f) {
            this.f11959p = i;
            this.f11958o = f;
            this.f11963t = true;
            invalidateSelf();
        }
    }

    public final void m19969b(float f) {
        if (this.f11960q != f) {
            this.f11960q = f;
            this.f11963t = true;
            invalidateSelf();
        }
    }

    public final void m19966a(@Nullable TransformCallback transformCallback) {
        this.f11968y = transformCallback;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Bitmap bitmap = this.f11897a;
        Paint paint = this.f11901e;
        if (bitmap != null) {
            Object obj;
            if (this.f11955l || this.f11956m || this.f11958o > 0.0f) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                paint.setShader(null);
                canvas.drawBitmap(bitmap, null, bounds, paint);
                return;
            }
            if (this.f11968y != null) {
                this.f11968y.a(this.f11951h);
                this.f11968y.a(this.f11945b);
            } else {
                this.f11951h.reset();
                this.f11945b.set(bounds);
            }
            this.f11947d.set(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            this.f11948e.set(bounds);
            this.f11949f.setRectToRect(this.f11947d, this.f11948e, ScaleToFit.FILL);
            if (!(this.f11951h.equals(this.f11952i) && this.f11949f.equals(this.f11950g))) {
                this.f11965v = true;
                this.f11951h.invert(this.f11953j);
                this.f11954k.set(this.f11951h);
                this.f11954k.preConcat(this.f11949f);
                this.f11952i.set(this.f11951h);
                this.f11950g.set(this.f11949f);
            }
            if (!this.f11945b.equals(this.f11946c)) {
                this.f11963t = true;
                this.f11946c.set(this.f11945b);
            }
            m19962b(bitmap);
            m19963d();
            int save = canvas.save();
            canvas.concat(this.f11953j);
            canvas.drawPath(this.f11961r, this.f11901e);
            if (this.f11958o > 0.0f) {
                this.f11964u.setStrokeWidth(this.f11958o);
                this.f11964u.setColor(DrawableUtils.a(this.f11959p, this.f11901e.getAlpha()));
                canvas.drawPath(this.f11962s, this.f11964u);
            }
            canvas.restoreToCount(save);
        }
    }

    private void m19963d() {
        if (this.f11963t) {
            this.f11962s.reset();
            this.f11945b.inset(this.f11958o / 2.0f, this.f11958o / 2.0f);
            if (this.f11955l) {
                this.f11962s.addCircle(this.f11945b.centerX(), this.f11945b.centerY(), Math.min(this.f11945b.width(), this.f11945b.height()) / 2.0f, Direction.CW);
            } else {
                for (int i = 0; i < this.f11944a.length; i++) {
                    this.f11944a[i] = (this.f11957n[i] + this.f11960q) - (this.f11958o / 2.0f);
                }
                this.f11962s.addRoundRect(this.f11945b, this.f11944a, Direction.CW);
            }
            this.f11945b.inset((-this.f11958o) / 2.0f, (-this.f11958o) / 2.0f);
            this.f11961r.reset();
            this.f11945b.inset(this.f11960q, this.f11960q);
            if (this.f11955l) {
                this.f11961r.addCircle(this.f11945b.centerX(), this.f11945b.centerY(), Math.min(this.f11945b.width(), this.f11945b.height()) / 2.0f, Direction.CW);
            } else {
                this.f11961r.addRoundRect(this.f11945b, this.f11957n, Direction.CW);
            }
            this.f11945b.inset(-this.f11960q, -this.f11960q);
            this.f11961r.setFillType(FillType.WINDING);
            this.f11963t = false;
        }
    }
}
