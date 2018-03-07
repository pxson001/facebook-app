package com.facebook.feed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: missed */
public final class FetchPaginatedGroupsYouShouldJoinGraphQL {

    /* compiled from: missed */
    public class PaginatedGroupsYouShouldJoinQueryString extends TypedGraphQlQueryString<GraphQLNode> {
        public PaginatedGroupsYouShouldJoinQueryString() {
            super(GraphQLNode.class, false, "PaginatedGroupsYouShouldJoinQuery", "503a39b3395066a8f4580761b7c3308f", "node", "10154429038511729", RegularImmutableSet.a);
        }

        public final TriState m16273g() {
            return TriState.NO;
        }

        public final String m16272a(String str) {
            switch (str.hashCode()) {
                case -599319479:
                    return "2";
                case 336420357:
                    return "5";
                case 550113673:
                    return "3";
                case 566144106:
                    return "1";
                case 1613128163:
                    return "4";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
