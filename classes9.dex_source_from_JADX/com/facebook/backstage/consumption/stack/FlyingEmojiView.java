package com.facebook.backstage.consumption.stack;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.backstage.consumption.BackstagePanelImageView;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import java.util.Random;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: retr_st */
public class FlyingEmojiView extends FrameLayout {
    @Inject
    public ScreenUtil f5063a;
    private final int[] f5064b;
    public final FbTextView f5065c;
    public final BackstagePanelImageView f5066d;
    private boolean f5067e;

    /* compiled from: retr_st */
    class C05391 implements OnGlobalLayoutListener {
        final /* synthetic */ FlyingEmojiView f5053a;

        C05391(FlyingEmojiView flyingEmojiView) {
            this.f5053a = flyingEmojiView;
        }

        public void onGlobalLayout() {
            this.f5053a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f5053a.setPivotX((float) (this.f5053a.getWidth() / 2));
            this.f5053a.setPivotY((float) (this.f5053a.getHeight() / 2));
            this.f5053a.m4863a(this.f5053a);
        }
    }

    /* compiled from: retr_st */
    class C05423 implements AnimatorListener {
        final /* synthetic */ FlyingEmojiView f5062a;

        /* compiled from: retr_st */
        class C05411 implements OnFinishListener {
            final /* synthetic */ C05423 f5061a;

            C05411(C05423 c05423) {
                this.f5061a = c05423;
            }

            public final void mo142a() {
                ViewGroup viewGroup = (ViewGroup) this.f5061a.f5062a.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f5061a.f5062a);
                }
            }
        }

        C05423(FlyingEmojiView flyingEmojiView) {
            this.f5062a = flyingEmojiView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            ViewAnimator d = ViewAnimator.m5752a(this.f5062a).m5760d(1.0f, 0.0f);
            d.f5528e = new C05411(this);
            d.m5759d();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    private static <T extends View> void m4866a(Class<T> cls, T t) {
        m4867a((Object) t, t.getContext());
    }

    private static void m4867a(Object obj, Context context) {
        ((FlyingEmojiView) obj).f5063a = ScreenUtil.m4547a(FbInjector.get(context));
    }

    public FlyingEmojiView(Context context) {
        this(context, null);
    }

    private void m4864a(ScreenUtil screenUtil) {
        this.f5063a = screenUtil;
    }

    public FlyingEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlyingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5064b = new int[2];
        m4866a(FlyingEmojiView.class, (View) this);
        setLayoutParams(new LayoutParams(-2, -2));
        this.f5065c = new FbTextView(getContext());
        this.f5065c.setLayoutParams(new LayoutParams(-2, -2));
        this.f5065c.setTextSize(0, getResources().getDimension(2131433281));
        addView(this.f5065c);
        int dimension = (int) getResources().getDimension(2131433281);
        this.f5066d = new BackstagePanelImageView(getContext());
        this.f5066d.setLayoutParams(new LayoutParams(dimension, dimension));
        this.f5066d.m4505a(true);
        this.f5066d.setVisibility(8);
        addView(this.f5066d);
    }

    public final void m4871a(View view, SeenByUser seenByUser) {
        view.getLocationInWindow(this.f5064b);
        setX((float) this.f5064b[0]);
        setY((float) (this.f5064b[1] - view.getHeight()));
        if (this.f5064b[1] >= this.f5063a.m4554d()) {
            this.f5067e = true;
        } else {
            this.f5067e = false;
        }
        this.f5065c.setText(seenByUser.f5111a);
        this.f5066d.setImage(seenByUser.f5102c);
    }

    public final void m4870a() {
        getViewTreeObserver().addOnGlobalLayoutListener(new C05391(this));
    }

    private void m4863a(View view) {
        float f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(4000);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        final float x = view.getX();
        final float y = view.getY();
        final float nextInt = (float) new Random().nextInt(this.f5063a.m4551a());
        if (this.f5067e) {
            f = 0.0f;
        } else {
            f = (float) this.f5063a.m4552b();
        }
        final View view2 = view;
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ FlyingEmojiView f5059f;
            private boolean f5060g = false;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view2.setTranslationX(FlyingEmojiView.m4868b(x, floatValue, nextInt));
                view2.setTranslationY(FlyingEmojiView.m4868b(y, floatValue, f));
                if (m4859a(floatValue)) {
                    ViewAnimator a = ViewAnimator.m5752a(this.f5059f.f5066d);
                    a.f5549z = 0;
                    a.m5760d(0.0f, 1.0f).m5759d();
                    a = ViewAnimator.m5752a(this.f5059f.f5065c);
                    a.f5524A = 8;
                    a.m5760d(1.0f, 0.0f).m5759d();
                    this.f5060g = true;
                }
            }

            private boolean m4859a(float f) {
                return !this.f5060g && f >= 0.7f;
            }
        });
        ofFloat.addListener(new C05423(this));
        ofFloat.start();
    }

    public static float m4868b(float f, float f2, float f3) {
        return ((f3 - f) * f2) + f;
    }
}
