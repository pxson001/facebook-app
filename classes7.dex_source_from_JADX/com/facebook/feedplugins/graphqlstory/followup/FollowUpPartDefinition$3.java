package com.facebook.feedplugins.graphqlstory.followup;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: StandardCoverPhotoView.bindModel */
class FollowUpPartDefinition$3 implements OnClickListener {
    final /* synthetic */ InstagramEntryPoint f23152a;
    final /* synthetic */ GraphQLStory f23153b;
    final /* synthetic */ FollowUpPartDefinition f23154c;

    FollowUpPartDefinition$3(FollowUpPartDefinition followUpPartDefinition, InstagramEntryPoint instagramEntryPoint, GraphQLStory graphQLStory) {
        this.f23154c = followUpPartDefinition;
        this.f23152a = instagramEntryPoint;
        this.f23153b = graphQLStory;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 597034700);
        this.f23154c.i.a(view.getContext(), this.f23152a, this.f23153b);
        Logger.a(2, EntryType.UI_INPUT_END, 933482169, a);
    }
}
