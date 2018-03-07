package com.facebook.prefetch.feed.scheduler;

import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: response_end_ms */
public class NewsFeedPrefetchHelperDefaultImpl implements NewsFeedPrefetchHelper {
    public static NewsFeedPrefetchHelperDefaultImpl m4320a(InjectorLike injectorLike) {
        return new NewsFeedPrefetchHelperDefaultImpl();
    }

    public final ListenableFuture<?> mo202a() {
        throw new RuntimeException("Unsupported method! Did you mean to reach out to AsyncNewsFeedPrefetchHelper?");
    }
}
