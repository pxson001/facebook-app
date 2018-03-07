package com.facebook.instantshopping.model.data.impl;

import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.HasElementDescriptor;
import com.facebook.instantshopping.model.data.HasLoggingParams;
import com.facebook.instantshopping.model.data.HasTextMetrics;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingButtonElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import javax.annotation.Nullable;

/* compiled from: Saved item target is null. */
public class ButtonBlockDataImpl extends BaseElementDescriptorBlockData implements HasElementDescriptor, HasLoggingParams, HasTextMetrics, InstantShoppingBlockData {
    public final InstantShoppingButtonElementFragment f23639a;

    public ButtonBlockDataImpl(InstantShoppingButtonElementFragment instantShoppingButtonElementFragment) {
        super(instantShoppingButtonElementFragment.d(), 113, instantShoppingButtonElementFragment.g());
        this.f23639a = instantShoppingButtonElementFragment;
    }

    @Nullable
    public final InstantShoppingTextMetricsDescriptorFragmentModel mo1021f() {
        return this.f23639a.d() != null ? this.f23639a.d().g() : null;
    }

    public final int mo1000B() {
        return this.f23639a.g();
    }

    public final LoggingParams mo1008C() {
        return new LoggingParams(this.f23639a.iI_(), this.f23639a.c().toString());
    }
}
