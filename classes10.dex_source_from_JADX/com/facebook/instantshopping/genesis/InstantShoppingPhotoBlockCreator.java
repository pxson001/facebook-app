package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.LinkableImageBlockPresenter;
import com.facebook.instantshopping.view.block.impl.LinkableImageBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.ImageBlockView;
import com.facebook.richdocument.view.block.impl.ImageBlockViewImpl;
import javax.inject.Inject;

/* compiled from: Show PerfMarker in LogCat */
public class InstantShoppingPhotoBlockCreator extends BaseBlockCreator<ImageBlockView> {
    public final AbstractBlockPresenter m24830a(BlockView blockView) {
        return new LinkableImageBlockPresenter((ImageBlockViewImpl) blockView);
    }

    @Inject
    public InstantShoppingPhotoBlockCreator() {
        super(2130904956, 114);
    }

    public final BlockView m24831a(View view) {
        return LinkableImageBlockViewImpl.m25097b(view);
    }
}
