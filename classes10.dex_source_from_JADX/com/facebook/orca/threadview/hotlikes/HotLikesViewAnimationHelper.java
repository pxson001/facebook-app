package com.facebook.orca.threadview.hotlikes;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.messaging.threadview.hotlikes.HotLikesSpringConfig;
import com.facebook.widget.ViewTransform;

/* compiled from: mark_spam */
public class HotLikesViewAnimationHelper {
    private final int f8211a = this.f8213c.getDimensionPixelSize(2131428039);
    private final int f8212b = this.f8213c.getDimensionPixelSize(2131428039);
    private final Resources f8213c;
    public final View f8214d;
    public final ViewTransform f8215e = new ViewTransform(this.f8214d);

    public HotLikesViewAnimationHelper(Resources resources, View view) {
        this.f8213c = resources;
        this.f8214d = view;
    }

    public final void m8101a(HotLikesAnimationState hotLikesAnimationState) {
        float floatValue;
        float c = hotLikesAnimationState.m8100c();
        if (hotLikesAnimationState.f8208l) {
            c = HotLikesSpringConfig.convertSizeEndValueForHotEmojilikes(c);
        }
        int i = (int) (((float) this.f8212b) * c);
        int i2 = (int) (c * ((float) this.f8211a));
        LayoutParams layoutParams = this.f8214d.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        if (hotLikesAnimationState.f8207k) {
            floatValue = ((Float) hotLikesAnimationState.f8205i.getAnimatedValue()).floatValue();
            double d = (double) ((200.0f * (1.0f - floatValue)) + (70.0f * floatValue));
            floatValue = (float) (((double) (floatValue * 10.0f)) * (((((double) hotLikesAnimationState.f8200d.now()) % d) / d) - 0.5d));
        } else {
            floatValue = ((float) hotLikesAnimationState.f8204h.d()) * 100.0f;
        }
        float f = floatValue;
        this.f8215e.setPivotX(((float) i) * 0.5f);
        this.f8215e.setPivotY(((float) i2) * 0.5f);
        this.f8215e.setRotation(f);
        this.f8214d.setAlpha(hotLikesAnimationState.f8206j);
        this.f8214d.requestLayout();
    }
}
