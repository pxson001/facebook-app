package com.facebook.instantshopping.model.data.impl;

import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.HasElementDescriptor;
import com.facebook.instantshopping.model.data.HasLoggingParams;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingCompositeBlockElementFragment;

/* compiled from: Saved Item %s exits the viewport without entering. */
public class CompositeBlockDataImpl extends BaseElementDescriptorBlockData implements HasElementDescriptor, HasLoggingParams, InstantShoppingBlockData {
    public final InstantShoppingCompositeBlockElementFragment f23641a;

    public CompositeBlockDataImpl(InstantShoppingCompositeBlockElementFragment instantShoppingCompositeBlockElementFragment) {
        super(instantShoppingCompositeBlockElementFragment.d(), 106, instantShoppingCompositeBlockElementFragment.g());
        this.f23641a = instantShoppingCompositeBlockElementFragment;
    }

    public final LoggingParams mo1008C() {
        return new LoggingParams(this.f23641a.iI_(), this.f23641a.c().toString());
    }
}
