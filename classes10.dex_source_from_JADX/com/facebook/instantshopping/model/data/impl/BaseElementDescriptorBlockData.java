package com.facebook.instantshopping.model.data.impl;

import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.instantshopping.model.data.HasElementDescriptor;
import com.facebook.instantshopping.model.data.HasGridWidth;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.data.impl.BaseInstantShoppingBlockData.BaseInstantShoppingBlockDataBuilder;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingElementDescriptorFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import javax.annotation.Nullable;

/* compiled from: Saved2Fragment */
public abstract class BaseElementDescriptorBlockData extends BaseInstantShoppingBlockData implements HasElementDescriptor, HasGridWidth, InstantShoppingBlockData {
    private final InstantShoppingElementDescriptorFragmentModel f23606a;

    public BaseElementDescriptorBlockData(BaseInstantShoppingBlockDataBuilder baseInstantShoppingBlockDataBuilder, InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel) {
        super(baseInstantShoppingBlockDataBuilder);
        this.f23606a = instantShoppingElementDescriptorFragmentModel;
    }

    public BaseElementDescriptorBlockData(InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel, int i, int i2) {
        super(i, i2);
        this.f23606a = instantShoppingElementDescriptorFragmentModel;
    }

    @Nullable
    public final String mo1004u() {
        if (this.f23606a != null) {
            return this.f23606a.d();
        }
        return null;
    }

    @Nullable
    public final String nB_() {
        if (this.f23606a != null) {
            return this.f23606a.iM_();
        }
        return null;
    }

    @Nullable
    public final String mo1005w() {
        if (this.f23606a != null) {
            return this.f23606a.iN_();
        }
        return null;
    }

    @Nullable
    public final String nC_() {
        if (this.f23606a != null) {
            return this.f23606a.c();
        }
        return null;
    }

    @Nullable
    public final String mo1006y() {
        if (this.f23606a == null) {
            return null;
        }
        String b = this.f23606a.b();
        if (b == null || b.startsWith("#")) {
            return b;
        }
        return "#" + b;
    }

    @Nullable
    public final GraphQLInstantShoppingDocumentAlignmentDescriptorType mo1007z() {
        return this.f23606a != null ? this.f23606a.a() : null;
    }

    @Nullable
    public final InstantShoppingTextMetricsDescriptorFragmentModel mo1001A() {
        return this.f23606a != null ? this.f23606a.g() : null;
    }

    @Nullable
    public final String m24923l() {
        return null;
    }
}
