package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.HairlineBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.HairlineBlockView;
import com.facebook.richdocument.view.block.impl.InlineRelatedArticlesFooterBlockViewImpl;
import javax.inject.Inject;

/* compiled from: playlist_scrubbing */
public class InlineRelatedArticlesFooterBlockCreator extends BaseBlockCreator<HairlineBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new HairlineBlockPresenter((HairlineBlockView) blockView);
    }

    @Inject
    public InlineRelatedArticlesFooterBlockCreator() {
        super(2130906871, 21);
    }

    public final BlockView mo264a(View view) {
        return new InlineRelatedArticlesFooterBlockViewImpl(view);
    }
}
