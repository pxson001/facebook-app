package com.facebook.timeline.header.menus;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.protiles.model.ProtilesData;

/* compiled from: fetch_bio */
public class TimelineFriendingControllerProvider extends AbstractAssistedProvider<TimelineFriendingController> {
    public final TimelineFriendingController m11971a(TimelineUserContext timelineUserContext, TimelineDataFetcher timelineDataFetcher, TimelineFragment timelineFragment, TimelineHeaderUserData timelineHeaderUserData, TimelineFriendingClient timelineFriendingClient) {
        return new TimelineFriendingController(timelineUserContext, timelineDataFetcher, timelineFragment, timelineHeaderUserData, timelineFriendingClient, ProtilesData.m12116a((InjectorLike) this), IdBasedSingletonScopeProvider.a(this, 11155));
    }
}
