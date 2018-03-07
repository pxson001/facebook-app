package com.facebook.richdocument.genesis;

import android.view.View;
import android.widget.LinearLayout;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.BylineBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.BylineBlockView;
import com.facebook.richdocument.view.block.impl.BylineBlockViewImpl;
import com.facebook.richdocument.view.widget.RichTextView;
import javax.inject.Inject;

/* compiled from: popularity */
public class BylineBlockCreator extends BaseBlockCreator<BylineBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new BylineBlockPresenter((BylineBlockViewImpl) blockView);
    }

    @Inject
    public BylineBlockCreator() {
        super(2130906866, 14);
    }

    public final BlockView mo264a(View view) {
        return new BylineBlockViewImpl(view, (FbDraweeView) view.findViewById(2131567030), (LinearLayout) view.findViewById(2131567029), (RichTextView) view.findViewById(2131567031), (RichTextView) view.findViewById(2131567032));
    }
}
