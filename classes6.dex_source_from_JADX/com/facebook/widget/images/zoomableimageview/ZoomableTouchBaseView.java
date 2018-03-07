package com.facebook.widget.images.zoomableimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.images.zoomableimageview.easing.Cubic;
import com.facebook.widget.images.zoomableimageview.graphics.FastBitmapDrawable;
import javax.annotation.Nullable;

/* compiled from: replyActionType */
public class ZoomableTouchBaseView extends ImageView {
    public static final String f5906l = ZoomableTouchBaseView.class.getSimpleName();
    protected int f5907A;
    protected boolean f5908B;
    public int f5909C;
    protected float f5910D;
    protected float f5911E;
    protected final float f5912F;
    protected final int f5913G;
    protected RectF f5914H;
    protected RectF f5915I;
    protected RectF f5916J;
    private OnBitmapChangedListener f5917a;
    protected Cubic f5918m;
    protected Matrix f5919n;
    public Matrix f5920o;
    protected Matrix f5921p;
    protected Matrix f5922q;
    protected Matrix f5923r;
    protected Matrix f5924s;
    protected Handler f5925t;
    protected Runnable f5926u;
    public float f5927v;
    protected float f5928w;
    protected final Matrix f5929x;
    public final float[] f5930y;
    protected int f5931z;

    /* compiled from: replyActionType */
    public interface OnBitmapChangedListener {
    }

    public ZoomableTouchBaseView(Context context) {
        super(context);
        this.f5918m = new Cubic();
        this.f5919n = new Matrix();
        this.f5920o = new Matrix();
        this.f5921p = new Matrix();
        this.f5922q = new Matrix();
        this.f5923r = new Matrix();
        this.f5924s = new Matrix();
        this.f5925t = new Handler();
        this.f5926u = null;
        this.f5928w = -1.0f;
        this.f5929x = new Matrix();
        this.f5930y = new float[9];
        this.f5931z = -1;
        this.f5907A = -1;
        this.f5908B = false;
        this.f5909C = 0;
        this.f5912F = 2.0f;
        this.f5913G = 400;
        this.f5914H = new RectF();
        this.f5915I = new RectF();
        this.f5916J = new RectF();
        mo397a();
    }

