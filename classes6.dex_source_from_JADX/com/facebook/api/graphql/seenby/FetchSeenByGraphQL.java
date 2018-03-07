package com.facebook.api.graphql.seenby;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: prompt_question */
public final class FetchSeenByGraphQL {

    /* compiled from: prompt_question */
    public class FetchSeenByString extends TypedGraphQlQueryString<GraphQLNode> {
        public FetchSeenByString() {
            super(GraphQLNode.class, false, "FetchSeenBy", "8a72764dee79c489029c42c2e0097a96", "node", "10154686241031729", RegularImmutableSet.a);
        }

        public final TriState m10294g() {
            return TriState.NO;
        }

        public final String m10292a(String str) {
            switch (str.hashCode()) {
                case -1362584798:
                    return "6";
                case -1302586347:
                    return "0";
                case -1101600581:
                    return "1";
                case 689802720:
                    return "2";
                case 1369038136:
                    return "4";
                case 2002810048:
                    return "5";
                case 2052506587:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m10293a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 54:
                    if (str.equals("6")) {
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
