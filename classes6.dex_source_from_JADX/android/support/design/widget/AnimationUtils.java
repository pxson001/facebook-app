package android.support.design.widget;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: qe_experience_type */
public class AnimationUtils {
    static final Interpolator f6854a = new LinearInterpolator();
    public static final Interpolator f6855b = new FastOutSlowInInterpolator();
    static final Interpolator f6856c = new FastOutLinearInInterpolator();
    static final Interpolator f6857d = new LinearOutSlowInInterpolator();
    static final Interpolator f6858e = new DecelerateInterpolator();

    AnimationUtils() {
    }

    static float m9978a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }
}
