package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: surface_generic_map_fragment */
public class StickerParamsSerializer extends JsonSerializer<StickerParams> {
    public final void m4704a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        StickerParams stickerParams = (StickerParams) obj;
        if (stickerParams == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4703b(stickerParams, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(StickerParams.class, new StickerParamsSerializer());
    }

    private static void m4703b(StickerParams stickerParams, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "id", stickerParams.mo228g());
        AutoGenJsonHelper.a(jsonGenerator, "uniqueId", stickerParams.m4698m());
        AutoGenJsonHelper.a(jsonGenerator, "rotation_degrees", Float.valueOf(stickerParams.mo224c()));
        AutoGenJsonHelper.a(jsonGenerator, "sticker_uri", stickerParams.m4697l());
        AutoGenJsonHelper.a(jsonGenerator, "left", Float.valueOf(stickerParams.m4699n()));
        AutoGenJsonHelper.a(jsonGenerator, "top", Float.valueOf(stickerParams.m4700o()));
        AutoGenJsonHelper.a(jsonGenerator, "width", Float.valueOf(stickerParams.mo226e()));
        AutoGenJsonHelper.a(jsonGenerator, "height", Float.valueOf(stickerParams.mo227f()));
        AutoGenJsonHelper.a(jsonGenerator, "isFlipped", Boolean.valueOf(stickerParams.mo229h()));
        AutoGenJsonHelper.a(jsonGenerator, "isSelectable", Boolean.valueOf(stickerParams.mo232k()));
        AutoGenJsonHelper.a(jsonGenerator, "isFrameItem", Boolean.valueOf(stickerParams.mo231j()));
    }
}
