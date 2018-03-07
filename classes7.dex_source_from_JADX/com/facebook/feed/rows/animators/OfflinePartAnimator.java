package com.facebook.feed.rows.animators;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.sections.offline.ui.OfflineFooterView;
import com.facebook.feed.rows.styling.animators.FeedAnimators;
import com.facebook.feedplugins.offline.OfflineStoryPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: addressbooks */
public class OfflinePartAnimator {
    private static OfflinePartAnimator f19834e;
    private static final Object f19835f = new Object();
    public final FeedAnimators f19836a;
    public final Set<View> f19837b = Sets.a();
    private final DefaultAndroidThreadUtil f19838c;
    public OfflineFooterView f19839d;

    /* compiled from: addressbooks */
    public class C17242 extends BaseAnimatorListener {
        final /* synthetic */ OfflineFooterView f19832a;
        final /* synthetic */ OfflinePartAnimator f19833b;

        public C17242(OfflinePartAnimator offlinePartAnimator, OfflineFooterView offlineFooterView) {
            this.f19833b = offlinePartAnimator;
            this.f19832a = offlineFooterView;
        }

        public void onAnimationStart(Animator animator) {
            this.f19832a.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
            this.f19832a.clearAnimation();
            this.f19832a.getLayoutParams().height = -2;
        }
    }

    private static OfflinePartAnimator m23094b(InjectorLike injectorLike) {
        return new OfflinePartAnimator(FeedAnimators.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public OfflinePartAnimator(FeedAnimators feedAnimators, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f19836a = feedAnimators;
        this.f19838c = defaultAndroidThreadUtil;
    }

    public final void m23095a(View view) {
        this.f19837b.add(view);
    }

    public static OfflinePartAnimator m23093a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflinePartAnimator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19835f) {
                OfflinePartAnimator offlinePartAnimator;
                if (a2 != null) {
                    offlinePartAnimator = (OfflinePartAnimator) a2.a(f19835f);
                } else {
                    offlinePartAnimator = f19834e;
                }
                if (offlinePartAnimator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23094b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19835f, b3);
                        } else {
                            f19834e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlinePartAnimator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m23096a(final OfflineStoryPersistentState offlineStoryPersistentState) {
        this.f19838c.b(new Runnable(this) {
            final /* synthetic */ OfflinePartAnimator f19831b;

            public void run() {
                if (!this.f19831b.f19837b.isEmpty()) {
                    Collection a = Lists.a();
                    FeedAnimators feedAnimators = this.f19831b.f19836a;
                    a.addAll(FeedAnimators.a(this.f19831b.f19837b, 0.3f, 1.0f, 500));
                    if (this.f19831b.f19839d != null) {
                        OfflinePartAnimator offlinePartAnimator = this.f19831b;
                        OfflineFooterView offlineFooterView = this.f19831b.f19839d;
                        offlineFooterView.measure(MeasureSpec.makeMeasureSpec(offlineFooterView.getContext().getResources().getDisplayMetrics().widthPixels, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
                        Animator a2 = offlinePartAnimator.f19836a.a(offlineFooterView, 0, offlineFooterView.getMeasuredHeight());
                        a2.setDuration(300);
                        a2.addListener(new C17242(offlinePartAnimator, offlineFooterView));
                        a.add(a2);
                    }
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(a);
                    animatorSet.start();
                    this.f19831b.f19837b.clear();
                    this.f19831b.f19839d = null;
                    offlineStoryPersistentState.f23557a = true;
                }
            }
        });
    }
}
