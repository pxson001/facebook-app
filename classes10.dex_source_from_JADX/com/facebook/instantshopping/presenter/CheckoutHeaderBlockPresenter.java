package com.facebook.instantshopping.presenter;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.HeaderElementsModel;
import com.facebook.instantshopping.utils.InstantShoppingCart;
import com.facebook.instantshopping.utils.InstantShoppingDocumentContext;
import com.facebook.instantshopping.view.block.HeaderBlockView;
import com.facebook.instantshopping.view.block.impl.CheckoutHeaderBlockViewImpl;
import com.facebook.richdocument.model.data.BlockData;
import javax.inject.Inject;

/* compiled from: SUGGESTIONS_FETCHED */
public class CheckoutHeaderBlockPresenter extends HeaderBlockPresenter {
    @Inject
    public InstantShoppingCart f23663d;
    @Inject
    public InstantShoppingDocumentContext f23664e;
    private final HeaderElementsModel f23665f;

    public static void m24986a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CheckoutHeaderBlockPresenter checkoutHeaderBlockPresenter = (CheckoutHeaderBlockPresenter) obj;
        InstantShoppingCart a = InstantShoppingCart.a(fbInjector);
        InstantShoppingDocumentContext a2 = InstantShoppingDocumentContext.a(fbInjector);
        checkoutHeaderBlockPresenter.f23663d = a;
        checkoutHeaderBlockPresenter.f23664e = a2;
    }

    public final /* synthetic */ void mo1023a(BlockData blockData) {
        mo1024b();
    }

    public CheckoutHeaderBlockPresenter(HeaderBlockView headerBlockView, HeaderElementsModel headerElementsModel) {
        super(headerBlockView);
        this.f23665f = headerElementsModel;
        Class cls = CheckoutHeaderBlockPresenter.class;
        m24986a(this, getContext());
    }

    public final void mo1024b() {
        ((HeaderBlockView) this.d).mo1028c();
        ((CheckoutHeaderBlockViewImpl) this.d).m25041a(this.f23663d.c(this.f23664e.b));
        ((CheckoutHeaderBlockViewImpl) this.d).f23716h = this.f23665f.iL_();
        ((HeaderBlockView) this.d).mo1027a(this.f23665f.a());
    }
}
