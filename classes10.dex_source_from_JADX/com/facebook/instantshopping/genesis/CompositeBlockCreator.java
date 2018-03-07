package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.CompositeBlockPresenter;
import com.facebook.instantshopping.view.block.CompositeBlockView;
import com.facebook.instantshopping.view.block.impl.CompositeBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: ShowShareComposerHandler */
public class CompositeBlockCreator extends BaseBlockCreator<CompositeBlockView> {
    public final AbstractBlockPresenter m24822a(BlockView blockView) {
        return new CompositeBlockPresenter((CompositeBlockViewImpl) blockView);
    }

    @Inject
    public CompositeBlockCreator() {
        super(2130904955, 106);
    }

    public final BlockView m24823a(View view) {
        return new CompositeBlockViewImpl(view);
    }
}
