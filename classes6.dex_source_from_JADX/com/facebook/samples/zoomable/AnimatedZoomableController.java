package com.facebook.samples.zoomable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.animation.DecelerateInterpolator;
import com.facebook.common.internal.Preconditions;
import com.facebook.samples.gestures.MultiPointerGestureDetector;
import com.facebook.samples.gestures.TransformGestureDetector;
import javax.annotation.Nullable;

/* compiled from: setImageSpecDrawable */
public class AnimatedZoomableController extends AbstractAnimatedZoomableController {
    private static final Class<?> f4828a = AnimatedZoomableController.class;
    private final ValueAnimator f4829b = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});

    /* compiled from: setImageSpecDrawable */
    class C02881 implements AnimatorUpdateListener {
        final /* synthetic */ AnimatedZoomableController f4825a;

        C02881(AnimatedZoomableController animatedZoomableController) {
            this.f4825a = animatedZoomableController;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AbstractAnimatedZoomableController abstractAnimatedZoomableController = this.f4825a;
            Matrix matrix = this.f4825a.f4824f;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                abstractAnimatedZoomableController.f4822d[i] = ((1.0f - floatValue) * abstractAnimatedZoomableController.f4820b[i]) + (abstractAnimatedZoomableController.f4821c[i] * floatValue);
            }
            matrix.setValues(abstractAnimatedZoomableController.f4822d);
            super.m7605b(this.f4825a.f4824f);
        }
    }

    public static AnimatedZoomableController m7625i() {
        return new AnimatedZoomableController(new TransformGestureDetector(new MultiPointerGestureDetector()));
    }

    @SuppressLint({"NewApi"})
    private AnimatedZoomableController(TransformGestureDetector transformGestureDetector) {
        super(transformGestureDetector);
        this.f4829b.setInterpolator(new DecelerateInterpolator());
    }

    @SuppressLint({"NewApi"})
    public final void mo349b(Matrix matrix, long j, @Nullable final Runnable runnable) {
        boolean z = false;
        Long.valueOf(j);
        mo350g();
        Preconditions.a(j > 0);
        if (!this.f4819a) {
            z = true;
        }
        Preconditions.b(z);
        this.f4819a = true;
        this.f4829b.setDuration(j);
        mo345p().getValues(this.f4820b);
        matrix.getValues(this.f4821c);
        this.f4829b.addUpdateListener(new C02881(this));
        this.f4829b.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ AnimatedZoomableController f4827b;

            public void onAnimationCancel(Animator animator) {
                this.f4827b.mo351h();
                m7623a();
            }

            public void onAnimationEnd(Animator animator) {
                this.f4827b.mo351h();
                m7623a();
            }

            private void m7623a() {
                if (runnable != null) {
                    runnable.run();
                }
                this.f4827b.f4819a = false;
                this.f4827b.f4803c.m7574e();
            }
        });
        this.f4829b.start();
    }

    protected final Class<?> mo351h() {
        return f4828a;
    }

    @SuppressLint({"NewApi"})
    public final void mo350g() {
        if (this.f4819a) {
            this.f4829b.cancel();
            this.f4829b.removeAllUpdateListeners();
            this.f4829b.removeAllListeners();
        }
    }
}
