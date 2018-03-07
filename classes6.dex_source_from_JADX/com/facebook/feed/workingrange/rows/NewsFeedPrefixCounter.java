package com.facebook.feed.workingrange.rows;

import com.facebook.feed.ui.NewsFeedRecyclerViewAdapterWrapper;
import com.facebook.feed.workingrange.AdapterPrefixCounter;
import com.google.common.base.Preconditions;

/* compiled from: media_upload_failed */
public class NewsFeedPrefixCounter implements AdapterPrefixCounter {
    private final NewsFeedRecyclerViewAdapterWrapper f10453a;

    public NewsFeedPrefixCounter(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper) {
        this.f10453a = newsFeedRecyclerViewAdapterWrapper;
    }

    public final int m16626a() {
        boolean z;
        int b = this.f10453a.b();
        if (b >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "firstPosition is invalid");
        if (b == 0) {
            return 0;
        }
        return b - 1;
    }
}
