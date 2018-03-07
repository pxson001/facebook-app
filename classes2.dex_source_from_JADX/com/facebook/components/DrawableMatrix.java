package com.facebook.components;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView.ScaleType;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: friends_locations */
public final class DrawableMatrix extends Matrix {
    public boolean f23010a;

    /* compiled from: friends_locations */
    /* synthetic */ class C09291 {
        static final /* synthetic */ int[] f23011a = new int[ScaleType.values().length];

        static {
            try {
                f23011a[ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23011a[ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23011a[ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23011a[ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private DrawableMatrix() {
    }

    public static DrawableMatrix m31140a(Drawable drawable, ScaleType scaleType, int i, int i2) {
        boolean z = true;
        float f = 0.0f;
        if (scaleType == null) {
            scaleType = ScaleType.FIT_CENTER;
        }
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0 || ScaleType.FIT_XY == scaleType || ScaleType.MATRIX == scaleType) {
            return null;
        }
        if (i == intrinsicWidth && i2 == intrinsicHeight) {
            return null;
        }
        DrawableMatrix drawableMatrix = new DrawableMatrix();
        if (ScaleType.CENTER == scaleType) {
            drawableMatrix.setTranslate((float) FastMath.m31104a(((float) (i - intrinsicWidth)) * 0.5f), (float) FastMath.m31104a(((float) (i2 - intrinsicHeight)) * 0.5f));
            if (intrinsicWidth <= i && intrinsicHeight <= i2) {
                z = false;
            }
            drawableMatrix.f23010a = z;
        } else if (ScaleType.CENTER_CROP == scaleType) {
            float f2;
            if (intrinsicWidth * i2 > i * intrinsicHeight) {
                r1 = ((float) i2) / ((float) intrinsicHeight);
                f2 = (((float) i) - (((float) intrinsicWidth) * r1)) * 0.5f;
            } else {
                r1 = ((float) i) / ((float) intrinsicWidth);
                f2 = 0.0f;
                f = (((float) i2) - (((float) intrinsicHeight) * r1)) * 0.5f;
            }
            drawableMatrix.setScale(r1, r1);
            drawableMatrix.postTranslate((float) FastMath.m31104a(f2), (float) FastMath.m31104a(f));
            drawableMatrix.f23010a = true;
        } else if (ScaleType.CENTER_INSIDE == scaleType) {
            float min;
            if (intrinsicWidth > i || intrinsicHeight > i2) {
                min = Math.min(((float) i) / ((float) intrinsicWidth), ((float) i2) / ((float) intrinsicHeight));
            } else {
                min = 1.0f;
            }
            r1 = (float) FastMath.m31104a((((float) i) - (((float) intrinsicWidth) * min)) * 0.5f);
            f = (float) FastMath.m31104a((((float) i2) - (((float) intrinsicHeight) * min)) * 0.5f);
            drawableMatrix.setScale(min, min);
            drawableMatrix.postTranslate(r1, f);
        } else {
            RectF h = ComponentsPools.m30530h();
            RectF h2 = ComponentsPools.m30530h();
            try {
                h.set(0.0f, 0.0f, (float) intrinsicWidth, (float) intrinsicHeight);
                h2.set(0.0f, 0.0f, (float) i, (float) i2);
                drawableMatrix.setRectToRect(h, h2, m31139a(scaleType));
            } finally {
                ComponentsPools.m30521a(h);
                ComponentsPools.m30521a(h2);
            }
        }
        return drawableMatrix;
    }

    private static ScaleToFit m31139a(ScaleType scaleType) {
        switch (C09291.f23011a[scaleType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ScaleToFit.FILL;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ScaleToFit.START;
            case 3:
                return ScaleToFit.CENTER;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return ScaleToFit.END;
            default:
                throw new IllegalArgumentException("Only FIT_... values allowed");
        }
    }
}
