package com.facebook.privacy.audience;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: record_remote_video */
public class InlinePrivacySurveyConfigSerializer extends JsonSerializer<InlinePrivacySurveyConfig> {
    public final void m3942a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        InlinePrivacySurveyConfig inlinePrivacySurveyConfig = (InlinePrivacySurveyConfig) obj;
        if (inlinePrivacySurveyConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3941b(inlinePrivacySurveyConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(InlinePrivacySurveyConfig.class, new InlinePrivacySurveyConfigSerializer());
    }

    private static void m3941b(InlinePrivacySurveyConfig inlinePrivacySurveyConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10229a(jsonGenerator, "eligible", Boolean.valueOf(inlinePrivacySurveyConfig.mEligible));
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "trigger_option", inlinePrivacySurveyConfig.mTriggerPrivacyOption);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "first_option", inlinePrivacySurveyConfig.mFirstSurveyOption);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "second_option", inlinePrivacySurveyConfig.mSecondSurveyOption);
    }
}
