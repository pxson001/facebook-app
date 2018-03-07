package com.facebook.search.titlebar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: video_frame_height */
class TitleBarAnimators$1 implements AnimatorUpdateListener {
    final /* synthetic */ View f411a;
    final /* synthetic */ TitleBarAnimators$AnimationAction f412b;
    final /* synthetic */ float f413c;
    final /* synthetic */ Integer f414d;
    final /* synthetic */ TitleBarAnimators f415e;

    TitleBarAnimators$1(TitleBarAnimators titleBarAnimators, View view, TitleBarAnimators$AnimationAction titleBarAnimators$AnimationAction, float f, Integer num) {
        this.f415e = titleBarAnimators;
        this.f411a = view;
        this.f412b = titleBarAnimators$AnimationAction;
        this.f413c = f;
        this.f414d = num;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f411a.getLayoutParams();
        switch (TitleBarAnimators$4.f421a[this.f412b.ordinal()]) {
            case 1:
                f = this.f413c * (1.0f - floatValue);
                floatValue = (floatValue * ((float) this.f414d.intValue())) * -1.0f;
                break;
            case 2:
                f = this.f413c * floatValue;
                floatValue = ((1.0f - floatValue) * ((float) this.f414d.intValue())) * -1.0f;
                break;
            default:
                floatValue = this.f415e.f.a() ? (float) marginLayoutParams.rightMargin : (float) marginLayoutParams.leftMargin;
                if (!this.f415e.f.a()) {
                    f = floatValue;
                    floatValue = (float) marginLayoutParams.rightMargin;
                    break;
                }
                f = floatValue;
                floatValue = (float) marginLayoutParams.leftMargin;
                break;
        }
        if (this.f415e.f.a()) {
            marginLayoutParams.setMargins((int) floatValue, 0, (int) f, 0);
        } else {
            marginLayoutParams.setMargins((int) f, 0, (int) floatValue, 0);
        }
        this.f411a.setLayoutParams(marginLayoutParams);
        this.f411a.requestLayout();
    }
}
