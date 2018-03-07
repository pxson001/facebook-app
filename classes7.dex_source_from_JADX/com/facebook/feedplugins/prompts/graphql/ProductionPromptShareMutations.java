package com.facebook.feedplugins.prompts.graphql;

import com.facebook.feedplugins.prompts.graphql.ProductionPromptShareMutationsModels.ProductionPromptShareMutationFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: SINGLE_IMAGE_PORTRAIT_SQUARE_HEIGHT */
public final class ProductionPromptShareMutations {

    /* compiled from: SINGLE_IMAGE_PORTRAIT_SQUARE_HEIGHT */
    public class ProductionPromptShareMutationsString extends TypedGraphQLMutationString<ProductionPromptShareMutationFieldsModel> {
        public ProductionPromptShareMutationsString() {
            super(ProductionPromptShareMutationFieldsModel.class, false, "ProductionPromptShareMutations", "831929b1820f6a585c55a963f0556bb8", "production_prompt_share", "0", "10154553158861729", RegularImmutableSet.a);
        }

        public final String m25925a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
