package com.facebook.instantshopping.genesis;

import android.view.View;
import android.widget.ImageView;
import com.facebook.instantshopping.presenter.InstantShoppingSlideshowBlockPresenter;
import com.facebook.instantshopping.view.block.InstantShoppingSlideshowBlockView;
import com.facebook.instantshopping.view.block.impl.InstantShoppingSlideshowBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: Should not be starting hosts when no artist or hosts are provided. */
public class InstantShoppingSlideshowBlockCreator extends BaseBlockCreator<InstantShoppingSlideshowBlockView> {
    public final AbstractBlockPresenter m24834a(BlockView blockView) {
        return new InstantShoppingSlideshowBlockPresenter((InstantShoppingSlideshowBlockViewImpl) blockView);
    }

    @Inject
    public InstantShoppingSlideshowBlockCreator() {
        super(2130904958, 116);
    }

    public final BlockView m24835a(View view) {
        return new InstantShoppingSlideshowBlockViewImpl((MediaFrame) view, view, (ImageView) view.findViewById(2131563263));
    }
}
