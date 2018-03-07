package com.facebook.feed.rows.sections.hidden;

import android.view.View;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel.FeedCurationFlowStepModel;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitAnimationHelper;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitView;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: Unable to provide an image due to stuck input/output */
public class FeedHiddenUnitPartDefinition$9 implements FutureCallback<FeedCurationFlowStepModel> {
    final /* synthetic */ FeedProps f21460a;
    final /* synthetic */ FeedHiddenUnitPartDefinition$State f21461b;
    final /* synthetic */ FeedHiddenUnitView f21462c;
    final /* synthetic */ FeedHiddenUnitPartDefinition f21463d;

    public FeedHiddenUnitPartDefinition$9(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, FeedProps feedProps, FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State, FeedHiddenUnitView feedHiddenUnitView) {
        this.f21463d = feedHiddenUnitPartDefinition;
        this.f21460a = feedProps;
        this.f21461b = feedHiddenUnitPartDefinition$State;
        this.f21462c = feedHiddenUnitView;
    }

    public void onSuccess(Object obj) {
        if (((FeedCurationFlowStepModel) obj) == null) {
            FeedHiddenUnitPartDefinition.a(this.f21463d, StoryVisibility.VISIBLE, (NegativeFeedbackActionsUnit) this.f21460a.a, this.f21461b);
            return;
        }
        FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition = this.f21463d;
        FeedHiddenUnitView feedHiddenUnitView = this.f21462c;
        FeedProps feedProps = this.f21460a;
        FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State = this.f21461b;
        feedHiddenUnitView.m24144e();
        FeedHiddenUnitPartDefinition.a(feedHiddenUnitPartDefinition, feedHiddenUnitView, feedHiddenUnitPartDefinition$State, feedProps);
        feedHiddenUnitView.f21480d.setVisibility(0);
        FeedHiddenUnitAnimationHelper feedHiddenUnitAnimationHelper = feedHiddenUnitView.f21483g;
        View view = feedHiddenUnitView.f21480d;
        feedHiddenUnitAnimationHelper.f21473a = FeedHiddenUnitAnimationHelper.m24139a(null);
        view.startAnimation(feedHiddenUnitAnimationHelper.f21473a);
    }

    public void onFailure(Throwable th) {
        FeedHiddenUnitPartDefinition.a(this.f21463d, this.f21462c.getContext());
        FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition = this.f21463d;
        FeedHiddenUnitView feedHiddenUnitView = this.f21462c;
        FeedProps feedProps = this.f21460a;
        FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State = this.f21461b;
        feedHiddenUnitView.m24144e();
        FeedHiddenUnitPartDefinition.a(feedHiddenUnitPartDefinition, feedHiddenUnitView, feedHiddenUnitPartDefinition$State, feedProps);
        feedHiddenUnitView.f21480d.setVisibility(0);
        FeedHiddenUnitAnimationHelper feedHiddenUnitAnimationHelper = feedHiddenUnitView.f21483g;
        View view = feedHiddenUnitView.f21480d;
        feedHiddenUnitAnimationHelper.f21473a = FeedHiddenUnitAnimationHelper.m24139a(null);
        view.startAnimation(feedHiddenUnitAnimationHelper.f21473a);
    }
}
