package com.facebook.friends.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: malformed */
public final class FetchPeopleYouMayInviteGraphQL {

    /* compiled from: malformed */
    public class PeopleYouMayInviteQueryString extends TypedGraphQlQueryString<GraphQLNode> {
        public PeopleYouMayInviteQueryString() {
            super(GraphQLNode.class, false, "PeopleYouMayInviteQuery", "ecd488a2f42f508823b0d485437de4d6", "node", "10154663487531729", RegularImmutableSet.a);
        }

        public final TriState m17004g() {
            return TriState.NO;
        }

        public final String m17003a(String str) {
            switch (str.hashCode()) {
                case 16907033:
                    return "1";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
