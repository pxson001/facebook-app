package com.facebook.messaging.business.review.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.business.review.graphql.ReviewQueryFragmentsModels.MessengerPlatformBotReviewQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: threadNameDialog */
public final class ReviewQueryFragments {

    /* compiled from: threadNameDialog */
    public class MessengerPlatformBotReviewQueryString extends TypedGraphQlQueryString<MessengerPlatformBotReviewQueryModel> {
        public MessengerPlatformBotReviewQueryString() {
            super(MessengerPlatformBotReviewQueryModel.class, false, "MessengerPlatformBotReviewQuery", "d2ddc1e7ff628fec7d89456d3979b84d", "node", "10154651113471729", RegularImmutableSet.a);
        }

        public final String m1611a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
