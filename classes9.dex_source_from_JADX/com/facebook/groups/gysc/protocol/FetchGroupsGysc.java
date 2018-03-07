package com.facebook.groups.gysc.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.gysc.protocol.FetchGroupsGyscModels.FetchGroupCreationSuggestionsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: payments */
public final class FetchGroupsGysc {

    /* compiled from: payments */
    public class FetchGroupCreationSuggestionsString extends TypedGraphQlQueryString<FetchGroupCreationSuggestionsModel> {
        public FetchGroupCreationSuggestionsString() {
            super(FetchGroupCreationSuggestionsModel.class, false, "FetchGroupCreationSuggestions", "93ff27c37bb312bff8365e98847ce472", "viewer", "10154358537931729", RegularImmutableSet.a);
        }

        public final String m7226a(String str) {
            switch (str.hashCode()) {
                case -1523901860:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
