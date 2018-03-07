package com.facebook.privacy.audience;

import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.protocol.ReportInlinePrivacySurveyActionParams.InlinePrivacySurveyEvent;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetchProfileQuestionParams */
public class InlinePrivacySurveyLoggingController {
    private Clock f14975a;
    private PrivacyOperationsClient f14976b;

    @Inject
    public InlinePrivacySurveyLoggingController(Clock clock, PrivacyOperationsClient privacyOperationsClient) {
        this.f14975a = clock;
        this.f14976b = privacyOperationsClient;
    }

    public final void m22581a(PrivacyOptionFields privacyOptionFields, String str) {
        this.f14976b.m22555a(InlinePrivacySurveyEvent.EXPOSED, m22578a(), m22579a(privacyOptionFields), null, str);
    }

    public final void m22582b(PrivacyOptionFields privacyOptionFields, String str) {
        this.f14976b.m22555a(InlinePrivacySurveyEvent.DISMISSED, m22578a(), m22579a(privacyOptionFields), m22579a(privacyOptionFields), str);
    }

    public final void m22583c(PrivacyOptionFields privacyOptionFields, String str) {
        this.f14976b.m22555a(InlinePrivacySurveyEvent.MORE_OPTIONS, m22578a(), m22579a(privacyOptionFields), null, str);
    }

    public final void m22580a(InlinePrivacySurveyEvent inlinePrivacySurveyEvent, PrivacyOptionFields privacyOptionFields, PrivacyOptionFields privacyOptionFields2, String str) {
        this.f14976b.m22555a(inlinePrivacySurveyEvent, m22578a(), m22579a(privacyOptionFields), m22579a(privacyOptionFields2), str);
    }

    private Long m22578a() {
        return Long.valueOf(this.f14975a.a() / 1000);
    }

    @Nullable
    private static String m22579a(PrivacyOptionFields privacyOptionFields) {
        if (privacyOptionFields != null) {
            return privacyOptionFields.c();
        }
        BLog.c("InlinePrivacySurveyLoggingController", "Trying to log an empty option for inline privacy survey");
        return null;
    }
}
