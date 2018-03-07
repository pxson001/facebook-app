package com.facebook.orca.threadview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.orca.threadview.GiftWrapAnimationManager.C10432;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: messenger_inbox2_android */
public class MessageStateAnimationManager {
    public final Map<String, ValueAnimator> f7225a = new HashMap();
    @Nullable
    public C10432 f7226b;

    public static MessageStateAnimationManager m6914a(InjectorLike injectorLike) {
        return new MessageStateAnimationManager();
    }

    public final void m6915a(final String str, float f, float f2, long j, Interpolator interpolator) {
        if (((ValueAnimator) this.f7225a.get(str)) == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f7225a.put(str, valueAnimator);
            valueAnimator.setDuration(j);
            valueAnimator.setInterpolator(interpolator);
            this.f7225a.put(str, valueAnimator);
            valueAnimator.setFloatValues(new float[]{f, f2});
            valueAnimator.addListener(new AnimatorListener(this) {
                final /* synthetic */ MessageStateAnimationManager f7220b;
                private boolean f7221c;

                public void onAnimationEnd(Animator animator) {
                    this.f7220b.f7225a.remove(str);
                    if (this.f7220b.f7226b != null && !this.f7221c) {
                        C10432 c10432 = this.f7220b.f7226b;
                        c10432.f6928a.m7410a(str);
                    }
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationCancel(Animator animator) {
                    this.f7220b.f7225a.remove(str);
                    this.f7221c = true;
                }

                public void onAnimationRepeat(Animator animator) {
                }
            });
            valueAnimator.start();
        }
    }

    public final void m6916a(String str, final RowMessageItem rowMessageItem, final AnimationLinker animationLinker) {
        ValueAnimator valueAnimator = (ValueAnimator) this.f7225a.get(str);
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            animationLinker.mo250a(rowMessageItem);
            return;
        }
        AnimatorUpdateListener c10842 = new AnimatorUpdateListener(this) {
            final /* synthetic */ MessageStateAnimationManager f7224c;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animationLinker.mo251a(rowMessageItem, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        };
        valueAnimator.removeAllUpdateListeners();
        valueAnimator.addUpdateListener(c10842);
        animationLinker.mo251a(rowMessageItem, ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
