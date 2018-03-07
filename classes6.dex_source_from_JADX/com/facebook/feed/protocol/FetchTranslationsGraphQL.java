package com.facebook.feed.protocol;

import com.facebook.feed.protocol.FetchTranslationsGraphQLModels.TranslatedStoryMessageModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: min_broadacst_duration */
public final class FetchTranslationsGraphQL {

    /* compiled from: min_broadacst_duration */
    public class TranslatedStoryMessageString extends TypedGraphQlQueryString<TranslatedStoryMessageModel> {
        public TranslatedStoryMessageString() {
            super(TranslatedStoryMessageModel.class, false, "TranslatedStoryMessage", "e5c6f7f9aad2b7ccbd3a770d7fcf2279", "node", "10154429038491729", RegularImmutableSet.a);
        }

        public final String m16309a(String str) {
            switch (str.hashCode()) {
                case 1717754021:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
