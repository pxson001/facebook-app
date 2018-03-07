package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.NativeAdBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.VideoBlockView;
import com.facebook.richdocument.view.block.impl.NativeAdBlockViewImpl;
import com.facebook.richdocument.view.block.impl.VideoBlockViewImpl;
import javax.inject.Inject;

/* compiled from: playbackDuration */
public class NativeAdBlockCreator extends BaseBlockCreator<VideoBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new NativeAdBlockPresenter((VideoBlockViewImpl) blockView);
    }

    @Inject
    public NativeAdBlockCreator() {
        super(2130904822, 23);
    }

    public final BlockView mo264a(View view) {
        return NativeAdBlockViewImpl.m7048a(view);
    }
}
