package com.facebook.nearby.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: unseen_message_count */
public class NearbyPlaceEdgeWithLayoutSerializer extends JsonSerializer<NearbyPlaceEdgeWithLayout> {
    public final void m492a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        NearbyPlaceEdgeWithLayout nearbyPlaceEdgeWithLayout = (NearbyPlaceEdgeWithLayout) obj;
        if (nearbyPlaceEdgeWithLayout == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m491b(nearbyPlaceEdgeWithLayout, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(NearbyPlaceEdgeWithLayout.class, new NearbyPlaceEdgeWithLayoutSerializer());
    }

    private static void m491b(NearbyPlaceEdgeWithLayout nearbyPlaceEdgeWithLayout, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "placeEdge", nearbyPlaceEdgeWithLayout.placeEdge);
        AutoGenJsonHelper.a(jsonGenerator, "layout", nearbyPlaceEdgeWithLayout.layout);
    }
}
