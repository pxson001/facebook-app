package com.facebook.instantshopping.model.data;

import com.facebook.graphql.enums.GraphQLInstantShoppingPresentationStyle;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingTextElementFragment;
import com.facebook.richdocument.model.data.AnnotatableBlock;
import com.facebook.richdocument.model.data.CoverMediaBlock;
import com.facebook.richdocument.model.data.SlideBlock;
import java.util.List;

/* compiled from: SavedItemReviewedEvent posted without page Id */
public interface InstantShoppingMediaBlock extends CanStretchNarrowFitToHeightMedia, HasElementDescriptor, HasInteractionHint, HasPreviewPayload, InstantShoppingBlockData, LandscapeEnabled, LinkableMediaSection, MediaHasCaption, MediaHasOverlay, NonAdjustedFitToWidthSlide, TiltableMediaSection, AnnotatableBlock, CoverMediaBlock, SlideBlock {
    List<? extends InstantShoppingTextElementFragment> mo1009D();

    List<GraphQLInstantShoppingPresentationStyle> mo1010E();
}
