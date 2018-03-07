package com.facebook.messaging.events.banner;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.time.Clock;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadSummary;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: specific_context_items */
public class EventReminderLogger {
    private AnalyticsLogger f2307a;
    private Clock f2308b;

    @Inject
    public EventReminderLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f2307a = analyticsLogger;
        this.f2308b = clock;
    }

    public final void m2169a(ThreadEventReminder threadEventReminder, ThreadSummary threadSummary) {
        if (threadEventReminder != null && threadSummary != null) {
            HoneyClientEventFast a = this.f2307a.a("event_reminder_banner_view", false);
            if (a.a()) {
                a.a("event_reminders").a("reminder_id", threadEventReminder.a).a("thread_id", threadSummary.a.h()).a("time_until_reminder", Math.max(0, TimeUnit.SECONDS.toMillis(threadEventReminder.b) - this.f2308b.a())).b();
            }
        }
    }
}
