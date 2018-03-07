package com.facebook.messaging.media.photoquality;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: lookup_payload */
public class PhotoQualityCacheItemSerializer extends JsonSerializer<PhotoQualityCacheItem> {
    public final void m12419a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PhotoQualityCacheItem photoQualityCacheItem = (PhotoQualityCacheItem) obj;
        if (photoQualityCacheItem == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m12418b(photoQualityCacheItem, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PhotoQualityCacheItem.class, new PhotoQualityCacheItemSerializer());
    }

    private static void m12418b(PhotoQualityCacheItem photoQualityCacheItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "threadKey", photoQualityCacheItem.threadKey);
        AutoGenJsonHelper.a(jsonGenerator, "resolution", photoQualityCacheItem.resolution);
        AutoGenJsonHelper.a(jsonGenerator, "thumbnailResolution", photoQualityCacheItem.thumbnailResolution);
        AutoGenJsonHelper.a(jsonGenerator, "expirationTimeMs", photoQualityCacheItem.expirationTimeMs);
    }
}
