package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: RKTiming */
public class SouvenirMetadataSerializer extends JsonSerializer<SouvenirMetadata> {
    public final void m26176a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SouvenirMetadata souvenirMetadata = (SouvenirMetadata) obj;
        if (souvenirMetadata == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m26175b(souvenirMetadata, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SouvenirMetadata.class, new SouvenirMetadataSerializer());
    }

    private static void m26175b(SouvenirMetadata souvenirMetadata, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "local_id", souvenirMetadata.mId);
        AutoGenJsonHelper.a(jsonGenerator, "title", souvenirMetadata.mTitle);
        AutoGenJsonHelper.a(jsonGenerator, "start_date", Long.valueOf(souvenirMetadata.mStartDate));
        AutoGenJsonHelper.a(jsonGenerator, "end_date", Long.valueOf(souvenirMetadata.mEndDate));
        AutoGenJsonHelper.a(jsonGenerator, "shareability_score", Float.valueOf(souvenirMetadata.mShareabilityScore));
    }
}
