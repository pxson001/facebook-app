package com.facebook.katana.features.faceweb;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: p2p_pin_changed */
public class FacewebComponentsStoreSerializer extends JsonSerializer<FacewebComponentsStore> {
    public final void m7858a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FacewebComponentsStore facewebComponentsStore = (FacewebComponentsStore) obj;
        if (facewebComponentsStore == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m7857b(facewebComponentsStore, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FacewebComponentsStore.class, new FacewebComponentsStoreSerializer());
    }

    private static void m7857b(FacewebComponentsStore facewebComponentsStore, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "version", facewebComponentsStore.mVersion);
        AutoGenJsonHelper.a(jsonGenerator, "components", facewebComponentsStore.mSkeletonString);
    }
}
