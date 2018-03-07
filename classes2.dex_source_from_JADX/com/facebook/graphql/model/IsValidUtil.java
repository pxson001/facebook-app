package com.facebook.graphql.model;

import android.text.TextUtils;
import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/* compiled from: logging_channel */
public class IsValidUtil {
    private IsValidUtil() {
    }

    public static boolean m22947a(GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem) {
        GraphQLGroup m = graphQLGroupsYouShouldJoinFeedUnitItem.m();
        return (m == null || m.m23275I() == null || m.m23282P() == null || m.ag() == null || !m22948a(m.ag()) || (m.aI() != GraphQLGroupJoinState.CAN_JOIN && m.aI() != GraphQLGroupJoinState.CAN_REQUEST && m.aI() != GraphQLGroupJoinState.REQUESTED && m.aI() != GraphQLGroupJoinState.MEMBER)) ? false : true;
    }

    public static boolean m22946a(GraphQLGroupTopStoriesFeedUnitStoriesEdge graphQLGroupTopStoriesFeedUnitStoriesEdge) {
        GraphQLStory j = graphQLGroupTopStoriesFeedUnitStoriesEdge.j();
        return (j == null || j.aJ() == null || j.m22349b() == null || j.aj() == null || j.mo2890l() == null) ? false : true;
    }

