package com.facebook.feedplugins.graphqlstory.footer.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.abtest.FeedDiscoveryExperimentUtil;
import com.facebook.feedplugins.graphqlstory.footer.FeedDiscoveryBlingBarPartDefinition$1;
import com.facebook.feedplugins.graphqlstory.footer.FeedDiscoveryBlingBarPartDefinition.FeedDiscoveryViewStateChangeListener;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.Assisted;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Show called after saveInstanceState */
public class FeedDiscoveryBlingBarAnimationController {
    private final int f23300a = this.f23302c.a.a(ExperimentsForFeedbackTestModule.i, 300);
    private final FeedDiscoveryBlingBarAnimationUtil f23301b;
    private final FeedDiscoveryExperimentUtil f23302c;
    public FeedDiscoveryViewState f23303d;
    public FeedDiscoveryViewState f23304e;
    public boolean f23305f;
    private ObjectAnimator f23306g;
    private ObjectAnimator f23307h;
    private ObjectAnimator f23308i;
    private ObjectAnimator f23309j;
    private AnimatorSet f23310k;
    private AnimatorSet f23311l;
    public WeakReference<FeedDiscoveryBlingBar> f23312m;
    private final FeedDiscoveryBlingBarPartDefinition$1 f23313n;
    private List<String> f23314o;
    private GraphQLTextWithEntities f23315p;

    /* compiled from: Show called after saveInstanceState */
    class C20161 extends AnimatorListenerAdapter {
        final /* synthetic */ FeedDiscoveryBlingBarAnimationController f23298a;

        C20161(FeedDiscoveryBlingBarAnimationController feedDiscoveryBlingBarAnimationController) {
            this.f23298a = feedDiscoveryBlingBarAnimationController;
        }

        public void onAnimationStart(Animator animator) {
            this.f23298a.m25680a(this.f23298a.f23304e, false);
        }
    }

    /* compiled from: Show called after saveInstanceState */
    public enum FeedDiscoveryViewState {
        SHOWING_REAL_TIME_ACTIVITY,
        SHOWING_BLING_BAR
    }

    @Inject
    public FeedDiscoveryBlingBarAnimationController(FeedDiscoveryBlingBarAnimationUtil feedDiscoveryBlingBarAnimationUtil, FeedDiscoveryExperimentUtil feedDiscoveryExperimentUtil, @Assisted FeedDiscoveryViewState feedDiscoveryViewState, @Assisted FeedDiscoveryViewStateChangeListener feedDiscoveryViewStateChangeListener, @Assisted List<String> list, @Assisted GraphQLTextWithEntities graphQLTextWithEntities) {
        this.f23301b = feedDiscoveryBlingBarAnimationUtil;
        this.f23303d = feedDiscoveryViewState;
        this.f23302c = feedDiscoveryExperimentUtil;
        this.f23313n = feedDiscoveryViewStateChangeListener;
        this.f23314o = list;
        this.f23315p = graphQLTextWithEntities;
        m25674e();
    }

    private void m25674e() {
        int i = this.f23300a;
        FeedDiscoveryBlingBarAnimationUtil feedDiscoveryBlingBarAnimationUtil = this.f23301b;
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setValues(new PropertyValuesHolder[]{feedDiscoveryBlingBarAnimationUtil.f23321e, FeedDiscoveryBlingBarAnimationUtil.f23316a});
        objectAnimator.setDuration((long) i);
        this.f23306g = objectAnimator;
        feedDiscoveryBlingBarAnimationUtil = this.f23301b;
        objectAnimator = new ObjectAnimator();
        objectAnimator.setValues(new PropertyValuesHolder[]{feedDiscoveryBlingBarAnimationUtil.f23319c, FeedDiscoveryBlingBarAnimationUtil.f23316a});
        objectAnimator.setDuration((long) i);
        this.f23307h = objectAnimator;
        feedDiscoveryBlingBarAnimationUtil = this.f23301b;
        objectAnimator = new ObjectAnimator();
        objectAnimator.setValues(new PropertyValuesHolder[]{feedDiscoveryBlingBarAnimationUtil.f23322f, FeedDiscoveryBlingBarAnimationUtil.f23317b});
        objectAnimator.setDuration((long) i);
        this.f23308i = objectAnimator;
        feedDiscoveryBlingBarAnimationUtil = this.f23301b;
        objectAnimator = new ObjectAnimator();
        objectAnimator.setValues(new PropertyValuesHolder[]{feedDiscoveryBlingBarAnimationUtil.f23320d, FeedDiscoveryBlingBarAnimationUtil.f23317b});
        objectAnimator.setDuration((long) i);
        this.f23309j = objectAnimator;
        this.f23310k = m25671a(this.f23308i, this.f23307h);
        this.f23311l = m25671a(this.f23309j, this.f23306g);
    }

