package com.facebook.ui.compat.opacity;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.facebook.infer.annotation.Assertions;

/* compiled from: community_category */
public class ImageViewOpacity {
    @TargetApi(16)
    public static void m10314a(ImageView imageView, int i) {
        boolean z = i >= 0 && i <= 255;
        Assertions.a(z);
        if (VERSION.SDK_INT >= 16) {
            imageView.setImageAlpha(i);
            return;
        }
        float f = ((float) i) / 255.0f;
        boolean z2 = f >= 0.0f && f <= 1.0f;
        Assertions.a(z2);
        if (VERSION.SDK_INT >= 11) {
            imageView.setAlpha(f);
        } else {
            Animation alphaAnimation = new AlphaAnimation(f, f);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            imageView.startAnimation(alphaAnimation);
        }
    }
}
