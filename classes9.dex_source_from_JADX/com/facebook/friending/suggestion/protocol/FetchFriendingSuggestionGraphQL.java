package com.facebook.friending.suggestion.protocol;

import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLModels.FetchFriendingSuggestionQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TEXT_COLOR_CHANGE */
public final class FetchFriendingSuggestionGraphQL {

    /* compiled from: TEXT_COLOR_CHANGE */
    public class FetchFriendingSuggestionQueryString extends TypedGraphQlQueryString<FetchFriendingSuggestionQueryModel> {
        public FetchFriendingSuggestionQueryString() {
            super(FetchFriendingSuggestionQueryModel.class, false, "FetchFriendingSuggestionQuery", "88ebe0101b1068a450ef8aeb7ef76c49", "user", "10154405445276729", RegularImmutableSet.a);
        }

        public final String m26719a(String str) {
            switch (str.hashCode()) {
                case -1102636175:
                    return "0";
                case -693728706:
                    return "3";
                case 3530753:
                    return "4";
                case 566144106:
                    return "2";
                case 1969934428:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
