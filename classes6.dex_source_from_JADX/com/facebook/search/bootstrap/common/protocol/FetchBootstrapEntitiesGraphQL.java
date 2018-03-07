package com.facebook.search.bootstrap.common.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.FetchBootstrapEntitiesModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapEntitiesGraphQLModels.FetchBootstrapSnippetsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_feed_story */
public final class FetchBootstrapEntitiesGraphQL {

    /* compiled from: extra_feed_story */
    public class FetchBootstrapEntitiesString extends TypedGraphQlQueryString<FetchBootstrapEntitiesModel> {
        public FetchBootstrapEntitiesString() {
            super(FetchBootstrapEntitiesModel.class, false, "FetchBootstrapEntities", "7851c5654ea89223ac81d9a2d0cf0353", "viewer", "10154686242396729", RegularImmutableSet.a);
        }

        public final String m23190a(String str) {
            switch (str.hashCode()) {
                case -701764500:
                    return "0";
                case 104120:
                    return "1";
                case 55126294:
                    return "3";
                case 759954292:
                    return "4";
                case 1070455903:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m23191a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
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

    /* compiled from: extra_feed_story */
    public class FetchBootstrapSnippetsString extends TypedGraphQlQueryString<FetchBootstrapSnippetsModel> {
        public FetchBootstrapSnippetsString() {
            super(FetchBootstrapSnippetsModel.class, false, "FetchBootstrapSnippets", "b6433ba7a28dbaa64b76e14bda1bc6e5", "viewer", "10154686242391729", RegularImmutableSet.a);
        }

        public final String m23192a(String str) {
            switch (str.hashCode()) {
                case 104120:
                    return "0";
                case 759954292:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
