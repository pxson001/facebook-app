package com.facebook.placetips.bootstrap;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: search_results_feed_scroll_perf */
public class PresenceSourceSerializer extends JsonSerializer<PresenceSource> {
    public final void m3719a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PresenceSource presenceSource = (PresenceSource) obj;
        if (presenceSource == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3718b(presenceSource, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PresenceSource.class, new PresenceSourceSerializer());
    }

    private static void m3718b(PresenceSource presenceSource, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "type", presenceSource.mPresenceSourceType);
        AutoGenJsonHelper.a(jsonGenerator, "pulsar_rssi", presenceSource.mPulsarRssi);
        AutoGenJsonHelper.a(jsonGenerator, "latitude", presenceSource.mLatitude);
        AutoGenJsonHelper.a(jsonGenerator, "longitude", presenceSource.mLongitude);
        AutoGenJsonHelper.a(jsonGenerator, "accuracy", presenceSource.mAccuracy);
    }
}
