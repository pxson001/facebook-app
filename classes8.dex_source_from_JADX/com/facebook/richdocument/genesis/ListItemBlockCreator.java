package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.ListBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.ListBlockView;
import com.facebook.richdocument.view.block.impl.ListBlockViewImpl;
import javax.inject.Inject;

/* compiled from: playerState */
public class ListItemBlockCreator extends BaseBlockCreator<ListBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new ListBlockPresenter((ListBlockViewImpl) blockView);
    }

    @Inject
    public ListItemBlockCreator() {
        super(2130906874, 22);
    }

    public final BlockView mo264a(View view) {
        return new ListBlockViewImpl(view);
    }
}
