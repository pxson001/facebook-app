package com.facebook.notes.genesis;

import android.view.View;
import com.facebook.notes.presenter.TimestampAndPrivacyBlockPresenter;
import com.facebook.notes.view.block.TimestampAndPrivacyBlockView;
import com.facebook.notes.view.block.impl.TimestampAndPrivacyBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: Unable to fetch groups from groupsstore */
public class TimestampAndPrivacyBlockCreator extends BaseBlockCreator<TimestampAndPrivacyBlockView> {
    public final AbstractBlockPresenter m10915a(BlockView blockView) {
        return new TimestampAndPrivacyBlockPresenter((TimestampAndPrivacyBlockViewImpl) blockView);
    }

    @Inject
    public TimestampAndPrivacyBlockCreator() {
        super(2130905471, 202);
    }

    public final BlockView m10916a(View view) {
        return new TimestampAndPrivacyBlockViewImpl(view);
    }
}
