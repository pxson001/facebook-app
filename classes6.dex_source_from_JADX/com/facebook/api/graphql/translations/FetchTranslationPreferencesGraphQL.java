package com.facebook.api.graphql.translations;

import com.facebook.api.graphql.translations.FetchTranslationPreferencesGraphQLModels.NeverTranslateLanguageCoreMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: prompt_image */
public final class FetchTranslationPreferencesGraphQL {

    /* compiled from: prompt_image */
    public class NeverTranslateLanguageCoreMutationString extends TypedGraphQLMutationString<NeverTranslateLanguageCoreMutationFieldsModel> {
        public NeverTranslateLanguageCoreMutationString() {
            super(NeverTranslateLanguageCoreMutationFieldsModel.class, false, "NeverTranslateLanguageCoreMutation", "62421b3434ba72340ca303f067271ab7", "never_translate_language", "0", "10154339187121729", RegularImmutableSet.a);
        }

        public final String m10295a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
