package com.facebook.messaging.business.pages.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesModels.BYMMQueryModel;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesModels.BusinessUserHasMessagedQueryModel;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesModels.SuggestedBotsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: msg_create_thread_attempted */
public final class BusinessMessagingQueries {

    /* compiled from: msg_create_thread_attempted */
    public class BYMMQueryString extends TypedGraphQlQueryString<BYMMQueryModel> {
        public BYMMQueryString() {
            super(BYMMQueryModel.class, false, "BYMMQuery", "258fef71164e2998f24d019c1d85f750", "viewer", "10154588701696729", RegularImmutableSet.a);
        }

        public final String m9289a(String str) {
            switch (str.hashCode()) {
                case -892272052:
                    return "0";
                case -20088988:
                    return "3";
                case 790172080:
                    return "1";
                case 860481728:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: msg_create_thread_attempted */
    public class BusinessUserHasMessagedQueryString extends TypedGraphQlQueryString<BusinessUserHasMessagedQueryModel> {
        public BusinessUserHasMessagedQueryString() {
            super(BusinessUserHasMessagedQueryModel.class, false, "BusinessUserHasMessagedQuery", "a8ec7a4ddbc6f57bc28fc18c5eda56c7", "viewer", "10154588701741729", RegularImmutableSet.a);
        }

        public final String m9290a(String str) {
            switch (str.hashCode()) {
                case -892272052:
                    return "0";
                case -20088988:
                    return "3";
                case 790172080:
                    return "1";
                case 860481728:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: msg_create_thread_attempted */
    public class SuggestedBotsQueryString extends TypedGraphQlQueryString<SuggestedBotsQueryModel> {
        public SuggestedBotsQueryString() {
            super(SuggestedBotsQueryModel.class, false, "SuggestedBotsQuery", "3d230d2ae819648c444ffb0850e3c278", "viewer", "10154588701716729", RegularImmutableSet.a);
        }

        public final String m9291a(String str) {
            switch (str.hashCode()) {
                case -892272052:
                    return "0";
                case -20088988:
                    return "3";
                case 790172080:
                    return "1";
                case 860481728:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
