package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.ShareBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.ShareBlockView;
import com.facebook.richdocument.view.block.impl.ShareBlockViewImpl;
import javax.inject.Inject;

/* compiled from: platform_composer_onAttachmentChanged_IndexOutOfBounds */
public class ShareBlockCreator extends BaseBlockCreator<ShareBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new ShareBlockPresenter((ShareBlockViewImpl) blockView);
    }

    @Inject
    public ShareBlockCreator() {
        super(2130906880, 9);
    }

    public final BlockView mo264a(View view) {
        return new ShareBlockViewImpl(view);
    }
}
