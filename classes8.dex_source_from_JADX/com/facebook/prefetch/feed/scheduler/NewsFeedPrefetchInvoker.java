package com.facebook.prefetch.feed.scheduler;

import com.facebook.common.init.AppInitLock;
import com.facebook.inject.InjectorLike;
import com.facebook.prefetch.feed.AsyncNewsFeedPrefetchHelper;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: resources */
public class NewsFeedPrefetchInvoker {
    private final NewsFeedPrefetchHelper f4477a;
    private final AppInitLock f4478b;

    public static NewsFeedPrefetchInvoker m4322b(InjectorLike injectorLike) {
        return new NewsFeedPrefetchInvoker((NewsFeedPrefetchHelper) AsyncNewsFeedPrefetchHelper.a(injectorLike), AppInitLock.a(injectorLike));
    }

    @Inject
    public NewsFeedPrefetchInvoker(NewsFeedPrefetchHelper newsFeedPrefetchHelper, AppInitLock appInitLock) {
        this.f4477a = newsFeedPrefetchHelper;
        this.f4478b = appInitLock;
    }

    final ListenableFuture<?> m4323a() {
        if (this.f4478b.c()) {
            return this.f4477a.mo202a();
        }
        return Futures.a(new NewsFeedPrefetchException("App is not initialized"));
    }
}
