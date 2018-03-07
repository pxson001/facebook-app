package com.facebook.messaging.inbox2.analytics;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.inbox2.analytics.InboxViewImpressionTracker.C04391;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;

/* compiled from: shanveffin12mang77 */
public class InboxRecyclerViewItemTrackerProvider extends AbstractAssistedProvider<InboxRecyclerViewItemTracker> {
    public final InboxRecyclerViewItemTracker m2606a(InboxUnitViewWithRecyclerView inboxUnitViewWithRecyclerView, C04391 c04391) {
        return new InboxRecyclerViewItemTracker((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), inboxUnitViewWithRecyclerView, c04391);
    }
}
