package com.facebook.pages.messaging.responsiveness.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.messaging.responsiveness.graphql.FetchPageResponsivenessGraphQLModels.PageResponsivenessContextModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: cb_ */
public final class FetchPageResponsivenessGraphQL {

    /* compiled from: cb_ */
    public class FetchPageResponsivenessQueryString extends TypedGraphQlQueryString<PageResponsivenessContextModel> {
        public FetchPageResponsivenessQueryString() {
            super(PageResponsivenessContextModel.class, false, "FetchPageResponsivenessQuery", "995eb848515561fdb755518abaa17e64", "page", "10154405445596729", RegularImmutableSet.a);
        }

        public final String m18433a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
