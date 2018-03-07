package com.facebook.feedplugins.goodwill;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaignFeedUnit;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: gravity_search_null_state_click */
public class AnniversaryCampaignFeedUnitToStoryConverter {
    public static FeedProps<GraphQLStory> m14114a(@Nullable FeedProps<GraphQLGoodwillAnniversaryCampaignFeedUnit> feedProps) {
        if (feedProps == null) {
            return null;
        }
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = (GraphQLGoodwillAnniversaryCampaignFeedUnit) feedProps.a;
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.l() == null) {
            return null;
        }
        Builder builder = new Builder();
        String n = graphQLGoodwillAnniversaryCampaignFeedUnit.n();
        if (n == null || !n.equals("anniversary_video")) {
            builder.r = graphQLGoodwillAnniversaryCampaignFeedUnit.l().r();
        } else if (graphQLGoodwillAnniversaryCampaignFeedUnit.l().j() == null || graphQLGoodwillAnniversaryCampaignFeedUnit.l().j().isEmpty()) {
            GraphQLMedia.Builder builder2 = new GraphQLMedia.Builder();
            builder2.N = graphQLGoodwillAnniversaryCampaignFeedUnit.l().t();
            GraphQLMedia a = builder2.a();
            Builder builder3 = new Builder();
            builder3.l = a;
            builder.r = ImmutableList.of(builder3.a());
        } else {
            builder.r = graphQLGoodwillAnniversaryCampaignFeedUnit.l().j();
        }
        GraphQLStory.Builder builder4 = new GraphQLStory.Builder();
        builder4.o = graphQLGoodwillAnniversaryCampaignFeedUnit.g();
        builder4 = builder4;
        builder4.ay = graphQLGoodwillAnniversaryCampaignFeedUnit.l().o();
        GraphQLStory.Builder builder5 = builder4;
        builder5.m = ImmutableList.of(builder.a());
        return feedProps.b(builder5.a());
    }
}
