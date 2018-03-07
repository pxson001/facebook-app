package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.InstantShoppingVideoBlockPresenter;
import com.facebook.instantshopping.view.block.impl.InstantShoppingVideoBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.VideoBlockView;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: Should not be getting time zone before it has been set. */
public class InstantShoppingVideoBlockCreator extends BaseBlockCreator<VideoBlockView> {
    public final AbstractBlockPresenter m24836a(BlockView blockView) {
        return new InstantShoppingVideoBlockPresenter((VideoBlockViewImpl) blockView);
    }

    @Inject
    public InstantShoppingVideoBlockCreator() {
        super(2130904963, 115);
    }

    public final BlockView m24837a(View view) {
        return new InstantShoppingVideoBlockViewImpl((MediaFrame) view, view);
    }
}
