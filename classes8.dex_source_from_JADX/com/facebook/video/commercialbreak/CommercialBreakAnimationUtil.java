package com.facebook.video.commercialbreak;

import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import com.facebook.ui.animations.SpringAnimator;

/* compiled from: logging_token */
public class CommercialBreakAnimationUtil {
    public static final Interpolator f9709a = PathInterpolatorCompat.a(0.23f, 1.0f, 0.32f, 1.0f);

    public static SpringAnimator m11437a(SpringAnimator springAnimator) {
        springAnimator.c = 0.2f;
        SpringAnimator springAnimator2 = springAnimator;
        springAnimator2.d = 0.8f;
        springAnimator2 = springAnimator2;
        springAnimator2.g = 0.0f;
        return springAnimator2;
    }
}
