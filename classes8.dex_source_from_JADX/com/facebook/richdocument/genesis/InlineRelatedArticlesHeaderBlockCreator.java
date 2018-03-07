package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.TextBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.TextBlockView;
import com.facebook.richdocument.view.block.impl.InlineRelatedArticlesHeaderBlockViewImpl;
import javax.inject.Inject;

/* compiled from: player_current_position */
public class InlineRelatedArticlesHeaderBlockCreator extends BaseBlockCreator<TextBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new TextBlockPresenter((TextBlockView) blockView);
    }

    @Inject
    public InlineRelatedArticlesHeaderBlockCreator() {
        super(2130906872, 20);
    }

    public final BlockView mo264a(View view) {
        return new InlineRelatedArticlesHeaderBlockViewImpl(view);
    }
}
