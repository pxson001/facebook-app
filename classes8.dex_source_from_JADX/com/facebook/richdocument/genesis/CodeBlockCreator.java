package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.TextBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.TextBlockView;
import com.facebook.richdocument.view.block.impl.CodeBlockViewImpl;
import javax.inject.Inject;

/* compiled from: poll_optins */
public class CodeBlockCreator extends BaseBlockCreator<TextBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new TextBlockPresenter((TextBlockView) blockView);
    }

    @Inject
    public CodeBlockCreator() {
        super(2130906868, 18);
    }

    public final BlockView mo264a(View view) {
        return new CodeBlockViewImpl(view);
    }
}
