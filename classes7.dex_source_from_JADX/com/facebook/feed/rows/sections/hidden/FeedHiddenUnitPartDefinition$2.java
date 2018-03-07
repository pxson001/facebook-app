package com.facebook.feed.rows.sections.hidden;

import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;

/* compiled from: Unable to provide an image due to stuck input/output */
public class FeedHiddenUnitPartDefinition$2 implements Runnable {
    final /* synthetic */ NegativeFeedbackActionsUnit f21433a;
    final /* synthetic */ FeedHiddenUnitPartDefinition$State f21434b;
    final /* synthetic */ FeedHiddenUnitPartDefinition f21435c;

    public FeedHiddenUnitPartDefinition$2(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State) {
        this.f21435c = feedHiddenUnitPartDefinition;
        this.f21433a = negativeFeedbackActionsUnit;
        this.f21434b = feedHiddenUnitPartDefinition$State;
    }

    public void run() {
        this.f21435c.d.a(new StoryVisibilityEvent(this.f21433a.g(), null, null, StoryVisibility.HIDDEN, FeedHiddenUnitPartDefinition.a(this.f21435c, this.f21434b)));
    }
}
