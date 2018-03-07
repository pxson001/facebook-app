package com.facebook.notes.genesis;

import android.view.View;
import com.facebook.notes.presenter.FromBlockPresenter;
import com.facebook.notes.view.block.FromBlockView;
import com.facebook.notes.view.block.impl.FromBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: Unable to initialize video card - missing data */
public class FromAuthorBlockCreator extends BaseBlockCreator<FromBlockView> {
    public final AbstractBlockPresenter m10913a(BlockView blockView) {
        return new FromBlockPresenter((FromBlockViewImpl) blockView);
    }

    @Inject
    public FromAuthorBlockCreator() {
        super(2130905467, 201);
    }

    public final BlockView m10914a(View view) {
        return new FromBlockViewImpl(view);
    }
}
