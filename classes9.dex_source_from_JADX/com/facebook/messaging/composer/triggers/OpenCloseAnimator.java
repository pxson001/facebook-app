package com.facebook.messaging.composer.triggers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.widget.ViewStubHolder;

/* compiled from: messenger_inbox_unit_should_show_see_more */
public class OpenCloseAnimator {
    public final ViewStubHolder<? extends AnimatedView> f9922a;
    public final int f9923b;
    public boolean f9924c;
    public ValueAnimator f9925d;

    /* compiled from: messenger_inbox_unit_should_show_see_more */
    public interface AnimatedView {
        void mo403a();
    }

    OpenCloseAnimator(ViewStubHolder<? extends AnimatedView> viewStubHolder, int i) {
        this.f9922a = viewStubHolder;
        this.f9923b = i;
    }

    public final void m10474a(final boolean z) {
        if (z != this.f9924c) {
            final LayoutParams layoutParams = this.f9922a.a().getLayoutParams();
            if (this.f9925d != null) {
                this.f9925d.cancel();
                this.f9925d = null;
            }
            int i = layoutParams.height;
            int i2 = z ? this.f9923b : 0;
            this.f9925d = ValueAnimator.ofInt(new int[]{i, i2});
            this.f9925d.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ OpenCloseAnimator f9919b;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    this.f9919b.f9922a.a().requestLayout();
                }
            });
            this.f9925d.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ OpenCloseAnimator f9921b;

                public void onAnimationStart(Animator animator) {
                    if (z) {
                        this.f9921b.f9922a.f();
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!z) {
                        this.f9921b.f9922a.e();
                        ((AnimatedView) this.f9921b.f9922a.a()).mo403a();
                    }
                    this.f9921b.f9925d = null;
                }
            });
            this.f9925d.setDuration(300);
            this.f9925d.start();
            this.f9924c = z;
        }
    }
}
