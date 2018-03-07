package com.facebook.messaging.business.subscription.common.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutationsModels.ContentPageSubscribeMutationModel;
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutationsModels.ContentPageUnsubscribeMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: trackers_all_loaded */
public final class BusinessSubscriptionMutations {

    /* compiled from: trackers_all_loaded */
    public class ContentPageSubscribeMutationString extends TypedGraphQLMutationString<ContentPageSubscribeMutationModel> {
        public ContentPageSubscribeMutationString() {
            super(ContentPageSubscribeMutationModel.class, false, "ContentPageSubscribeMutation", "ae72a39ddf577b594bfd1fc2461f6ad0", "messenger_content_page_subscribe", "0", "10154579773151729", RegularImmutableSet.a);
        }

        public final String m1593a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: trackers_all_loaded */
    public class ContentPageUnsubscribeMutationString extends TypedGraphQLMutationString<ContentPageUnsubscribeMutationModel> {
        public ContentPageUnsubscribeMutationString() {
            super(ContentPageUnsubscribeMutationModel.class, false, "ContentPageUnsubscribeMutation", "abe51b3f34d611987e311b02a59ec4b4", "messenger_content_page_unsubscribe", "0", "10154579773156729", RegularImmutableSet.a);
        }

        public final String m1594a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
