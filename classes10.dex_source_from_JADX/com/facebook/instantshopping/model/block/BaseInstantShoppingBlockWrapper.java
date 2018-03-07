package com.facebook.instantshopping.model.block;

import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingElementDescriptorFragmentModel;
import javax.annotation.Nullable;

/* compiled from: Share */
public class BaseInstantShoppingBlockWrapper {
    private final InstantShoppingElementDescriptorFragmentModel f23580a;

    public BaseInstantShoppingBlockWrapper(InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel) {
        this.f23580a = instantShoppingElementDescriptorFragmentModel;
    }

    @Nullable
    public final GraphQLInstantShoppingDocumentAlignmentDescriptorType m24891e() {
        return this.f23580a != null ? this.f23580a.a() : null;
    }
}
