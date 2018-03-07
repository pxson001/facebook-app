package com.facebook.feed.model;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;

/* compiled from: last_state_change_time */
public class ClientFeedUnitEdgeStoryTypeClassifier {
    private static final Class<ClientFeedUnitEdgeStoryTypeClassifier> f17877a = ClientFeedUnitEdgeStoryTypeClassifier.class;

    public static String m25093a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        if (graphQLFeedUnitEdge.X_() == 0.0d) {
            return "Ad";
        }
        FeedUnit c = graphQLFeedUnitEdge.mo2540c();
        if (c instanceof Sponsorable) {
            SponsoredImpression ab_ = ((Sponsorable) c).ab_();
            if (ab_ != null && ab_.mo3121k()) {
                return "Ad";
            }
        }
        if ((c instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnit) || (c instanceof GraphQLPeopleYouMayKnowFeedUnit) || (c instanceof GraphQLPagesYouMayLikeFeedUnit) || (c instanceof GraphQLGroupsYouShouldJoinFeedUnit) || (c instanceof GraphQLStorySet)) {
            return "Ad";
        }
        StringBuilder stringBuilder;
        if (c instanceof GraphQLStory) {
            GraphQLStory graphQLStory = (GraphQLStory) c;
            if (graphQLStory.m22349b() == null || graphQLStory.m22349b().isEmpty()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("FeedUnit GraphQLStory does not have any actors.  Id:");
                stringBuilder.append(((GraphQLStory) c).m22350c());
                BLog.c(f17877a, stringBuilder.toString());
                return "Unknown";
            }
            return "Page".equals(((GraphQLActor) graphQLStory.m22349b().get(0)).m23790b().m22299e()) ? "Page" : "User";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("FeedUnit is not GraphQLStory so can't extract actors.FeedUnitType:");
            stringBuilder.append(c.getType().m22299e());
            BLog.a(f17877a, stringBuilder.toString());
            return "Unknown";
        }
    }
}
