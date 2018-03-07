package com.facebook.graphql.model;

/* compiled from: groups/discover */
public class ImpressionUtil {
    private ImpressionUtil() {
    }

    static boolean m29324a(Sponsorable sponsorable) {
        SponsoredImpression ab_ = sponsorable.ab_();
        return (ab_ == null || ab_ == SponsoredImpression.f21615n) ? false : true;
    }

    static SponsoredImpression m29319a(HasCachedSponsoredImpression hasCachedSponsoredImpression) {
        SponsoredImpression sponsoredImpression = PropertyHelper.m21261a((Object) hasCachedSponsoredImpression).f14853b;
        if (sponsoredImpression != null) {
            return sponsoredImpression;
        }
        sponsoredImpression = hasCachedSponsoredImpression.Z_();
        PropertyHelper.m21261a((Object) hasCachedSponsoredImpression).f14853b = sponsoredImpression;
        return sponsoredImpression;
    }

    public static void m29325b(Sponsorable sponsorable) {
        if (sponsorable instanceof ScrollableItemListFeedUnit) {
            PropertyHelper.m21279a(sponsorable, (1 << ((ScrollableItemListFeedUnit) sponsorable).ac_()) | PropertyHelper.m21287b(sponsorable));
            return;
        }
        PropertyHelper.m21280a(sponsorable, true);
    }

    public static boolean m29326c(Sponsorable sponsorable) {
        if (!(sponsorable instanceof ScrollableItemListFeedUnit)) {
            return PropertyHelper.m21285a(sponsorable);
        }
        return ((1 << ((ScrollableItemListFeedUnit) sponsorable).ac_()) & PropertyHelper.m21287b(sponsorable)) != 0;
    }

    public static int m29327d(Sponsorable sponsorable) {
        if (sponsorable instanceof ScrollableItemListFeedUnit) {
            return PropertyHelper.m21287b(sponsorable);
        }
        return PropertyHelper.m21285a(sponsorable) ? 1 : 0;
    }

    public static void m29322a(Sponsorable sponsorable, int i) {
        if (sponsorable instanceof ScrollableItemListFeedUnit) {
            PropertyHelper.m21279a(sponsorable, PropertyHelper.m21287b(sponsorable) | i);
        } else if (i == 1) {
            PropertyHelper.m21280a(sponsorable, true);
        }
    }

    static SponsoredImpression m29320a(HasSponsoredData hasSponsoredData) {
        return SponsoredImpression.m29328a(hasSponsoredData.mo2994A());
    }

    public static void m29321a(PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem, boolean z) {
        if (peopleYouMayKnowFeedUnitItem instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) {
            PropertyHelper.m21261a((GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) peopleYouMayKnowFeedUnitItem).f14868q = z;
        } else if (peopleYouMayKnowFeedUnitItem instanceof GraphQLPeopleYouMayKnowFeedUnitItem) {
            PropertyHelper.m21261a((GraphQLPeopleYouMayKnowFeedUnitItem) peopleYouMayKnowFeedUnitItem).f14868q = z;
        } else {
            throw new RuntimeException("Type doesn't have isImpressionLogged property:" + peopleYouMayKnowFeedUnitItem.getClass().getSimpleName());
        }
    }

    public static boolean m29323a(PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem) {
        if (peopleYouMayKnowFeedUnitItem instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) {
            return PropertyHelper.m21261a((GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) peopleYouMayKnowFeedUnitItem).f14868q;
        }
        if (peopleYouMayKnowFeedUnitItem instanceof GraphQLPeopleYouMayKnowFeedUnitItem) {
            return PropertyHelper.m21261a((GraphQLPeopleYouMayKnowFeedUnitItem) peopleYouMayKnowFeedUnitItem).f14868q;
        }
        throw new RuntimeException("Type doesn't have isImpressionLogged property:" + peopleYouMayKnowFeedUnitItem.getClass().getSimpleName());
    }
}
