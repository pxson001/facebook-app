package com.facebook.widget.animatablelistview.custom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.widget.listview.BetterListView;

/* compiled from: android.intent.action.SCREEN_ON */
public class InterceptAnimation {
    public final InterRowAnimation f20524a;
    public final ValueAnimator f20525b = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    private final int f20526c;
    private Point f20527d;
    public boolean f20528e;

    /* compiled from: android.intent.action.SCREEN_ON */
    class MyAnimatorListener extends BaseAnimatorListener {
        final /* synthetic */ InterceptAnimation f20522a;

        public MyAnimatorListener(InterceptAnimation interceptAnimation) {
            this.f20522a = interceptAnimation;
        }

        public void onAnimationEnd(Animator animator) {
            InterceptAnimation.m20073e(this.f20522a);
        }

        public void onAnimationCancel(Animator animator) {
            InterceptAnimation.m20073e(this.f20522a);
        }
    }

    /* compiled from: android.intent.action.SCREEN_ON */
    class MyAnimatorUpdateListener implements AnimatorUpdateListener {
        final /* synthetic */ InterceptAnimation f20523a;

        public MyAnimatorUpdateListener(InterceptAnimation interceptAnimation) {
            this.f20523a = interceptAnimation;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f20523a.f20524a.f20520p) {
                this.f20523a.f20525b.cancel();
            } else {
                InterceptAnimation.m20071a(this.f20523a, ((Float) this.f20523a.f20525b.getAnimatedValue()).floatValue());
            }
        }
    }

    private InterceptAnimation(InterRowAnimation interRowAnimation, int i) {
        this.f20524a = interRowAnimation;
        this.f20526c = i;
        this.f20525b.setDuration(this.f20524a.f20512h);
        this.f20525b.addUpdateListener(new MyAnimatorUpdateListener(this));
        this.f20525b.addListener(new MyAnimatorListener(this));
    }

    public static InterceptAnimation m20070a(Context context, BetterListView betterListView, FrameLayout frameLayout, View view, int i, int i2, int i3, long j, int i4) {
        return new InterceptAnimation(new InterRowAnimation(context, betterListView, frameLayout, view, i, i2, i3, j), i4);
    }

    public static void m20071a(InterceptAnimation interceptAnimation, float f) {
        interceptAnimation.m20072d();
        if (interceptAnimation.f20527d != null && interceptAnimation.f20528e) {
            View b = interceptAnimation.f20524a.m20067b();
            if (b != null) {
                b.setVisibility(4);
            }
            b = interceptAnimation.f20524a.m20069c();
            if (b != null) {
                b.setVisibility(4);
            }
            int i = (int) (((float) interceptAnimation.f20526c) * f);
            Point a = interceptAnimation.f20524a.m20066a(interceptAnimation.f20524a.m20069c());
            if (a == null) {
                return;
            }
            if (interceptAnimation.f20524a.f20510f > interceptAnimation.f20524a.f20509e) {
                i += interceptAnimation.f20527d.y;
                if (a.y < i) {
                    interceptAnimation.f20524a.m20068b((float) a.y);
                    return;
                } else {
                    interceptAnimation.f20524a.m20068b((float) i);
                    return;
                }
            }
            i = interceptAnimation.f20527d.y - i;
            if (a.y > i) {
                interceptAnimation.f20524a.m20068b((float) a.y);
            } else {
                interceptAnimation.f20524a.m20068b((float) i);
            }
        }
    }

    private void m20072d() {
        if (this.f20527d == null && this.f20528e) {
            this.f20527d = this.f20524a.m20066a(this.f20524a.m20067b());
            if (this.f20527d != null) {
                float f = (float) this.f20527d.x;
                this.f20524a.f20508d.setTranslationX(f);
                this.f20524a.m20068b((float) this.f20527d.y);
                this.f20524a.f20508d.setVisibility(0);
            }
        }
    }

    public static void m20073e(InterceptAnimation interceptAnimation) {
        InterRowAnimation interRowAnimation = interceptAnimation.f20524a;
        if (interRowAnimation.f20515k != null) {
            interRowAnimation.f20515k.setVisibility(interRowAnimation.f20518n);
        }
        interRowAnimation = interceptAnimation.f20524a;
        if (interRowAnimation.f20516l != null) {
            interRowAnimation.f20516l.setVisibility(interRowAnimation.f20517m);
        }
        interRowAnimation = interceptAnimation.f20524a;
        if (!interRowAnimation.f20521q) {
            interRowAnimation.f20521q = true;
            interRowAnimation.f20507c.removeView(interRowAnimation.f20513i);
            interRowAnimation.f20506b.b(interRowAnimation.f20514j);
        }
    }

    public final void m20074b() {
        this.f20528e = true;
        m20072d();
    }
}
