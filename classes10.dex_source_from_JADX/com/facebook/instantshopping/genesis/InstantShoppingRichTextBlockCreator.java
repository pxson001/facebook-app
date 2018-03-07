package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.InstantShoppingTextBlockPresenter;
import com.facebook.instantshopping.view.block.InstantShoppingTextBlockView;
import com.facebook.instantshopping.view.block.impl.InstantShoppingTextBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: Should not reach this code path. */
public class InstantShoppingRichTextBlockCreator extends BaseBlockCreator<InstantShoppingTextBlockView> {
    public final AbstractBlockPresenter m24832a(BlockView blockView) {
        return new InstantShoppingTextBlockPresenter((InstantShoppingTextBlockViewImpl) blockView);
    }

    @Inject
    public InstantShoppingRichTextBlockCreator() {
        super(2130904961, 112);
    }

    public final BlockView m24833a(View view) {
        return new InstantShoppingTextBlockViewImpl(view);
    }
}
