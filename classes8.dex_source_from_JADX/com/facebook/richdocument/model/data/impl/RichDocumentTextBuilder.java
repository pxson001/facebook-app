package com.facebook.richdocument.model.data.impl;

import com.facebook.graphql.enums.GraphQLComposedBlockType;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText.EntityRanges;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText.InlineStyleRanges;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: photo_picker_grid_select_photo */
public class RichDocumentTextBuilder {
    public String f5755a;
    public GraphQLComposedBlockType f5756b;
    private int f5757c;
    public ImmutableList<? extends InlineStyleRanges> f5758d = RegularImmutableList.a;
    public ImmutableList<? extends EntityRanges> f5759e = RegularImmutableList.a;

    /* compiled from: photo_picker_grid_select_photo */
    class RichDocumentTextImpl implements RichDocumentText {
        final /* synthetic */ RichDocumentTextBuilder f5749a;
        private final String f5750b;
        private final GraphQLComposedBlockType f5751c;
        private final int f5752d;
        private final ImmutableList<? extends InlineStyleRanges> f5753e;
        private final ImmutableList<? extends EntityRanges> f5754f;

        public RichDocumentTextImpl(RichDocumentTextBuilder richDocumentTextBuilder, GraphQLComposedBlockType graphQLComposedBlockType, String str, int i, ImmutableList<? extends InlineStyleRanges> immutableList, ImmutableList<? extends EntityRanges> immutableList2) {
            this.f5749a = richDocumentTextBuilder;
            this.f5751c = graphQLComposedBlockType;
            this.f5750b = str;
            this.f5752d = i;
            this.f5753e = immutableList;
            this.f5754f = immutableList2;
        }

        @Nullable
        public final GraphQLComposedBlockType mo300a() {
            return this.f5749a.f5756b;
        }

        public final ImmutableList<? extends EntityRanges> mo301b() {
            return this.f5749a.f5759e;
        }

        public final ImmutableList<? extends InlineStyleRanges> mo302c() {
            return this.f5749a.f5758d;
        }

        @Nullable
        public final String mo303d() {
            return this.f5749a.f5755a;
        }
    }

    public final RichDocumentText m5547a() {
        return new RichDocumentTextImpl(this, this.f5756b, this.f5755a, this.f5757c, this.f5758d, this.f5759e);
    }
}
