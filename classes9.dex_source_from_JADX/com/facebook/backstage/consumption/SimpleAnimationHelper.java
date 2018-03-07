package com.facebook.backstage.consumption;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;

/* compiled from: rtc_one_on_one_over_multiway */
public class SimpleAnimationHelper {
    public final AnimationListener f4644a;
    public final View f4645b;
    private final OnFinishListener f4646c = new C04591(this);
    public final OnFinishListener f4647d = new C04602(this);
    public AnimationState f4648e;

    /* compiled from: rtc_one_on_one_over_multiway */
    class C04591 implements OnFinishListener {
        final /* synthetic */ SimpleAnimationHelper f4640a;

        C04591(SimpleAnimationHelper simpleAnimationHelper) {
            this.f4640a = simpleAnimationHelper;
        }

        public final void mo142a() {
            this.f4640a.f4648e = AnimationState.HIDDEN;
            this.f4640a.f4645b.setX(0.0f);
            if (this.f4640a.f4644a != null) {
                this.f4640a.f4644a.mo168a();
            }
        }
    }

    /* compiled from: rtc_one_on_one_over_multiway */
    class C04602 implements OnFinishListener {
        final /* synthetic */ SimpleAnimationHelper f4641a;

        C04602(SimpleAnimationHelper simpleAnimationHelper) {
            this.f4641a = simpleAnimationHelper;
        }

        public final void mo142a() {
            this.f4641a.f4648e = AnimationState.SHOWN;
            if (this.f4641a.f4644a != null) {
                this.f4641a.f4644a.mo169b();
            }
        }
    }

    /* compiled from: rtc_one_on_one_over_multiway */
    public class C04613 implements OnGlobalLayoutListener {
        final /* synthetic */ SimpleAnimationHelper f4642a;

        public C04613(SimpleAnimationHelper simpleAnimationHelper) {
            this.f4642a = simpleAnimationHelper;
        }

        public void onGlobalLayout() {
            ViewAnimator b = ViewAnimator.m5752a(this.f4642a.f4645b).m5756b((float) this.f4642a.f4645b.getWidth(), 0.0f);
            b.f5549z = 0;
            b = b;
            b.f5528e = this.f4642a.f4647d;
            b.m5759d();
            this.f4642a.f4645b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: rtc_one_on_one_over_multiway */
    public interface AnimationListener {
        void mo168a();

        void mo169b();
    }

    /* compiled from: rtc_one_on_one_over_multiway */
    public enum AnimationState {
        SHOWING,
        HIDING,
        SHOWN,
        HIDDEN
    }

    /* compiled from: rtc_one_on_one_over_multiway */
    public enum AnimationType {
        ALPHA,
        SLIDE_FROM_RIGHT
    }

    public SimpleAnimationHelper(View view, AnimationListener animationListener) {
        this.f4645b = view;
        this.f4644a = animationListener;
    }

    public final void m4560a(AnimationType animationType) {
        this.f4648e = AnimationState.SHOWING;
        ViewAnimator d;
        switch (animationType) {
            case ALPHA:
                d = ViewAnimator.m5752a(this.f4645b).m5760d(0.0f, 1.0f);
                d.f5549z = 0;
                d = d;
                d.f5528e = this.f4647d;
                d.m5759d();
                return;
            case SLIDE_FROM_RIGHT:
                if (this.f4645b.getWidth() != 0) {
                    d = ViewAnimator.m5752a(this.f4645b).m5756b((float) this.f4645b.getWidth(), 0.0f);
                    d.f5549z = 0;
                    d = d;
                    d.f5528e = this.f4647d;
                    d.m5759d();
                    return;
                }
                this.f4645b.getViewTreeObserver().addOnGlobalLayoutListener(new C04613(this));
                return;
            default:
                return;
        }
    }

    public final boolean m4561a() {
        return this.f4648e == AnimationState.SHOWING || this.f4648e == AnimationState.SHOWN;
    }

    public final void m4562b(AnimationType animationType) {
        if (this.f4648e != AnimationState.HIDDEN) {
            ViewAnimator.m5752a(this.f4645b).m5761e();
            if (this.f4648e == AnimationState.HIDING) {
                this.f4645b.setVisibility(8);
                this.f4645b.setX(0.0f);
                this.f4648e = AnimationState.HIDDEN;
                this.f4646c.mo142a();
            }
            this.f4648e = AnimationState.HIDING;
            m4559d(animationType);
        }
    }

    private void m4559d(AnimationType animationType) {
        if (this.f4645b.getWidth() == 0) {
            animationType = AnimationType.ALPHA;
        }
        ViewAnimator d;
        switch (animationType) {
            case ALPHA:
                d = ViewAnimator.m5752a(this.f4645b).m5760d(1.0f, 0.0f);
                d.f5524A = 8;
                d = d;
                d.f5528e = this.f4646c;
                d.m5759d();
                return;
            case SLIDE_FROM_RIGHT:
                d = ViewAnimator.m5752a(this.f4645b).m5756b(0.0f, (float) this.f4645b.getWidth());
                d.f5524A = 8;
                d = d;
                d.f5528e = this.f4646c;
                d.m5759d();
                return;
            default:
                return;
        }
    }
}
