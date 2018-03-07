package com.facebook.timeline.refresher.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Interpolator;
import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.facebook.timeline.refresher.ProfileRefresherHeaderFragment;
import com.facebook.timeline.refresher.ProfileRefresherModel;
import com.facebook.timeline.refresher.ProfileRefresherView;

/* compiled from: unhighlighted_icon */
public class ProfileRefresherAnimationHelper {
    public Interpolator f1101a = this.f962g;

    public final void m1183b(View view, float f, @Nullable AnimatorListener animatorListener) {
        view.animate().alpha(0.0f).translationY(f).setInterpolator(this.f1101a).setListener(animatorListener);
    }

    public final void m1184c(View view, float f, @Nullable AnimatorListener animatorListener) {
        view.setTranslationY(f);
        view.setAlpha(0.0f);
        view.animate().translationY(0.0f).alpha(1.0f).setInterpolator(this.f1101a).setListener(animatorListener);
    }

    public static void m1181a(@Nullable View view) {
        if (view != null) {
            view.animate().setListener(null);
        }
    }

    public final void m1182a(@Nullable ProfileRefresherModel profileRefresherModel, ProfileRefresherView profileRefresherView, @Nullable ProfileRefresherHeaderFragment profileRefresherHeaderFragment, boolean z) {
        Object obj = 1;
        if (!z && (profileRefresherModel == null || !(profileRefresherModel.m1031e() == GraphQLProfileWizardStepType.PROFILE_PICTURE || profileRefresherModel.m1031e() == GraphQLProfileWizardStepType.COVER_PHOTO))) {
            obj = null;
        }
        if (!(obj == null || profileRefresherView.f1051k == null || profileRefresherView.f1051k.getVisibility() != 8)) {
            profileRefresherView.f1051k.setVisibility(0);
            m1184c(profileRefresherView.f1051k, (float) profileRefresherView.f1051k.getHeight(), null);
        }
        final ProfileRefresherModel profileRefresherModel2 = profileRefresherModel;
        final ProfileRefresherHeaderFragment profileRefresherHeaderFragment2 = profileRefresherHeaderFragment;
        final boolean z2 = z;
        final ProfileRefresherView profileRefresherView2 = profileRefresherView;
        AnimatorListener c01091 = new AnimatorListenerAdapter(this) {
            final /* synthetic */ ProfileRefresherAnimationHelper f1100e;

            public void onAnimationEnd(Animator animator) {
                View view;
                if (profileRefresherModel2 != null) {
                    profileRefresherModel2.f1023k = profileRefresherModel2.m1031e();
                }
                if (profileRefresherHeaderFragment2 != null && profileRefresherHeaderFragment2.at().getVisibility() == 8) {
                    profileRefresherHeaderFragment2.at().setVisibility(0);
                }
                ProfileRefresherAnimationHelper profileRefresherAnimationHelper = this.f1100e;
                if (z2) {
                    view = profileRefresherView2.f1053m;
                } else {
                    view = profileRefresherView2.f1052l.m1038b(profileRefresherModel2.m1031e()).T;
                }
                profileRefresherAnimationHelper.m1184c(view, 100.0f, null);
            }
        };
        View view = profileRefresherView.f1054n;
        view.setTranslationX((float) profileRefresherView.f1054n.getWidth());
        view.setAlpha(0.0f);
        view.animate().translationX(0.0f).alpha(1.0f).setInterpolator(this.f1101a).setListener(c01091);
    }
}
