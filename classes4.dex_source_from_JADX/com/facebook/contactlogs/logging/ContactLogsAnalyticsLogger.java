package com.facebook.contactlogs.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.contactlogs.logging.ContactLogsLoggingConstants.EventType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_profile_photo_checkup */
public class ContactLogsAnalyticsLogger {
    private static ContactLogsAnalyticsLogger f12101b;
    private static final Object f12102c = new Object();
    public final AnalyticsLogger f12103a;

    private static ContactLogsAnalyticsLogger m12778b(InjectorLike injectorLike) {
        return new ContactLogsAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactLogsAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f12103a = analyticsLogger;
    }

    public final void m12780a(EventType eventType) {
        this.f12103a.a(m12777b(eventType));
    }

    public final void m12779a(long j, long j2, long j3) {
        this.f12103a.a(m12777b(EventType.UPLOAD_TYPES).a("call", j).a("sms", j2).a("mms", j3));
    }

    public static HoneyClientEvent m12777b(EventType eventType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(eventType.getEventName());
        honeyClientEvent.c = "contact_logs";
        return honeyClientEvent;
    }

    public static ContactLogsAnalyticsLogger m12776a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContactLogsAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12102c) {
                ContactLogsAnalyticsLogger contactLogsAnalyticsLogger;
                if (a2 != null) {
                    contactLogsAnalyticsLogger = (ContactLogsAnalyticsLogger) a2.a(f12102c);
                } else {
                    contactLogsAnalyticsLogger = f12101b;
                }
                if (contactLogsAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12778b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12102c, b3);
                        } else {
                            f12101b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contactLogsAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
