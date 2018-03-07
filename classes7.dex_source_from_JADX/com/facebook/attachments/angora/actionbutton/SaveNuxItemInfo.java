package com.facebook.attachments.angora.actionbutton;

import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.nux.interstitial.SaveNuxBubbleDelegate.NuxItemInfo;
import com.google.common.base.Preconditions;

/* compiled from: user_group_commerce_post_to_marketplace_state */
public class SaveNuxItemInfo implements NuxItemInfo {
    private final GraphQLStoryActionLink f878a;

    public SaveNuxItemInfo(GraphQLStoryActionLink graphQLStoryActionLink) {
        Preconditions.checkNotNull(graphQLStoryActionLink);
        Preconditions.checkNotNull(graphQLStoryActionLink.J());
        Preconditions.checkArgument(graphQLStoryActionLink.a().g() == -908457779);
        this.f878a = graphQLStoryActionLink;
    }

    public final boolean m868a() {
        return this.f878a.J().jn() == GraphQLSavedState.SAVED;
    }

    public final String m869b() {
        return "native_newsfeed";
    }

    public final String m870c() {
        return this.f878a.J().dp();
    }

    public final String m871d() {
        return this.f878a.J().gK().b();
    }

    public final CurationSurface m872e() {
        return CurationSurface.NATIVE_STORY;
    }

    public final CurationMechanism m873f() {
        return CurationMechanism.SAVED_ADD;
    }
}
