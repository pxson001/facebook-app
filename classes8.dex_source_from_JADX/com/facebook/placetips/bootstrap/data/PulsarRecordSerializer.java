package com.facebook.placetips.bootstrap.data;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: search_filter_text */
public class PulsarRecordSerializer extends JsonSerializer<PulsarRecord> {
    public final void m3729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PulsarRecord pulsarRecord = (PulsarRecord) obj;
        if (pulsarRecord == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3728b(pulsarRecord, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PulsarRecord.class, new PulsarRecordSerializer());
    }

    private static void m3728b(PulsarRecord pulsarRecord, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "company_identifier", Integer.valueOf(pulsarRecord.mCompanyIdentifier));
        AutoGenJsonHelper.a(jsonGenerator, "pulsar_ad_indicator", Integer.valueOf(pulsarRecord.mPulsarAdvertismentIndicator));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "uuid", pulsarRecord.mUUID);
        AutoGenJsonHelper.a(jsonGenerator, "major", Integer.valueOf(pulsarRecord.mMajor));
        AutoGenJsonHelper.a(jsonGenerator, "minor", Integer.valueOf(pulsarRecord.mMinor));
    }
}
