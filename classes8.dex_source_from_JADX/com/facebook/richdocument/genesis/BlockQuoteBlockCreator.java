package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.TextBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.TextBlockView;
import com.facebook.richdocument.view.block.impl.BlockQuoteBlockViewImpl;
import javax.inject.Inject;

/* compiled from: post_composition_shown */
public class BlockQuoteBlockCreator extends BaseBlockCreator<TextBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new TextBlockPresenter((TextBlockView) blockView);
    }

    @Inject
    public BlockQuoteBlockCreator() {
        super(2130906865, 17);
    }

    public final BlockView mo264a(View view) {
        return new BlockQuoteBlockViewImpl(view);
    }
}
