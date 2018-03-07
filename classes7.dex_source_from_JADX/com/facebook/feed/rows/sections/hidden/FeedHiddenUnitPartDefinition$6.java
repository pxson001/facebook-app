package com.facebook.feed.rows.sections.hidden;

import android.view.View;
import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel.FeedCurationFlowStepModel;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitAnimationHelper;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitView;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: Unable to provide an image due to stuck input/output */
class FeedHiddenUnitPartDefinition$6 implements FutureCallback<FeedCurationFlowStepModel> {
    final /* synthetic */ FeedHiddenUnitView f21447a;
    final /* synthetic */ FeedProps f21448b;
    final /* synthetic */ FeedHiddenUnitPartDefinition$State f21449c;
    final /* synthetic */ FeedHiddenUnitPartDefinition f21450d;

    FeedHiddenUnitPartDefinition$6(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, FeedHiddenUnitView feedHiddenUnitView, FeedProps feedProps, FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State) {
        this.f21450d = feedHiddenUnitPartDefinition;
        this.f21447a = feedHiddenUnitView;
        this.f21448b = feedProps;
        this.f21449c = feedHiddenUnitPartDefinition$State;
    }

    public void onSuccess(Object obj) {
        FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition = this.f21450d;
        FeedHiddenUnitView feedHiddenUnitView = this.f21447a;
        FeedProps feedProps = this.f21448b;
        feedHiddenUnitView.m24142a(new FeedHiddenUnitPartDefinition$7(feedHiddenUnitPartDefinition, feedHiddenUnitView, this.f21449c, feedProps, feedHiddenUnitView.getHeight()));
    }

    public void onFailure(Throwable th) {
        FeedHiddenUnitPartDefinition.a(this.f21450d, this.f21447a.getContext());
        FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition = this.f21450d;
        FeedHiddenUnitView feedHiddenUnitView = this.f21447a;
        FeedProps feedProps = this.f21448b;
        FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State = this.f21449c;
        feedHiddenUnitView.m24144e();
        FeedHiddenUnitPartDefinition.a(feedHiddenUnitPartDefinition, feedHiddenUnitView, feedHiddenUnitPartDefinition$State, feedProps);
        feedHiddenUnitView.f21480d.setVisibility(0);
        FeedHiddenUnitAnimationHelper feedHiddenUnitAnimationHelper = feedHiddenUnitView.f21483g;
        View view = feedHiddenUnitView.f21480d;
        feedHiddenUnitAnimationHelper.f21473a = FeedHiddenUnitAnimationHelper.m24139a(null);
        view.startAnimation(feedHiddenUnitAnimationHelper.f21473a);
    }
}
