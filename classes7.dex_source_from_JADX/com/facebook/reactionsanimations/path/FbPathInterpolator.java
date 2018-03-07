package com.facebook.reactionsanimations.path;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: fetch_event_data */
public class FbPathInterpolator implements Interpolator {
    private final float[] f14403a;
    private final float[] f14404b;

    public FbPathInterpolator(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.03f)) + 1;
        this.f14403a = new float[i];
        this.f14404b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, null);
            this.f14403a[i2] = fArr[0];
            this.f14404b[i2] = fArr[1];
        }
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f14403a.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f14403a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f14403a[length] - this.f14403a[i];
        if (f2 == 0.0f) {
            return this.f14404b[i];
        }
        float f3 = (f - this.f14403a[i]) / f2;
        f2 = this.f14404b[i];
        return (f3 * (this.f14404b[length] - f2)) + f2;
    }
}
