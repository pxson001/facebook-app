package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.WebViewBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.WebViewBlockView;
import com.facebook.richdocument.view.block.impl.WebViewBlockViewImpl;
import javax.inject.Inject;

/* compiled from: places_search */
public class WebViewBlockCreator extends BaseBlockCreator<WebViewBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new WebViewBlockPresenter((WebViewBlockViewImpl) blockView);
    }

    @Inject
    public WebViewBlockCreator() {
        super(2130904827, 8);
    }

    public final BlockView mo264a(View view) {
        return WebViewBlockViewImpl.m7118a(view);
    }
}
