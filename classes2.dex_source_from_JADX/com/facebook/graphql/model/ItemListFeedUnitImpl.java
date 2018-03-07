package com.facebook.graphql.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;

/* compiled from: gl_ES */
public class ItemListFeedUnitImpl {
    public static ImmutableList<GraphQLStoryAttachment> m30137a(GraphQLArticleChainingFeedUnit graphQLArticleChainingFeedUnit) {
        if (graphQLArticleChainingFeedUnit.m27279r() != null) {
            return graphQLArticleChainingFeedUnit.m27279r().a();
        }
        return RegularImmutableList.f535a;
    }

    public static ImmutableList<GraphQLCelebrationsFeedUnitItem> m30138a(GraphQLCelebrationsFeedUnit graphQLCelebrationsFeedUnit) {
        return graphQLCelebrationsFeedUnit.m27319o();
    }

    public static ImmutableList<GraphQLStoryAttachment> m30139a(GraphQLEventCollectionFeedUnit graphQLEventCollectionFeedUnit) {
        if (graphQLEventCollectionFeedUnit.q() != null) {
            return graphQLEventCollectionFeedUnit.q().a();
        }
        return RegularImmutableList.f535a;
    }

    public static ImmutableList<GraphQLGroupTopStoriesFeedUnitStoriesEdge> m30140a(GraphQLGroupTopStoriesFeedUnit graphQLGroupTopStoriesFeedUnit) {
        GraphQLGroupTopStoriesFeedUnitStoriesConnection l = graphQLGroupTopStoriesFeedUnit.m25484l();
        return l != null ? l.a() : RegularImmutableList.f535a;
    }

    public static ImmutableList<GraphQLPeopleYouShouldFollowFeedUnitItem> m30149a(GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit) {
        return graphQLPeopleYouShouldFollowFeedUnit.m25810q().a();
    }

    public static ImmutableList<GraphQLPlaceReviewFeedUnitItem> m30150a(GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit) {
        ImmutableList immutableList = graphQLPlaceReviewFeedUnit.m25917q().f20930a;
        if (immutableList == null) {
            return graphQLPlaceReviewFeedUnit.m25913l();
        }
        Builder builder = ImmutableList.builder();
        ImmutableList l = graphQLPlaceReviewFeedUnit.m25913l();
        int size = l.size();
        for (int i = 0; i < size; i++) {
            GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem = (GraphQLPlaceReviewFeedUnitItem) l.get(i);
            if (immutableList.contains(graphQLPlaceReviewFeedUnitItem.l().ae())) {
                builder.m1069c(graphQLPlaceReviewFeedUnitItem);
            }
        }
        return builder.m1068b();
    }

    public static ImmutableList<GraphQLSocialWifiFeedUnitItem> m30154a(GraphQLSocialWifiFeedUnit graphQLSocialWifiFeedUnit) {
        return graphQLSocialWifiFeedUnit.m29854p();
    }

    public static ImmutableList<GraphQLActor> m30156a(GraphQLUnseenStoriesFeedUnit graphQLUnseenStoriesFeedUnit) {
        GraphQLActor o = graphQLUnseenStoriesFeedUnit.o();
        if (o == null) {
            return RegularImmutableList.f535a;
        }
        return ImmutableList.of(o);
    }

