package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.LogoBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.LogoBlockView;
import com.facebook.richdocument.view.block.impl.LogoBlockViewImpl;
import javax.inject.Inject;

/* compiled from: playbackRate */
public class LogoBlockCreator extends BaseBlockCreator<LogoBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new LogoBlockPresenter((LogoBlockViewImpl) blockView);
    }

    @Inject
    public LogoBlockCreator() {
        super(2130906876, 12);
    }

    public final BlockView mo264a(View view) {
        return new LogoBlockViewImpl(view);
    }
}
