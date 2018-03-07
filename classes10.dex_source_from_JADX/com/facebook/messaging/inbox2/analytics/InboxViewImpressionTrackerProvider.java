package com.facebook.messaging.inbox2.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.messaging.photoreminders.PhotoRemindersLogger;

/* compiled from: setupThreadViewFragment */
public class InboxViewImpressionTrackerProvider extends AbstractAssistedProvider<InboxViewImpressionTracker> {
    public final InboxViewImpressionTracker m2617a(InboxUnitViewWithRecyclerView inboxUnitViewWithRecyclerView) {
        return new InboxViewImpressionTracker(InboxViewLogger.m2623b(this), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), IdleExecutor_ForUiThreadMethodAutoProvider.b(this), (InboxRecyclerViewItemTrackerProvider) getOnDemandAssistedProviderForStaticDi(InboxRecyclerViewItemTrackerProvider.class), AnalyticsLoggerMethodAutoProvider.a(this), PhotoRemindersLogger.b(this), inboxUnitViewWithRecyclerView);
    }
}
