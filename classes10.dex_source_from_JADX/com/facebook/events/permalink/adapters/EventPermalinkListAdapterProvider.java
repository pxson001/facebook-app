package com.facebook.events.permalink.adapters;

import android.content.Context;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.feed.data.EventFeedPager;
import com.facebook.events.feed.ui.environment.EventFeedEnvironmentGeneratedProvider;
import com.facebook.events.gating.EventPermalinkBazingaHelper;
import com.facebook.events.permalink.EventPermalinkFragment;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.permalink.actionbar.ActionItemPost;
import com.facebook.events.permalink.calltoaction.EventCallToActionController;
import com.facebook.events.permalink.calltoaction.EventCheckinButtonController;
import com.facebook.events.permalink.summary.EventSummaryContextRowsStateTracker;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: button_with_disabled */
public class EventPermalinkListAdapterProvider extends AbstractAssistedProvider<EventPermalinkListAdapter> {
    public final EventPermalinkListAdapter m18574a(EventFeedPager eventFeedPager, ActionItemPost actionItemPost, ActionItemInvite actionItemInvite, EventAnalyticsParams eventAnalyticsParams, EventPermalinkFragment eventPermalinkFragment, Context context, EventCheckinButtonController eventCheckinButtonController) {
        return new EventPermalinkListAdapter(eventFeedPager, actionItemPost, actionItemInvite, eventAnalyticsParams, eventPermalinkFragment, context, eventCheckinButtonController, MultiRowAdapterBuilder.a(this), IdBasedLazy.a(this, 5671), IdBasedLazy.a(this, 1480), MultipleRowsStoriesRecycleCallback.a(this), (EventFeedEnvironmentGeneratedProvider) getOnDemandAssistedProviderForStaticDi(EventFeedEnvironmentGeneratedProvider.class), EventCallToActionController.m18631a(this), EventPendingPostsAdapter.m18522a(this), EventPermalinkBazingaHelper.a(this), EventSummaryContextRowsStateTracker.m19162a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
