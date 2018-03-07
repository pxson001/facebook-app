package com.facebook.events.permalink.adapters;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.feed.data.EventFeedPager;
import com.facebook.events.gating.EventPermalinkBazingaHelper;
import com.facebook.events.permalink.EventPermalinkFragment;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.permalink.actionbar.ActionItemPost;
import com.facebook.events.permalink.calltoaction.EventCallToActionController;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonController;
import com.facebook.events.permalink.multirow.environment.EventPermalinkEnvironmentGeneratedProvider;
import com.facebook.events.permalink.summary.EventSummaryContextRowsStateTracker;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;

/* compiled from: button_link_click */
public class EventPermalinkRecyclerViewAdapterProvider extends AbstractAssistedProvider<EventPermalinkRecyclerViewAdapter> {
    public final EventPermalinkRecyclerViewAdapter m18614a(EventFeedPager eventFeedPager, ActionItemPost actionItemPost, ActionItemInvite actionItemInvite, EventAnalyticsParams eventAnalyticsParams, EventPermalinkFragment eventPermalinkFragment, Context context, ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter, EventCheckinButtonController eventCheckinButtonController, BetterLinearLayoutManager betterLinearLayoutManager) {
        return new EventPermalinkRecyclerViewAdapter(eventFeedPager, actionItemPost, actionItemInvite, eventAnalyticsParams, eventPermalinkFragment, context, reactionMixedRecyclerViewAdapter, eventCheckinButtonController, betterLinearLayoutManager, AnalyticsLoggerMethodAutoProvider.a(this), MultiRowAdapterBuilder.a(this), IdBasedLazy.a(this, 5663), IdBasedLazy.a(this, 5662), ImpressionManager.a(this), MultipleRowsStoriesRecycleCallback.a(this), (EventPermalinkEnvironmentGeneratedProvider) getOnDemandAssistedProviderForStaticDi(EventPermalinkEnvironmentGeneratedProvider.class), EventPendingPostsAdapter.m18522a(this), EventCallToActionController.m18631a(this), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), ReactionEventBus.a(this), EventPermalinkBazingaHelper.a(this), EventSummaryContextRowsStateTracker.m19162a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
