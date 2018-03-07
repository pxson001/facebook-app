package com.facebook.timeline.header.menus;

import android.content.Context;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import java.util.concurrent.Executor;

/* compiled from: fetch_creation_story */
public class TimelineFriendingClientProvider extends AbstractAssistedProvider<TimelineFriendingClient> {
    public final TimelineFriendingClient m11960a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, TimelineDataFetcher timelineDataFetcher, TimelineFragment timelineFragment) {
        return new TimelineFriendingClient(IdBasedLazy.a(this, 2073), IdBasedLazy.a(this, 2077), timelineContext, timelineHeaderUserData, timelineDataFetcher, timelineFragment, IdBasedLazy.a(this, 3588), IdBasedSingletonScopeProvider.a(this, 11155), FriendingEventBus.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (Context) getInstance(Context.class));
    }
}
