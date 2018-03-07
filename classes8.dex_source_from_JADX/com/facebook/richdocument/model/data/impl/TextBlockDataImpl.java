package com.facebook.richdocument.model.data.impl;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.TextBlockData;
import com.facebook.richdocument.model.data.impl.BaseBlockData.BaseBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;

/* compiled from: photo_selected_count */
public class TextBlockDataImpl extends BaseBlockData implements TextBlockData {
    private final RichDocumentText f5724a;
    private final RichDocumentTextType f5725b;
    private final int f5726c;

    /* compiled from: photo_selected_count */
    public class TextBlockDataBuilder extends BaseBlockDataBuilder<TextBlockData> {
        public final RichDocumentText f5717a;
        public RichDocumentTextType f5718b;
        public int f5719c;

        public /* synthetic */ BlockData mo288b() {
            return mo295c();
        }

        public TextBlockDataBuilder(RichDocumentText richDocumentText) {
            this(3, richDocumentText);
        }

        public TextBlockDataBuilder(int i, RichDocumentText richDocumentText) {
            super(i);
            this.f5719c = 0;
            this.f5717a = richDocumentText;
            this.f5718b = RichDocumentTextType.from(richDocumentText.mo300a());
        }

        public TextBlockData mo295c() {
            return new TextBlockDataImpl(this);
        }
    }

    protected TextBlockDataImpl(TextBlockDataBuilder textBlockDataBuilder) {
        super((BaseBlockDataBuilder) textBlockDataBuilder);
        this.f5724a = textBlockDataBuilder.f5717a;
        this.f5725b = textBlockDataBuilder.f5718b;
        this.f5726c = textBlockDataBuilder.f5719c;
    }

    public final RichDocumentText mo297f() {
        return this.f5724a;
    }

    public final RichDocumentTextType mo298g() {
        return this.f5725b;
    }

    public final int mo296a() {
        return this.f5726c;
    }

    public GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.RICH_TEXT;
    }
}
