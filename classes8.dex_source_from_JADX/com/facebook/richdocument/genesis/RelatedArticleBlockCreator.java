package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.RelatedArticlePresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.RelatedArticleBlockView;
import com.facebook.richdocument.view.block.impl.RelatedArticleBlockViewImpl;
import javax.inject.Inject;

/* compiled from: playButton */
public class RelatedArticleBlockCreator extends BaseBlockCreator<RelatedArticleBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new RelatedArticlePresenter((RelatedArticleBlockViewImpl) blockView);
    }

    @Inject
    public RelatedArticleBlockCreator() {
        super(2130904823, 2);
    }

    public final BlockView mo264a(View view) {
        return new RelatedArticleBlockViewImpl(view);
    }
}
