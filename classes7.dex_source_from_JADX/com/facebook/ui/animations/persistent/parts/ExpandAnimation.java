package com.facebook.ui.animations.persistent.parts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import javax.annotation.Nullable;

/* compiled from: entry_with_keyboard_shown */
public class ExpandAnimation implements PersistentAnimation {
    public final View f15229a;
    private final int f15230b;
    private final int f15231c;
    @Nullable
    private final AnimatorListener f15232d;
    private final long f15233e;

    /* compiled from: entry_with_keyboard_shown */
    class C11411 implements AnimatorUpdateListener {
        final /* synthetic */ ExpandAnimation f15226a;

        C11411(ExpandAnimation expandAnimation) {
            this.f15226a = expandAnimation;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LayoutParams layoutParams = this.f15226a.f15229a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f15226a.f15229a.requestLayout();
            }
        }
    }

    public ExpandAnimation(View view, long j, int i, int i2, AnimatorListener animatorListener) {
        this.f15229a = view;
        this.f15230b = i;
        this.f15231c = i2;
        this.f15233e = j;
        this.f15232d = animatorListener;
    }

    public final Animator mo1179a(float f) {
        final int i = (int) (((float) this.f15230b) + (((float) (this.f15231c - this.f15230b)) * f));
        Animator ofInt = ValueAnimator.ofInt(new int[]{i, this.f15231c});
        ofInt.addUpdateListener(new C11411(this));
        if (this.f15232d != null) {
            ofInt.addListener(this.f15232d);
        }
        ofInt.addListener(new BaseAnimatorListener(this) {
            final /* synthetic */ ExpandAnimation f15228b;

            public void onAnimationStart(Animator animator) {
                if (this.f15228b.f15229a.getLayoutParams() != null) {
                    this.f15228b.f15229a.getLayoutParams().height = i;
                }
                this.f15228b.f15229a.requestLayout();
            }
        });
        ofInt.setDuration((long) ((1.0f - f) * ((float) this.f15233e)));
        return ofInt;
    }

    public final long mo1178a() {
        return this.f15233e;
    }
}
