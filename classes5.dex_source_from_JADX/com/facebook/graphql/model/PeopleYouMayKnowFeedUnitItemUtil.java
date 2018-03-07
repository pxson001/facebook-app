package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: TV_ONE_TIME */
public class PeopleYouMayKnowFeedUnitItemUtil {
    public static GraphQLFriendshipStatus m22567a(PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem) {
        if (peopleYouMayKnowFeedUnitItem instanceof GraphQLPeopleYouMayKnowFeedUnitItem) {
            return ((GraphQLPeopleYouMayKnowFeedUnitItem) peopleYouMayKnowFeedUnitItem).m20682m().M();
        }
        if (peopleYouMayKnowFeedUnitItem instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) {
            return ((GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) peopleYouMayKnowFeedUnitItem).m().M();
        }
        throw new RuntimeException("Calling getFriendshipStatus with wrong type" + peopleYouMayKnowFeedUnitItem.getClass().getSimpleName());
    }
}
