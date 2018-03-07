package com.facebook.search.bootstrap.common.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLModels.FetchBootstrapKeywordsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_currency */
public final class FetchBootstrapKeywordsGraphQL {

    /* compiled from: extra_currency */
    public class FetchBootstrapKeywordsString extends TypedGraphQlQueryString<FetchBootstrapKeywordsModel> {
        public FetchBootstrapKeywordsString() {
            super(FetchBootstrapKeywordsModel.class, false, "FetchBootstrapKeywords", "2ba73465566c6ffa38b84db7c297624c", "viewer", "10154575571791729", RegularImmutableSet.a);
        }

        public final String m23308a(String str) {
            switch (str.hashCode()) {
                case -2043217435:
                    return "1";
                case 680341222:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m23309a(String str, Object obj) {
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
}
