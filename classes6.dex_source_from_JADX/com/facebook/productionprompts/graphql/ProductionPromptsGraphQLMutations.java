package com.facebook.productionprompts.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.productionprompts.graphql.ProductionPromptsGraphQLMutationsModels.ProductionPromptCoreMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: starting_view_name */
public final class ProductionPromptsGraphQLMutations {

    /* compiled from: starting_view_name */
    public class ProductionPromptDismissString extends TypedGraphQLMutationString<ProductionPromptCoreMutationFieldsModel> {
        public ProductionPromptDismissString() {
            super(ProductionPromptCoreMutationFieldsModel.class, false, "ProductionPromptDismiss", "e1bc6ef54f3911a6444a57c8147e304a", "production_prompt_dismiss", "0", "10154343227191729", RegularImmutableSet.a);
        }

        public final String m6250a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
