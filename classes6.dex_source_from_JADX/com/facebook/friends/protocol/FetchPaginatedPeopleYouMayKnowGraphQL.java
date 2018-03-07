package com.facebook.friends.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: manager */
public final class FetchPaginatedPeopleYouMayKnowGraphQL {

    /* compiled from: manager */
    public class PaginatedPeopleYouMayKnowQueryString extends TypedGraphQlQueryString<GraphQLNode> {
        public PaginatedPeopleYouMayKnowQueryString() {
            super(GraphQLNode.class, false, "PaginatedPeopleYouMayKnowQuery", "e3a64b7a90255550e915b5f07aa1e8ea", "node", "10154678548031729", RegularImmutableSet.a);
        }

        public final TriState m17002g() {
            return TriState.NO;
        }

        public final String m17001a(String str) {
            switch (str.hashCode()) {
                case -1385981785:
                    return "3";
                case 566144106:
                    return "1";
                case 1939875509:
                    return "2";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
