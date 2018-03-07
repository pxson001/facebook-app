package com.facebook.messaging.graphql.search;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.graphql.search.UserNameSearchQueryModels.UserNameSearchQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: single_minutiae */
public final class UserNameSearchQuery {

    /* compiled from: single_minutiae */
    public class UserNameSearchQueryString extends TypedGraphQlQueryString<UserNameSearchQueryModel> {
        public UserNameSearchQueryString() {
            super(UserNameSearchQueryModel.class, false, "UserNameSearchQuery", "afb42d5a0689fe062e77eca7416181ab", "entities_named", "10154395258551729", RegularImmutableSet.a);
        }

        public final String m2262a(String str) {
            switch (str.hashCode()) {
                case -1366603820:
                    return "0";
                case -766535118:
                    return "1";
                case 210215821:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
