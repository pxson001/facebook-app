package com.facebook.messaging.contextbanner.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.contextbanner.graphql.ProfileContextQueryModels.ProfileContextItemsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: subcodes */
public final class ProfileContextQuery {

    /* compiled from: subcodes */
    public class ProfileContextQueryString extends TypedGraphQlQueryString<ProfileContextItemsModel> {
        public ProfileContextQueryString() {
            super(ProfileContextItemsModel.class, false, "ProfileContextQuery", "2a5dd4f7505e5c50d603f5127537c26a", "node", "10154427701076729", RegularImmutableSet.a);
        }

        public final String m2053a(String str) {
            switch (str.hashCode()) {
                case -1685391298:
                    return "2";
                case -1102636175:
                    return "0";
                case -450005638:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
