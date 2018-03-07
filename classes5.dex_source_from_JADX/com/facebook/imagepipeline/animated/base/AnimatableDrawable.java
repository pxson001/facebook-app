package com.facebook.imagepipeline.animated.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.graphics.drawable.Animatable;

@TargetApi(11)
/* compiled from: TREEHOUSE_IOS_GROUPS_TAB_MENU */
public interface AnimatableDrawable extends Animatable {
    AnimatorUpdateListener mo1237a();

    ValueAnimator mo1238a(int i);
}
