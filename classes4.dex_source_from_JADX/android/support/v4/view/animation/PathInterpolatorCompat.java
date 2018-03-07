package android.support.v4.view.animation;

import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: default */
public class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator m14975a(float f, float f2, float f3, float f4) {
        if (VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f, f2, f3, f4);
        }
        return new PathInterpolatorDonut(f, f2, f3, f4);
    }
}