    public static boolean m22957a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) {
        GraphQLGroup l = graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.l();
        return (l == null || l.m23275I() == null || l.m23282P() == null || l.ag() == null || !m22948a(l.ag())) ? false : true;
    }

    public static boolean m22964a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge) {
        GraphQLGroup j = graphQLSaleGroupsNearYouFeedUnitGroupsEdge.j();
        return (j == null || j.m23275I() == null || j.m23282P() == null || j.ag() == null || !m22948a(j.ag())) ? false : true;
    }

    public static boolean m22953a(GraphQLPageStoriesYouMissedFeedUnit graphQLPageStoriesYouMissedFeedUnit) {
        if (graphQLPageStoriesYouMissedFeedUnit == null || graphQLPageStoriesYouMissedFeedUnit.m25590s() == null || graphQLPageStoriesYouMissedFeedUnit.m25584l() == null || graphQLPageStoriesYouMissedFeedUnit.m25584l().a() == null || graphQLPageStoriesYouMissedFeedUnit.m25584l().a().isEmpty()) {
            return false;
        }
        ImmutableList a = graphQLPageStoriesYouMissedFeedUnit.m25584l().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (!m22954a((GraphQLPageStoriesYouMissedFeedUnitStoriesEdge) a.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m22954a(GraphQLPageStoriesYouMissedFeedUnitStoriesEdge graphQLPageStoriesYouMissedFeedUnitStoriesEdge) {
        GraphQLStory a = graphQLPageStoriesYouMissedFeedUnitStoriesEdge.a();
        return (a == null || a.m22349b() == null || a.m22349b().isEmpty() || a.mo2890l() == null || StoryAttachmentHelper.m28042o(a) == null) ? false : true;
    }

    public static boolean m22960a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge) {
        return (graphQLPeopleYouMayInviteFeedUnitContactsEdge == null || graphQLPeopleYouMayInviteFeedUnitContactsEdge.j() == null || graphQLPeopleYouMayInviteFeedUnitContactsEdge.l() == null || graphQLPeopleYouMayInviteFeedUnitContactsEdge.k() == null) ? false : true;
    }

    public static boolean m22961a(GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem) {
        return m22966a(graphQLPeopleYouMayKnowFeedUnitItem.m());
    }

    public static boolean m22958a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) {
        return m22966a(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.m31481m());
    }

    public static boolean m22962a(GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit) {
        if (graphQLPeopleYouShouldFollowFeedUnit.mo2878m() == null || CollectionUtil.m29342a(graphQLPeopleYouShouldFollowFeedUnit.m25806l())) {
            return false;
        }
        ImmutableList a = graphQLPeopleYouShouldFollowFeedUnit.m25810q().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (!m22963a((GraphQLPeopleYouShouldFollowFeedUnitItem) a.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m22963a(GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem) {
        return (graphQLPeopleYouShouldFollowFeedUnitItem.m() == null || graphQLPeopleYouShouldFollowFeedUnitItem.m().ar() == null || graphQLPeopleYouShouldFollowFeedUnitItem.m().aZ() == null || graphQLPeopleYouShouldFollowFeedUnitItem.l() == null || graphQLPeopleYouShouldFollowFeedUnitItem.m().aI() == null || !m22948a(graphQLPeopleYouShouldFollowFeedUnitItem.m().aI())) ? false : true;
    }

    private static boolean m22966a(GraphQLUser graphQLUser) {
        if (graphQLUser == null || graphQLUser.m23909P() == null || graphQLUser.ar() == null || graphQLUser.aI() == null || !m22948a(graphQLUser.aI())) {
            return false;
        }
        try {
            Long.parseLong(graphQLUser.m23909P());
            return true;
        } catch (Throwable e) {
            BLog.c("IsValidUtil", e, "User id not a long: %s", new Object[]{graphQLUser.m23909P()});
            return false;
        }
    }

    public static boolean m22955a(GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit) {
        if (graphQLPagesYouMayLikeFeedUnit.m22832t() != null && !graphQLPagesYouMayLikeFeedUnit.m22832t().isEmpty()) {
            ImmutableList t = graphQLPagesYouMayLikeFeedUnit.m22832t();
            int size = t.size();
            for (int i = 0; i < size; i++) {
                if (!m22956a((GraphQLPagesYouMayLikeFeedUnitItem) t.get(i))) {
                    return false;
                }
            }
            return true;
        } else if (graphQLPagesYouMayLikeFeedUnit.m22830r().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean m22950a(GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit) {
        if (graphQLPYMLWithLargeImageFeedUnit.m25730B() == null || graphQLPYMLWithLargeImageFeedUnit.m25730B().a() == null || graphQLPYMLWithLargeImageFeedUnit.m25730B().a().isEmpty()) {
            return false;
        }
        ImmutableList a = graphQLPYMLWithLargeImageFeedUnit.m25730B().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (!m22951a(((GraphQLPYMLWithLargeImageFeedUnitsEdge) a.get(i)).a())) {
                return false;
            }
        }
        return true;
    }

    public static boolean m22959a(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        if (graphQLPeopleYouMayInviteFeedUnit == null || graphQLPeopleYouMayInviteFeedUnit.m25674u() == null || graphQLPeopleYouMayInviteFeedUnit.m25674u().m23854a() == null) {
            return false;
        }
        ImmutableList a = graphQLPeopleYouMayInviteFeedUnit.m25674u().m23854a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (!m22960a((GraphQLPeopleYouMayInviteFeedUnitContactsEdge) a.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m22943a(NewsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields) {
        return !Strings.isNullOrEmpty(newsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields.mo2962a());
    }

    public static boolean m22965a(GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem) {
        GraphQLProfile n = graphQLSavedCollectionFeedUnitItem.n();
        if (!(n == null || graphQLSavedCollectionFeedUnitItem.p() == null)) {
            if (!StringUtil.m3591a(n.m22999b(), graphQLSavedCollectionFeedUnitItem.p().mo2911a(), n.ax()) && ((GraphQLHelper.m22483a(n) || GraphQLHelper.m22498c(n)) && n.m23000j() != null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22944a(GraphQLCreativePagesYouMayLikeFeedUnitItem graphQLCreativePagesYouMayLikeFeedUnitItem) {
        if (graphQLCreativePagesYouMayLikeFeedUnitItem.y() == null || graphQLCreativePagesYouMayLikeFeedUnitItem.y().ae() == null || graphQLCreativePagesYouMayLikeFeedUnitItem.y().aG() == null || graphQLCreativePagesYouMayLikeFeedUnitItem.t() == null || graphQLCreativePagesYouMayLikeFeedUnitItem.s() == null || graphQLCreativePagesYouMayLikeFeedUnitItem.s().mo2925c() == 0 || graphQLCreativePagesYouMayLikeFeedUnitItem.s().mo2923a() == 0) {
            return false;
        }
        return true;
    }

    public static boolean m22956a(GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem) {
        if (graphQLPagesYouMayLikeFeedUnitItem.u() == null || graphQLPagesYouMayLikeFeedUnitItem.u().ae() == null || graphQLPagesYouMayLikeFeedUnitItem.u().aG() == null) {
            return false;
        }
        return true;
    }

    public static boolean m22951a(GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem) {
        if (graphQLPYMLWithLargeImageFeedUnitItem.D() == null || graphQLPYMLWithLargeImageFeedUnitItem.D().ae() == null || graphQLPYMLWithLargeImageFeedUnitItem.D().aG() == null || graphQLPYMLWithLargeImageFeedUnitItem.y() == null || graphQLPYMLWithLargeImageFeedUnitItem.v() == null || graphQLPYMLWithLargeImageFeedUnitItem.v().mo2925c() == 0 || graphQLPYMLWithLargeImageFeedUnitItem.v().mo2923a() == 0) {
            return false;
        }
        return true;
    }

    public static boolean m22952a(GraphQLPageInfo graphQLPageInfo) {
        return (graphQLPageInfo.v_() == null || graphQLPageInfo.mo1405a() == null) ? false : true;
    }

    public static boolean m22948a(GraphQLImage graphQLImage) {
        return graphQLImage.mo2924b() != null;
    }

    public static boolean m22949a(GraphQLLocation graphQLLocation) {
        return Math.abs(graphQLLocation.mo2957a()) <= 90.0d && Math.abs(graphQLLocation.mo2958b()) <= 180.0d;
    }

    public static boolean m22945a(GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit) {
        return (graphQLGoodwillAnniversaryCampaignFeedUnit.m25350l() == null || graphQLGoodwillAnniversaryCampaignFeedUnit.m25350l().o() == null || TextUtils.isEmpty(graphQLGoodwillAnniversaryCampaignFeedUnit.m25350l().o().mo2911a())) ? false : true;
    }
}
