package com.facebook.feedplugins.graphqlstory.followup;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;

/* compiled from: StandardCoverPhotoView.bindModel */
class FollowUpPartDefinition$2 extends SimpleOnPageChangeListener {
    final /* synthetic */ GraphQLStory f23150a;
    final /* synthetic */ FollowUpPartDefinition f23151b;

    FollowUpPartDefinition$2(FollowUpPartDefinition followUpPartDefinition, GraphQLStory graphQLStory) {
        this.f23151b = followUpPartDefinition;
        this.f23150a = graphQLStory;
    }

    public final void e_(int i) {
        this.f23151b.c.a((ScrollableItemListFeedUnit) PropertyHelper.b(this.f23150a), i);
    }
}
