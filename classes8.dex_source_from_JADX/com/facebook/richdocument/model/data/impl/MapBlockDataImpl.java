package com.facebook.richdocument.model.data.impl;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentMapStyle;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.richdocument.model.data.AnnotatableBlock;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.MapBlockData;
import com.facebook.richdocument.model.data.OGBlock;
import com.facebook.richdocument.model.data.impl.BaseAnnotableBlockData.BaseAnnotatableBlockBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentLocationAnnotation;
import com.google.common.collect.ImmutableList;

/* compiled from: photo_picker_to_composer */
public class MapBlockDataImpl extends BaseAnnotableBlockData implements AnnotatableBlock, BlockData, OGBlock {
    public final int f5736a;
    public final GraphQLDocumentMapStyle f5737b;
    public final ImmutableList<? extends RichDocumentLocationAnnotation> f5738c;
    private final GraphQLDocumentMediaPresentationStyle f5739d;

    /* compiled from: photo_picker_to_composer */
    public class MapBlockBuilder extends BaseAnnotatableBlockBuilder<MapBlockData> {
        public final int f5732a;
        public final GraphQLDocumentMapStyle f5733b;
        public final ImmutableList<? extends RichDocumentLocationAnnotation> f5734c;
        public final GraphQLDocumentMediaPresentationStyle f5735d;

        public MapBlockBuilder(ImmutableList<? extends RichDocumentLocationAnnotation> immutableList, GraphQLDocumentMapStyle graphQLDocumentMapStyle, int i, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
            this(immutableList, graphQLDocumentMapStyle, i, graphQLDocumentMediaPresentationStyle, 7);
        }

        private MapBlockBuilder(ImmutableList<? extends RichDocumentLocationAnnotation> immutableList, GraphQLDocumentMapStyle graphQLDocumentMapStyle, int i, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle, int i2) {
            super(i2);
            this.f5732a = i;
            this.f5734c = immutableList;
            this.f5733b = graphQLDocumentMapStyle;
            this.f5735d = graphQLDocumentMediaPresentationStyle;
        }

        public final BlockData mo288b() {
            return new MapBlockDataImpl(this);
        }
    }

    public MapBlockDataImpl(MapBlockBuilder mapBlockBuilder) {
        super(mapBlockBuilder);
        this.f5736a = mapBlockBuilder.f5732a;
        this.f5738c = mapBlockBuilder.f5734c;
        this.f5737b = mapBlockBuilder.f5733b;
        this.f5739d = mapBlockBuilder.f5735d;
    }

    public final GraphQLDocumentMediaPresentationStyle mo293m() {
        return this.f5739d;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.MAP;
    }
}
