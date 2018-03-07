package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLFriendLocationCategory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;

/* compiled from: de */
public class ScrollableItemListFeedUnitImpl {
    private static final ImmutableSet<GraphQLFriendLocationCategory> f14183a = ImmutableSet.of(GraphQLFriendLocationCategory.PRESENCE, GraphQLFriendLocationCategory.APPROXIMATE_LOCATION, GraphQLFriendLocationCategory.CHECKIN, GraphQLFriendLocationCategory.CURRENT_CITY, GraphQLFriendLocationCategory.PULSE);

    public static ImmutableList<InstagramPhotosFromFriendsPhoto> m14988a(GraphQLInstagramPhotosFromFriendsFeedUnit graphQLInstagramPhotosFromFriendsFeedUnit) {
        Builder builder = new Builder();
        ImmutableList o = graphQLInstagramPhotosFromFriendsFeedUnit.o();
        int size = o.size();
        for (int i = 0; i < size; i++) {
            GraphQLInstagramPhotosFromFriendsFeedUnitItem graphQLInstagramPhotosFromFriendsFeedUnitItem = (GraphQLInstagramPhotosFromFriendsFeedUnitItem) o.get(i);
            ImmutableList a = graphQLInstagramPhotosFromFriendsFeedUnitItem.a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                builder.c(new InstagramPhotosFromFriendsPhoto((GraphQLPhoto) a.get(i2), graphQLInstagramPhotosFromFriendsFeedUnit.k(), graphQLInstagramPhotosFromFriendsFeedUnitItem.k()));
            }
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLMobilePageAdminPanelFeedUnitItem> m14989a(GraphQLMobilePageAdminPanelFeedUnit graphQLMobilePageAdminPanelFeedUnit) {
        return graphQLMobilePageAdminPanelFeedUnit.p();
    }

    public static ImmutableList<GraphQLFriendLocationFeedUnitItem> m14985a(GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit) {
        Builder builder = ImmutableList.builder();
        ImmutableList q = graphQLFriendsLocationsFeedUnit.q();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem = (GraphQLFriendLocationFeedUnitItem) q.get(i);
            if (f14183a.contains(graphQLFriendLocationFeedUnitItem.m())) {
                builder.c(graphQLFriendLocationFeedUnitItem);
            }
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLSavedCollectionFeedUnitItem> m14995a(GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit) {
        Builder builder = new Builder();
        ImmutableList a = SavedCollectionFeedUnitHelper.a(graphQLSavedCollectionFeedUnit);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem = (GraphQLSavedCollectionFeedUnitItem) a.get(i);
            if (IsValidUtil.a(graphQLSavedCollectionFeedUnitItem)) {
                builder.c(graphQLSavedCollectionFeedUnitItem);
            }
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> m14993a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit graphQLQuickPromotionPeopleYouMayKnowFeedUnit) {
        Builder builder = new Builder();
        ImmutableList a = ItemListFeedUnitImpl.a(graphQLQuickPromotionPeopleYouMayKnowFeedUnit);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem = (GraphQLPeopleYouMayKnowFeedUnitItem) a.get(i);
            if (IsValidUtil.a(graphQLPeopleYouMayKnowFeedUnitItem)) {
                builder.c(graphQLPeopleYouMayKnowFeedUnitItem);
            }
        }
        return builder.b();
    }

    public static ImmutableList<SuggestedPageUnitItem> m14984a(GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit) {
        Builder builder = new Builder();
        ImmutableList x = graphQLCreativePagesYouMayLikeFeedUnit.x();
        int size = x.size();
        for (int i = 0; i < size; i++) {
            GraphQLCreativePagesYouMayLikeFeedUnitItem graphQLCreativePagesYouMayLikeFeedUnitItem = (GraphQLCreativePagesYouMayLikeFeedUnitItem) x.get(i);
            if (IsValidUtil.a(graphQLCreativePagesYouMayLikeFeedUnitItem)) {
                builder.c(graphQLCreativePagesYouMayLikeFeedUnitItem);
            }
        }
        return builder.b();
    }

    public static ImmutableList<SuggestedPageUnitItem> m14991a(GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit) {
        Builder builder = new Builder();
        ImmutableList t = graphQLPagesYouMayLikeFeedUnit.t();
        int size = t.size();
        for (int i = 0; i < size; i++) {
            GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem = (GraphQLPagesYouMayLikeFeedUnitItem) t.get(i);
            if (IsValidUtil.a(graphQLPagesYouMayLikeFeedUnitItem)) {
                builder.c(graphQLPagesYouMayLikeFeedUnitItem);
            }
        }
        if (graphQLPagesYouMayLikeFeedUnit.x() != null) {
            builder.c(new SuggestedPageUnitEndItem());
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLGroupsYouShouldJoinFeedUnitItem> m14987a(GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit) {
        ImmutableList immutableList = graphQLGroupsYouShouldJoinFeedUnit.s().c;
        ImmutableList a = ItemListFeedUnitImpl.a(graphQLGroupsYouShouldJoinFeedUnit);
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem = (GraphQLGroupsYouShouldJoinFeedUnitItem) a.get(i);
            GraphQLGroup m = graphQLGroupsYouShouldJoinFeedUnitItem.m();
            if (IsValidUtil.a(graphQLGroupsYouShouldJoinFeedUnitItem) && m != null && (immutableList == null || !immutableList.contains(m.I()))) {
                builder.c(graphQLGroupsYouShouldJoinFeedUnitItem);
            }
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> m14992a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit) {
        ImmutableList immutableList = graphQLPaginatedGroupsYouShouldJoinFeedUnit.u().c;
        ImmutableList a = ItemListFeedUnitImpl.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit);
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) a.get(i);
            GraphQLGroup l = graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.l();
            if (IsValidUtil.a(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) && l != null && (immutableList == null || !immutableList.contains(l.I()))) {
                builder.c(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge);
            }
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLStory> m14986a(GraphQLGroupTopStoriesFeedUnit graphQLGroupTopStoriesFeedUnit) {
        ImmutableList a = ItemListFeedUnitImpl.a(graphQLGroupTopStoriesFeedUnit);
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLGroupTopStoriesFeedUnitStoriesEdge graphQLGroupTopStoriesFeedUnitStoriesEdge = (GraphQLGroupTopStoriesFeedUnitStoriesEdge) a.get(i);
            if (IsValidUtil.a(graphQLGroupTopStoriesFeedUnitStoriesEdge)) {
                builder.c(graphQLGroupTopStoriesFeedUnitStoriesEdge.j());
            }
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> m14994a(GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit) {
        ImmutableList immutableList = graphQLSaleGroupsNearYouFeedUnit.u().c;
        ImmutableList a = ItemListFeedUnitImpl.a(graphQLSaleGroupsNearYouFeedUnit);
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge = (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) a.get(i);
            GraphQLGroup j = graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j();
            if (IsValidUtil.a(graphQLSaleGroupsNearYouFeedUnitGroupsEdge) && j != null && (immutableList == null || !immutableList.contains(j.I()))) {
                builder.c(graphQLSaleGroupsNearYouFeedUnitGroupsEdge);
            }
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLStory> m14990a(GraphQLPageStoriesYouMissedFeedUnit graphQLPageStoriesYouMissedFeedUnit) {
        ImmutableList a = ItemListFeedUnitImpl.a(graphQLPageStoriesYouMissedFeedUnit);
        Builder builder = new Builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPageStoriesYouMissedFeedUnitStoriesEdge graphQLPageStoriesYouMissedFeedUnitStoriesEdge = (GraphQLPageStoriesYouMissedFeedUnitStoriesEdge) a.get(i);
            if (IsValidUtil.a(graphQLPageStoriesYouMissedFeedUnitStoriesEdge)) {
                builder.c(graphQLPageStoriesYouMissedFeedUnitStoriesEdge.a());
            }
        }
        return builder.b();
    }

    public static ImmutableList<GraphQLStory> m14996a(ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        if (scrollableItemListFeedUnit instanceof GraphQLPageStoriesYouMissedFeedUnit) {
            return m14990a((GraphQLPageStoriesYouMissedFeedUnit) scrollableItemListFeedUnit);
        }
        if (scrollableItemListFeedUnit instanceof GraphQLGroupTopStoriesFeedUnit) {
            return m14986a((GraphQLGroupTopStoriesFeedUnit) scrollableItemListFeedUnit);
        }
        throw new IllegalAccessError("This should not be called for base class object");
    }
}
