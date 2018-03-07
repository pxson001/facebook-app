package com.facebook.contacts.background;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.contacts.graphql.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: photo_max_width */
public class ContactsReliabilityCheckLogger {
    private final AnalyticsLogger f8130a;
    private final Provider<Boolean> f8131b;

    @Inject
    public ContactsReliabilityCheckLogger(AnalyticsLogger analyticsLogger, Provider<Boolean> provider) {
        this.f8130a = analyticsLogger;
        this.f8131b = provider;
    }

    public final void m11685a(int i, int i2, int i3, int i4, int i5, List<Contact> list) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("contacts_reliability_difference");
        honeyClientEvent.c = "contacts_reliability";
        honeyClientEvent = honeyClientEvent.a("num_checked", i).a("num_differences", i2).a("num_missing", i3).a("num_db_contacts", i4).a("num_server_contacts", i5).a("omnistore_contacts_enabled", this.f8131b.get());
        String str = "db_contacts";
        StringBuilder stringBuilder = new StringBuilder();
        for (Contact c : list) {
            stringBuilder.append(c.c()).append(',');
        }
        this.f8130a.a(honeyClientEvent.b(str, stringBuilder.toString()));
    }
}
