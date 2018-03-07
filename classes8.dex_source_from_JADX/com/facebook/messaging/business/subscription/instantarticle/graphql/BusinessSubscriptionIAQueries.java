package com.facebook.messaging.business.subscription.instantarticle.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.business.subscription.instantarticle.graphql.BusinessSubscriptionIAQueriesModels.BusinessSubscriptionMessengerContentSubscribedQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: trackNumber */
public final class BusinessSubscriptionIAQueries {

    /* compiled from: trackNumber */
    public class BusinessSubscriptionMessengerContentSubscribedQueryString extends TypedGraphQlQueryString<BusinessSubscriptionMessengerContentSubscribedQueryModel> {
        public BusinessSubscriptionMessengerContentSubscribedQueryString() {
            super(BusinessSubscriptionMessengerContentSubscribedQueryModel.class, false, "BusinessSubscriptionMessengerContentSubscribedQuery", "cb5ba7d2b053c359769f64269b884f07", "node", "10154596029471729", RegularImmutableSet.a);
        }

        public final String m1654a(String str) {
            switch (str.hashCode()) {
                case -995752950:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
