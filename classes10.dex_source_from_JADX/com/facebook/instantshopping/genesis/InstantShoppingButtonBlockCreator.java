package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.ButtonBlockPresenter;
import com.facebook.instantshopping.view.block.ButtonBlockView;
import com.facebook.instantshopping.view.block.impl.ButtonBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: Show navigation events when there is a page transition */
public class InstantShoppingButtonBlockCreator extends BaseBlockCreator<ButtonBlockView> {
    public final AbstractBlockPresenter m24828a(BlockView blockView) {
        return new ButtonBlockPresenter((ButtonBlockViewImpl) blockView);
    }

    @Inject
    public InstantShoppingButtonBlockCreator() {
        super(2130904941, 113);
    }

    public final BlockView m24829a(View view) {
        return new ButtonBlockViewImpl(view);
    }
}
