package com.facebook.photos.creativeediting.swipeable.composer.nux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.photos.creativeediting.model.SwipingTouchEventState.SwipingState;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController.C08115;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableTouchEventController;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: lockscreen_notification_dismiss */
public abstract class SwipeableAnimatingNuxViewController {
    public static final AtomicBoolean f9925c = new AtomicBoolean(false);
    protected final Context f9926a;
    public ViewGroup f9927b;
    public boolean f9928d;
    public float f9929e;
    public final SpringAlphaAnimator f9930f;
    public ImageView f9931g;
    @Nullable
    public TextView f9932h;
    public C08115 f9933i;

    /* compiled from: lockscreen_notification_dismiss */
    public class C08241 implements Runnable {
        final /* synthetic */ SwipeableAnimatingNuxViewController f9937a;

        public C08241(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
            this.f9937a = swipeableAnimatingNuxViewController;
        }

        public void run() {
            SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController = this.f9937a;
            swipeableAnimatingNuxViewController.f9931g.setAlpha(0.0f);
            swipeableAnimatingNuxViewController.f9931g.setTranslationX(SwipeableAnimatingNuxViewController.m11850b(swipeableAnimatingNuxViewController, swipeableAnimatingNuxViewController.mo529c()));
            swipeableAnimatingNuxViewController.f9931g.setTranslationY((((float) swipeableAnimatingNuxViewController.f9927b.getMeasuredHeight()) / 2.0f) + (((float) swipeableAnimatingNuxViewController.f9931g.getMeasuredHeight()) / 2.0f));
            swipeableAnimatingNuxViewController.f9927b.invalidate();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{SwipeableAnimatingNuxViewController.m11851n(this.f9937a), SwipeableAnimatingNuxViewController.m11853p(this.f9937a)});
            animatorSet.start();
        }
    }

    /* compiled from: lockscreen_notification_dismiss */
    public class C08262 implements Runnable {
        final /* synthetic */ SwipeableAnimatingNuxViewController f9939a;

        /* compiled from: lockscreen_notification_dismiss */
        class C08251 extends AnimatorListenerAdapter {
            final /* synthetic */ C08262 f9938a;

            C08251(C08262 c08262) {
                this.f9938a = c08262;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.f9938a.f9939a.f9933i.m11760a();
            }
        }

        public C08262(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
            this.f9939a = swipeableAnimatingNuxViewController;
        }

        public void run() {
            Animator p = SwipeableAnimatingNuxViewController.m11853p(this.f9939a);
            p.addListener(new C08251(this));
            p.setStartDelay(this.f9939a.mo536j());
            p.start();
        }
    }

    /* compiled from: lockscreen_notification_dismiss */
    class C08273 implements AnimatorUpdateListener {
        final /* synthetic */ SwipeableAnimatingNuxViewController f9940a;

        C08273(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
            this.f9940a = swipeableAnimatingNuxViewController;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9940a.f9931g.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: lockscreen_notification_dismiss */
    class C08295 extends AnimatorListenerAdapter {
        final /* synthetic */ SwipeableAnimatingNuxViewController f9943a;

        C08295(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
            this.f9943a = swipeableAnimatingNuxViewController;
        }

        public void onAnimationStart(Animator animator) {
            C08115 c08115 = this.f9943a.f9933i;
            float f = this.f9943a.mo532f();
            SwipeableTouchEventController swipeableTouchEventController = c08115.f9790a.f9809L;
            SwipeableTouchEventController.m11841c(swipeableTouchEventController, f);
            SwipeableTouchEventController.m11839a(swipeableTouchEventController, SwipingState.SWIPING);
        }

        public void onAnimationEnd(Animator animator) {
            this.f9943a.f9933i.m11760a();
            SwipeableAnimatingNuxViewController.m11852o(this.f9943a).start();
            if (this.f9943a.f9932h != null) {
                SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController = this.f9943a;
                swipeableAnimatingNuxViewController.f9927b.postDelayed(new C08306(swipeableAnimatingNuxViewController), 500);
            }
        }
    }

    /* compiled from: lockscreen_notification_dismiss */
    public class C08306 implements Runnable {
        final /* synthetic */ SwipeableAnimatingNuxViewController f9944a;

        public C08306(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
            this.f9944a = swipeableAnimatingNuxViewController;
        }

        public void run() {
            this.f9944a.f9930f.a(this.f9944a.f9932h, 0);
        }
    }

    protected abstract float mo526a(float f);

    public abstract ImageView mo527a();

    @Nullable
    public abstract TextView mo528b();

    public abstract float mo529c();

    protected abstract float mo530d();

    protected abstract boolean mo531e();

    protected abstract float mo532f();

    public abstract float mo533g();

    public abstract boolean mo534h();

    protected SwipeableAnimatingNuxViewController(Context context, SpringAlphaAnimator springAlphaAnimator) {
        this.f9926a = context;
        this.f9930f = springAlphaAnimator;
    }

    protected long mo535i() {
        return 1600;
    }

    protected long mo536j() {
        return 0;
    }

    public static Animator m11851n(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
        Animator duration = swipeableAnimatingNuxViewController.m11849a(0.0f, 1.0f).setDuration(500);
        duration.setInterpolator(new DecelerateInterpolator());
        return duration;
    }

    public static Animator m11852o(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
        Animator duration = swipeableAnimatingNuxViewController.m11849a(1.0f, 0.0f).setDuration(200);
        duration.setInterpolator(new AccelerateInterpolator());
        return duration;
    }

    private Animator m11849a(float f, float f2) {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new C08273(this));
        return ofFloat;
    }

    public static Animator m11853p(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
        final float f = (float) (15 * ((long) (swipeableAnimatingNuxViewController.mo531e() ? 1 : -1)));
        Animator duration = ValueAnimator.ofFloat(new float[]{swipeableAnimatingNuxViewController.mo529c(), swipeableAnimatingNuxViewController.mo530d()}).setDuration(swipeableAnimatingNuxViewController.mo535i());
        duration.setInterpolator(new DecelerateInterpolator(2.0f));
        duration.addUpdateListener(new AnimatorUpdateListener(swipeableAnimatingNuxViewController) {
            final /* synthetic */ SwipeableAnimatingNuxViewController f9942b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float f = (Float) valueAnimator.getAnimatedValue();
                float f2 = 0.0f;
                if (valueAnimator.getAnimatedFraction() > 0.8f) {
                    f2 = (f * (valueAnimator.getAnimatedFraction() - 0.8f)) * 5.0000005f;
                    this.f9942b.f9931g.setRotation(f2);
                    f2 = ((float) Math.sin(Math.toRadians((double) (f2 * -1.0f)))) * ((float) this.f9942b.f9931g.getMeasuredHeight());
                }
                this.f9942b.f9931g.setTranslationX(f2 + SwipeableAnimatingNuxViewController.m11850b(this.f9942b, f.floatValue()));
                C08115 c08115 = this.f9942b.f9933i;
                SwipeableTouchEventController.m11838a(c08115.f9790a.f9809L, f.floatValue(), 0.0f, false, false);
                if (this.f9942b.f9932h != null) {
                    this.f9942b.f9932h.setAlpha(valueAnimator.getAnimatedFraction());
                }
            }
        });
        duration.addListener(new C08295(swipeableAnimatingNuxViewController));
        return duration;
    }

    public static float m11850b(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController, float f) {
        return swipeableAnimatingNuxViewController.mo526a(f) + swipeableAnimatingNuxViewController.f9929e;
    }
}
