package com.facebook.feed.thirdparty.instagram;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.model.GraphQLStory;
import javax.annotation.Nullable;

/* compiled from: should_rebuild_sections */
class InstagramUtils$InstagramClickEvent extends HoneyClientEvent {
    public InstagramUtils$InstagramClickEvent(InstagramEntryPoint instagramEntryPoint, @Nullable GraphQLStory graphQLStory, @Nullable String str) {
        super("link_click");
        this.c = "instagram_fb";
        b("type", instagramEntryPoint.getType());
        if (graphQLStory != null) {
            b("story_id", graphQLStory.c());
        }
        b("instagram_url", str);
    }
}
