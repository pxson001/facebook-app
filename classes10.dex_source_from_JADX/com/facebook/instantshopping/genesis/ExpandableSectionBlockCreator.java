package com.facebook.instantshopping.genesis;

import android.view.View;
import com.facebook.instantshopping.presenter.ExpandableBlockPresenter;
import com.facebook.instantshopping.view.block.ExpandableBlockView;
import com.facebook.instantshopping.view.block.impl.ExpandableBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: Show reasons why prompts are not seen */
public class ExpandableSectionBlockCreator extends BaseBlockCreator<ExpandableBlockView> {
    public final AbstractBlockPresenter m24826a(BlockView blockView) {
        return new ExpandableBlockPresenter((ExpandableBlockViewImpl) blockView);
    }

    @Inject
    public ExpandableSectionBlockCreator() {
        super(2130904950, 105);
    }

    public final BlockView m24827a(View view) {
        return new ExpandableBlockViewImpl(view);
    }
}
