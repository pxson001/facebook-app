package com.facebook.instantshopping.model.block;

import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.FooterElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.HeaderElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingFontObjectFragmentModel;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.google.common.collect.ImmutableList;

/* compiled from: SetJavaScriptEnabled */
public class InstantShoppingBlocks extends RichDocumentBlocksImpl {
    private final String f23581a;
    public String f23582b;
    public ImmutableList<HeaderElementsModel> f23583c;
    public ImmutableList<FooterElementsModel> f23584d;
    public InstantShoppingDocumentFragmentModel f23585e;
    public ImmutableList<InstantShoppingFontObjectFragmentModel> f23586f;

    public InstantShoppingBlocks(String str) {
        this(str, null);
    }

    private InstantShoppingBlocks(String str, String str2) {
        super(str);
        this.f23581a = str2;
    }
}
