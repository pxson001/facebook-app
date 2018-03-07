package com.facebook.privacy.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: featuredProductCount */
public class PrivacyParameterSerializer extends JsonSerializer<PrivacyParameter> {
    public final void m22691a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PrivacyParameter privacyParameter = (PrivacyParameter) obj;
        if (privacyParameter == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m22690b(privacyParameter, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PrivacyParameter.class, new PrivacyParameterSerializer());
    }

    private static void m22690b(PrivacyParameter privacyParameter, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "value", privacyParameter.value);
        AutoGenJsonHelper.a(jsonGenerator, "deny", privacyParameter.deny);
        AutoGenJsonHelper.a(jsonGenerator, "allow", privacyParameter.allow);
        AutoGenJsonHelper.a(jsonGenerator, "friends", privacyParameter.friends);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "settings", privacyParameter.settings);
    }
}
