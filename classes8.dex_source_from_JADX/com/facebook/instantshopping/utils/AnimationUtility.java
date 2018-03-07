package com.facebook.instantshopping.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* compiled from: unsupported_association_dialog */
public class AnimationUtility {
    public static void m1339a(Context context, View view, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
        if (loadAnimation != null) {
            loadAnimation.reset();
            if (view != null) {
                view.clearAnimation();
                loadAnimation.setFillAfter(true);
                view.startAnimation(loadAnimation);
            }
        }
    }
}
