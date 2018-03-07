package com.facebook.api.graphql.fetchfeedback;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: angora_attachment_cover_image_size */
public final class FetchLikersGraphQL {

    /* compiled from: angora_attachment_cover_image_size */
    public class StaticLikersString extends TypedGraphQlQueryString<GraphQLFeedback> {
        public StaticLikersString() {
            super(GraphQLFeedback.class, false, "StaticLikers", "205c957eb505d8a5f9dd884590fe6996", "node", "10154686240691729", RegularImmutableSet.a);
        }

        public final TriState m16543g() {
            return TriState.NO;
        }

        public final String m16541a(String str) {
            switch (str.hashCode()) {
                case -1362584798:
                    return "7";
                case -1302586347:
                    return "0";
                case -1101600581:
                    return "1";
                case -253520830:
                    return "2";
                case -130329384:
                    return "4";
                case 263265243:
                    return "5";
                case 689802720:
                    return "3";
                case 1114993491:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m16542a(String str, Object obj) {
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
