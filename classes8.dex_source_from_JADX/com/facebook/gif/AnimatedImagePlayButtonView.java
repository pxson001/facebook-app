package com.facebook.gif;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.inject.FbInjector;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: {surface} */
public class AnimatedImagePlayButtonView extends CustomFrameLayout {
    private State f16a;
    public State f17b;
    public ImageView f18c;
    public ImageView f19d;
    public ImageView f20e;
    private Animator f21f;
    private Animator f22g;
    public AnimationUtil f23h;
    private Clock f24i;
    private long f25j;
    private DialtoneController f26k;
    private DialtoneStateChangedListener f27l;

    /* compiled from: {surface} */
    class C00001 extends BaseAnimatorListener {
        final /* synthetic */ AnimatedImagePlayButtonView f12a;

        C00001(AnimatedImagePlayButtonView animatedImagePlayButtonView) {
            this.f12a = animatedImagePlayButtonView;
        }

        public void onAnimationStart(Animator animator) {
            this.f12a.f23h.a(this.f12a.f18c);
        }

        public void onAnimationEnd(Animator animator) {
            this.f12a.f23h.b(this.f12a.f18c);
        }

        public void onAnimationCancel(Animator animator) {
            this.f12a.f23h.b(this.f12a.f18c);
        }
    }

    /* compiled from: {surface} */
    class C00012 implements DialtoneStateChangedListener {
        final /* synthetic */ AnimatedImagePlayButtonView f13a;

        C00012(AnimatedImagePlayButtonView animatedImagePlayButtonView) {
            this.f13a = animatedImagePlayButtonView;
        }

        public final void iw_() {
        }

        public final void b_(boolean z) {
            this.f13a.setState(this.f13a.f17b);
        }
    }

    /* compiled from: {surface} */
    class C00023 extends BaseAnimatorListener {
        final /* synthetic */ AnimatedImagePlayButtonView f14a;

        C00023(AnimatedImagePlayButtonView animatedImagePlayButtonView) {
            this.f14a = animatedImagePlayButtonView;
        }

        public void onAnimationStart(Animator animator) {
            this.f14a.f23h.a(this.f14a.f18c);
            this.f14a.f23h.a(this.f14a.f20e);
            this.f14a.f23h.a(this.f14a.f19d);
        }

        public void onAnimationEnd(Animator animator) {
            AnimatedImagePlayButtonView.m27g(this.f14a);
        }

        public void onAnimationCancel(Animator animator) {
            AnimatedImagePlayButtonView.m27g(this.f14a);
        }
    }

    /* compiled from: {surface} */
    public enum State {
        READY_TO_PLAY,
        LOADING,
        DONE_LOADING,
        HIDDEN
    }

    private static <T extends View> void m17a(Class<T> cls, T t) {
        m18a((Object) t, t.getContext());
    }

    private static void m18a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AnimatedImagePlayButtonView) obj).m16a(AnimationUtil.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector));
    }

    public AnimatedImagePlayButtonView(Context context) {
        super(context);
        m14a();
    }

    public AnimatedImagePlayButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14a();
    }

    public AnimatedImagePlayButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14a();
    }

    @Inject
    private void m16a(AnimationUtil animationUtil, Clock clock, DialtoneController dialtoneController) {
        this.f23h = animationUtil;
        this.f24i = clock;
        this.f26k = dialtoneController;
    }

    private void m14a() {
        m17a(AnimatedImagePlayButtonView.class, (View) this);
        setContentView(2130904591);
        this.f20e = (ImageView) c(2131562540);
        this.f18c = (ImageView) c(2131562539);
        this.f19d = (ImageView) c(2131562538);
        this.f21f = m12a(0.0f);
        this.f21f.addListener(new C00001(this));
        if (this.f26k.j()) {
            m20b();
        }
    }

    private void m20b() {
        if (this.f27l == null) {
            this.f27l = new C00012(this);
        }
        this.f26k.a(this.f27l);
    }

    private void m24e() {
        this.f21f.cancel();
        if (this.f22g != null) {
            this.f22g.cancel();
            this.f22g = null;
        }
        m15a(this.f18c);
        m15a(this.f20e);
        m15a(this.f19d);
        this.f18c.setRotation(0.0f);
    }

    private static void m15a(View view) {
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    public void setState(State state) {
        int i = 8;
        if (state != this.f16a) {
            if (this.f26k.b()) {
                this.f17b = state;
                setVisibility(8);
                return;
            }
            this.f16a = state;
            if (state != State.HIDDEN) {
                i = 0;
            }
            setVisibility(i);
            switch (state) {
                case READY_TO_PLAY:
                    m24e();
                    return;
                case LOADING:
                    m24e();
                    this.f25j = this.f24i.a();
                    this.f21f.start();
                    return;
                case DONE_LOADING:
                    this.f21f.cancel();
                    this.f22g = m25f();
                    this.f22g.start();
                    return;
                default:
                    return;
            }
        }
    }

    private AnimatorSet m25f() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f19d, "alpha", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(this.f18c, "alpha", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(this.f20e, "alpha", new float[]{1.0f, 0.0f})});
        animatorSet.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f19d, "scaleX", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(this.f19d, "scaleY", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(this.f18c, "scaleX", new float[]{1.1f, 0.0f}), ObjectAnimator.ofFloat(this.f18c, "scaleY", new float[]{1.1f, 0.0f}), ObjectAnimator.ofFloat(this.f20e, "scaleX", new float[]{1.5f, 0.0f}), ObjectAnimator.ofFloat(this.f20e, "scaleY", new float[]{1.5f, 0.0f})});
        animatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(600);
        animatorSet3.playTogether(new Animator[]{animatorSet, animatorSet2, m28h()});
        animatorSet3.addListener(new C00023(this));
        return animatorSet3;
    }

    public static void m27g(AnimatedImagePlayButtonView animatedImagePlayButtonView) {
        animatedImagePlayButtonView.f23h.b(animatedImagePlayButtonView.f18c);
        animatedImagePlayButtonView.f23h.b(animatedImagePlayButtonView.f20e);
        animatedImagePlayButtonView.f23h.b(animatedImagePlayButtonView.f19d);
    }

    private Animator m28h() {
        return m12a(((((float) (this.f24i.a() - this.f25j)) / 2500.0f) * 360.0f) % 360.0f);
    }

    private Animator m12a(float f) {
        Animator ofFloat = ObjectAnimator.ofFloat(this.f18c, "rotation", new float[]{f, 360.0f + f});
        ofFloat.setDuration(2500);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }
}
