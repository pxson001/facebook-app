package com.facebook.feedplugins.graphqlstory.followup;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.chaining.HScrollChainingView;
import com.facebook.feed.ui.chaining.HScrollChainingViewController;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: StandardCoverPhotoView.bindModel */
class FollowUpPartDefinition$4 implements OnClickListener {
    final /* synthetic */ GraphQLStory f23155a;
    final /* synthetic */ FollowUpPersistentState f23156b;
    final /* synthetic */ FollowUpPartDefinition f23157c;

    FollowUpPartDefinition$4(FollowUpPartDefinition followUpPartDefinition, GraphQLStory graphQLStory, FollowUpPersistentState followUpPersistentState) {
        this.f23157c = followUpPartDefinition;
        this.f23155a = graphQLStory;
        this.f23156b = followUpPersistentState;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1101609146);
        HScrollChainingView a2 = FollowUpPartDefinition.a(this.f23157c, view);
        if (a2 == null) {
            RuntimeException runtimeException = new RuntimeException("Unable to find HScrollChainingView.");
            Logger.a(2, EntryType.UI_INPUT_END, -237277382, a);
            throw runtimeException;
        }
        FollowUpPartDefinition followUpPartDefinition = this.f23157c;
        HScrollChainingViewController hScrollChainingViewController = a2.f21849h;
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) PropertyHelper.b(this.f23155a);
        if (hScrollChainingViewController != null) {
            followUpPartDefinition.g.c(NewsFeedAnalyticsEventBuilder.i(hScrollChainingViewController.mo1563a(FeedProps.c(scrollableItemListFeedUnit)), null));
        }
        FollowUpPartDefinition.c(this.f23157c, this.f23155a, a2, this.f23156b);
        LogUtils.a(-194695631, a);
    }
}
