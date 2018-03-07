package com.facebook.feed.freshfeed;

import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;

/* compiled from: search_typeahead_results/?module=MarketplaceSearch */
public class FreshFeedRankerProvider {
    @Inject
    public volatile Provider<FreshFeedSortKeyRanker> f5853a = UltralightRuntime.f367a;
    @Inject
    public volatile Provider<FreshFeedStoryRanker> f5854b = UltralightRuntime.f367a;

    public final FreshFeedRanker m10013a(int i) {
        switch (i) {
            case 0:
                return (FreshFeedStoryRanker) this.f5854b.get();
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (FreshFeedSortKeyRanker) this.f5853a.get();
            default:
                throw new IllegalArgumentException("Invalid Ranker Type: " + i);
        }
    }
}
