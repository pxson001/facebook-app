package com.facebook.feedplugins.graphqlstory.followup;

import com.facebook.feed.environment.HasInvalidate;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: StandardCoverPhotoView.bindModel */
class FollowUpPartDefinition$6 implements Runnable {
    final /* synthetic */ HasInvalidate f23161a;
    final /* synthetic */ GraphQLStory f23162b;
    final /* synthetic */ FollowUpPartDefinition f23163c;

    FollowUpPartDefinition$6(FollowUpPartDefinition followUpPartDefinition, HasInvalidate hasInvalidate, GraphQLStory graphQLStory) {
        this.f23163c = followUpPartDefinition;
        this.f23161a = hasInvalidate;
        this.f23162b = graphQLStory;
    }

    public void run() {
        this.f23161a.a(new Object[]{this.f23162b});
    }
}
