package com.facebook.photos.crop;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* compiled from: live_indicator_info_event_key */
public class ProfilePicZoomableImageView extends ImageView {
    private Orientation f10069a = Orientation.NORMAL;
    private Matrix f10070b = new Matrix();
    private Matrix f10071c = new Matrix();
    private Matrix f10072d = new Matrix();
    private Matrix f10073e = new Matrix();
    private RectF f10074f = new RectF();
    private RectF f10075g = new RectF();
    public RectF f10076h = new RectF();
    private RectF f10077i = null;
    private RectF f10078j;
    private float[] f10079k = null;
    private float[] f10080l = null;
    private float f10081m = -1.0f;
    private float f10082n = 1.0f;
    private boolean f10083o = false;
    private float f10084p = 4.0f;
    private float f10085q = 1.0f;

    /* compiled from: live_indicator_info_event_key */
    public enum Orientation {
        NORMAL(0),
        ROTATED_CW(90),
        UPSIDE_DOWN(180),
        ROTATED_CCW(270);
        
        public final int rotation;

        public static Orientation valueOf(int i) {
            switch (i % 360) {
                case 90:
                    return ROTATED_CW;
                case 180:
                    return UPSIDE_DOWN;
                case 270:
                    return ROTATED_CCW;
                default:
                    return NORMAL;
            }
        }

        private Orientation(int i) {
            this.rotation = i;
        }

        public final boolean isRatioChanged() {
            return this == ROTATED_CCW || this == ROTATED_CW;
        }
    }

    public ProfilePicZoomableImageView(Context context) {
        super(context);
        m11969a();
    }

