package com.facebook.pages.adminedpages.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: push_source */
public final class AdminedPagesPrefetchGraphQL {

    /* compiled from: push_source */
    public class AdminedPagesPrefetchQueryString extends TypedGraphQlQueryString<AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel> {
        public AdminedPagesPrefetchQueryString() {
            super(AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.class, false, "AdminedPagesPrefetchQuery", "9251855baf39b410df16e62e09f73af5", "viewer", "10153218533731729", RegularImmutableSet.a);
        }

        public final String m4500a(String str) {
            switch (str.hashCode()) {
                case 1845875734:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
