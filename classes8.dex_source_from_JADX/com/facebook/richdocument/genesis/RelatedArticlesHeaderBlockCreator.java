package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.TextBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.TextBlockView;
import com.facebook.richdocument.view.block.impl.FooterTextBlockViewImpl;
import javax.inject.Inject;

/* compiled from: platform_native_share */
public class RelatedArticlesHeaderBlockCreator extends BaseBlockCreator<TextBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new TextBlockPresenter((TextBlockView) blockView);
    }

    @Inject
    public RelatedArticlesHeaderBlockCreator() {
        super(2130906879, 19);
    }

    public final BlockView mo264a(View view) {
        return FooterTextBlockViewImpl.m6965a(view);
    }
}
