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

/* compiled from: Should convert to delegation to better avoid this method */
public class NoCaptionSlideshowPhotoBlockCreator extends BaseBlockCreator<ImageBlockView> {
    public final AbstractBlockPresenter m24838a(BlockView blockView) {
        return new LinkableImageBlockPresenter((ImageBlockViewImpl) blockView);
    }

    @Inject
    public NoCaptionSlideshowPhotoBlockCreator() {
        super(2130905464, 110);
    }

    public final BlockView m24839a(View view) {
        return LinkableImageBlockViewImpl.m25097b(view);
    }
}
