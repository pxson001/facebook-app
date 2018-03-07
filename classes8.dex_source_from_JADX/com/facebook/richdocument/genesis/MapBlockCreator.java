package com.facebook.richdocument.genesis;

import android.view.View;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.MapBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.MapBlockView;
import com.facebook.richdocument.view.block.impl.MapBlockViewImpl;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: playbackDuration cannot be NaN. */
public class MapBlockCreator extends BaseBlockCreator<MapBlockView> {
    public final AbstractBlockPresenter mo263a(BlockView blockView) {
        return new MapBlockPresenter((MapBlockViewImpl) blockView);
    }

    @Inject
    public MapBlockCreator() {
        super(2130906878, 7);
    }

    public final BlockView mo264a(View view) {
        return new MapBlockViewImpl((MediaFrame) view, view);
    }
}
