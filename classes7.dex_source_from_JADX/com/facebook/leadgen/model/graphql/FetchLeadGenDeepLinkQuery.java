package com.facebook.leadgen.model.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLModels.LeadGenDeepLinkDataFragModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photos_feed_blingbar */
public final class FetchLeadGenDeepLinkQuery {

    /* compiled from: photos_feed_blingbar */
    public class FetchLeadGenDeepLinkString extends TypedGraphQlQueryString<LeadGenDeepLinkDataFragModel> {
        public FetchLeadGenDeepLinkString() {
            super(LeadGenDeepLinkDataFragModel.class, false, "FetchLeadGenDeepLink", "41dfeb686bf7da65512d0d29c4d85167", "node", "10154665768916729", RegularImmutableSet.a);
        }

        public final String m8261a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 423175038:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
