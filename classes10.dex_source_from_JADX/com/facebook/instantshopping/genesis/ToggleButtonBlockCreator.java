package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.ToggleButtonBlockPresenter;
import com.facebook.instantshopping.view.block.ToggleButtonBlockView;
import com.facebook.instantshopping.view.block.impl.ToggleButtonBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: Shopping */
public class ToggleButtonBlockCreator extends BaseBlockCreator<ToggleButtonBlockView> {
    public final AbstractBlockPresenter m24844a(BlockView blockView) {
        return new ToggleButtonBlockPresenter((ToggleButtonBlockViewImpl) blockView);
    }

    @Inject
    public ToggleButtonBlockCreator() {
        super(2130904962, 109);
    }

    public final BlockView m24845a(View view) {
        return new ToggleButtonBlockViewImpl(view);
    }
}
