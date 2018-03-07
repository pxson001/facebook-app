package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.HairlineBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.HairlineBlockView;
import com.facebook.richdocument.view.block.impl.HairlineBlockViewImpl;
import javax.inject.Inject;

/* compiled from: polaroid_v1 */
public class HairlineBlockCreator extends BaseBlockCreator<HairlineBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new HairlineBlockPresenter((HairlineBlockView) blockView);
    }

    @Inject
    public HairlineBlockCreator() {
        super(2130906870, 11);
    }

    public final BlockView mo264a(View view) {
        return new HairlineBlockViewImpl(view);
    }
}
