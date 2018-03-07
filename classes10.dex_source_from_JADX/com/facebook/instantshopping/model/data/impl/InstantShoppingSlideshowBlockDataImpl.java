package com.facebook.instantshopping.model.data.impl;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.instantshopping.model.data.CanStretchNarrowFitToHeightMedia;
import com.facebook.instantshopping.model.data.HasInteractionHint;
import com.facebook.instantshopping.model.data.InstantShoppingMediaBlock;
import com.facebook.instantshopping.model.data.InstantShoppingSlideshowBlockData;
import com.facebook.instantshopping.model.data.NonAdjustedFitToWidthSlide;
import com.facebook.instantshopping.model.data.impl.BaseInstantShoppingMediaBlock.BaseInstantShoppingMediaBlockBuilder;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.SlideshowBlockData;
import javax.annotation.Nullable;

/* compiled from: SWITCH_TO_DBL */
public class InstantShoppingSlideshowBlockDataImpl extends BaseInstantShoppingMediaBlock implements CanStretchNarrowFitToHeightMedia, HasInteractionHint, InstantShoppingMediaBlock, NonAdjustedFitToWidthSlide, SlideshowBlockData {
    private final RichDocumentBlocksImpl f23648a;
    public final int f23649b;
    private final boolean f23650c;

    /* compiled from: SWITCH_TO_DBL */
    public class InstantShoppingSlideshowBlockDataBuilder extends BaseInstantShoppingMediaBlockBuilder<InstantShoppingSlideshowBlockData> {
        public final RichDocumentBlocksImpl f23645a;
        public int f23646b = 0;
        public boolean f23647c = true;

        public final /* synthetic */ BlockData m24965b() {
            return m24966d();
        }

        public InstantShoppingSlideshowBlockDataBuilder(RichDocumentBlocksImpl richDocumentBlocksImpl, NodeModel nodeModel, int i, int i2) {
            super(nodeModel, i, i2);
            this.f23645a = richDocumentBlocksImpl;
            this.f23620m = true;
        }

        public final InstantShoppingSlideshowBlockDataImpl m24966d() {
            return new InstantShoppingSlideshowBlockDataImpl(this);
        }
    }

    public InstantShoppingSlideshowBlockDataImpl(InstantShoppingSlideshowBlockDataBuilder instantShoppingSlideshowBlockDataBuilder) {
        super(instantShoppingSlideshowBlockDataBuilder);
        this.f23648a = instantShoppingSlideshowBlockDataBuilder.f23645a;
        this.f23649b = instantShoppingSlideshowBlockDataBuilder.f23646b;
        this.f23650c = instantShoppingSlideshowBlockDataBuilder.f23647c;
    }

    @Nullable
    public final RichDocumentBlocksImpl m24967a() {
        return this.f23648a;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.SLIDESHOW;
    }
}