    private AnimatorSet m25671a(ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2) {
        AnimatorSet animatorSet = new AnimatorSet();
        objectAnimator2.addListener(new C20161(this));
        animatorSet.play(objectAnimator).with(objectAnimator2);
        return animatorSet;
    }

    private void m25675f() {
        this.f23310k.setDuration((long) this.f23300a);
        this.f23311l.setDuration((long) this.f23300a);
    }

    private boolean m25676g() {
        return (this.f23310k != null && this.f23310k.isRunning()) || (this.f23311l != null && this.f23311l.isRunning());
    }

    private void m25673b(ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2) {
        m25672a(objectAnimator, this.f23303d);
        m25672a(objectAnimator2, this.f23304e);
    }

    private void m25672a(ObjectAnimator objectAnimator, FeedDiscoveryViewState feedDiscoveryViewState) {
        FeedDiscoveryBlingBar j = m25679j();
        if (j != null) {
            switch (feedDiscoveryViewState) {
                case SHOWING_REAL_TIME_ACTIVITY:
                    j.setAnimatorTargetToRealTimeActivity(objectAnimator);
                    return;
                case SHOWING_BLING_BAR:
                    j.setAnimatorTargetToBlingBar(objectAnimator);
                    return;
                default:
                    throw new IllegalStateException("Unknown view state for feed discovery: " + feedDiscoveryViewState);
            }
        }
    }

    @VisibleForTesting
    public final void m25680a(FeedDiscoveryViewState feedDiscoveryViewState, boolean z) {
        FeedDiscoveryBlingBar j = m25679j();
        if (j != null) {
            this.f23303d = feedDiscoveryViewState;
            this.f23313n.f23216a.f23225a = this.f23303d;
            switch (this.f23303d) {
                case SHOWING_REAL_TIME_ACTIVITY:
                    j.setText(this.f23315p);
                    j.setFacepileStrings(this.f23314o);
                    if (z) {
                        j.mo1576b();
                        return;
                    }
                    return;
                case SHOWING_BLING_BAR:
                    if (z) {
                        j.mo1575a();
                        return;
                    }
                    return;
                default:
                    throw new IllegalStateException("Unknown view state for feed discovery: " + feedDiscoveryViewState);
            }
        }
    }

    private void m25677h() {
        if (this.f23303d != FeedDiscoveryViewState.SHOWING_REAL_TIME_ACTIVITY && !m25676g()) {
            this.f23304e = FeedDiscoveryViewState.SHOWING_REAL_TIME_ACTIVITY;
            m25673b(this.f23308i, this.f23307h);
            m25675f();
            this.f23310k.start();
        }
    }

    private void m25678i() {
        if (this.f23303d != FeedDiscoveryViewState.SHOWING_BLING_BAR && !m25676g()) {
            this.f23304e = FeedDiscoveryViewState.SHOWING_BLING_BAR;
            m25673b(this.f23309j, this.f23306g);
            m25675f();
            this.f23311l.start();
        }
    }

    public final boolean m25681c() {
        if (this.f23305f) {
            this.f23305f = false;
            return false;
        }
        if (this.f23303d == FeedDiscoveryViewState.SHOWING_BLING_BAR) {
            m25677h();
        } else {
            m25678i();
        }
        return true;
    }

    @Nullable
    @VisibleForTesting
    private FeedDiscoveryBlingBar m25679j() {
        return this.f23312m == null ? null : (FeedDiscoveryBlingBar) this.f23312m.get();
    }

    public final void m25682d() {
        if (this.f23310k != null && this.f23310k.isRunning()) {
            this.f23310k.end();
        }
        if (this.f23311l != null && this.f23311l.isRunning()) {
            this.f23311l.end();
        }
        this.f23306g.setTarget(null);
        this.f23307h.setTarget(null);
        this.f23308i.setTarget(null);
        this.f23309j.setTarget(null);
        this.f23312m = null;
    }
}
