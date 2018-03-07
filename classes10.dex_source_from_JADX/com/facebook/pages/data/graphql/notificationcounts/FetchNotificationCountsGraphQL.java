package com.facebook.pages.data.graphql.notificationcounts;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLModels.PageNotificationCountsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mReceivedMessages */
public final class FetchNotificationCountsGraphQL {

    /* compiled from: mReceivedMessages */
    public class FetchSinglePageNotificationCountsQueryString extends TypedGraphQlQueryString<PageNotificationCountsModel> {
        public FetchSinglePageNotificationCountsQueryString() {
            super(PageNotificationCountsModel.class, false, "FetchSinglePageNotificationCountsQuery", "dc2b644f50036e07c3bc14190b6ad159", "page", "10154681213501729", RegularImmutableSet.a);
        }

        public final String m8313a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
