package com.facebook.uicontrib.typinganimation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: email_coupon */
public class TypingDotsAnimationHelper {
    private final Context f15340a;

    /* compiled from: email_coupon */
    public class TypingAnimationParams {
        public final View f15334a;
        public final View f15335b;
        public final View f15336c;
        public final int f15337d;
        public final int f15338e;
        public final int f15339f;

        public TypingAnimationParams(View view, View view2, View view3, int i, int i2, int i3) {
            this.f15334a = view;
            this.f15335b = view2;
            this.f15336c = view3;
            this.f15337d = i;
            this.f15338e = i2;
            this.f15339f = i3;
        }
    }

    public static TypingDotsAnimationHelper m19345b(InjectorLike injectorLike) {
        return new TypingDotsAnimationHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public TypingDotsAnimationHelper(Context context) {
        this.f15340a = context;
    }

    public final AnimatorSet m19346a(final TypingAnimationParams typingAnimationParams) {
        int a = SizeUtil.a(this.f15340a, (float) typingAnimationParams.f15337d);
        float[] a2 = m19344a(TypingAnimationValues.f15328a, a);
        float[] a3 = m19344a(TypingAnimationValues.f15329b, a);
        float[] a4 = m19344a(TypingAnimationValues.f15330c, a);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{m19343a(typingAnimationParams.f15334a, a2), m19343a(typingAnimationParams.f15335b, a3), m19343a(typingAnimationParams.f15336c, a4)});
        animatorSet.setDuration((long) typingAnimationParams.f15338e);
        animatorSet.addListener(new AnimatorListener(this) {
            final /* synthetic */ TypingDotsAnimationHelper f15333c;

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                animatorSet.setStartDelay((long) typingAnimationParams.f15339f);
            }
        });
        return animatorSet;
    }

    private static float[] m19344a(float[] fArr, int i) {
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = fArr[i2] * ((float) i);
        }
        return fArr2;
    }

    private static ObjectAnimator m19343a(View view, float[] fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setPropertyName("translationY");
        objectAnimator.setFloatValues(fArr);
        objectAnimator.setRepeatCount(-1);
        return objectAnimator;
    }
}
