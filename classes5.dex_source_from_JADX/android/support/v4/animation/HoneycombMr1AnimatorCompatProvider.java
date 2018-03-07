package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: work_admin_panel */
class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
    private TimeInterpolator f17a;

    /* compiled from: work_admin_panel */
    class AnimatorListenerCompatWrapper implements AnimatorListener {
        final AnimatorListenerCompat f12a;
        final ValueAnimatorCompat f13b;

        public AnimatorListenerCompatWrapper(AnimatorListenerCompat animatorListenerCompat, ValueAnimatorCompat valueAnimatorCompat) {
            this.f12a = animatorListenerCompat;
            this.f13b = valueAnimatorCompat;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f12a.mo455a(this.f13b);
        }

        public void onAnimationCancel(Animator animator) {
            this.f12a.mo454a();
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: work_admin_panel */
    class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {
        final Animator f16a;

        public HoneycombValueAnimatorCompat(Animator animator) {
            this.f16a = animator;
        }

        public final void mo5a(View view) {
            this.f16a.setTarget(view);
        }

        public final void mo3a(AnimatorListenerCompat animatorListenerCompat) {
            this.f16a.addListener(new AnimatorListenerCompatWrapper(animatorListenerCompat, this));
        }

        public final void mo2a(long j) {
            this.f16a.setDuration(j);
        }

        public final void mo1a() {
            this.f16a.start();
        }

        public final void mo6b() {
            this.f16a.cancel();
        }

        public final void mo4a(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            if (this.f16a instanceof ValueAnimator) {
                ((ValueAnimator) this.f16a).addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ HoneycombValueAnimatorCompat f15b;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        animatorUpdateListenerCompat.mo457a(this.f15b);
                    }
                });
            }
        }

        public final float mo7c() {
            return ((ValueAnimator) this.f16a).getAnimatedFraction();
        }
    }

    HoneycombMr1AnimatorCompatProvider() {
    }

    public final ValueAnimatorCompat mo8a() {
        return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public final void mo9a(View view) {
        if (this.f17a == null) {
            this.f17a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f17a);
    }
}
