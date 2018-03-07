package com.facebook.feed.fragment;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.rows.core.persistence.ContextStateMap;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: platform_publish_open_graph_action */
public class StoryVisibilitySubscriberProvider extends AbstractAssistedProvider<StoryVisibilitySubscriber> {
    public final StoryVisibilitySubscriber m14649a(LegacyFeedUnitUpdater legacyFeedUnitUpdater) {
        return new StoryVisibilitySubscriber(SystemClockMethodAutoProvider.m1498a(this), ContextStateMap.m14935a((InjectorLike) this), legacyFeedUnitUpdater);
    }
}
