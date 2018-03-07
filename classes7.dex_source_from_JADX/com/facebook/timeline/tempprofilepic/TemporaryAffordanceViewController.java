package com.facebook.timeline.tempprofilepic;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.time.Clock;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.header.TimelineProfileImageFrameController.1;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.widget.LazyView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: faceCount cannot be < 0 */
public class TemporaryAffordanceViewController {
    private final TemporaryAffordanceViewBinder f14965a;
    public final Resources f14966b;
    private final Clock f14967c;
    public final LazyView<ProfileImageTemporaryAffordanceView> f14968d;
    @Nullable
    public Runnable f14969e;
    @Nullable
    public Runnable f14970f;
    public int f14971g = 0;
    public boolean f14972h;
    @Nullable
    public 1 f14973i;

    /* compiled from: faceCount cannot be < 0 */
    public class C11051 implements Runnable {
        final /* synthetic */ TemporaryAffordanceViewController f14958a;

        public C11051(TemporaryAffordanceViewController temporaryAffordanceViewController) {
            this.f14958a = temporaryAffordanceViewController;
        }

        public void run() {
            if (!this.f14958a.f14972h) {
                TemporaryAffordanceViewController temporaryAffordanceViewController = this.f14958a;
                ProfileImageTemporaryAffordanceView profileImageTemporaryAffordanceView = (ProfileImageTemporaryAffordanceView) temporaryAffordanceViewController.f14968d.a();
                View view = profileImageTemporaryAffordanceView.f14954a;
                Animator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(profileImageTemporaryAffordanceView.getContext(), 2131034114);
                animator.setTarget(profileImageTemporaryAffordanceView);
                Animator animator2 = animator;
                ObjectAnimator b = TemporaryAffordanceViewAnimators.m18793b(view);
                profileImageTemporaryAffordanceView.setBackgroundAlpha(temporaryAffordanceViewController.f14966b.getInteger(2131492933));
                profileImageTemporaryAffordanceView.setVisibility(0);
                view.setVisibility(4);
                b.addListener(new C11062(temporaryAffordanceViewController, view, profileImageTemporaryAffordanceView));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{animator2, b});
                animatorSet.start();
            }
        }
    }

    /* compiled from: faceCount cannot be < 0 */
    public class C11062 extends AnimatorListenerAdapter {
        final /* synthetic */ View f14959a;
        final /* synthetic */ ProfileImageTemporaryAffordanceView f14960b;
        final /* synthetic */ TemporaryAffordanceViewController f14961c;

        public C11062(TemporaryAffordanceViewController temporaryAffordanceViewController, View view, ProfileImageTemporaryAffordanceView profileImageTemporaryAffordanceView) {
            this.f14961c = temporaryAffordanceViewController;
            this.f14959a = view;
            this.f14960b = profileImageTemporaryAffordanceView;
        }

        public void onAnimationStart(Animator animator) {
            if (!this.f14961c.f14972h) {
                this.f14959a.setAlpha(0.0f);
                this.f14959a.setVisibility(0);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f14961c.f14972h) {
                ProfileImageTemporaryAffordanceView profileImageTemporaryAffordanceView = this.f14960b;
                TemporaryAffordanceViewController temporaryAffordanceViewController = this.f14961c;
                if (temporaryAffordanceViewController.f14970f == null) {
                    temporaryAffordanceViewController.f14970f = new C11073(temporaryAffordanceViewController);
                }
                profileImageTemporaryAffordanceView.postDelayed(temporaryAffordanceViewController.f14970f, 2450);
            }
        }
    }

    /* compiled from: faceCount cannot be < 0 */
    public class C11073 implements Runnable {
        final /* synthetic */ TemporaryAffordanceViewController f14962a;

        public C11073(TemporaryAffordanceViewController temporaryAffordanceViewController) {
            this.f14962a = temporaryAffordanceViewController;
        }

        public void run() {
            if (!this.f14962a.f14972h) {
                TemporaryAffordanceViewController temporaryAffordanceViewController = this.f14962a;
                ProfileImageTemporaryAffordanceView profileImageTemporaryAffordanceView = (ProfileImageTemporaryAffordanceView) temporaryAffordanceViewController.f14968d.a();
                ObjectAnimator c = TemporaryAffordanceViewAnimators.m18794c(profileImageTemporaryAffordanceView.f14954a);
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(profileImageTemporaryAffordanceView.getContext(), 2131034115);
                objectAnimator.setTarget(profileImageTemporaryAffordanceView);
                ObjectAnimator objectAnimator2 = objectAnimator;
                objectAnimator2.addUpdateListener(new C11084(temporaryAffordanceViewController));
                objectAnimator2.addListener(new C11095(temporaryAffordanceViewController));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{c, objectAnimator2});
                animatorSet.start();
            }
        }
    }

    /* compiled from: faceCount cannot be < 0 */
    public class C11084 implements AnimatorUpdateListener {
        final /* synthetic */ TemporaryAffordanceViewController f14963a;

        public C11084(TemporaryAffordanceViewController temporaryAffordanceViewController) {
            this.f14963a = temporaryAffordanceViewController;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (((Integer) valueAnimator.getAnimatedValue()).intValue() < 76) {
                this.f14963a.f14971g = 2;
                if (this.f14963a.f14973i != null) {
                    1 1 = this.f14963a.f14973i;
                    if (!1.h.h) {
                        1.h.a(1.h.i, 1.a, 1.b, 1.c, 1.d, 1.e, 1.f, 1.g, true);
                    }
                    this.f14963a.f14973i = null;
                }
            }
        }
    }

    /* compiled from: faceCount cannot be < 0 */
    public class C11095 extends AnimatorListenerAdapter {
        final /* synthetic */ TemporaryAffordanceViewController f14964a;

        public C11095(TemporaryAffordanceViewController temporaryAffordanceViewController) {
            this.f14964a = temporaryAffordanceViewController;
        }

        public void onAnimationEnd(Animator animator) {
            this.f14964a.f14971g = 3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: faceCount cannot be < 0 */
    public @interface AnimationState {
    }

    @Inject
    public TemporaryAffordanceViewController(TemporaryAffordanceViewBinder temporaryAffordanceViewBinder, Resources resources, Clock clock, @Assisted LazyView<ProfileImageTemporaryAffordanceView> lazyView) {
        this.f14965a = temporaryAffordanceViewBinder;
        this.f14966b = resources;
        this.f14967c = clock;
        this.f14968d = lazyView;
    }

    public final boolean m18800a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, boolean z, boolean z2) {
        return timelineContext != null && !z && !z2 && timelineContext.i() && timelineHeaderUserData.m18518w() && timelineHeaderUserData.m18519x() > this.f14967c.a();
    }

    public final void m18798a(1 1) {
        this.f14973i = 1;
    }

    public final void m18799a(TimelineHeaderUserData timelineHeaderUserData) {
        TemporaryAffordanceViewBinder temporaryAffordanceViewBinder = this.f14965a;
        LazyView lazyView = this.f14968d;
        ((ProfileImageTemporaryAffordanceView) lazyView.a()).setTimerText(((DefaultTimeFormatUtil) temporaryAffordanceViewBinder.f14956a.get()).a(TimeFormatStyle.DAY_HOUR_FUTURE_STYLE, timelineHeaderUserData.m18519x()));
        ((ProfileImageTemporaryAffordanceView) lazyView.a()).setTimerDrawable(((GlyphColorizer) temporaryAffordanceViewBinder.f14957b.get()).a(2130843562, -1));
        ProfileImageTemporaryAffordanceView profileImageTemporaryAffordanceView = (ProfileImageTemporaryAffordanceView) this.f14968d.a();
        if (this.f14969e == null) {
            this.f14969e = new C11051(this);
        }
        profileImageTemporaryAffordanceView.post(this.f14969e);
        this.f14971g = 1;
    }

    public final void m18797a() {
        this.f14968d.c();
    }

    public final int m18801b() {
        return this.f14971g;
    }
}
