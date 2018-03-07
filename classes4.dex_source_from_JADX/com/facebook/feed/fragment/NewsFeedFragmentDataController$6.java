package com.facebook.feed.fragment;

import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;

/* compiled from: price */
public class NewsFeedFragmentDataController$6 implements OnDrawListener {
    final /* synthetic */ int f4240a;
    final /* synthetic */ NewsFeedFragmentDataController f4241b;

    public NewsFeedFragmentDataController$6(NewsFeedFragmentDataController newsFeedFragmentDataController, int i) {
        this.f4241b = newsFeedFragmentDataController;
        this.f4240a = i;
    }

    public final boolean gD_() {
        FeedPerfLogger feedPerfLogger = this.f4241b.u;
        int i = this.f4240a;
        boolean z = true;
        boolean h = feedPerfLogger.h.h(655422, "NNFTailFetchTime");
        if (h && feedPerfLogger.h.h(655423, "NNFTailFetchRenderTime")) {
            if (!feedPerfLogger.i.a(655410)) {
                feedPerfLogger.G = i;
            }
            feedPerfLogger.h.c(655422, "NNFTailFetchTime");
            feedPerfLogger.h.c(655423, "NNFTailFetchRenderTime");
            feedPerfLogger.i.b(655410, (short) 2);
        } else if (h) {
            z = false;
        }
        return z;
    }
}
