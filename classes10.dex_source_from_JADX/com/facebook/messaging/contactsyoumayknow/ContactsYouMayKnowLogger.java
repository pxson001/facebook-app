package com.facebook.messaging.contactsyoumayknow;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: sync_bad_cdn_attachment_info */
public class ContactsYouMayKnowLogger {
    public final AnalyticsLogger f2123a;

    /* compiled from: sync_bad_cdn_attachment_info */
    public class ContactYouMayKnowViewImpression {
        public final ContactSuggestion f2121a;
        public final int f2122b;

        public ContactYouMayKnowViewImpression(ContactSuggestion contactSuggestion, int i) {
            this.f2121a = contactSuggestion;
            this.f2122b = i;
        }
    }

    public static ContactsYouMayKnowLogger m1934b(InjectorLike injectorLike) {
        return new ContactsYouMayKnowLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactsYouMayKnowLogger(AnalyticsLogger analyticsLogger) {
        this.f2123a = analyticsLogger;
    }

    public final void m1935a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "contacts_you_may_know_people";
        this.f2123a.a(honeyClientEvent);
    }
}
