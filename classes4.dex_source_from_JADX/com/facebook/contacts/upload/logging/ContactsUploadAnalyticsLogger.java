package com.facebook.contacts.upload.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.contacts.upload.logging.ContactsUploadLoggingConstants.Events;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_feed_vpv_updates */
public class ContactsUploadAnalyticsLogger {
    private static ContactsUploadAnalyticsLogger f12160c;
    private static final Object f12161d = new Object();
    public final AnalyticsLogger f12162a;
    public final FunnelLoggerImpl f12163b;

    private static ContactsUploadAnalyticsLogger m12822b(InjectorLike injectorLike) {
        return new ContactsUploadAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public ContactsUploadAnalyticsLogger(AnalyticsLogger analyticsLogger, FunnelLoggerImpl funnelLoggerImpl) {
        this.f12162a = analyticsLogger;
        this.f12163b = funnelLoggerImpl;
    }

    public final void m12825a(String str) {
        this.f12163b.a(FunnelRegistry.r, str);
    }

    public final void m12823a(Events events) {
        this.f12163b.b(FunnelRegistry.r, events.getEventName());
    }

    public final void m12824a(Events events, String str) {
        this.f12163b.a(FunnelRegistry.r, events.getEventName(), str);
    }

    public final void m12831b() {
        this.f12163b.b(FunnelRegistry.r);
    }

    public final void m12826a(String str, int i, int i2, int i3, int i4, int i5) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ccu_upload");
        honeyClientEvent.b("app_type", str).b("data_type", "ccu_upload_operation").a("phonebook_size", i).a("ccu_add_count", i2).a("ccu_modify_count", i3).a("ccu_delete_count", i4).a("ccu_upload_size", i5).c = "contacts_upload";
        this.f12162a.a(honeyClientEvent);
    }

    public static ContactsUploadAnalyticsLogger m12821a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContactsUploadAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12161d) {
                ContactsUploadAnalyticsLogger contactsUploadAnalyticsLogger;
                if (a2 != null) {
                    contactsUploadAnalyticsLogger = (ContactsUploadAnalyticsLogger) a2.a(f12161d);
                } else {
                    contactsUploadAnalyticsLogger = f12160c;
                }
                if (contactsUploadAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12822b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12161d, b3);
                        } else {
                            f12160c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contactsUploadAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m12829a(boolean z) {
        AnalyticsLogger analyticsLogger = this.f12162a;
        HoneyClientEvent a = new HoneyClientEvent("ccu_setting").a("ccu_status", z);
        a.c = "contacts_upload";
        analyticsLogger.a(a);
    }

    public final void m12830a(boolean z, boolean z2, boolean z3, String str, long j, long j2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ccu_server_check_client");
        honeyClientEvent.a("ccu_server_check_success", z).a("out_of_sync", z2).a("will_upload", z3).b("last_upload_client_hash", str).a("last_upload_attempt_time", j).a("last_upload_success_time", j2).c = "contacts_upload";
        this.f12162a.a(honeyClientEvent);
    }

    public final void m12828a(String str, boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ccu_invalid_contact_id");
        honeyClientEvent.a("duplicate_contact_id", z).b("contact_id", str).c = "contacts_upload";
        this.f12162a.a(honeyClientEvent);
    }

    public final void m12827a(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ccu_no_emails_no_phones_contact");
        honeyClientEvent.b("contact_id", str).b("contact_action", str2).c = "contacts_upload";
        this.f12162a.a(honeyClientEvent);
    }
}
