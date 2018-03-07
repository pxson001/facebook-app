package com.facebook.privacy.audience;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reauth_activity_verifier */
public class ComposerStickyGuardrailConfigSerializer extends JsonSerializer<ComposerStickyGuardrailConfig> {
    public final void m4174a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerStickyGuardrailConfig composerStickyGuardrailConfig = (ComposerStickyGuardrailConfig) obj;
        if (composerStickyGuardrailConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4173b(composerStickyGuardrailConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(ComposerStickyGuardrailConfig.class, new ComposerStickyGuardrailConfigSerializer());
    }

    private static void m4173b(ComposerStickyGuardrailConfig composerStickyGuardrailConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10229a(jsonGenerator, "eligible", Boolean.valueOf(composerStickyGuardrailConfig.mEligible));
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "current_privacy_option", composerStickyGuardrailConfig.mCurrentPrivacyOption);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "suggested_privacy_option", composerStickyGuardrailConfig.mSuggestedPrivacyOption);
        AutoGenJsonHelper.m10233a(jsonGenerator, "suggestion_timestamp", Long.valueOf(composerStickyGuardrailConfig.mSuggestedTime));
        AutoGenJsonHelper.m10233a(jsonGenerator, "config_updated_time", Long.valueOf(composerStickyGuardrailConfig.mUpdatedTime));
    }
}
