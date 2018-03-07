package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ChatContextsGraphQLModels.FetchChatContextsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_fife_url */
public final class ChatContextsGraphQL {

    /* compiled from: photo_fife_url */
    public class FetchChatContextsQueryString extends TypedGraphQlQueryString<FetchChatContextsQueryModel> {
        public FetchChatContextsQueryString() {
            super(FetchChatContextsQueryModel.class, false, "FetchChatContextsQuery", "ad8062f540432bc16f1f2cea05e3f930", "me", "10154641431261729", RegularImmutableSet.a);
        }

        public final String m11698a(String str) {
            switch (str.hashCode()) {
                case -2131707655:
                    return "6";
                case -1666926107:
                    return "1";
                case -1439978388:
                    return "3";
                case 55126294:
                    return "5";
                case 137365935:
                    return "4";
                case 265662953:
                    return "2";
                case 1805391058:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