    public static ImmutableList<GraphQLResearchPollMultipleChoiceQuestion> m30152a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit) {
        GraphQLResearchPollSurvey H = graphQLResearchPollFeedUnit.m25861H();
        Preconditions.checkNotNull(H);
        Preconditions.checkNotNull(H.m());
        return H.m();
    }

    public static ImmutableList<GraphQLStoryAttachment> m30157a(GraphQLVideoChainingFeedUnit graphQLVideoChainingFeedUnit) {
        if (graphQLVideoChainingFeedUnit.m27300r() != null) {
            return graphQLVideoChainingFeedUnit.m27300r().a();
        }
        return RegularImmutableList.f535a;
    }

    public static ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> m30148a(GraphQLPeopleYouMayKnowFeedUnit graphQLPeopleYouMayKnowFeedUnit) {
        ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> z = graphQLPeopleYouMayKnowFeedUnit.m27263z();
        return !z.isEmpty() ? z : graphQLPeopleYouMayKnowFeedUnit.m27229E();
    }

    public static ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> m30151a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit graphQLQuickPromotionPeopleYouMayKnowFeedUnit) {
        ImmutableList<GraphQLPeopleYouMayKnowFeedUnitItem> o = graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m25717o();
        return !o.isEmpty() ? o : graphQLQuickPromotionPeopleYouMayKnowFeedUnit.m25717o();
    }

    public static ImmutableList<GraphQLIncomingFriendRequestFeedUnitItem> m30142a(GraphQLIncomingFriendRequestFeedUnit graphQLIncomingFriendRequestFeedUnit) {
        ImmutableList<GraphQLIncomingFriendRequestFeedUnitItem> o = graphQLIncomingFriendRequestFeedUnit.o();
        return !o.isEmpty() ? o : graphQLIncomingFriendRequestFeedUnit.o();
    }

    public static ImmutableList m30143a(GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit) {
        Builder builder = new Builder();
        GraphQLPYMLWithLargeImageFeedUnitsConnection B = graphQLPYMLWithLargeImageFeedUnit.m25730B();
        if (B != null) {
            ImmutableList a = B.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLPYMLWithLargeImageFeedUnitsEdge graphQLPYMLWithLargeImageFeedUnitsEdge = (GraphQLPYMLWithLargeImageFeedUnitsEdge) a.get(i);
                if (graphQLPYMLWithLargeImageFeedUnitsEdge.a() != null && IsValidUtil.m22951a(graphQLPYMLWithLargeImageFeedUnitsEdge.a())) {
                    builder.m1069c(graphQLPYMLWithLargeImageFeedUnitsEdge.a());
                }
            }
        }
        return builder.m1068b();
    }

    public static ImmutableList<GraphQLGroupsYouShouldJoinFeedUnitItem> m30141a(GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit) {
        ImmutableList<GraphQLGroupsYouShouldJoinFeedUnitItem> p = graphQLGroupsYouShouldJoinFeedUnit.m25283p();
        return (p == null || p.isEmpty()) ? graphQLGroupsYouShouldJoinFeedUnit.m25280l() : p;
    }

    public static ImmutableList<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> m30145a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit) {
        GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection o = graphQLPaginatedGroupsYouShouldJoinFeedUnit.m25300o();
        return o != null ? o.m23858a() : RegularImmutableList.f535a;
    }

    public static ImmutableList<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> m30153a(GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit) {
        GraphQLSaleGroupsNearYouFeedUnitGroupsConnection o = graphQLSaleGroupsNearYouFeedUnit.m25941o();
        return o != null ? o.m23862a() : RegularImmutableList.f535a;
    }

    public static ImmutableList<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> m30146a(GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection o = graphQLPaginatedPeopleYouMayKnowFeedUnit.m25696o();
        if (o == null) {
            return RegularImmutableList.f535a;
        }
        ImmutableList a = o.m23876a();
        ImmutableList immutableList = graphQLPaginatedPeopleYouMayKnowFeedUnit.m25702u().f20932c;
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) a.get(i);
            if (IsValidUtil.m22958a(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) && graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.m31481m() != null && (immutableList == null || !immutableList.contains(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.m31481m().m23909P()))) {
                builder.m1069c(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge);
            }
        }
        return builder.m1068b();
    }

    public static ImmutableList<GraphQLPeopleYouMayInviteFeedUnitContactsEdge> m30147a(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection u = graphQLPeopleYouMayInviteFeedUnit.m25674u();
        if (u == null) {
            return RegularImmutableList.f535a;
        }
        ImmutableList a = u.m23854a();
        ImmutableList immutableList = graphQLPeopleYouMayInviteFeedUnit.m25654U().f20932c;
        Builder builder = new Builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) a.get(i);
            if (IsValidUtil.m22960a(graphQLPeopleYouMayInviteFeedUnitContactsEdge) && (immutableList == null || !immutableList.contains(graphQLPeopleYouMayInviteFeedUnitContactsEdge.k()))) {
                builder.m1069c(graphQLPeopleYouMayInviteFeedUnitContactsEdge);
            }
        }
        return builder.m1068b();
    }

    public static ImmutableList<GraphQLTrueTopicFeedOption> m30155a(GraphQLTopicCustomizationStory graphQLTopicCustomizationStory) {
        if (graphQLTopicCustomizationStory.m26102J() == null) {
            return RegularImmutableList.f535a;
        }
        ImmutableList a = graphQLTopicCustomizationStory.m26102J().a();
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLTrueTopicFeedOptionsEdge graphQLTrueTopicFeedOptionsEdge = (GraphQLTrueTopicFeedOptionsEdge) a.get(i);
            if (graphQLTrueTopicFeedOptionsEdge.a() != null) {
                builder.m1069c(graphQLTrueTopicFeedOptionsEdge.a());
            }
        }
        return builder.m1068b();
    }

    public static ImmutableList<GraphQLPageStoriesYouMissedFeedUnitStoriesEdge> m30144a(GraphQLPageStoriesYouMissedFeedUnit graphQLPageStoriesYouMissedFeedUnit) {
        GraphQLPageStoriesYouMissedFeedUnitStoriesConnection l = graphQLPageStoriesYouMissedFeedUnit.m25584l();
        return l == null ? RegularImmutableList.f535a : l.a();
    }
}
