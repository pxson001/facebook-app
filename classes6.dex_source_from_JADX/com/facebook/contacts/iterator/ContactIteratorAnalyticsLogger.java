package com.facebook.contacts.iterator;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: pending_story_save_failed */
public class ContactIteratorAnalyticsLogger {
    private static ContactIteratorAnalyticsLogger f8220b;
    private static final Object f8221c = new Object();
    private final AnalyticsLogger f8222a;

    private static ContactIteratorAnalyticsLogger m12061b(InjectorLike injectorLike) {
        return new ContactIteratorAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactIteratorAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f8222a = analyticsLogger;
    }

    public final void m12062a(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("invalid_contact_field");
        honeyClientEvent.b("contact_id", str).b("contact_field", str2).c = "contacts_iterator";
        this.f8222a.a(honeyClientEvent);
    }

    public static ContactIteratorAnalyticsLogger m12060a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContactIteratorAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8221c) {
                ContactIteratorAnalyticsLogger contactIteratorAnalyticsLogger;
                if (a2 != null) {
                    contactIteratorAnalyticsLogger = (ContactIteratorAnalyticsLogger) a2.a(f8221c);
                } else {
                    contactIteratorAnalyticsLogger = f8220b;
                }
                if (contactIteratorAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12061b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8221c, b3);
                        } else {
                            f8220b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contactIteratorAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
