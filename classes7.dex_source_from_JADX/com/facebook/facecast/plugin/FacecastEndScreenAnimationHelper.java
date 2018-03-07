package com.facebook.facecast.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.ui.animations.SpringAnimator;
import java.util.ArrayList;
import java.util.List;

/* compiled from: boundaryCursor */
public class FacecastEndScreenAnimationHelper {
    private static final ArgbEvaluator f18294a = new ArgbEvaluator();

    /* compiled from: boundaryCursor */
    final class C15471 implements Runnable {
        final /* synthetic */ View f18280a;

        C15471(View view) {
            this.f18280a = view;
        }

        public final void run() {
            this.f18280a.setVisibility(0);
        }
    }

    /* compiled from: boundaryCursor */
    final class C15482 implements Runnable {
        final /* synthetic */ View f18281a;

        C15482(View view) {
            this.f18281a = view;
        }

        public final void run() {
            this.f18281a.setVisibility(8);
        }
    }

    /* compiled from: boundaryCursor */
    final class C15493 implements AnimatorUpdateListener {
        final /* synthetic */ View f18282a;

        C15493(View view) {
            this.f18282a = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f18282a.setBackground(new ColorDrawable(((Integer) valueAnimator.getAnimatedValue()).intValue()));
        }
    }

    /* compiled from: boundaryCursor */
    public class EnterExitAnimatorsBuilder {
        private final List<Animator> f18286a = new ArrayList();
        private final List<Animator> f18287b = new ArrayList();
        private final List<Runnable> f18288c = new ArrayList();
        private final List<Runnable> f18289d = new ArrayList();
        private final List<Runnable> f18290e = new ArrayList();
        public final List<Runnable> f18291f = new ArrayList();

        public final EnterExitAnimatorsBuilder m22015a(Animator animator) {
            this.f18286a.add(animator);
            return this;
        }

        public final EnterExitAnimatorsBuilder m22018b(Animator animator) {
            this.f18287b.add(animator);
            return this;
        }

        public final EnterExitAnimatorsBuilder m22016a(Runnable runnable) {
            this.f18288c.add(runnable);
            return this;
        }

        public final EnterExitAnimatorsBuilder m22019b(Runnable runnable) {
            this.f18289d.add(runnable);
            return this;
        }

        public final EnterExitAnimatorsBuilder m22020c(Runnable runnable) {
            this.f18290e.add(runnable);
            return this;
        }

        public final TransitionAnimators m22017a() {
            return new TransitionAnimators(m22014a(this.f18286a, this.f18288c, this.f18290e), m22014a(this.f18287b, this.f18289d, this.f18291f));
        }

        private AnimatorSet m22014a(List<Animator> list, final List<Runnable> list2, final List<Runnable> list3) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(list);
            animatorSet.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ EnterExitAnimatorsBuilder f18285c;

                public void onAnimationStart(Animator animator) {
                    for (Runnable run : list2) {
                        run.run();
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    for (Runnable run : list3) {
                        run.run();
                    }
                }
            });
            return animatorSet;
        }
    }

    /* compiled from: boundaryCursor */
    public class TransitionAnimators {
        public final AnimatorSet f18292a;
        public final AnimatorSet f18293b;

        public TransitionAnimators(AnimatorSet animatorSet, AnimatorSet animatorSet2) {
            this.f18292a = animatorSet;
            this.f18293b = animatorSet2;
        }
    }

    public static void m22023a(EnterExitAnimatorsBuilder enterExitAnimatorsBuilder, View view) {
        enterExitAnimatorsBuilder.m22015a(m22021a(view, 0.0f)).m22020c(new C15482(view)).m22018b(m22021a(view, 1.0f)).m22019b(new C15471(view));
    }

    private static Animator m22021a(View view, float f) {
        return SpringAnimator.a(view, "alpha", f);
    }

    public static Animator m22024b(View view, float f) {
        return SpringAnimator.a(view, "translationY", f);
    }

    public static Animator m22022a(View view, int i, int i2) {
        Animator ofObject = SpringAnimator.ofObject(f18294a, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ofObject.addUpdateListener(new C15493(view));
        return ofObject;
    }
}
