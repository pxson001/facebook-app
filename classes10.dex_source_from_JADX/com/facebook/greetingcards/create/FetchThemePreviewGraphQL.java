package com.facebook.greetingcards.create;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.greetingcards.create.FetchThemePreviewGraphQLModels.FetchThemePreviewQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: {placeholder_text} */
public final class FetchThemePreviewGraphQL {

    /* compiled from: {placeholder_text} */
    public class FetchThemePreviewQueryString extends TypedGraphQlQueryString<FetchThemePreviewQueryModel> {
        public FetchThemePreviewQueryString() {
            super(FetchThemePreviewQueryModel.class, false, "FetchThemePreviewQuery", "e00b601cc18f43d82509425914510b5c", "node", "10154341706066729", RegularImmutableSet.a);
        }

        public final String m26a(String str) {
            switch (str.hashCode()) {
                case -925312643:
                    return "0";
                case 109250890:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
