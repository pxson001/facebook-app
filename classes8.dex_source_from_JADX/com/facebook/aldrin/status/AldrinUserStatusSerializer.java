package com.facebook.aldrin.status;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: launch_target_selection_clicked */
public class AldrinUserStatusSerializer extends JsonSerializer<AldrinUserStatus> {
    public final void m12185a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AldrinUserStatus aldrinUserStatus = (AldrinUserStatus) obj;
        if (aldrinUserStatus == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m12184b(aldrinUserStatus, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(AldrinUserStatus.class, new AldrinUserStatusSerializer());
    }

    private static void m12184b(AldrinUserStatus aldrinUserStatus, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "effective_region", aldrinUserStatus.effectiveRegion);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "current_region", aldrinUserStatus.currentRegion);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "tos_transition_type", aldrinUserStatus.tosTransitionType);
        AutoGenJsonHelper.a(jsonGenerator, "is_cu", Boolean.valueOf(aldrinUserStatus.isCu));
        AutoGenJsonHelper.a(jsonGenerator, "should_be_cu", Boolean.valueOf(aldrinUserStatus.shouldBeCu));
        AutoGenJsonHelper.a(jsonGenerator, "tos_terms_url", aldrinUserStatus.tosTermsUrl);
        AutoGenJsonHelper.a(jsonGenerator, "tos_privacy_url", aldrinUserStatus.tosPrivacyUrl);
        AutoGenJsonHelper.a(jsonGenerator, "tos_cookies_url", aldrinUserStatus.tosCookiesUrl);
        AutoGenJsonHelper.a(jsonGenerator, "tos_version", aldrinUserStatus.tosVersion);
        AutoGenJsonHelper.a(jsonGenerator, "fetch_time", Long.valueOf(aldrinUserStatus.fetchTime));
        AutoGenJsonHelper.a(jsonGenerator, "user_id", aldrinUserStatus.userId);
    }
}
