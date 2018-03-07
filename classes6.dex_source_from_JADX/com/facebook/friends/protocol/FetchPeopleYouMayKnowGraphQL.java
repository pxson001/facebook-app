package com.facebook.friends.protocol;

import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLModels.PeopleYouMayKnowQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: make_shared */
public final class FetchPeopleYouMayKnowGraphQL {

    /* compiled from: make_shared */
    public class PeopleYouMayKnowQueryString extends TypedGraphQlQueryString<PeopleYouMayKnowQueryModel> {
        public PeopleYouMayKnowQueryString() {
            super(PeopleYouMayKnowQueryModel.class, false, "PeopleYouMayKnowQuery", "bdfc47014bd679b7d26dc83ec0badf02", "viewer", "10154358997571729", RegularImmutableSet.a);
        }

        public final boolean m17006l() {
            return true;
        }

        public final int[][] m17007m() {
            return new int[][]{new int[]{1, 0, Integer.MIN_VALUE, 0, 2}, new int[]{137, 0, Integer.MIN_VALUE, 0, 1}};
        }

        public final String m17005a(String str) {
            switch (str.hashCode()) {
                case -785864030:
                    return "5";
                case -693728706:
                    return "3";
                case 107876:
                    return "1";
                case 566144106:
                    return "2";
                case 1901043637:
                    return "0";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }
    }
}
