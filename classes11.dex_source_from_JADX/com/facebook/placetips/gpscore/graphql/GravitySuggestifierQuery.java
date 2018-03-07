package com.facebook.placetips.gpscore.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.placetips.gpscore.graphql.GravitySuggestifierQueryModels.GravitySuggestifierQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TigonHttpEntityBodyProviderDomain */
public final class GravitySuggestifierQuery {

    /* compiled from: TigonHttpEntityBodyProviderDomain */
    public class GravitySuggestifierQueryString extends TypedGraphQlQueryString<GravitySuggestifierQueryModel> {
        public GravitySuggestifierQueryString() {
            super(GravitySuggestifierQueryModel.class, false, "GravitySuggestifierQuery", "f65970b90237c1ab691784971ad88ad5", "checkin_search_query", "10154362891101729", RegularImmutableSet.a);
        }

        public final String m11110a(String str) {
            switch (str.hashCode()) {
                case 204774316:
                    return "1";
                case 1994249042:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
