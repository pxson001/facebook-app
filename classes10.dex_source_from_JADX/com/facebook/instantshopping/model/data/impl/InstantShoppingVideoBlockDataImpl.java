package com.facebook.instantshopping.model.data.impl;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.instantshopping.model.data.CanStretchNarrowFitToHeightMedia;
import com.facebook.instantshopping.model.data.HasInteractionHint;
import com.facebook.instantshopping.model.data.InstantShoppingMediaBlock;
import com.facebook.instantshopping.model.data.InstantShoppingVideoBlockData;
import com.facebook.instantshopping.model.data.LandscapeEnabled;
import com.facebook.instantshopping.model.data.LinkableMediaSection;
import com.facebook.instantshopping.model.data.impl.BaseInstantShoppingMediaBlock.BaseInstantShoppingMediaBlockBuilder;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.SlideBlock;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import javax.annotation.Nullable;

/* compiled from: SWITCH_CONTACTPOINT_TYPE */
public class InstantShoppingVideoBlockDataImpl extends BaseInstantShoppingMediaBlock implements CanStretchNarrowFitToHeightMedia, HasInteractionHint, InstantShoppingMediaBlock, LandscapeEnabled, LinkableMediaSection, SlideBlock, VideoBlockData {
    private final NodeModel f23657a;
    public final boolean f23658b;

    /* compiled from: SWITCH_CONTACTPOINT_TYPE */
    public class InstantShoppingVideoBlockDataBuilder extends BaseInstantShoppingMediaBlockBuilder<InstantShoppingVideoBlockData> {
        public final NodeModel f23655a;
        public boolean f23656b;

        public final /* synthetic */ BlockData m24972b() {
            return m24973d();
        }

        public InstantShoppingVideoBlockDataBuilder(NodeModel nodeModel, int i, int i2) {
            super(nodeModel, i, i2);
            this.f23655a = nodeModel;
        }

        public final InstantShoppingVideoBlockDataImpl m24973d() {
            return new InstantShoppingVideoBlockDataImpl(this);
        }
    }

    public InstantShoppingVideoBlockDataImpl(InstantShoppingVideoBlockDataBuilder instantShoppingVideoBlockDataBuilder) {
        super(instantShoppingVideoBlockDataBuilder);
        this.f23657a = instantShoppingVideoBlockDataBuilder.f23655a;
        this.f23658b = instantShoppingVideoBlockDataBuilder.f23656b;
    }

    @Nullable
    public final FBVideo m24974p() {
        return this.f23657a.y();
    }

    @Nullable
    public final GraphQLDocumentVideoAutoplayStyle m24976r() {
        return this.f23657a.v();
    }

    @Nullable
    public final GraphQLDocumentVideoControlStyle m24977s() {
        return this.f23657a.x();
    }

    @Nullable
    public final GraphQLDocumentVideoLoopingStyle m24978t() {
        return this.f23657a.B();
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.VIDEO;
    }

    public final boolean iS_() {
        return false;
    }

    @Nullable
    public final FBPhoto m24975q() {
        return null;
    }
}
