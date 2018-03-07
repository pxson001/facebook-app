package com.facebook.richdocument.model.data.impl;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.SlideshowBlockData;
import com.facebook.richdocument.model.data.impl.BaseAnnotableBlockData.BaseAnnotatableBlockBuilder;
import javax.annotation.Nullable;

/* compiled from: photo_picker_gallery_select_photo */
public class SlideshowBlockDataImpl extends BaseAnnotableBlockData implements SlideshowBlockData {
    private final RichDocumentBlocksImpl f5764a;
    private final GraphQLDocumentMediaPresentationStyle f5765b;
    private final boolean f5766c;

    /* compiled from: photo_picker_gallery_select_photo */
    public class SlideshowBlockDataBuilder extends BaseAnnotatableBlockBuilder<SlideshowBlockData> {
        public final RichDocumentBlocksImpl f5761a;
        public final GraphQLDocumentMediaPresentationStyle f5762b;
        public boolean f5763c;

        public SlideshowBlockDataBuilder(RichDocumentBlocksImpl richDocumentBlocksImpl, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
            this(6, richDocumentBlocksImpl, graphQLDocumentMediaPresentationStyle);
        }

        private SlideshowBlockDataBuilder(int i, RichDocumentBlocksImpl richDocumentBlocksImpl, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
            super(i);
            this.f5761a = richDocumentBlocksImpl;
            this.f5762b = graphQLDocumentMediaPresentationStyle;
        }

        public final BlockData mo288b() {
            return new SlideshowBlockDataImpl(this);
        }
    }

    public SlideshowBlockDataImpl(SlideshowBlockDataBuilder slideshowBlockDataBuilder) {
        super(slideshowBlockDataBuilder);
        this.f5764a = slideshowBlockDataBuilder.f5761a;
        this.f5765b = slideshowBlockDataBuilder.f5762b;
        this.f5766c = slideshowBlockDataBuilder.f5763c;
    }

    @Nullable
    public final RichDocumentBlocksImpl mo304a() {
        return this.f5764a;
    }

    @Nullable
    public final GraphQLDocumentMediaPresentationStyle mo293m() {
        return this.f5765b;
    }

    public final boolean iR_() {
        return this.f5766c;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.SLIDESHOW;
    }
}
