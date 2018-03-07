package com.facebook.feed.freshfeed;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nullable;

/* compiled from: select max(bundle_end_timestamp) from queue */
public abstract class FreshFeedHandler extends Handler {
    @Nullable
    private final int[] f5782a;

    public FreshFeedHandler(Looper looper, int[] iArr) {
        super(looper);
        this.f5782a = iArr;
    }

    public FreshFeedHandler(Looper looper) {
        this(looper, null);
    }

    public void mo1402a() {
        if (this.f5782a != null) {
            for (int removeMessages : this.f5782a) {
                removeMessages(removeMessages);
            }
        }
    }
}
