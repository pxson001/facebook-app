package android.support.v4.view.animation;

import android.view.animation.Interpolator;

/* compiled from: valueCount <= 0 */
abstract class LookupTableInterpolator implements Interpolator {
    private final float[] f386a;
    private final float f387b = (1.0f / ((float) (this.f386a.length - 1)));

    public LookupTableInterpolator(float[] fArr) {
        this.f386a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f386a.length - 1)) * f), this.f386a.length - 2);
        float f2 = (f - (((float) min) * this.f387b)) / this.f387b;
        return ((this.f386a[min + 1] - this.f386a[min]) * f2) + this.f386a[min];
    }
}
