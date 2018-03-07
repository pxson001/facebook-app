package com.facebook.api.graphql.feedback;

import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutationsModels.FeedbackSubscribeMutationFragmentModel;
import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutationsModels.FeedbackUnsubscribeMutationFragmentModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: any */
public final class FeedbackSubscriptionMutations {

    /* compiled from: any */
    public class FeedbackSubscribeMutationString extends TypedGraphQLMutationString<FeedbackSubscribeMutationFragmentModel> {
        public FeedbackSubscribeMutationString() {
            super(FeedbackSubscribeMutationFragmentModel.class, false, "FeedbackSubscribeMutation", "9ee72cf752a5d55ac82a24a8b0add9b3", "feedback_subscribe", "0", "10154339186946729", RegularImmutableSet.a);
        }

        public final String m16299a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: any */
    public class FeedbackUnsubscribeMutationString extends TypedGraphQLMutationString<FeedbackUnsubscribeMutationFragmentModel> {
        public FeedbackUnsubscribeMutationString() {
            super(FeedbackUnsubscribeMutationFragmentModel.class, false, "FeedbackUnsubscribeMutation", "240a88e887e324cd05f2b023342c841a", "feedback_unsubscribe", "0", "10154339186966729", RegularImmutableSet.a);
        }

        public final String m16300a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
