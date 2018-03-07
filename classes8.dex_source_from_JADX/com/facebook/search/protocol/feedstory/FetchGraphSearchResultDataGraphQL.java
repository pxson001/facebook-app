package com.facebook.search.protocol.feedstory;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLModels.FBGraphSearchQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: nearby_friends_tap */
public final class FetchGraphSearchResultDataGraphQL {

    /* compiled from: nearby_friends_tap */
    public class FBGraphSearchQueryString extends TypedGraphQlQueryString<FBGraphSearchQueryModel> {
        public FBGraphSearchQueryString() {
            super(FBGraphSearchQueryModel.class, false, "FBGraphSearchQuery", "2e8f066ae779ae04324a482608c2c45d", "graph_search_query", "10154679952711729", RegularImmutableSet.a);
        }

        public final String m9260a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "12";
                case -1663499699:
                    return "10";
                case -1442803611:
                    return "8";
                case -1101600581:
                    return "4";
                case -854547461:
                    return "1";
                case -461877888:
                    return "11";
                case 92734940:
                    return "2";
                case 94851343:
                    return "3";
                case 107944136:
                    return "0";
                case 169846802:
                    return "13";
                case 532434399:
                    return "5";
                case 614012309:
                    return "6";
                case 823395938:
                    return "7";
                case 1939875509:
                    return "9";
                default:
                    return str;
            }
        }

        protected final boolean m9261a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 55:
                    if (str.equals("7")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }
}
