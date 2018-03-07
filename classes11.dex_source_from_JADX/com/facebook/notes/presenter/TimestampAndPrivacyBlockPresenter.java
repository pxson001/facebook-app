package com.facebook.notes.presenter;

import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.notes.model.data.TimestampAndPrivacyBlockData;
import com.facebook.notes.model.data.impl.TimestampAndPrivacyBlockDataImpl;
import com.facebook.notes.view.block.TimestampAndPrivacyBlockView;
import com.facebook.notes.view.block.impl.TimestampAndPrivacyBlockViewImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;

/* compiled from: Tried to use permissions API while not attached to an Activity. */
public class TimestampAndPrivacyBlockPresenter extends AbstractBlockPresenter<TimestampAndPrivacyBlockView, TimestampAndPrivacyBlockData> {
    public final void m11037a(BlockData blockData) {
        TimestampAndPrivacyBlockDataImpl timestampAndPrivacyBlockDataImpl = (TimestampAndPrivacyBlockDataImpl) blockData;
        ((TimestampAndPrivacyBlockViewImpl) this.d).a(null);
        TimestampAndPrivacyBlockViewImpl timestampAndPrivacyBlockViewImpl = (TimestampAndPrivacyBlockViewImpl) this.d;
        long j = timestampAndPrivacyBlockDataImpl.f10533b;
        String str = timestampAndPrivacyBlockDataImpl.f10532a;
        String a = timestampAndPrivacyBlockViewImpl.f10539a.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000 * j);
        timestampAndPrivacyBlockViewImpl.f10540b.setText(timestampAndPrivacyBlockViewImpl.getContext().getString(2131242548, new Object[]{a, str}).toUpperCase(timestampAndPrivacyBlockViewImpl.getContext().getResources().getConfiguration().locale));
    }

    public TimestampAndPrivacyBlockPresenter(TimestampAndPrivacyBlockViewImpl timestampAndPrivacyBlockViewImpl) {
        super(timestampAndPrivacyBlockViewImpl);
    }
}
