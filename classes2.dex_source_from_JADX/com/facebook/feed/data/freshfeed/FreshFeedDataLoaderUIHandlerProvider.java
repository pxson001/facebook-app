package com.facebook.feed.data.freshfeed;

import android.os.Looper;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.feed.data.freshfeed.FreshFeedDataLoader.FreshFeedCollectionListener;
import com.facebook.feed.loader.FeedDataLoaderListener;
import com.facebook.feed.loader.HeadLoaderStatus;
import com.facebook.feed.loader.TailLoaderStatus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: set_unknown_state_true */
public class FreshFeedDataLoaderUIHandlerProvider extends AbstractAssistedProvider<FreshFeedDataLoaderUIHandler> {
    public final FreshFeedDataLoaderUIHandler m9071a(Looper looper, FeedUnitCollection feedUnitCollection, HeadLoaderStatus headLoaderStatus, TailLoaderStatus tailLoaderStatus, FeedDataLoaderListener feedDataLoaderListener, TailLoaderStatus tailLoaderStatus2, FreshFeedCollectionListener freshFeedCollectionListener) {
        return new FreshFeedDataLoaderUIHandler(looper, feedUnitCollection, headLoaderStatus, tailLoaderStatus, feedDataLoaderListener, tailLoaderStatus2, freshFeedCollectionListener, IdBasedSingletonScopeProvider.m1810b(this, 1721), QeInternalImplMethodAutoProvider.m3744a(this));
    }
}
