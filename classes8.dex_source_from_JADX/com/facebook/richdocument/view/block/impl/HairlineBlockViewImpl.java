package com.facebook.richdocument.view.block.impl;

import android.view.View;
import com.facebook.richdocument.presenter.HairlineBlockPresenter;
import com.facebook.richdocument.utils.UIUtils;
import com.facebook.richdocument.view.block.HairlineBlockView;

/* compiled from: page_service_id_extra */
public class HairlineBlockViewImpl extends AbstractBlockView<HairlineBlockPresenter> implements HairlineBlockView {
    public HairlineBlockViewImpl(View view) {
        super(view);
    }

    public final void mo388c(int i) {
        UIUtils.m6864a(iY_(), i);
    }

    public final void mo386a(int i) {
        iY_().getLayoutParams().width = i;
        iY_().requestLayout();
    }

    public final void mo387b(int i) {
        iY_().getLayoutParams().height = i;
        iY_().requestLayout();
    }
}
