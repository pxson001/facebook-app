package com.facebook.widget.images;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: reply_to_mention_submit */
public class RotateBitmap {
    public static final Class<?> f5834a = RotateBitmap.class;
    public Bitmap f5835b;
    public int f5836c;

    public RotateBitmap(Bitmap bitmap) {
        this.f5835b = bitmap;
        this.f5836c = 0;
    }

    public RotateBitmap(Bitmap bitmap, int i) {
        this.f5835b = bitmap;
        this.f5836c = i % 360;
    }

    public final Matrix m8391c() {
        Matrix matrix = new Matrix();
        if (this.f5836c != 0) {
            matrix.preTranslate((float) (-(this.f5835b.getWidth() / 2)), (float) (-(this.f5835b.getHeight() / 2)));
            matrix.postRotate((float) this.f5836c);
            matrix.postTranslate((float) (m8393e() / 2), (float) (m8392d() / 2));
        }
        return matrix;
    }

    private boolean m8390f() {
        return (this.f5836c / 90) % 2 != 0;
    }

    public final int m8392d() {
        if (m8390f()) {
            return this.f5835b.getWidth();
        }
        return this.f5835b.getHeight();
    }

    public final int m8393e() {
        if (m8390f()) {
            return this.f5835b.getHeight();
        }
        return this.f5835b.getWidth();
    }
}
