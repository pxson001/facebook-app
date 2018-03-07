package com.facebook.orca.threadview.hotlikes;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.facebook.common.time.MonotonicClock;
import com.facebook.orca.threadview.hotlikes.HotLikesAnimationManager.C12261;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.inject.Provider;

/* compiled from: mark_unread */
public class HotLikesAnimationState {
    private static final SpringConfig f8197a = SpringConfig.a(50.0d, 3.5d);
    private static final SpringConfig f8198b = SpringConfig.a(10.0d, 4.0d);
    public final String f8199c;
    public final MonotonicClock f8200d;
    private final SpringSystem f8201e;
    private final Provider<Boolean> f8202f;
    public final Spring f8203g;
    public final Spring f8204h;
    public final ValueAnimator f8205i;
    public float f8206j;
    public boolean f8207k;
    public boolean f8208l;
    public C12261 f8209m;
    public HotLikesViewAnimationHelper f8210n;

    /* compiled from: mark_unread */
    class C12281 extends SimpleSpringListener {
        final /* synthetic */ HotLikesAnimationState f8194a;

        C12281(HotLikesAnimationState hotLikesAnimationState) {
            this.f8194a = hotLikesAnimationState;
        }

        public final void m8097a(Spring spring) {
            HotLikesAnimationState.m8099f(this.f8194a);
        }

        public final void m8098b(Spring spring) {
            if (this.f8194a.f8209m != null) {
                Object obj;
                HotLikesAnimationState hotLikesAnimationState = this.f8194a;
                if (hotLikesAnimationState.f8203g.k() && hotLikesAnimationState.f8204h.k()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    C12261 c12261 = this.f8194a.f8209m;
                    HotLikesAnimationManager.m8090b(c12261.f8179a, this.f8194a.f8199c);
                }
            }
        }
    }

    /* compiled from: mark_unread */
    class C12292 implements AnimatorListener {
        final /* synthetic */ HotLikesAnimationState f8195a;

        C12292(HotLikesAnimationState hotLikesAnimationState) {
            this.f8195a = hotLikesAnimationState;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f8195a.f8209m != null) {
                C12261 c12261 = this.f8195a.f8209m;
                String str = this.f8195a.f8199c;
                if (c12261.f8179a.f8192l != null) {
                    c12261.f8179a.f8181a.e(0.25f);
                }
                HotLikesAnimationManager.m8092c(c12261.f8179a, str);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: mark_unread */
    class C12303 implements AnimatorUpdateListener {
        final /* synthetic */ HotLikesAnimationState f8196a;

        C12303(HotLikesAnimationState hotLikesAnimationState) {
            this.f8196a = hotLikesAnimationState;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HotLikesAnimationState.m8099f(this.f8196a);
        }
    }

    public HotLikesAnimationState(String str, MonotonicClock monotonicClock, SpringSystem springSystem, Provider<Boolean> provider) {
        this.f8199c = str;
        this.f8200d = monotonicClock;
        this.f8201e = springSystem;
        this.f8202f = provider;
        this.f8206j = ((Boolean) this.f8202f.get()).booleanValue() ? 1.0f : 0.5f;
        C12281 c12281 = new C12281(this);
        this.f8203g = this.f8201e.a().a(f8197a).a(c12281);
        this.f8204h = this.f8201e.a().a(f8198b).a(c12281);
        this.f8205i = new ValueAnimator();
        this.f8205i.setDuration(3000);
        this.f8205i.setFloatValues(new float[]{0.24f, 0.8f, 0.8f});
        this.f8205i.addListener(new C12292(this));
        this.f8205i.addUpdateListener(new C12303(this));
    }

    public static void m8099f(HotLikesAnimationState hotLikesAnimationState) {
        if (hotLikesAnimationState.f8209m != null) {
            hotLikesAnimationState.f8209m.f8179a.f8189i.mo351b();
        }
        if (hotLikesAnimationState.f8210n != null) {
            hotLikesAnimationState.f8210n.m8101a(hotLikesAnimationState);
        }
    }

    public final float m8100c() {
        return this.f8207k ? ((Float) this.f8205i.getAnimatedValue()).floatValue() : (float) this.f8203g.d();
    }
}
