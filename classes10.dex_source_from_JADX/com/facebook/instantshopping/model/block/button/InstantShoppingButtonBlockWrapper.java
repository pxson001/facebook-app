package com.facebook.instantshopping.model.block.button;

import android.graphics.Color;
import com.facebook.instantshopping.model.block.BaseInstantShoppingBlockWrapper;
import com.facebook.instantshopping.model.block.HasTextMetrics;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingButtonElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import javax.annotation.Nullable;

/* compiled from: Set all inline FB videos to unmuted state */
public class InstantShoppingButtonBlockWrapper extends BaseInstantShoppingBlockWrapper implements HasTextMetrics {
    public final InstantShoppingButtonElementFragment f23589a;

    public InstantShoppingButtonBlockWrapper(InstantShoppingButtonElementFragment instantShoppingButtonElementFragment) {
        super(instantShoppingButtonElementFragment.d());
        this.f23589a = instantShoppingButtonElementFragment;
    }

    @Nullable
    public final InstantShoppingTextMetricsDescriptorFragmentModel nu_() {
        return this.f23589a.d() != null ? this.f23589a.d().g() : null;
    }

    public final int m24897c() {
        if (this.f23589a.b() == null) {
            return -1;
        }
        return this.f23589a.b().startsWith("#") ? Color.parseColor(this.f23589a.b()) : Color.parseColor("#" + this.f23589a.b());
    }
}
