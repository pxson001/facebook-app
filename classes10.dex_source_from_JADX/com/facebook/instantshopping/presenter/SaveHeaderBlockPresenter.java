package com.facebook.instantshopping.presenter;

import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.HeaderElementsModel;
import com.facebook.instantshopping.view.block.HeaderBlockView;
import com.facebook.instantshopping.view.block.impl.SaveHeaderBlockViewImpl;
import com.facebook.richdocument.model.data.BlockData;

/* compiled from: STEP_VIEW */
public class SaveHeaderBlockPresenter extends HeaderBlockPresenter {
    private final HeaderElementsModel f23693d;

    public final /* synthetic */ void mo1023a(BlockData blockData) {
        mo1024b();
    }

    public SaveHeaderBlockPresenter(HeaderBlockView headerBlockView, HeaderElementsModel headerElementsModel) {
        super(headerBlockView);
        this.f23693d = headerElementsModel;
    }

    public final void mo1024b() {
        ((HeaderBlockView) this.d).mo1028c();
        ((SaveHeaderBlockViewImpl) this.d).m25113a(this.f23693d.d());
        ((HeaderBlockView) this.d).mo1027a(this.f23693d.a());
        ((SaveHeaderBlockViewImpl) this.d).f23829f = new LoggingParams(this.f23693d.c(), this.f23693d.b().toString());
    }
}
