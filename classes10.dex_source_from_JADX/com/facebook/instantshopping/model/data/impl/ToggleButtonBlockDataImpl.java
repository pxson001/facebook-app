package com.facebook.instantshopping.model.data.impl;

import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.HasElementDescriptor;
import com.facebook.instantshopping.model.data.HasLoggingParams;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingToggleElementFragment;

/* compiled from: SWITCH */
public class ToggleButtonBlockDataImpl extends BaseElementDescriptorBlockData implements HasElementDescriptor, HasLoggingParams, InstantShoppingBlockData {
    public final InstantShoppingToggleElementFragment f23659a;

    public ToggleButtonBlockDataImpl(InstantShoppingToggleElementFragment instantShoppingToggleElementFragment, int i) {
        super(instantShoppingToggleElementFragment.d(), 109, i);
        this.f23659a = instantShoppingToggleElementFragment;
    }

    public final LoggingParams mo1008C() {
        return new LoggingParams(this.f23659a.iI_(), this.f23659a.c().toString());
    }
}
