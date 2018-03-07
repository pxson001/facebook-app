package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.VideoBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.VideoBlockView;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: platform_attribution_conversion */
public class VideoBlockCreator extends BaseBlockCreator<VideoBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new VideoBlockPresenter((VideoBlockViewImpl) blockView);
    }

    @Inject
    public VideoBlockCreator() {
        super(2130906885, 5);
    }

    public final BlockView mo264a(View view) {
        return new VideoBlockViewImpl((MediaFrame) view, view);
    }
}
