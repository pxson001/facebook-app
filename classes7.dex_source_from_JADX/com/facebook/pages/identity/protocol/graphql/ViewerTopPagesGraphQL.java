package com.facebook.pages.identity.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.identity.protocol.graphql.ViewerTopPagesGraphQLModels.ViewerTopPagesQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mdat */
public final class ViewerTopPagesGraphQL {

    /* compiled from: mdat */
    public class ViewerTopPagesQueryString extends TypedGraphQlQueryString<ViewerTopPagesQueryModel> {
        public ViewerTopPagesQueryString() {
            super(ViewerTopPagesQueryModel.class, false, "ViewerTopPagesQuery", "fbbadb01178d6ccfb7d64553d2576890", "viewer", "10153893291921729", RegularImmutableSet.a);
        }

        public final String m11235a(String str) {
            switch (str.hashCode()) {
                case 334591713:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
