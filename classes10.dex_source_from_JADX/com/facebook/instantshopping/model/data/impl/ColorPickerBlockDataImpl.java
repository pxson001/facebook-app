package com.facebook.instantshopping.model.data.impl;

import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.HasElementDescriptor;
import com.facebook.instantshopping.model.data.HasLoggingParams;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingColorSelectorColorFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingColorSelectorElementFragment;
import com.google.common.collect.ImmutableList;

/* compiled from: Saved item ID is null or empty. */
public class ColorPickerBlockDataImpl extends BaseElementDescriptorBlockData implements HasElementDescriptor, HasLoggingParams, InstantShoppingBlockData {
    public final InstantShoppingColorSelectorElementFragment f23640a;

    public ColorPickerBlockDataImpl(InstantShoppingColorSelectorElementFragment instantShoppingColorSelectorElementFragment, int i, int i2) {
        super(instantShoppingColorSelectorElementFragment.d(), i, i2);
        this.f23640a = instantShoppingColorSelectorElementFragment;
    }

    public final ImmutableList<? extends InstantShoppingColorSelectorColorFragment> m24950b() {
        return this.f23640a.j();
    }

    public final LoggingParams mo1008C() {
        return new LoggingParams(this.f23640a.iI_(), this.f23640a.c().toString());
    }
}
