package com.facebook.megaphone.api;

import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fbtrace */
public final class FetchMegaphoneGraphQL {

    /* compiled from: fbtrace */
    public class FetchMegaphoneQueryString extends TypedGraphQlQueryString<GraphQLViewer> {
        public FetchMegaphoneQueryString() {
            super(GraphQLViewer.class, false, "FetchMegaphoneQuery", "d42484aa4d3d320a43bb3007be35b57a", "viewer", "10154517212381729", RegularImmutableSet.a);
        }

        public final String m12551a(String str) {
            switch (str.hashCode()) {
                case -694787331:
                    return "1";
                case 116290605:
                    return "2";
                case 1901043637:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
