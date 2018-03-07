package com.facebook.feed.rows.core.preparer;

import com.facebook.inject.Assisted;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import javax.inject.Inject;

/* compiled from: fetch_zero_token */
public class RangeAdapterPreparerScrollListener implements OnScrollListener {
    private final RangeAdapterPreparer f23809a;

    @Inject
    public RangeAdapterPreparerScrollListener(@Assisted RangeAdapterPreparer rangeAdapterPreparer) {
        this.f23809a = rangeAdapterPreparer;
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (i == 0) {
            this.f23809a.mo2533a();
        }
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
    }
}
