package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: REVEALING */
public class SouvenirUriItemSerializer extends JsonSerializer<SouvenirUriItem> {
    public final void m26199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (((SouvenirUriItem) obj) == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SouvenirUriItem.class, new SouvenirUriItemSerializer());
    }

    public static void m26198d() {
    }
}
