package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.LinkableImageWithAnnotationBlockPresenter;
import com.facebook.instantshopping.view.block.impl.LinkableImageWithAnnotationBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.ImageBlockView;
import com.facebook.richdocument.view.block.impl.ImageBlockViewImpl;
import javax.inject.Inject;

/* compiled from: Should be two children */
public class SlideshowPhotoBlockCreator extends BaseBlockCreator<ImageBlockView> {
    public final AbstractBlockPresenter m24840a(BlockView blockView) {
        return new LinkableImageWithAnnotationBlockPresenter((ImageBlockViewImpl) blockView, null);
    }

    @Inject
    public SlideshowPhotoBlockCreator() {
        super(2130904959, 107);
    }

    public final BlockView m24841a(View view) {
        return LinkableImageWithAnnotationBlockViewImpl.m25108c(view);
    }
}
