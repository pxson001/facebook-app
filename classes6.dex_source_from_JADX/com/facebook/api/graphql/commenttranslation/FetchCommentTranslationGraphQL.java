package com.facebook.api.graphql.commenttranslation;

import com.facebook.api.graphql.commenttranslation.FetchCommentTranslationGraphQLModels.TranslatedCommentBodyModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: prompt_tracking_string */
public final class FetchCommentTranslationGraphQL {

    /* compiled from: prompt_tracking_string */
    public class TranslatedCommentBodyString extends TypedGraphQlQueryString<TranslatedCommentBodyModel> {
        public TranslatedCommentBodyString() {
            super(TranslatedCommentBodyModel.class, false, "TranslatedCommentBody", "8d027b9094b6edbcbcd0e12653f5109d", "node", "10154354463066729", RegularImmutableSet.a);
        }

        public final String m10280a(String str) {
            switch (str.hashCode()) {
                case 899150587:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
