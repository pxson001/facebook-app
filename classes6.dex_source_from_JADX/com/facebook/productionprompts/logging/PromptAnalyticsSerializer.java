package com.facebook.productionprompts.logging;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: startService / manual retry */
public class PromptAnalyticsSerializer extends JsonSerializer<PromptAnalytics> {
    public final void m6273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PromptAnalytics promptAnalytics = (PromptAnalytics) obj;
        if (promptAnalytics == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m6272b(promptAnalytics, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PromptAnalytics.class, new PromptAnalyticsSerializer());
    }

    private static void m6272b(PromptAnalytics promptAnalytics, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "prompt_id", promptAnalytics.promptId);
        AutoGenJsonHelper.a(jsonGenerator, "prompt_type", promptAnalytics.promptType);
        AutoGenJsonHelper.a(jsonGenerator, "prompt_session_id", promptAnalytics.promptSessionId);
        AutoGenJsonHelper.a(jsonGenerator, "composer_session_id", promptAnalytics.composerSessionId);
        AutoGenJsonHelper.a(jsonGenerator, "tracking_string", promptAnalytics.trackingString);
        AutoGenJsonHelper.a(jsonGenerator, "prompt_view_state", promptAnalytics.promptViewState);
    }
}
