package com.facebook.feed.rows.sections.hidden;

import android.view.animation.Animation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitView;
import com.facebook.widget.listeners.BaseAnimationListener;

/* compiled from: Unable to provide an image due to stuck input/output */
public class FeedHiddenUnitPartDefinition$7 extends BaseAnimationListener {
    final /* synthetic */ FeedHiddenUnitView f21451a;
    final /* synthetic */ FeedHiddenUnitPartDefinition$State f21452b;
    final /* synthetic */ FeedProps f21453c;
    final /* synthetic */ int f21454d;
    final /* synthetic */ FeedHiddenUnitPartDefinition f21455e;

    public FeedHiddenUnitPartDefinition$7(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, FeedHiddenUnitView feedHiddenUnitView, FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State, FeedProps feedProps, int i) {
        this.f21455e = feedHiddenUnitPartDefinition;
        this.f21451a = feedHiddenUnitView;
        this.f21452b = feedHiddenUnitPartDefinition$State;
        this.f21453c = feedProps;
        this.f21454d = i;
    }

    public void onAnimationStart(Animation animation) {
        this.f21451a.setEnabled(false);
    }

    public void onAnimationEnd(Animation animation) {
        FeedHiddenUnitPartDefinition.a(this.f21455e, this.f21451a, this.f21452b, this.f21453c);
        this.f21451a.m24143b(this.f21454d, this.f21451a.m24145g());
    }
}
