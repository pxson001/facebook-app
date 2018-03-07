package com.facebook.feedplugins.pyml.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: android_messages_collection_size */
public final class FetchPaginatedPYMLWithLargeImageItemsGraphQL {

    /* compiled from: android_messages_collection_size */
    public class FetchPaginatedPYMLWithLargeImageItemsQueryString extends TypedGraphQlQueryString<GraphQLViewer> {
        public FetchPaginatedPYMLWithLargeImageItemsQueryString() {
            super(GraphQLViewer.class, false, "FetchPaginatedPYMLWithLargeImageItemsQuery", "9dbf10c51a6f5442b06b40c245a0f706", "viewer", "10154658545246729", RegularImmutableSet.a);
        }

        public final TriState m19982g() {
            return TriState.NO;
        }

        public final String m19980a(String str) {
            switch (str.hashCode()) {
                case -1362584798:
                    return "4";
                case -1256899066:
                    return "11";
                case -1101600581:
                    return "5";
                case -230346670:
                    return "2";
                case -117334504:
                    return "9";
                case 94851343:
                    return "3";
                case 169846802:
                    return "8";
                case 240181920:
                    return "10";
                case 361270353:
                    return "7";
                case 1250156604:
                    return "0";
                case 1542046293:
                    return "1";
                case 1728811114:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m19981a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
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
