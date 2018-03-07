package com.facebook.richdocument.model.data.impl;

import android.content.Context;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.OGBlock;
import com.facebook.richdocument.model.data.TextBlockData;
import com.facebook.richdocument.model.data.impl.TextBlockDataImpl.TextBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;

/* compiled from: photo_results_count */
public class ListItemBlockDataImpl extends TextBlockDataImpl implements OGBlock, TextBlockData {
    public final int f5727a;
    public final boolean f5728b;
    public final String f5729c;

    /* compiled from: photo_results_count */
    public class ListItemBlockDataBuilder extends TextBlockDataBuilder {
        public int f5720a;
        public final int f5721b;
        public final boolean f5722c;
        public final Context f5723d;

        public final /* synthetic */ BlockData mo288b() {
            return mo295c();
        }

        public ListItemBlockDataBuilder(Context context, RichDocumentText richDocumentText, boolean z, int i) {
            this(22, context, richDocumentText, z, i);
        }

        private ListItemBlockDataBuilder(int i, Context context, RichDocumentText richDocumentText, boolean z, int i2) {
            super(i, richDocumentText);
            this.f5723d = context;
            this.f5721b = i2;
            this.f5722c = z;
        }

        public final TextBlockData mo295c() {
            return new ListItemBlockDataImpl(this);
        }
    }

    public ListItemBlockDataImpl(ListItemBlockDataBuilder listItemBlockDataBuilder) {
        super(listItemBlockDataBuilder);
        this.f5727a = listItemBlockDataBuilder.f5720a;
        this.f5728b = listItemBlockDataBuilder.f5722c;
        if (this.f5728b) {
            this.f5729c = listItemBlockDataBuilder.f5723d.getString(2131237718, new Object[]{Integer.toString(listItemBlockDataBuilder.f5721b + 1)});
            return;
        }
        this.f5729c = listItemBlockDataBuilder.f5723d.getString(2131237719);
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.LIST_ITEM;
    }
}
