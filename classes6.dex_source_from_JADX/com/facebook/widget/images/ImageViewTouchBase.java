package com.facebook.widget.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: reportInlinePrivacySurveyAction */
public class ImageViewTouchBase extends ImageView {
    private static float f5813m = 1.0f;
    protected Matrix f5814a;
    protected Matrix f5815b;
    protected final RotateBitmap f5816c;
    int f5817d;
    int f5818e;
    boolean f5819f;
    protected float f5820g;
    protected Handler f5821h;
    private final Matrix f5822i;
    private final float[] f5823j;
    private Recycler f5824k;
    private Runnable f5825l;

    /* compiled from: reportInlinePrivacySurveyAction */
    public interface Recycler {
    }

    public void setRecycler(Recycler recycler) {
        this.f5824k = recycler;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5817d = i3 - i;
        this.f5818e = i4 - i2;
        Runnable runnable = this.f5825l;
        if (runnable != null) {
            this.f5825l = null;
            runnable.run();
        } else if (this.f5816c.f5835b != null) {
            m8372a(this.f5816c, this.f5814a, true);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        m8371a(bitmap, 0);
    }

    private void m8371a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.mutate().setDither(true);
        }
        this.f5816c.f5835b = bitmap;
        this.f5816c.f5836c = i;
    }

    public final void m8374a() {
        m8378a(null, true);
    }

    public final void m8378a(Bitmap bitmap, boolean z) {
        m8379a(new RotateBitmap(bitmap), z);
    }

    public void setDrawable(Drawable drawable) {
        if (getScaleType() == ScaleType.MATRIX && (drawable instanceof BitmapDrawable)) {
            m8379a(new RotateBitmap(((BitmapDrawable) drawable).getBitmap(), 0), true);
        } else {
            setImageDrawable(drawable);
        }
    }

    public final void m8379a(final RotateBitmap rotateBitmap, final boolean z) {
        this.f5819f = true;
        if (getWidth() <= 0) {
            this.f5825l = new Runnable(this) {
                final /* synthetic */ ImageViewTouchBase f5805c;

                public void run() {
                    this.f5805c.m8379a(rotateBitmap, z);
                }
            };
            return;
        }
        if (rotateBitmap.f5835b != null) {
            m8372a(rotateBitmap, this.f5814a, true);
            m8371a(rotateBitmap.f5835b, rotateBitmap.f5836c);
        } else {
            this.f5814a.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f5815b.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.f5820g = m8373b();
    }

    public final void m8380a(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.f5816c.f5835b != null) {
            int height;
            Matrix imageViewMatrix = getImageViewMatrix();
            RectF rectF = new RectF(0.0f, 0.0f, (float) this.f5816c.f5835b.getWidth(), (float) this.f5816c.f5835b.getHeight());
            imageViewMatrix.mapRect(rectF);
            float height2 = rectF.height();
            float width = rectF.width();
            if (z2) {
                height = getHeight();
                if (height2 < ((float) height)) {
                    height2 = ((((float) height) - height2) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    height2 = -rectF.top;
                } else if (rectF.bottom < ((float) height)) {
                    height2 = ((float) getHeight()) - rectF.bottom;
                }
                if (z) {
                    height = getWidth();
                    if (width < ((float) height)) {
                        f = ((((float) height) - width) / 2.0f) - rectF.left;
                    } else if (rectF.left > 0.0f) {
                        f = -rectF.left;
                    } else if (rectF.right < ((float) height)) {
                        f = ((float) height) - rectF.right;
                    }
                }
                new StringBuilder("center() delta: ").append(f).append(", ").append(height2);
                m8375a(f, height2);
                setImageMatrix(getImageViewMatrix());
            }
            height2 = 0.0f;
            if (z) {
                height = getWidth();
                if (width < ((float) height)) {
                    f = ((((float) height) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f = -rectF.left;
                } else if (rectF.right < ((float) height)) {
                    f = ((float) height) - rectF.right;
                }
            }
            new StringBuilder("center() delta: ").append(f).append(", ").append(height2);
            m8375a(f, height2);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.f5814a = new Matrix();
        this.f5815b = new Matrix();
        this.f5822i = new Matrix();
        this.f5823j = new float[9];
        this.f5816c = new RotateBitmap(null);
        this.f5817d = -1;
        this.f5818e = -1;
        this.f5819f = true;
        this.f5820g = 4.0f;
        this.f5821h = new Handler();
        this.f5825l = null;
        setScaleType(ScaleType.MATRIX);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5814a = new Matrix();
        this.f5815b = new Matrix();
        this.f5822i = new Matrix();
        this.f5823j = new float[9];
        this.f5816c = new RotateBitmap(null);
        this.f5817d = -1;
        this.f5818e = -1;
        this.f5819f = true;
        this.f5820g = 4.0f;
        this.f5821h = new Handler();
        this.f5825l = null;
        setScaleType(ScaleType.MATRIX);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5814a = new Matrix();
        this.f5815b = new Matrix();
        this.f5822i = new Matrix();
        this.f5823j = new float[9];
        this.f5816c = new RotateBitmap(null);
        this.f5817d = -1;
        this.f5818e = -1;
        this.f5819f = true;
        this.f5820g = 4.0f;
        this.f5821h = new Handler();
        this.f5825l = null;
        setScaleType(ScaleType.MATRIX);
    }

    private float m8370a(Matrix matrix, int i) {
        matrix.getValues(this.f5823j);
        return this.f5823j[i];
    }

    private float m8369a(Matrix matrix) {
        return m8370a(matrix, 0);
    }

    public float getScale() {
        return m8369a(this.f5815b);
    }

    private void m8372a(RotateBitmap rotateBitmap, Matrix matrix, boolean z) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float e = (float) rotateBitmap.m8393e();
        float d = (float) rotateBitmap.m8392d();
        matrix.reset();
        if (z) {
            matrix.postConcat(rotateBitmap.m8391c());
        }
        if (this.f5819f) {
            float min = Math.min(Math.min(width / e, 10.0f), Math.min(height / d, 10.0f));
            matrix.postScale(min, min);
            matrix.postTranslate((width - (e * min)) / 2.0f, (height - (d * min)) / 2.0f);
            return;
        }
        matrix.postTranslate((width - e) / 2.0f, (height - d) / 2.0f);
    }

    protected Matrix getImageViewMatrix() {
        this.f5822i.set(this.f5814a);
        this.f5822i.postConcat(this.f5815b);
        return this.f5822i;
    }

    public Matrix getUnrotatedMatrix() {
        Matrix matrix = new Matrix();
        m8372a(this.f5816c, matrix, false);
        matrix.postConcat(this.f5815b);
        return matrix;
    }

    private float m8373b() {
        if (this.f5816c.f5835b == null) {
            return 1.0f;
        }
        return Math.max(((float) this.f5816c.m8393e()) / ((float) this.f5817d), ((float) this.f5816c.m8392d()) / ((float) this.f5818e)) * 4.0f;
    }

    private float m8368a(float f) {
        if (f > this.f5820g) {
            return this.f5820g;
        }
        if (f < f5813m) {
            return f5813m;
        }
        return f;
    }

    public void m8376a(float f, float f2, float f3) {
        float a = m8368a(f);
        float scale = getScale();
        a /= scale;
        new StringBuilder("Old scale ").append(scale).append(", delta ").append(a);
        this.f5815b.postScale(a, a, f2, f3);
        setImageMatrix(getImageViewMatrix());
        m8380a(true, true);
    }

    protected final void m8377a(float f, float f2, float f3, float f4) {
        final float scale = (f - getScale()) / f4;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        final float f5 = f4;
        final float f6 = f2;
        final float f7 = f3;
        HandlerDetour.a(this.f5821h, new Runnable(this) {
            final /* synthetic */ ImageViewTouchBase f5812g;

            public void run() {
                float min = Math.min(f5, (float) (System.currentTimeMillis() - currentTimeMillis));
                this.f5812g.m8376a(scale2 + (scale * min), f6, f7);
                if (min < f5) {
                    HandlerDetour.a(this.f5812g.f5821h, this, -433806954);
                }
            }
        }, -829306718);
    }

    public void m8375a(float f, float f2) {
        this.f5815b.postTranslate(f, f2);
    }

    public final void m8381b(float f, float f2) {
        m8375a(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    public float getMaxZoom() {
        return this.f5820g;
    }

    public float getImageRight() {
        if (this.f5816c.f5835b == null) {
            return 0.0f;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f5816c.f5835b.getWidth(), (float) this.f5816c.f5835b.getHeight());
        imageViewMatrix.mapRect(rectF);
        return rectF.right;
    }

    public float getImageLeft() {
        if (this.f5816c.f5835b == null) {
            return 0.0f;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f5816c.f5835b.getWidth(), (float) this.f5816c.f5835b.getHeight());
        imageViewMatrix.mapRect(rectF);
        return rectF.left;
    }

    public RectF getImageRect() {
        if (this.f5816c.f5835b == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f5816c.f5835b.getWidth(), (float) this.f5816c.f5835b.getHeight());
        imageViewMatrix.mapRect(rectF);
        return rectF;
    }
}
