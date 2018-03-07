package com.facebook.notifications.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQLModels.FetchNotificationsLikeCountModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: needsOffscreenAlphaCompositing */
public final class FetchNotificationsLikeCountGraphQL {

    /* compiled from: needsOffscreenAlphaCompositing */
    public class FetchNotificationsLikeCountString extends TypedGraphQlQueryString<Map<String, FetchNotificationsLikeCountModel>> {
        public FetchNotificationsLikeCountString() {
            super(FetchNotificationsLikeCountModel.class, true, "FetchNotificationsLikeCount", "bf77017e41313f7823d427b7bba7e6ea", "nodes", "10154229547441729", RegularImmutableSet.a);
        }

        public final String m10315a(String str) {
            switch (str.hashCode()) {
                case 1123394299:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
