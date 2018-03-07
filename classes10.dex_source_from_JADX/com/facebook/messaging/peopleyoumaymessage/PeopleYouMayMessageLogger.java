package com.facebook.messaging.peopleyoumaymessage;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: remove_host_ids */
public class PeopleYouMayMessageLogger {
    private static final Class<?> f3486a = PeopleYouMayMessageLogger.class;
    public final AnalyticsLogger f3487b;

    /* compiled from: remove_host_ids */
    public class PersonYouMayMessageViewImpression {
        public final PersonYouMayMessage f3484a;
        public final int f3485b;

        public PersonYouMayMessageViewImpression(PersonYouMayMessage personYouMayMessage, int i) {
            this.f3484a = personYouMayMessage;
            this.f3485b = i;
        }
    }

    public static PeopleYouMayMessageLogger m3368b(InjectorLike injectorLike) {
        return new PeopleYouMayMessageLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static PeopleYouMayMessageLogger m3367a(InjectorLike injectorLike) {
        return m3368b(injectorLike);
    }

    @Inject
    public PeopleYouMayMessageLogger(AnalyticsLogger analyticsLogger) {
        this.f3487b = analyticsLogger;
    }
}
