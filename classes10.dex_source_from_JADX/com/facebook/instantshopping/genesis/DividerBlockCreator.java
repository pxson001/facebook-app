package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.InstantShoppingDividerPresenter;
import com.facebook.instantshopping.view.block.InstantShoppingDividerBlockView;
import com.facebook.instantshopping.view.block.impl.InstantShoppingDividerBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: Show requests queue */
public class DividerBlockCreator extends BaseBlockCreator<InstantShoppingDividerBlockView> {
    public final AbstractBlockPresenter m24824a(BlockView blockView) {
        return new InstantShoppingDividerPresenter((InstantShoppingDividerBlockViewImpl) blockView);
    }

    @Inject
    public DividerBlockCreator() {
        super(2130904949, 102);
    }

    public final BlockView m24825a(View view) {
        return new InstantShoppingDividerBlockViewImpl(view);
    }
}