    public ProfilePicZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11969a();
    }

    public ProfilePicZoomableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11969a();
    }

    private void m11969a() {
        setScaleType(ScaleType.MATRIX);
    }

    public void setInitialZoomCropBounds(RectF rectF) {
        this.f10078j = rectF;
        m11971c();
    }

    public void setMaxScale(float f) {
        this.f10084p = f;
        m11971c();
    }

    public RectF getMinBoundingRect() {
        return this.f10077i;
    }

    public void setMinBoundingRectRatio(float f) {
        if (this.f10081m != f) {
            this.f10081m = f;
            m11971c();
        }
    }

    public void setCoverPhotoMultiplier(float f) {
        if (this.f10082n != f) {
            this.f10082n = f;
            m11971c();
        }
    }

    public void setDrawableOrientation(Orientation orientation) {
        if (this.f10069a != orientation) {
            this.f10069a = orientation;
            m11970b();
            m11971c();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m11970b();
        m11971c();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f10083o = true;
        if (z) {
            this.f10077i = null;
            m11971c();
        }
    }

    private void m11970b() {
        if (getDrawable() != null) {
            this.f10070b.reset();
            if (this.f10069a != Orientation.NORMAL) {
                Drawable drawable = getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                this.f10070b.postTranslate(((float) (-intrinsicWidth)) / 2.0f, ((float) (-intrinsicHeight)) / 2.0f);
                this.f10070b.postRotate((float) this.f10069a.rotation);
                if (this.f10069a.isRatioChanged()) {
                    this.f10070b.postTranslate(((float) intrinsicHeight) / 2.0f, ((float) intrinsicWidth) / 2.0f);
                } else {
                    this.f10070b.postTranslate(((float) intrinsicWidth) / 2.0f, ((float) intrinsicHeight) / 2.0f);
                }
            }
            this.f10074f.set(0.0f, 0.0f, (float) getRotatedDrawableWidth(), (float) getRotatedDrawableHeight());
        }
    }

    private void m11971c() {
        if (getDrawable() != null && this.f10083o) {
            float f;
            int rotatedDrawableHeight = getRotatedDrawableHeight();
            int rotatedDrawableWidth = getRotatedDrawableWidth();
            int height = getHeight();
            int width = getWidth();
            if (this.f10077i == null) {
                float f2;
                if (this.f10081m > 0.0f) {
                    float min = ((float) Math.min(height, width)) * this.f10081m;
                    f2 = (((float) width) - (this.f10082n * min)) / 2.0f;
                    f = (((float) height) - min) / 2.0f;
                    this.f10077i = new RectF(f2, f, (this.f10082n * min) + f2, min + f);
                } else if (height > width) {
                    f = ((float) (height - width)) / 2.0f;
                    this.f10077i = new RectF(0.0f, f, (float) width, ((float) width) + f);
                } else {
                    f2 = ((float) (width - height)) / 2.0f;
                    this.f10077i = new RectF(f2, 0.0f, ((float) height) + f2, (float) height);
                }
            }
            f = ((float) rotatedDrawableHeight) * this.f10082n > ((float) rotatedDrawableWidth) ? this.f10077i.width() / ((float) rotatedDrawableWidth) : this.f10077i.height() / ((float) rotatedDrawableHeight);
            this.f10071c.reset();
            this.f10071c.postTranslate(((float) (-rotatedDrawableWidth)) / 2.0f, ((float) (-rotatedDrawableHeight)) / 2.0f);
            this.f10071c.postScale(f, f);
            this.f10071c.postTranslate(this.f10077i.centerX(), this.f10077i.centerY());
            this.f10071c.mapRect(this.f10075g, this.f10074f);
            this.f10076h.set(this.f10075g);
            m11972d();
            m11973e();
        }
    }

    private void m11972d() {
        this.f10073e.set(this.f10070b);
        this.f10073e.postConcat(this.f10071c);
        this.f10072d.reset();
        this.f10085q = 1.0f;
        setImageMatrix(this.f10073e);
        this.f10076h.set(this.f10075g);
    }

    private void m11973e() {
        if (this.f10078j != null) {
            m11975a(this.f10076h.width() > this.f10076h.height() ? 1.0f / this.f10078j.height() : 1.0f / this.f10078j.width(), this.f10077i.centerX(), this.f10077i.centerY());
            m11974a((this.f10076h.width() / 2.0f) - (this.f10078j.centerX() * this.f10076h.width()), (this.f10076h.height() / 2.0f) - (this.f10078j.centerY() * this.f10076h.height()));
        }
    }

    public int getRotatedDrawableWidth() {
        return this.f10069a.isRatioChanged() ? getDrawable().getIntrinsicHeight() : getDrawable().getIntrinsicWidth();
    }

    public int getRotatedDrawableHeight() {
        return this.f10069a.isRatioChanged() ? getDrawable().getIntrinsicWidth() : getDrawable().getIntrinsicHeight();
    }

    public final void m11974a(float f, float f2) {
        if (this.f10076h.left + f > this.f10077i.left) {
            f = this.f10077i.left - this.f10076h.left;
        } else if (this.f10076h.right + f < this.f10077i.right) {
            f = this.f10077i.right - this.f10076h.right;
        }
        if (this.f10076h.top + f2 > this.f10077i.top) {
            f2 = this.f10077i.top - this.f10076h.top;
        } else if (this.f10076h.bottom + f2 < this.f10077i.bottom) {
            f2 = this.f10077i.bottom - this.f10076h.bottom;
        }
        if (Math.abs(f) < 1.0f) {
            f = 0.0f;
        }
        if (Math.abs(f2) < 1.0f) {
            f2 = 0.0f;
        }
        if (f != 0.0f || f2 != 0.0f) {
            this.f10072d.postTranslate(f, f2);
            this.f10073e.postTranslate(f, f2);
            this.f10076h.offset(f, f2);
            setImageMatrix(this.f10073e);
        }
    }

    public final void m11975a(float f, float f2, float f3) {
        if (this.f10085q * f > this.f10084p) {
            f = this.f10084p / this.f10085q;
        } else if (this.f10085q * f < 1.0f) {
            f = 1.0f / this.f10085q;
        }
        this.f10085q *= f;
        this.f10072d.postScale(f, f, f2, f3);
        this.f10073e.postScale(f, f, f2, f3);
        this.f10072d.mapRect(this.f10076h, this.f10075g);
        if (this.f10076h.contains(this.f10077i)) {
            setImageMatrix(this.f10073e);
        } else {
            m11974a(0.0f, 0.0f);
        }
    }

    public RectF getImageRect() {
        return this.f10076h;
    }
}
