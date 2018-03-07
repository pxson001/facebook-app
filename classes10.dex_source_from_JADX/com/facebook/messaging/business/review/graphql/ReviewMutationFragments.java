package com.facebook.messaging.business.review.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.business.review.graphql.ReviewMutationFragmentsModels.MessengerPlatformBotReviewMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: threadSummary for  */
public final class ReviewMutationFragments {

    /* compiled from: threadSummary for  */
    public class MessengerPlatformBotReviewMutationString extends TypedGraphQLMutationString<MessengerPlatformBotReviewMutationModel> {
        public MessengerPlatformBotReviewMutationString() {
            super(MessengerPlatformBotReviewMutationModel.class, false, "MessengerPlatformBotReviewMutation", "9c983027776c78b7a46decab67dcdc26", "bot_review_update", "0", "10154651421606729", RegularImmutableSet.a);
        }

        public final String m1604a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
