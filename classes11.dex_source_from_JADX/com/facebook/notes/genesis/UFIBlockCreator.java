package com.facebook.notes.genesis;

import android.view.View;
import com.facebook.notes.presenter.UFIBlockPresenter;
import com.facebook.notes.view.block.UFIBlockView;
import com.facebook.notes.view.block.impl.UFIBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: UUID is not passed in as args */
public class UFIBlockCreator extends BaseBlockCreator<UFIBlockView> {
    public final AbstractBlockPresenter m10917a(BlockView blockView) {
        return new UFIBlockPresenter((UFIBlockViewImpl) blockView);
    }

    @Inject
    public UFIBlockCreator() {
        super(2130906884, 203);
    }

    public final BlockView m10918a(View view) {
        return new UFIBlockViewImpl(view);
    }
}
