package com.facebook.search.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchFilterQueryModel;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchUserWithFiltersQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: no_activity_for_composer_target_selection */
public final class FB4AGraphSearchUserWithFiltersGraphQL {

    /* compiled from: no_activity_for_composer_target_selection */
    public class FB4AGraphSearchFilterQueryString extends TypedGraphQlQueryString<FB4AGraphSearchFilterQueryModel> {
        public FB4AGraphSearchFilterQueryString() {
            super(FB4AGraphSearchFilterQueryModel.class, false, "FB4AGraphSearchFilterQuery", "dafea9c3d22be5e8c367d3e87a5ff52a", "node", "10154429040011729", RegularImmutableSet.a);
        }

        public final String m8264a(String str) {
            switch (str.hashCode()) {
                case -721168749:
                    return "0";
                case 94851343:
                    return "2";
                case 530542161:
                    return "1";
                case 692733304:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: no_activity_for_composer_target_selection */
    public class FB4AGraphSearchUserWithFiltersQueryString extends TypedGraphQlQueryString<FB4AGraphSearchUserWithFiltersQueryModel> {
        public FB4AGraphSearchUserWithFiltersQueryString() {
            super(FB4AGraphSearchUserWithFiltersQueryModel.class, false, "FB4AGraphSearchUserWithFiltersQuery", "4e925d444f438ea40c45d99b038e68cf", "graph_search_query", "10154429040021729", RegularImmutableSet.a);
        }

        public final String m8265a(String str) {
            switch (str.hashCode()) {
                case -1335157162:
                    return "3";
                case -1274492040:
                    return "2";
                case -171705691:
                    return "1";
                case 92734940:
                    return "4";
                case 94851343:
                    return "5";
                case 107944136:
                    return "0";
                case 692733304:
                    return "6";
                default:
                    return str;
            }
        }
    }
}
