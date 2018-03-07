package com.facebook.messaging.location.sending.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQLModels.NearbyPlacesQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mIsPrepayEligible */
public final class NearbyPlacesGraphQL {

    /* compiled from: mIsPrepayEligible */
    public class NearbyPlacesQueryString extends TypedGraphQlQueryString<NearbyPlacesQueryModel> {
        public NearbyPlacesQueryString() {
            super(NearbyPlacesQueryModel.class, false, "NearbyPlacesQuery", "b6d2bfbd07916d278d7a66ac432f641f", "checkin_search_query", "10154358998146729", RegularImmutableSet.a);
        }

        public final String m12102a(String str) {
            switch (str.hashCode()) {
                case 692733304:
                    return "1";
                case 1364878333:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final NearbyPlacesQueryString m12103a() {
        return new NearbyPlacesQueryString();
    }
}
