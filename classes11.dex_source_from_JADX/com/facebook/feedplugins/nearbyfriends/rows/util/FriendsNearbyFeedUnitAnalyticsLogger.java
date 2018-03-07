package com.facebook.feedplugins.nearbyfriends.rows.util;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder;
import com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder.FriendsNearbyEvent;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLFriendLocationFeedUnitItem;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: com.android.calendar */
public class FriendsNearbyFeedUnitAnalyticsLogger {
    private final AnalyticsLogger f8569a;
    private final FriendsNearbyFeedUnitAnalyticsEventBuilder f8570b;

    public static FriendsNearbyFeedUnitAnalyticsLogger m9411b(InjectorLike injectorLike) {
        return new FriendsNearbyFeedUnitAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FriendsNearbyFeedUnitAnalyticsEventBuilder.a(injectorLike));
    }

    @Inject
    public FriendsNearbyFeedUnitAnalyticsLogger(AnalyticsLogger analyticsLogger, FriendsNearbyFeedUnitAnalyticsEventBuilder friendsNearbyFeedUnitAnalyticsEventBuilder) {
        this.f8569a = analyticsLogger;
        this.f8570b = friendsNearbyFeedUnitAnalyticsEventBuilder;
    }

    public final void m9413a(GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        m9410a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_SEE_ALL, graphQLFriendsLocationsFeedUnit);
    }

    public final void m9412a(GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem, GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        m9409a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_TAP_PROFILE, graphQLFriendLocationFeedUnitItem, graphQLFriendsLocationsFeedUnit);
    }

    public final void m9415b(GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem, GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        m9409a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_V2_TAP_PROFILE, graphQLFriendLocationFeedUnitItem, graphQLFriendsLocationsFeedUnit);
    }

    public final void m9417c(GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem, GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        m9409a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_V2_TAP_MAP, graphQLFriendLocationFeedUnitItem, graphQLFriendsLocationsFeedUnit);
    }

    public final void m9418d(GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem, GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        m9409a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_TAP_PROFILE_PIC, graphQLFriendLocationFeedUnitItem, graphQLFriendsLocationsFeedUnit);
    }

    public final void m9414a(GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit, boolean z) {
        m9410a(z ? FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_SCROLL_RIGHT : FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_SCROLL_LEFT, graphQLFriendsLocationsFeedUnit);
    }

    public final void m9416b(GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        m9410a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_SCROLL_NEAR_END, graphQLFriendsLocationsFeedUnit);
    }

    private void m9410a(FriendsNearbyEvent friendsNearbyEvent, GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        HoneyClientEvent a = FriendsNearbyFeedUnitAnalyticsEventBuilder.a(friendsNearbyEvent, FeedTrackableUtil.a(graphQLFriendsLocationsFeedUnit));
        if (a != null && (graphQLFriendsLocationsFeedUnit instanceof GraphQLFriendsLocationsFeedUnit)) {
            a.a("feed_type", graphQLFriendsLocationsFeedUnit.u());
        }
        this.f8569a.c(a);
    }

    private void m9409a(FriendsNearbyEvent friendsNearbyEvent, GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem, GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        HoneyClientEvent a = FriendsNearbyFeedUnitAnalyticsEventBuilder.a(friendsNearbyEvent, GraphQLHelper.a(graphQLFriendLocationFeedUnitItem, graphQLFriendsLocationsFeedUnit));
        if (a != null) {
            a.a("feed_type", graphQLFriendsLocationsFeedUnit.u());
            a.a("location_category", graphQLFriendLocationFeedUnitItem.m());
        }
        this.f8569a.c(a);
    }
}
