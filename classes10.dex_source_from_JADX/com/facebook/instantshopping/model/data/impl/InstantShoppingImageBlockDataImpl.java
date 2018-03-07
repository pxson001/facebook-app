package com.facebook.instantshopping.model.data.impl;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.instantshopping.model.block.media.InstantShoppingPhoto;
import com.facebook.instantshopping.model.data.CanStretchNarrowFitToHeightMedia;
import com.facebook.instantshopping.model.data.HasInteractionHint;
import com.facebook.instantshopping.model.data.HasPreviewPayload;
import com.facebook.instantshopping.model.data.InstantShoppingImageBlockData;
import com.facebook.instantshopping.model.data.InstantShoppingMediaBlock;
import com.facebook.instantshopping.model.data.LandscapeEnabled;
import com.facebook.instantshopping.model.data.LinkableMediaSection;
import com.facebook.instantshopping.model.data.MediaHasCaption;
import com.facebook.instantshopping.model.data.MediaHasOverlay;
import com.facebook.instantshopping.model.data.TiltableMediaSection;
import com.facebook.instantshopping.model.data.impl.BaseInstantShoppingMediaBlock.BaseInstantShoppingMediaBlockBuilder;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingPhotoElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingCompositeBlockElementFragmentModel.BlockElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;

/* compiled from: SampleIntegrationAppRoute */
public class InstantShoppingImageBlockDataImpl extends BaseInstantShoppingMediaBlock implements CanStretchNarrowFitToHeightMedia, HasInteractionHint, HasPreviewPayload, InstantShoppingMediaBlock, LandscapeEnabled, LinkableMediaSection, MediaHasCaption, MediaHasOverlay, TiltableMediaSection, ImageBlockData {
    private final FBPhoto f23644a;

    /* compiled from: SampleIntegrationAppRoute */
    public class InstantShoppingImageBlockDataBuilder extends BaseInstantShoppingMediaBlockBuilder<InstantShoppingImageBlockData> {
        public final FBPhoto f23643a;

        public final /* synthetic */ BlockData m24962b() {
            return m24963d();
        }

        public InstantShoppingImageBlockDataBuilder(NodeModel nodeModel, int i, int i2) {
            super(nodeModel, i, i2);
            this.f23643a = new InstantShoppingPhoto(nodeModel.n());
        }

        public InstantShoppingImageBlockDataBuilder(BlockElementsModel blockElementsModel, int i, int i2) {
            super(blockElementsModel, i, i2);
            this.f23643a = new InstantShoppingPhoto(blockElementsModel.n());
        }

        public InstantShoppingImageBlockDataBuilder(InstantShoppingPhotoElementFragment instantShoppingPhotoElementFragment, int i, int i2) {
            super(instantShoppingPhotoElementFragment, i, i2);
            this.f23643a = new InstantShoppingPhoto(instantShoppingPhotoElementFragment.n());
        }

        public final InstantShoppingImageBlockDataImpl m24963d() {
            return new InstantShoppingImageBlockDataImpl(this);
        }
    }

    public InstantShoppingImageBlockDataImpl(InstantShoppingImageBlockDataBuilder instantShoppingImageBlockDataBuilder) {
        super(instantShoppingImageBlockDataBuilder);
        this.f23644a = instantShoppingImageBlockDataBuilder.f23643a;
    }

    public final FBPhoto m24964a() {
        return this.f23644a;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.PHOTO;
    }
}
