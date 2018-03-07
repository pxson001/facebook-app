package com.facebook.imagepipeline.animated.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.animation.LinearInterpolator;
import com.facebook.common.time.MonotonicClock;
import java.util.concurrent.ScheduledExecutorService;

@TargetApi(11)
/* compiled from: TREEHOUSE_IOS_GROUPS_TAB */
public class AnimatedDrawable extends AbstractAnimatedDrawable implements AnimatableDrawable {

    /* compiled from: TREEHOUSE_IOS_GROUPS_TAB */
    class C12961 implements AnimatorUpdateListener {
        final /* synthetic */ AnimatedDrawable f13597a;

        C12961(AnimatedDrawable animatedDrawable) {
            this.f13597a = animatedDrawable;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f13597a.setLevel(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public AnimatedDrawable(ScheduledExecutorService scheduledExecutorService, AnimatedDrawableCachingBackend animatedDrawableCachingBackend, AnimatedDrawableDiagnostics animatedDrawableDiagnostics, MonotonicClock monotonicClock) {
        super(scheduledExecutorService, animatedDrawableCachingBackend, animatedDrawableDiagnostics, monotonicClock);
    }

    public final ValueAnimator mo1238a(int i) {
        int d = this.f13582l.mo1246d();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, this.f13575e});
        valueAnimator.setDuration((long) this.f13575e);
        if (d == 0) {
            d = -1;
        }
        valueAnimator.setRepeatCount(d);
        valueAnimator.setRepeatMode(1);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(mo1237a());
        ValueAnimator valueAnimator2 = valueAnimator;
        valueAnimator2.setRepeatCount(Math.max(i / this.f13582l.mo1242b(), 1));
        return valueAnimator2;
    }

    public final AnimatorUpdateListener mo1237a() {
        return new C12961(this);
    }
}
