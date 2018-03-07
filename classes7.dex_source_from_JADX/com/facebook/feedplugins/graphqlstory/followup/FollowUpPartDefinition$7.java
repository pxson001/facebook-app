package com.facebook.feedplugins.graphqlstory.followup;

import android.view.animation.Animation;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.feed.ui.chaining.HScrollChainingView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.widget.listeners.BaseAnimationListener;

/* compiled from: StandardCoverPhotoView.bindModel */
class FollowUpPartDefinition$7 extends BaseAnimationListener {
    final /* synthetic */ HScrollChainingView f23164a;
    final /* synthetic */ FollowUpPersistentState f23165b;
    final /* synthetic */ GraphQLStory f23166c;
    final /* synthetic */ FollowUpPartDefinition f23167d;

    FollowUpPartDefinition$7(FollowUpPartDefinition followUpPartDefinition, HScrollChainingView hScrollChainingView, FollowUpPersistentState followUpPersistentState, GraphQLStory graphQLStory) {
        this.f23167d = followUpPartDefinition;
        this.f23164a = hScrollChainingView;
        this.f23165b = followUpPersistentState;
        this.f23166c = graphQLStory;
    }

    public void onAnimationEnd(Animation animation) {
        FollowUpPartDefinition followUpPartDefinition = this.f23167d;
        FollowUpPartDefinition.a(this.f23164a, this.f23165b);
        if (this.f23166c.g() != null) {
            ((FeedbackGraphQLGenerator) this.f23167d.j.get()).a(this.f23166c.g(), null);
        }
    }
}
