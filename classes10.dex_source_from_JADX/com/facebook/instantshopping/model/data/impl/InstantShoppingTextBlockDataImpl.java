package com.facebook.instantshopping.model.data.impl;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.data.HasElementDescriptor;
import com.facebook.instantshopping.model.data.InstantShoppingBlockData;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingTextElementFragment;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.data.TextBlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;

/* compiled from: SWITCH_PROMO */
public class InstantShoppingTextBlockDataImpl extends BaseElementDescriptorBlockData implements HasElementDescriptor, InstantShoppingBlockData, TextBlockData {
    private final RichDocumentText f23651a;
    private final RichDocumentTextType f23652b = RichDocumentTextType.from(this.f23651a.a());
    public final boolean f23653c;
    private final LoggingParams f23654d;

    public InstantShoppingTextBlockDataImpl(InstantShoppingTextElementFragment instantShoppingTextElementFragment, int i, boolean z) {
        super(instantShoppingTextElementFragment.d(), 112, i);
        this.f23651a = instantShoppingTextElementFragment.iK_();
        this.f23653c = z;
        this.f23654d = new LoggingParams(instantShoppingTextElementFragment.iI_(), instantShoppingTextElementFragment.c().toString());
    }

    public final RichDocumentText m24970f() {
        return this.f23651a;
    }

    public final RichDocumentTextType m24971g() {
        return this.f23652b;
    }

    public final int m24969a() {
        return 0;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.RICH_TEXT;
    }

    public final LoggingParams mo1008C() {
        return this.f23654d;
    }
}
