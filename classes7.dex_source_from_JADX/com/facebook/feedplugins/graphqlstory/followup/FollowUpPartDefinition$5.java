package com.facebook.feedplugins.graphqlstory.followup;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLArticleChainingFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;

/* compiled from: StandardCoverPhotoView.bindModel */
class FollowUpPartDefinition$5 implements OnClickListener {
    final /* synthetic */ GraphQLStory f23158a;
    final /* synthetic */ HasInvalidate f23159b;
    final /* synthetic */ FollowUpPartDefinition f23160c;

    FollowUpPartDefinition$5(FollowUpPartDefinition followUpPartDefinition, GraphQLStory graphQLStory, HasInvalidate hasInvalidate) {
        this.f23160c = followUpPartDefinition;
        this.f23158a = graphQLStory;
        this.f23159b = hasInvalidate;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1499135782);
        Object a2 = FollowUpPartDefinition.a(this.f23160c, view);
        if (a2 == null) {
            RuntimeException runtimeException = new RuntimeException("Unable to find HScrollChainingView.");
            Logger.a(2, EntryType.UI_INPUT_END, -1362960562, a);
            throw runtimeException;
        }
        GraphQLArticleChainingFeedUnit graphQLArticleChainingFeedUnit = (GraphQLArticleChainingFeedUnit) PropertyHelper.b(this.f23158a);
        ((HasMenuButtonProvider) this.f23159b).e().a(FeedProps.a((GraphQLStoryAttachment) ItemListFeedUnitImpl.a(graphQLArticleChainingFeedUnit).get(a2.f21842a.k), ImmutableList.of(graphQLArticleChainingFeedUnit, this.f23158a)), a2);
        LogUtils.a(-385346520, a);
    }
}
