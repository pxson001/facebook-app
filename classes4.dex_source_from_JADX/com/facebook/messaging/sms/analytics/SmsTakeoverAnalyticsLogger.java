package com.facebook.messaging.sms.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: edit_story_privacy_cancel */
public class SmsTakeoverAnalyticsLogger {
    private final AnalyticsLogger f13326a;
    private final SmsIntegrationState f13327b;
    private final SmsTakeoverMultiverseExperimentHelper f13328c;

    public static SmsTakeoverAnalyticsLogger m14218b(InjectorLike injectorLike) {
        return new SmsTakeoverAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), SmsTakeoverMultiverseExperimentHelper.m14202b(injectorLike), SmsIntegrationState.m10491a(injectorLike));
    }

    @Inject
    public SmsTakeoverAnalyticsLogger(AnalyticsLogger analyticsLogger, SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper, SmsIntegrationState smsIntegrationState) {
        this.f13326a = analyticsLogger;
        this.f13328c = smsTakeoverMultiverseExperimentHelper;
        this.f13327b = smsIntegrationState;
    }

    public static SmsTakeoverAnalyticsLogger m14216a(InjectorLike injectorLike) {
        return m14218b(injectorLike);
    }

    public final void m14227a(String str) {
        m14219b(str, "show");
    }

    public final void m14238b(String str) {
        m14219b(str, "ok_clicked");
    }

    public final void m14241c(String str) {
        m14219b(str, "canceled");
    }

    private void m14219b(String str, String str2) {
        HoneyClientEvent i = m14223i("sms_takeover_explain_dialog_action");
        i.b("call_context", str).b("explain_dialog_action", str2);
        this.f13326a.a(i);
    }

    public final void m14243d(String str) {
        m14221c(str, "show");
    }

    public final void m14245e(String str) {
        m14221c(str, "delete");
    }

    public final void m14247f(String str) {
        m14221c(str, "settings");
    }

    private void m14221c(String str, String str2) {
        HoneyClientEvent i = m14223i("sms_takeover_delete_thread_dialog_action");
        i.b("call_context", str).b("delete_thread_dialog_action", str2);
        this.f13326a.a(i);
    }

    public final void m14224a() {
        m14222h("show");
    }

    private void m14222h(String str) {
        HoneyClientEvent i = m14223i("sms_takeover_sys_notification_action");
        i.b("action", str).a("state_now", m14248g());
        this.f13326a.a(i);
    }

    public final void m14236a(boolean z, boolean z2, boolean z3, int i, int i2) {
        HoneyClientEvent i3 = m14223i("sms_takeover_device_status");
        i3.a("has_sms_contact_permissions", z);
        i3.a("has_phone_permissions", z2);
        i3.a("has_multisim_api", z3);
        i3.a("active_sim_slots", i);
        i3.a("max_sim_slots", i2);
        this.f13326a.a(i3);
    }

    public final void m14237b() {
        m14220b(false, false, null, 0, 1);
    }

    public final void m14240c() {
        m14220b(false, true, null, 0, 1);
    }

    public final void m14229a(@Nullable String str, int i, int i2) {
        m14220b(true, false, str, i, i2);
    }

    public final void m14239b(@Nullable String str, int i, int i2) {
        m14220b(true, true, str, i, i2);
    }

    private void m14220b(boolean z, boolean z2, @Nullable String str, int i, int i2) {
        HoneyClientEvent a = m14223i("sms_takeover_send_message").a("is_resend", z2);
        m14217a(a, z, str, i, i2);
        this.f13326a.a(a);
    }

    public final void m14235a(boolean z, boolean z2, @Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, boolean z3) {
        HoneyClientEvent a = m14223i("sms_takeover_message_sent").a("is_sent_succeed", z2);
        m14217a(a, z, str3, i, i2);
        if (!Strings.isNullOrEmpty(str)) {
            a.b("error_type", str);
            if (!Strings.isNullOrEmpty(str2)) {
                a.b("error_msg", str2);
            }
        }
        a.a("legacy", z3);
        this.f13326a.a(a);
    }

    public final void m14234a(boolean z, boolean z2, @Nullable String str, int i, int i2) {
        HoneyClientEvent i3 = m14223i("sms_takeover_message_received");
        if (z) {
            i3.a("is_pending_download", z2);
        }
        m14217a(i3, z, str, i, i2);
        this.f13326a.a(i3);
    }

    public final void m14233a(boolean z, @Nullable String str, @Nullable String str2, boolean z2, boolean z3, boolean z4) {
        HoneyClientEvent a = m14223i("sms_takeover_message_downloaded").a("is_download_success", z);
        if (!Strings.isNullOrEmpty(str)) {
            a.b("error_type", str);
            if (!Strings.isNullOrEmpty(str2)) {
                a.b("error_msg", str2);
            }
        }
        a.a("auto_download", z2);
        a.a("legacy", z3);
        a.a("is_sender_missing", z4);
        this.f13326a.a(a);
    }

    public final void m14232a(boolean z, String str, int i, int i2) {
        HoneyClientEvent i3 = m14223i("sms_takeover_create_thread");
        m14217a(i3, z, str, i, i2);
        this.f13326a.a(i3);
    }

    public final void m14242d() {
        this.f13326a.a(m14223i("sms_takeover_fallback_notification"));
    }

    public final void m14226a(Object obj, SmsTakeoverState smsTakeoverState, SmsTakeoverState smsTakeoverState2) {
        HoneyClientEvent i = m14223i("sms_takeover_state_change");
        i.a("call_context", obj);
        i.a("state_before", smsTakeoverState);
        i.a("state_now", smsTakeoverState2);
        this.f13326a.a(i);
    }

    public final void m14225a(SmsCallerContext smsCallerContext) {
        HoneyClientEvent i = m14223i("sms_takeover_ro_action");
        i.b("call_context", smsCallerContext.toString());
        this.f13326a.a(i);
    }

    public final void m14249g(String str) {
        HoneyClientEvent i = m14223i("sms_takeover_mms_remux_failure");
        i.b("error_msg", str);
        this.f13326a.a(i);
    }

    public final void m14230a(String str, String str2) {
        HoneyClientEvent i = m14223i("sms_takeover_inbox_filter_action");
        i.b("old_tab", str).b("new_tab", str2).a("state_now", m14248g());
        this.f13326a.a(i);
    }

    public final void m14244e() {
        this.f13326a.a(m14223i("sms_takeover_inbox_filter_show_optin"));
    }

    public final void m14246f() {
        this.f13326a.a(m14223i("sms_takeover_inbox_filter_opt_out"));
    }

    public final void m14231a(String str, boolean z) {
        HoneyClientEvent i = m14223i("sms_takeover_promo_row");
        i.b("action", str);
        i.a("has_sms_contact_permissions", z);
        this.f13326a.a(i);
    }

    public final void m14228a(String str, int i) {
        HoneyClientEvent i2 = m14223i("sms_takeover_permanent_contact");
        i2.b("action", "load_contacts");
        i2.b("call_context", str);
        i2.a("num_phone_contacts", i);
        this.f13326a.a(i2);
    }

    private static void m14217a(HoneyClientEvent honeyClientEvent, boolean z, String str, int i, int i2) {
        honeyClientEvent.a("is_mms", z);
        if (!Strings.isNullOrEmpty(str)) {
            honeyClientEvent.b("mms_media_type", str);
            honeyClientEvent.a("mms_media_count", i);
        }
        if (i2 > 1) {
            honeyClientEvent.a("recipient_count", i2);
        }
    }

    private HoneyClientEvent m14223i(String str) {
        return new HoneyClientEvent(str).a(this.f13328c.m14204a());
    }

    public final SmsTakeoverState m14248g() {
        if (this.f13327b.m10499d()) {
            return SmsTakeoverState.FULL;
        }
        return this.f13327b.m10496a() ? SmsTakeoverState.READONLY : SmsTakeoverState.NONE;
    }
}