    public ZoomableTouchBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5918m = new Cubic();
        this.f5919n = new Matrix();
        this.f5920o = new Matrix();
        this.f5921p = new Matrix();
        this.f5922q = new Matrix();
        this.f5923r = new Matrix();
        this.f5924s = new Matrix();
        this.f5925t = new Handler();
        this.f5926u = null;
        this.f5928w = -1.0f;
        this.f5929x = new Matrix();
        this.f5930y = new float[9];
        this.f5931z = -1;
        this.f5907A = -1;
        this.f5908B = false;
        this.f5909C = 0;
        this.f5912F = 2.0f;
        this.f5913G = 400;
        this.f5914H = new RectF();
        this.f5915I = new RectF();
        this.f5916J = new RectF();
        mo397a();
    }

    public void setOnBitmapChangedListener(OnBitmapChangedListener onBitmapChangedListener) {
        this.f5917a = onBitmapChangedListener;
    }

    protected void mo397a() {
        setScaleType(ScaleType.MATRIX);
    }

    public void setFitToScreen(boolean z) {
        if (z != this.f5908B) {
            this.f5908B = z;
            requestLayout();
        }
    }

    public void setMinZoom(float f) {
        Log.d(f5906l, "minZoom: " + f);
        this.f5928w = f;
    }

    public void setRotation(int i) {
        if (i % 90 == 0) {
            this.f5909C = i % 360;
        } else {
            Log.d(f5906l, "Only allow rotations that are multiples of 90 degrees for now.");
        }
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f5924s.set(matrix);
        this.f5924s.preConcat(this.f5922q);
    }

    public Matrix getPhotoDisplayMatrix() {
        return this.f5924s;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5931z = i3 - i;
        this.f5907A = i4 - i2;
        Runnable runnable = this.f5926u;
        if (runnable != null) {
            this.f5926u = null;
            runnable.run();
        }
        if (getDrawable() != null) {
            if (this.f5908B) {
                m8474b(this.f5919n);
                setMinZoom(1.0f);
            } else {
                m8472a(getDrawable(), this.f5919n);
                setMinZoom(getMinZoom());
            }
            setImageMatrix(getImageViewMatrix());
            mo422c(getMinZoom());
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            m8491b(new FastBitmapDrawable(bitmap), true, null, -1.0f);
        } else {
            m8491b(null, true, null, -1.0f);
        }
    }

    public void setImageResource(int i) {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        m8491b(drawable, true, null, -1.0f);
    }

    public final void m8491b(@Nullable Drawable drawable, boolean z, @Nullable Matrix matrix, float f) {
        if (getWidth() <= 0) {
            final Drawable drawable2 = drawable;
            final boolean z2 = z;
            final Matrix matrix2 = matrix;
            final float f2 = f;
            this.f5926u = new Runnable(this) {
                final /* synthetic */ ZoomableTouchBaseView f5965e;

                public void run() {
                    this.f5965e.m8491b(drawable2, z2, matrix2, f2);
                }
            };
            return;
        }
        mo400a(drawable, z, matrix, f);
    }

    protected void mo400a(@Nullable Drawable drawable, boolean z, @Nullable Matrix matrix, float f) {
        super.setImageDrawable(drawable);
        if (drawable == null) {
            this.f5919n.reset();
        } else if (this.f5908B) {
            m8474b(this.f5919n);
            setMinZoom(m8476d(this.f5919n));
        } else {
            m8472a(drawable, this.f5919n);
            setMinZoom(getMinZoom());
        }
        if (z) {
            this.f5920o.reset();
            if (matrix != null) {
                this.f5920o = new Matrix(matrix);
            }
        }
        setImageMatrix(getImageViewMatrix());
        if (f < 1.0f) {
            f = mo421b();
        }
        this.f5927v = f;
        mo399a(drawable);
    }

    protected void mo399a(@Nullable Drawable drawable) {
    }

    private float mo421b() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.max(((float) getPhotoWidth()) / ((float) this.f5931z), ((float) getPhotoHeight()) / ((float) this.f5907A)) * 3.0f;
    }

    public float getMaxZoom() {
        if (this.f5927v < 1.0f) {
            this.f5927v = mo421b();
        }
        return this.f5927v;
    }

    public float getMinZoom() {
        if (this.f5928w < 0.0f) {
            this.f5928w = 1.0f;
        }
        return this.f5928w;
    }

    public Matrix getImageViewMatrix() {
        return m8470a(this.f5920o);
    }

    private Matrix m8470a(Matrix matrix) {
        this.f5929x.set(this.f5919n);
        this.f5929x.postConcat(matrix);
        return this.f5929x;
    }

    public Matrix getBaseMatrix() {
        return this.f5919n;
    }

    public Matrix getBasePhotoDisplayMatrix() {
        return this.f5923r;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.f5920o);
    }

    private void m8472a(Drawable drawable, Matrix matrix) {
        Log.i(f5906l, "getProperBaseMatrix");
        float width = (float) getWidth();
        float height = (float) getHeight();
        float intrinsicWidth = (float) drawable.getIntrinsicWidth();
        float intrinsicHeight = (float) drawable.getIntrinsicHeight();
        matrix.reset();
        if (intrinsicWidth > width || intrinsicHeight > height) {
            float min = Math.min(Math.min(width / intrinsicWidth, 2.0f), Math.min(height / intrinsicHeight, 2.0f));
            Log.d(f5906l, "scale: " + min);
            matrix.postScale(min, min);
            matrix.postTranslate((width - (intrinsicWidth * min)) / 2.0f, (height - (intrinsicHeight * min)) / 2.0f);
            return;
        }
        matrix.postTranslate((width - intrinsicWidth) / 2.0f, (height - intrinsicHeight) / 2.0f);
        Log.d(f5906l, "scale: null");
    }

    private void m8474b(Matrix matrix) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float photoWidth = (float) getPhotoWidth();
        float photoHeight = (float) getPhotoHeight();
        matrix.reset();
        Matrix matrix2 = new Matrix();
        if (this.f5909C != 0) {
            matrix2.postTranslate(((float) (-getDrawable().getIntrinsicWidth())) / 2.0f, ((float) (-getDrawable().getIntrinsicHeight())) / 2.0f);
            matrix2.postRotate((float) this.f5909C);
            matrix2.postTranslate(((float) getPhotoWidth()) / 2.0f, ((float) getPhotoHeight()) / 2.0f);
        }
        this.f5921p = matrix2;
        this.f5922q = getInverseRotationMatrix();
        matrix.postConcat(this.f5921p);
        float min = Math.min(width / photoWidth, height / photoHeight);
        matrix.postScale(min, min);
        height = (height - (photoHeight * min)) / 2.0f;
        this.f5910D = Math.max(this.f5911E + height, 0.0f) - height;
        matrix.postTranslate((width - (photoWidth * min)) / 2.0f, height + this.f5910D);
        this.f5923r.set(matrix);
        this.f5923r.preConcat(this.f5922q);
    }

    private Matrix getInverseRotationMatrix() {
        Matrix matrix = new Matrix();
        if (this.f5909C != 0) {
            matrix.postTranslate(((float) (-getPhotoWidth())) / 2.0f, ((float) (-getPhotoHeight())) / 2.0f);
            matrix.postRotate((float) (-this.f5909C));
            matrix.postTranslate(((float) getDrawable().getIntrinsicWidth()) / 2.0f, ((float) getDrawable().getIntrinsicHeight()) / 2.0f);
        }
        return matrix;
    }

    private boolean mo423d() {
        return (this.f5909C / 90) % 2 == 1;
    }

    public int getPhotoWidth() {
        return mo423d() ? getDrawable().getIntrinsicHeight() : getDrawable().getIntrinsicWidth();
    }

    public int getPhotoHeight() {
        return mo423d() ? getDrawable().getIntrinsicWidth() : getDrawable().getIntrinsicHeight();
    }

    public void setPhotoOffset(float f) {
        this.f5911E = f;
    }

    protected RectF getBitmapRect() {
        return m8475c(this.f5920o);
    }

    private RectF m8475c(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        Matrix a = m8470a(matrix);
        this.f5914H.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        a.mapRect(this.f5914H);
        return this.f5914H;
    }

    private float m8476d(Matrix matrix) {
        matrix.getValues(this.f5930y);
        return this.f5930y[0];
    }

    public float getRotation() {
        return 0.0f;
    }

    public float getScale() {
        return m8476d(this.f5920o);
    }

    protected void mo419a(boolean z, boolean z2) {
        if (getDrawable() != null) {
            RectF a = m8478a(this.f5920o, z, z2);
            if (a.left != 0.0f || a.top != 0.0f) {
                Log.d(f5906l, "center.rect: " + a.left + "x" + a.top);
                mo396a(a.left, a.top);
            }
        }
    }

    protected final RectF m8478a(Matrix matrix, boolean z, boolean z2) {
        if (getDrawable() == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        float f;
        int width;
        this.f5915I.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF c = m8475c(matrix);
        float height = c.height();
        float width2 = c.width();
        if (z2) {
            int height2 = (int) (((float) getHeight()) + (this.f5910D * 2.0f));
            if (height < ((float) height2)) {
                f = ((((float) height2) - height) / 2.0f) - c.top;
            } else if (c.top > 0.0f) {
                f = -c.top;
            } else if (c.bottom < ((float) height2)) {
                f = ((float) getHeight()) - c.bottom;
            }
            if (z) {
                width = getWidth();
                if (width2 < ((float) width)) {
                    height = ((((float) width) - width2) / 2.0f) - c.left;
                } else if (c.left > 0.0f) {
                    height = -c.left;
                } else if (c.right < ((float) width)) {
                    height = ((float) width) - c.right;
                }
                this.f5915I.set(height, f, 0.0f, 0.0f);
                return this.f5915I;
            }
            height = 0.0f;
            this.f5915I.set(height, f, 0.0f, 0.0f);
            return this.f5915I;
        }
        f = 0.0f;
        if (z) {
            width = getWidth();
            if (width2 < ((float) width)) {
                height = ((((float) width) - width2) / 2.0f) - c.left;
            } else if (c.left > 0.0f) {
                height = -c.left;
            } else if (c.right < ((float) width)) {
                height = ((float) width) - c.right;
            }
            this.f5915I.set(height, f, 0.0f, 0.0f);
            return this.f5915I;
        }
        height = 0.0f;
        this.f5915I.set(height, f, 0.0f, 0.0f);
        return this.f5915I;
    }

    private void mo396a(float f, float f2) {
        this.f5920o.postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void mo422c(float f) {
        m8483a(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public final void m8490b(float f, float f2) {
        mo415a(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, f2);
    }

    protected final void m8483a(float f, float f2, float f3) {
        float scale = f / getScale();
        Log.d(f5906l, "zoomTo: " + f + ", center: " + f2 + "x" + f3);
        this.f5920o.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        mo398a(getScale());
        mo419a(true, true);
    }

    protected void mo398a(float f) {
    }

    protected void mo401b(float f) {
    }

    public final void m8493c(float f, float f2) {
        mo414a((double) f, (double) f2);
    }

    protected void mo414a(double d, double d2) {
        RectF bitmapRect = getBitmapRect();
        this.f5916J.set((float) d, (float) d2, 0.0f, 0.0f);
        mo417a(bitmapRect, this.f5916J);
        mo396a(this.f5916J.left, this.f5916J.top);
        mo419a(true, true);
    }

    protected void mo417a(RectF rectF, RectF rectF2) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (rectF.top >= 0.0f && rectF.bottom <= height) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= width) {
            rectF2.left = 0.0f;
        }
        if (rectF.top + rectF2.top >= 0.0f && rectF.bottom > height) {
            rectF2.top = (float) ((int) (0.0f - rectF.top));
        }
        if (rectF.bottom + rectF2.top <= height - 0.0f && rectF.top < 0.0f) {
            rectF2.top = (float) ((int) ((height - 0.0f) - rectF.bottom));
        }
        if (rectF.left + rectF2.left >= 0.0f) {
            rectF2.left = (float) ((int) (0.0f - rectF.left));
        }
        if (rectF.right + rectF2.left <= width - 0.0f) {
            rectF2.left = (float) ((int) ((width - 0.0f) - rectF.right));
        }
    }

    public final void m8482a(float f, float f2, double d) {
        final double d2 = (double) f;
        final double d3 = (double) f2;
        final long currentTimeMillis = System.currentTimeMillis();
        final double d4 = d;
        HandlerDetour.a(this.f5925t, new Runnable(this) {
            double f5966a = 0.0d;
            double f5967b = 0.0d;
            final /* synthetic */ ZoomableTouchBaseView f5972g;

            public void run() {
                double min = Math.min(d4, (double) (System.currentTimeMillis() - currentTimeMillis));
                double a = this.f5972g.f5918m.m8560a(min, 0.0d, d2, d4);
                double a2 = this.f5972g.f5918m.m8560a(min, 0.0d, d3, d4);
                this.f5972g.mo414a(a - this.f5966a, a2 - this.f5967b);
                this.f5966a = a;
                this.f5967b = a2;
                if (min < d4) {
                    HandlerDetour.a(this.f5972g.f5925t, this, 1867907039);
                    return;
                }
                RectF a3 = this.f5972g.m8478a(this.f5972g.f5920o, true, true);
                if (a3.left != 0.0f || a3.top != 0.0f) {
                    this.f5972g.m8493c(a3.left, a3.top);
                }
            }
        }, -485303480);
    }

    protected void mo415a(float f, float f2, float f3, float f4) {
        if (f > getMaxZoom()) {
            f = getMaxZoom();
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final float scale = getScale();
        final float f5 = f - scale;
        Matrix matrix = new Matrix(this.f5920o);
        matrix.postScale(f, f, f2, f3);
        RectF a = m8478a(matrix, true, true);
        final float f6 = f2 + (a.left * f);
        final float f7 = f3 + (a.top * f);
        final float f8 = f4;
        HandlerDetour.a(this.f5925t, new Runnable(this) {
            final /* synthetic */ ZoomableTouchBaseView f5979g;

            public void run() {
                float min = Math.min(f8, (float) (System.currentTimeMillis() - currentTimeMillis));
                this.f5979g.m8483a(((float) this.f5979g.f5918m.m8561b((double) min, 0.0d, (double) f5, (double) f8)) + scale, f6, f7);
                if (min < f8) {
                    HandlerDetour.a(this.f5979g.f5925t, this, 1263533784);
                    return;
                }
                this.f5979g.mo401b(this.f5979g.getScale());
                this.f5979g.mo419a(true, true);
            }
        }, -1901683889);
    }
}
