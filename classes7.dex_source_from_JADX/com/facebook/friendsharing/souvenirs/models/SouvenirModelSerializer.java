package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: RKExceptionsManager */
public class SouvenirModelSerializer extends JsonSerializer<SouvenirModel> {
    public final void m26183a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SouvenirModel souvenirModel = (SouvenirModel) obj;
        if (souvenirModel == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m26182b(souvenirModel, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SouvenirModel.class, new SouvenirModelSerializer());
    }

    private static void m26182b(SouvenirModel souvenirModel, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "metadata", souvenirModel.mMetadata);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "items", souvenirModel.mItems);
    }
}
