package com.facebook.contacts.ccu.logging;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.contacts.ccu.logging.CCULoggingConstants.Events;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: isMessengerUser */
public class CCUAnalyticsLogger {
    public final AnalyticsLogger f10160a;

    @Inject
    public CCUAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f10160a = analyticsLogger;
    }

    public final void m10617a(String str, @Nullable String str2, boolean z, long j) {
        this.f10160a.a(m10616b(Events.CCU_CONTACTS_UPLOAD_FAILED.getName()).b("failure_reason", str).b("failure_message", str2).a("full_upload", z).a("last_upload_success_time", j));
    }

    public final void m10620a(boolean z, int i, String str, int i2, int i3) {
        this.f10160a.a(m10616b(Events.CCU_CONTACTS_UPLOAD_INFORMATION.getName()).b("upload_step", "create_session").a("full_upload", z).a("num_of_retries", i).b("source", str).a("batch_size", i2).a("contacts_upload_count", i3));
    }

    public final void m10618a(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f10160a.a(m10616b(Events.CCU_CONTACTS_UPLOAD_INFORMATION.getName()).b("upload_step", "batch_upload").a("full_upload", z).a("batch_index", i).a("batch_size", i2).a("contacts_upload_count", i3).a("add_count", i4).a("remove_count", i5).a("update_count", i6));
    }

    public final void m10619a(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f10160a.a(m10616b(Events.CCU_CONTACTS_UPLOAD_INFORMATION.getName()).b("upload_step", "close_session").a("full_upload", z).a("total_batch_count", i).a("contacts_upload_count", i2).a("add_count", i3).a("remove_count", i4).a("update_count", i5).a("phonebook_size", i6).a("max_contacts_to_upload", i7));
    }

    public static HoneyClientEvent m10616b(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "ccu_module";
        return honeyClientEvent;
    }
}
