package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.presenter.CompositeBlockPresenter;
import com.facebook.instantshopping.view.block.CompositeBlockView;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import javax.inject.Inject;

/* compiled from: STATE_SELECTED_QUANTITY */
public class CompositeBlockViewImpl extends AbstractBlockView<CompositeBlockPresenter> implements CompositeBlockView {
    @Inject
    public InstantShoppingAnalyticsLogger f23730a;

    public static void m25050a(Object obj, Context context) {
        ((CompositeBlockViewImpl) obj).f23730a = InstantShoppingAnalyticsLogger.m24853a(FbInjector.get(context));
    }

    public CompositeBlockViewImpl(View view) {
        super(view);
        Class cls = CompositeBlockViewImpl.class;
        m25050a(this, getContext());
    }

    public final void m25051a(Bundle bundle) {
        super.a(bundle);
        iY_().setVisibility(8);
    }
}
