package com.facebook.redspace.ui.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.DecelerateInterpolator;
import com.facebook.redspace.ui.RedSpaceSearchBarView;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;

@TargetApi(14)
/* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SENT */
public class RedSpaceAnimations {
    @Inject
    public volatile Provider<Resources> f12432a = UltralightRuntime.a;

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SENT */
    public final class C14682 implements OnPreDrawListener {
        final /* synthetic */ Runnable f12421a;
        final /* synthetic */ View f12422b;

        public C14682(Runnable runnable, View view) {
            this.f12421a = runnable;
            this.f12422b = view;
        }

        public final boolean onPreDraw() {
            this.f12421a.run();
            this.f12422b.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SENT */
    public class C14694 extends AnimatorListenerAdapter {
        final /* synthetic */ View f12423a;
        final /* synthetic */ RedSpaceAnimations f12424b;

        public C14694(RedSpaceAnimations redSpaceAnimations, View view) {
            this.f12424b = redSpaceAnimations;
            this.f12423a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f12423a.setTranslationY(0.0f);
            this.f12423a.setVisibility(4);
        }

        public void onAnimationCancel(Animator animator) {
            this.f12423a.setTranslationY(0.0f);
        }
    }

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SENT */
    public class C14705 implements Runnable {
        final /* synthetic */ RedSpaceSearchBarView f12425a;
        final /* synthetic */ View f12426b;
        final /* synthetic */ Rect f12427c;
        final /* synthetic */ Runnable f12428d;
        final /* synthetic */ RedSpaceAnimations f12429e;

        public C14705(RedSpaceAnimations redSpaceAnimations, RedSpaceSearchBarView redSpaceSearchBarView, View view, Rect rect, Runnable runnable) {
            this.f12429e = redSpaceAnimations;
            this.f12425a = redSpaceSearchBarView;
            this.f12426b = view;
            this.f12427c = rect;
            this.f12428d = runnable;
        }

        public void run() {
            RedSpaceAnimations redSpaceAnimations = this.f12429e;
            RedSpaceSearchBarView redSpaceSearchBarView = this.f12425a;
            View view = this.f12426b;
            Rect rect = this.f12427c;
            Runnable runnable = this.f12428d;
            Resources resources = (Resources) redSpaceAnimations.f12432a.get();
            Rect rect2 = new Rect();
            redSpaceSearchBarView.f12368f.getGlobalVisibleRect(rect2);
            int i = rect.left - rect2.left;
            redSpaceSearchBarView.setTranslationY((float) (-resources.getDimensionPixelOffset(2131430587)));
            redSpaceSearchBarView.f12368f.setTranslationX((float) i);
            View view2 = redSpaceSearchBarView.f12373k;
            view2.setTranslationX((float) i);
            view.setVisibility(0);
            redSpaceSearchBarView.f12368f.animate().setDuration(200).translationX(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new C14716(redSpaceAnimations, runnable));
            view2.animate().setDuration(200).translationX(0.0f).setInterpolator(new DecelerateInterpolator());
            redSpaceSearchBarView.animate().setDuration(200).translationY(0.0f).setInterpolator(new DecelerateInterpolator());
        }
    }

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SENT */
    public class C14716 extends AnimatorListenerAdapter {
        final /* synthetic */ Runnable f12430a;
        final /* synthetic */ RedSpaceAnimations f12431b;

        public C14716(RedSpaceAnimations redSpaceAnimations, Runnable runnable) {
            this.f12431b = redSpaceAnimations;
            this.f12430a = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            this.f12430a.run();
        }
    }

    public static void m12836a(Activity activity) {
        activity.overridePendingTransition(2130968751, 2130968615);
    }
}
