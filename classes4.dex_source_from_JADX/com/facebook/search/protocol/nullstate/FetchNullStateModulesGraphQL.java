package com.facebook.search.protocol.nullstate;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: friending_possibilities */
public final class FetchNullStateModulesGraphQL {

    /* compiled from: friending_possibilities */
    public class NullStateModuleQueryString extends TypedGraphQlQueryString<NullStateModuleQueryModel> {
        public NullStateModuleQueryString() {
            super(NullStateModuleQueryModel.class, false, "NullStateModuleQuery", "6965e53fa0aabeaf8da4298c5630484e", "graph_search_null_state", "10154583943746729", RegularImmutableSet.a);
        }

        public final boolean m11804l() {
            return true;
        }

        public final int[][] m11805m() {
            return new int[][]{new int[]{0, 0, Integer.MIN_VALUE, -2147483643, 0, 1}};
        }

        public final String m11802a(String str) {
            switch (str.hashCode()) {
                case -1721456160:
                    return "2";
                case -896505829:
                    return "0";
                case 245682486:
                    return "3";
                case 1901043637:
                    return "1";
                default:
                    return str;
            }
        }

        protected final boolean m11803a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 51:
                    if (str.equals("3")) {
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
