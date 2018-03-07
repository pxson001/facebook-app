package com.facebook.feed.rows.sections.hidden;

import android.view.animation.Animation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitView;
import com.facebook.widget.listeners.BaseAnimationListener;

/* compiled from: Unable to provide an image due to stuck input/output */
public class FeedHiddenUnitPartDefinition$8 extends BaseAnimationListener {
    final /* synthetic */ FeedHiddenUnitView f21456a;
    final /* synthetic */ FeedProps f21457b;
    final /* synthetic */ FeedHiddenUnitPartDefinition$State f21458c;
    final /* synthetic */ FeedHiddenUnitPartDefinition f21459d;

    public FeedHiddenUnitPartDefinition$8(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, FeedHiddenUnitView feedHiddenUnitView, FeedProps feedProps, FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State) {
        this.f21459d = feedHiddenUnitPartDefinition;
        this.f21456a = feedHiddenUnitView;
        this.f21457b = feedProps;
        this.f21458c = feedHiddenUnitPartDefinition$State;
    }

    public void onAnimationEnd(Animation animation) {
        this.f21456a.setHeight(this.f21456a.getMeasuredHeight());
        this.f21456a.m24141a();
        FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition = this.f21459d;
        FeedHiddenUnitView feedHiddenUnitView = this.f21456a;
        FeedProps feedProps = this.f21457b;
        feedHiddenUnitPartDefinition.e.a(feedProps, new FeedHiddenUnitPartDefinition$9(feedHiddenUnitPartDefinition, feedProps, this.f21458c, feedHiddenUnitView));
    }
}
