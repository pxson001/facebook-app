package com.facebook.feedplugins.articlechaining.protocol;

import com.facebook.feedplugins.articlechaining.protocol.ArticleHideSuggestionMutationModels.ArticleHideSuggestionMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TP;TE;) */
public final class ArticleHideSuggestionMutation {

    /* compiled from: TP;TE;) */
    public class ArticleHideSuggestionMutationString extends TypedGraphQLMutationString<ArticleHideSuggestionMutationModel> {
        public ArticleHideSuggestionMutationString() {
            super(ArticleHideSuggestionMutationModel.class, false, "ArticleHideSuggestionMutation", "44b56c3465e44b4674f503e0a9c76ef3", "article_hide_suggestion", "0", "10154204802991729", RegularImmutableSet.a);
        }

        public final String m25243a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
