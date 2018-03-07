package com.facebook.richdocument.genesis;

import android.view.View;
import android.widget.ImageView;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.SlideshowBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.SlideshowBlockView;
import com.facebook.richdocument.view.block.impl.SlideshowBlockViewImpl;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: platform_attribution_impression */
public class SlideshowBlockCreator extends BaseBlockCreator<SlideshowBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new SlideshowBlockPresenter((SlideshowBlockView) blockView);
    }

    @Inject
    public SlideshowBlockCreator() {
        super(2130906881, 6);
    }

    public final BlockView mo264a(View view) {
        return new SlideshowBlockViewImpl((MediaFrame) view, view, (ImageView) view.findViewById(2131563263));
    }
}
