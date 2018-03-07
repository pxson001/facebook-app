package com.facebook.goodwill.feed.rows;

import com.facebook.graphql.model.GraphQLGoodwillFriendversaryCampaign;

/* compiled from: feed_story_attachments_location */
public final class ThrowbackFeedUtils {

    /* compiled from: feed_story_attachments_location */
    public enum FriendversaryCampaignRenderStyle {
        POLAROID_V1("polaroid_v1"),
        COLLAGE_V1("collage_v1"),
        VIDEO_V1("video_v1");
        
        private final String name;

        private FriendversaryCampaignRenderStyle(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public static boolean m15330a(GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign) {
        return (graphQLGoodwillFriendversaryCampaign == null || graphQLGoodwillFriendversaryCampaign.x() == null || graphQLGoodwillFriendversaryCampaign.x().l() == null || graphQLGoodwillFriendversaryCampaign.x().l().isEmpty()) ? false : true;
    }

    public static boolean m15331b(GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign) {
        return (graphQLGoodwillFriendversaryCampaign == null || graphQLGoodwillFriendversaryCampaign.o() == null || graphQLGoodwillFriendversaryCampaign.o().isEmpty()) ? false : true;
    }
}
