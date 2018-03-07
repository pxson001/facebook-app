package com.facebook.interstitial.manager;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TOPIC_COMMUNITY_GOVERNMENT */
public class InterstitialTriggerSerializer extends JsonSerializer<InterstitialTrigger> {
    public final void m23260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        InterstitialTrigger interstitialTrigger = (InterstitialTrigger) obj;
        if (interstitialTrigger == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23259b(interstitialTrigger, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(InterstitialTrigger.class, new InterstitialTriggerSerializer());
    }

    private static void m23259b(InterstitialTrigger interstitialTrigger, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "action", interstitialTrigger.action);
        AutoGenJsonHelper.a(jsonGenerator, "activity_class", interstitialTrigger.activityClass);
    }
}
