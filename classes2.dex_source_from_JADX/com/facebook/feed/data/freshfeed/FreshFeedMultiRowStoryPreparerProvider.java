package com.facebook.feed.data.freshfeed;

import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.feed.rows.adapter.freshfeed.FreshFeedFeedUnitAdapterFactoryHolder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: secondary_action_truncated */
public class FreshFeedMultiRowStoryPreparerProvider extends AbstractAssistedProvider<FreshFeedMultiRowStoryPreparer> {
    public final FreshFeedMultiRowStoryPreparer m9991a(FreshFeedStoryCollection freshFeedStoryCollection) {
        return new FreshFeedMultiRowStoryPreparer(IdleExecutor_ForUiThreadMethodAutoProvider.m10033b(this), FreshFeedFeedUnitAdapterFactoryHolder.m10034a(this), freshFeedStoryCollection, FreshFeedConfigReader.m9080a((InjectorLike) this));
    }
}
