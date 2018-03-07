package com.facebook.feedplugins.graphqlstory.usertopictombstone;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;

/* compiled from: SYNC_CHECK_SERVER_RESPONSE_RECEIVED */
public class UserTopicTombstonePartDefinition$3 extends AbstractDisposableFutureCallback {
    final /* synthetic */ HasInvalidate f23482a;
    final /* synthetic */ NegativeFeedbackActionsUnit f23483b;
    final /* synthetic */ UserTopicTombstonePartDefinition f23484c;

    public UserTopicTombstonePartDefinition$3(UserTopicTombstonePartDefinition userTopicTombstonePartDefinition, HasInvalidate hasInvalidate, NegativeFeedbackActionsUnit negativeFeedbackActionsUnit) {
        this.f23484c = userTopicTombstonePartDefinition;
        this.f23482a = hasInvalidate;
        this.f23483b = negativeFeedbackActionsUnit;
    }

    protected final void m25754a(Object obj) {
        UserTopicTombstonePersistentState userTopicTombstonePersistentState = (UserTopicTombstonePersistentState) ((HasPersistentState) this.f23482a).a(new UserTopicTombstoneStoryKey(this.f23483b), this.f23483b);
        userTopicTombstonePersistentState.f23485a = null;
        userTopicTombstonePersistentState.f23486b = null;
        userTopicTombstonePersistentState.f23487c = null;
        userTopicTombstonePersistentState.f23488d = null;
        this.f23484c.f.a(this.f23483b, false);
        this.f23484c.d.a(new StoryVisibilityEvent(this.f23483b.g(), null, null, StoryVisibility.VISIBLE, this.f23483b.p()));
        this.f23484c.d.a(new ChangeRendererEvent());
    }

    protected final void m25755a(Throwable th) {
        this.f23484c.c.a(UserTopicTombstonePartDefinition.b, "unhide topic from user failed", th);
    }
}
