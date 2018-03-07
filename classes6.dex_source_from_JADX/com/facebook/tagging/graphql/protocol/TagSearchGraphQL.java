package com.facebook.tagging.graphql.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.FBPersonFriendTagSuggestionsQueryModel;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.TagSearchModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: delta_name */
public final class TagSearchGraphQL {

    /* compiled from: delta_name */
    public class FBPersonFriendTagSuggestionsQueryString extends TypedGraphQlQueryString<FBPersonFriendTagSuggestionsQueryModel> {
        public FBPersonFriendTagSuggestionsQueryString() {
            super(FBPersonFriendTagSuggestionsQueryModel.class, false, "FBPersonFriendTagSuggestionsQuery", "a1697f8cec7cddcd8996f34b12a24a70", "viewer", "10154651288566729", RegularImmutableSet.a);
        }

        public final String m25370a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "0";
                case 94851343:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: delta_name */
    public class TagSearchString extends TypedGraphQlQueryString<TagSearchModel> {
        public TagSearchString() {
            super(TagSearchModel.class, false, "TagSearch", "f13e85acffb61c61d4f1822a77d1ae74", "tag_search", "10154343228351729", RegularImmutableSet.a);
        }

        public final String m25371a(String str) {
            switch (str.hashCode()) {
                case -710140088:
                    return "0";
                case -537064932:
                    return "1";
                default:
                    return str;
            }
        }
    }

    public static final TagSearchString m25372a() {
        return new TagSearchString();
    }

    public static final FBPersonFriendTagSuggestionsQueryString m25373b() {
        return new FBPersonFriendTagSuggestionsQueryString();
    }
}
