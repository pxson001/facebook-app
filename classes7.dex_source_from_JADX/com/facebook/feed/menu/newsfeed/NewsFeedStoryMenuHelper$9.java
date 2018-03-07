package com.facebook.feed.menu.newsfeed;

import com.facebook.feed.protocol.FetchCurationFlowGraphQLModels.FetchCurationFlowModel.FeedCurationFlowStepModel;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$9 implements FutureCallback<FeedCurationFlowStepModel> {
    final /* synthetic */ NegativeFeedbackActionsUnit f19485a;
    final /* synthetic */ NewsFeedStoryMenuHelper f19486b;

    public NewsFeedStoryMenuHelper$9(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, NegativeFeedbackActionsUnit negativeFeedbackActionsUnit) {
        this.f19486b = newsFeedStoryMenuHelper;
        this.f19485a = negativeFeedbackActionsUnit;
    }

    public void onSuccess(Object obj) {
        this.f19486b.c.a(new ChangeRendererEvent());
    }

    public void onFailure(Throwable th) {
        this.f19486b.y.a(NewsFeedStoryMenuHelper.o, "fetch curation flow failed", th);
        this.f19486b.c.a(new StoryVisibilityEvent(this.f19485a.g(), null, null, StoryVisibility.GONE, this.f19485a.p()));
        this.f19486b.c.a(new ChangeRendererEvent());
    }
}
