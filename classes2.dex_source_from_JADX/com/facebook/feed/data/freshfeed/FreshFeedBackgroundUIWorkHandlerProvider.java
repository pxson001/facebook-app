package com.facebook.feed.data.freshfeed;

import android.os.Looper;
import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.feed.loader.TailLoaderStatus;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.server.FeedUnitPreRenderProcessor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: set_unknown_state_false */
public class FreshFeedBackgroundUIWorkHandlerProvider extends AbstractAssistedProvider<FreshFeedBackgroundUIWorkHandler> {
    public final FreshFeedBackgroundUIWorkHandler m9072a(Looper looper, FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler, TailLoaderStatus tailLoaderStatus, FeedType feedType, AbstractFeedTypeDataItem abstractFeedTypeDataItem) {
        return new FreshFeedBackgroundUIWorkHandler(FeedUnitPreRenderProcessor.m9989a(this), NewsFeedEventLogger.m4405a((InjectorLike) this), SystemClockMethodAutoProvider.m1498a(this), (FreshFeedMultiRowStoryPreparerProvider) getOnDemandAssistedProviderForStaticDi(FreshFeedMultiRowStoryPreparerProvider.class), FreshFeedStoryCollection.m9994b(this), looper, freshFeedDataLoaderUIHandler, tailLoaderStatus, feedType, abstractFeedTypeDataItem, FreshFeedConfigReader.m9080a((InjectorLike) this));
    }
}
