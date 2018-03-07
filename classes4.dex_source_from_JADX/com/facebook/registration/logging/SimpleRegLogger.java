package com.facebook.registration.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.growth.experiment.InitialAppLaunchExperimentLogger;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.registration.String_RegInstanceMethodAutoProvider;
import com.facebook.registration.constants.RegFragmentState;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_stop_map */
public class SimpleRegLogger {
    private final AnalyticsLogger f12436a;
    private final Lazy<InitialAppLaunchExperimentLogger> f12437b;
    private final String f12438c;
    private final FunnelLoggerImpl f12439d;

    public static SimpleRegLogger m13147b(InjectorLike injectorLike) {
        return new SimpleRegLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 2206), String_RegInstanceMethodAutoProvider.m13182a(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public SimpleRegLogger(AnalyticsLogger analyticsLogger, Lazy<InitialAppLaunchExperimentLogger> lazy, String str, FunnelLogger funnelLogger) {
        this.f12436a = analyticsLogger;
        this.f12437b = lazy;
        this.f12438c = str;
        this.f12439d = funnelLogger;
    }

    public final void m13152a(String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.ENTER_FLOW).b("ref", str));
        m13148i("started");
    }

    public final void m13162b(String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.EXIT_FLOW).b("ref", str));
        m13148i("quit");
    }

    public final void m13151a(RegFragmentState regFragmentState) {
        String str;
        if (regFragmentState == null) {
            str = "null";
        } else {
            str = regFragmentState.name().toLowerCase(Locale.US);
        }
        m13148i(str);
        if (regFragmentState == RegFragmentState.PHONE_ACQUIRED || regFragmentState == RegFragmentState.EMAIL_ACQUIRED) {
            m13148i("contactpoint_acquired");
        }
    }

    public final void m13153a(String str, int i, int i2) {
        HoneyClientEvent a = m13146a(RegistrationLoggingEventType.PREFILL);
        a.b("step_name", str);
        a.a("prefill_used", i);
        a.a("num_suggestions", i2);
        this.f12436a.c(a);
    }

    public final void m13157a(String str, String str2, String str3) {
        HoneyClientEvent a = m13146a(RegistrationLoggingEventType.PREFILL);
        a.b("step_name", str);
        a.b("prefilled_value", str2);
        a.b("used_value", str3);
        this.f12436a.c(a);
    }

    public final void m13149a() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.ACCOUNT_CREATION_ATTEMPT));
        m13148i("create_attempt");
    }

    public final void m13156a(String str, String str2) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.ACCOUNT_CREATION_SUCCESS).b("created_account_type", str).b("userId", str2));
        FunnelRegistry.f.c = 600;
        this.f12439d.a(FunnelRegistry.f);
    }

    public final void m13161b() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.ACCOUNT_CREATION_NEEDS_COMPLETION));
        m13148i("create_needs_completion");
    }

    public final void m13163b(String str, String str2) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.ACCOUNT_CREATION_ERROR).b("error_code", str).b("error_description", str2));
    }

    public final void m13167c(String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.STEP_VALIDATION_SUCCESS).b("step_name", str));
    }

    public final void m13164b(String str, String str2, String str3) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.STEP_VALIDATION_ERROR).b("step_name", str).b("error_code", str2).b("error_description", str3));
    }

    public final void m13154a(String str, TriState triState) {
        m13155a(str, triState, null);
    }

    public final void m13155a(String str, TriState triState, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("reg_instance", this.f12438c);
        if (!StringUtil.a(str2)) {
            hashMap.put("userId", str2);
        }
        ((InitialAppLaunchExperimentLogger) this.f12437b.get()).m987a(str, triState, hashMap);
    }

    public final void m13166c() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.FINISH_REGISTRATION_NOTIF_SCHEDULED));
    }

    public final void m13169d() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.FINISH_REGISTRATION_NOTIF_CREATED));
    }

    public final void m13171e() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.FINISH_REGISTRATION_NOTIF_CLICKED));
    }

    public final void m13158a(String str, @Nullable String str2, Map<String, String> map) {
        HoneyClientEvent a = m13146a(RegistrationLoggingEventType.FB4A_REGISTRATION_UPSELL_CAMPAIGN);
        a.b("campaign_name", str);
        if (str2 != null) {
            a.b("campaign_path_keys", str2);
        }
        for (String str3 : map.keySet()) {
            a.b(str3, (String) map.get(str3));
        }
        this.f12436a.c(a);
    }

    public final void m13159a(boolean z) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_CONTACTS_TERMS_ACCEPT).a("accept", z));
    }

    public final void m13170d(String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.SAVED_UNUSED_FORM_DATA).b("userId", str));
    }

    public final void m13173f() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.USED_SAVED_FORM_DATA));
    }

    public final void m13175g() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_LOGIN_START));
    }

    public final void m13172e(String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_LOGIN_SUCCESS).b("state", str));
    }

    public final void m13168c(String str, String str2, String str3) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_LOGIN_FAILURE).b("state", str).b("error_code", str2).b("error_description", str3));
    }

    public final void m13177h() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_PROFILE_PIC_STEP_SHOWN));
    }

    public final void m13179i() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_PROFILE_PIC_STEP_SKIPPED));
    }

    public final void m13180j() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_PROFILE_PIC_STEP_COMPLETED));
    }

    public final void m13181k() {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_PROFILE_PIC_UPLOADED));
    }

    public final void m13174f(String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_PROFILE_PIC_UPLOAD_ERROR).b("error_description", str));
    }

    public final void m13150a(int i, int i2) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_CP_SUGGESTION_CALL_SUCCESS).a("prefill", i).a("autocomplete", i2));
    }

    public final void m13176g(String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_CP_SUGGESTION_CALL_ERROR).b("error_description", str));
    }

    public final void m13165b(boolean z) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_CP_SUGGESTION_CALL_ATTEMPT).a("ready", z));
    }

    public final void m13160a(boolean z, String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_CP_SUGGESTION_READY).a("ready", z).b("step_name", str));
    }

    public final void m13178h(String str) {
        this.f12436a.c(m13146a(RegistrationLoggingEventType.REGISTRATION_ADDITIONAL_EMAIL_STATE).b("state", str));
    }

    private HoneyClientEvent m13146a(RegistrationLoggingEventType registrationLoggingEventType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(registrationLoggingEventType.getAnalyticsName());
        honeyClientEvent.c = "simple_reg";
        return honeyClientEvent.b("reg_instance", this.f12438c);
    }

    private void m13148i(String str) {
        this.f12439d.b(FunnelRegistry.d, str);
        this.f12436a.c(m13146a(RegistrationLoggingEventType.FLOW_STATE).b("state", str));
    }
}
