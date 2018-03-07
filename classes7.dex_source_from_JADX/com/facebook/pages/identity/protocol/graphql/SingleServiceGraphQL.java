package com.facebook.pages.identity.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mdhd */
public final class SingleServiceGraphQL {

    /* compiled from: mdhd */
    public class SingleServiceGraphQLString extends TypedGraphQlQueryString<PageServiceItemModel> {
        public SingleServiceGraphQLString() {
            super(PageServiceItemModel.class, false, "SingleServiceGraphQL", "a1e5f074e6742242890e9a015eb74f46", "node", "10154634017421729", RegularImmutableSet.a);
        }

        public final String m11234a(String str) {
            switch (str.hashCode()) {
                case -1724763419:
                    return "0";
                case -783752827:
                    return "2";
                case -11314776:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
