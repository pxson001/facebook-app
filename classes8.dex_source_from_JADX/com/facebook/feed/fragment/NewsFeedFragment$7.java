package com.facebook.feed.fragment;

import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.sequencelogger.Fb4aSequences;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;

/* compiled from: group_tag_suggestions_not_selected */
class NewsFeedFragment$7 implements OnDrawListener {
    final /* synthetic */ NewsFeedFragment f11871a;

    NewsFeedFragment$7(NewsFeedFragment newsFeedFragment) {
        this.f11871a = newsFeedFragment;
    }

    public final boolean gD_() {
        if (this.f11871a.i.p() > 0) {
            Object obj;
            FeedPerfLogger feedPerfLogger = this.f11871a.bD;
            if (feedPerfLogger.j.l(655404, "NNFHotStartAndFreshRenderTime") && feedPerfLogger.v && !feedPerfLogger.j.l(655416, "NNFHotStartTTI")) {
                feedPerfLogger.j.d(655403, "NNFHotStartAndRenderTime");
                feedPerfLogger.j.d(655404, "NNFHotStartAndFreshRenderTime");
                feedPerfLogger.k.b(Fb4aSequences.f);
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
