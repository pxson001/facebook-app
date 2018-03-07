package com.facebook.feedplugins.graphqlstory.seefirsttombstone;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.Location;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.NewStatus;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: ScheduleDispatchFrameCallback */
class SeeFirstTombstonePartDefinition$2 extends ClickableSpan {
    final /* synthetic */ GraphQLStory f23372a;
    final /* synthetic */ SeeFirstTombstonePersistentState f23373b;
    final /* synthetic */ HasInvalidate f23374c;
    final /* synthetic */ SeeFirstTombstonePartDefinition f23375d;

    SeeFirstTombstonePartDefinition$2(SeeFirstTombstonePartDefinition seeFirstTombstonePartDefinition, GraphQLStory graphQLStory, SeeFirstTombstonePersistentState seeFirstTombstonePersistentState, HasInvalidate hasInvalidate) {
        this.f23375d = seeFirstTombstonePartDefinition;
        this.f23372a = graphQLStory;
        this.f23373b = seeFirstTombstonePersistentState;
        this.f23374c = hasInvalidate;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        SeeFirstTombstonePartDefinition seeFirstTombstonePartDefinition = this.f23375d;
        GraphQLStory graphQLStory = this.f23372a;
        String str = this.f23373b.b;
        HasInvalidate hasInvalidate = this.f23374c;
        ((FriendingClient) seeFirstTombstonePartDefinition.c.get()).a(String.valueOf(str), NewStatus.SEE_FIRST, Location.FEED_X_UNDO);
        SeeFirstTombstonePersistentState seeFirstTombstonePersistentState = (SeeFirstTombstonePersistentState) ((HasPersistentState) hasInvalidate).a(new SeeFirstTombstoneStoryKey(graphQLStory), graphQLStory);
        seeFirstTombstonePersistentState.a(null);
        seeFirstTombstonePersistentState.d = false;
        hasInvalidate.hL_();
    }
}
