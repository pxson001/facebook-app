package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.TextBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.TextBlockView;
import com.facebook.richdocument.view.block.impl.TextBlockViewImpl;
import javax.inject.Inject;

/* compiled from: platform_composer_update_titlebar */
public class RichTextBlockCreator extends BaseBlockCreator<TextBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new TextBlockPresenter((TextBlockView) blockView);
    }

    @Inject
    public RichTextBlockCreator() {
        super(2130906882, 3);
    }

    public final BlockView mo264a(View view) {
        return new TextBlockViewImpl(view);
    }
}
