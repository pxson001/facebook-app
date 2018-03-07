package com.facebook.feedplugins.goodwill;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotedStoriesConnection;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.google.common.collect.ImmutableList;

/* compiled from: goodfriends_picker_select */
public class ThrowbackPromotionFeedUnitToStoryConverter {
    public static FeedProps<GraphQLStory> m14393a(FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps) {
        GraphQLStory graphQLStory;
        Builder a;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        GraphQLGoodwillThrowbackPromotedStoriesConnection E = graphQLGoodwillThrowbackPromotionFeedUnit.E();
        if (E == null || E.a() == null || E.a().isEmpty()) {
            graphQLStory = null;
        } else {
            GraphQLStoryActionLink.Builder builder = new GraphQLStoryActionLink.Builder();
            GraphQLObjectType.Builder builder2 = new GraphQLObjectType.Builder();
            builder2.a = -301083314;
            builder.aP = builder2.a();
            graphQLStory = (GraphQLStory) E.a().get(0);
            ImmutableList b = ImmutableList.builder().b(StoryActionLinkHelper.a(graphQLStory)).c(builder.a()).b();
            a = Builder.a(graphQLStory);
            a.d = b;
            graphQLStory = a.a();
            PropertyHelper.a(graphQLStory, null);
        }
        Builder builder3 = new Builder();
        builder3.o = graphQLGoodwillThrowbackPromotionFeedUnit.g();
        builder3 = builder3;
        builder3.ay = graphQLGoodwillThrowbackPromotionFeedUnit.I();
        builder3 = builder3;
        GraphQLTextWithEntities.Builder builder4 = new GraphQLTextWithEntities.Builder();
        builder4.i = Integer.toString(graphQLGoodwillThrowbackPromotionFeedUnit.L());
        builder3.am = builder4.a();
        builder3 = builder3;
        builder3.l = graphQLStory;
        a = builder3;
        a.aC = graphQLGoodwillThrowbackPromotionFeedUnit.k();
        return feedProps.b(a.a());
    }
}
