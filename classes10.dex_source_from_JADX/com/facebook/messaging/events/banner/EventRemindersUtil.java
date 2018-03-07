package com.facebook.messaging.events.banner;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.events.abtest.LightweightEventsGatekeepers;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: snapshot */
public class EventRemindersUtil {
    private final Lazy<LightweightEventsGatekeepers> f2373a;

    public static EventRemindersUtil m2207b(InjectorLike injectorLike) {
        return new EventRemindersUtil(IdBasedLazy.a(injectorLike, 7848));
    }

    @Inject
    public EventRemindersUtil(Lazy<LightweightEventsGatekeepers> lazy) {
        this.f2373a = lazy;
    }

    public final boolean m2208b(@Nullable ThreadKey threadKey, @Nullable ThreadEventReminder threadEventReminder, @Nullable EventReminderMembers eventReminderMembers) {
        return (threadKey == null || threadEventReminder == null || eventReminderMembers == null || !threadEventReminder.f || !((LightweightEventsGatekeepers) this.f2373a.get()).f2277a.a(255, false)) ? false : true;
    }
}
