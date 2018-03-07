package com.facebook.instantshopping.model.data.impl;

import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.HasElementDescriptor;
import com.facebook.instantshopping.model.data.HasLoggingParams;
import com.facebook.instantshopping.model.data.HasTextMetrics;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingDocumentExpandableSectionElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import javax.annotation.Nullable;

/* compiled from: Saved Item %s does not have ID to be logged. */
public class ExpandableBlockDataImpl extends BaseElementDescriptorBlockData implements HasElementDescriptor, HasLoggingParams, HasTextMetrics, InstantShoppingBlockData {
    public final InstantShoppingDocumentExpandableSectionElementFragment f23642a;

    public ExpandableBlockDataImpl(NodeModel nodeModel, int i) {
        super(nodeModel.d(), 105, i);
        this.f23642a = nodeModel;
    }

    public final LoggingParams mo1008C() {
        return new LoggingParams(this.f23642a.iI_(), this.f23642a.c().toString());
    }

    @Nullable
    public final InstantShoppingTextMetricsDescriptorFragmentModel mo1021f() {
        if (this.f23642a.o().d() != null) {
            return this.f23642a.o().d().g();
        }
        return null;
    }
}
