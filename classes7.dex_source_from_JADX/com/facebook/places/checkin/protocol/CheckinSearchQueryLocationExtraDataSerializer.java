package com.facebook.places.checkin.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: inline_play_gif */
public class CheckinSearchQueryLocationExtraDataSerializer extends JsonSerializer<CheckinSearchQueryLocationExtraData> {
    public final void m13032a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        CheckinSearchQueryLocationExtraData checkinSearchQueryLocationExtraData = (CheckinSearchQueryLocationExtraData) obj;
        if (checkinSearchQueryLocationExtraData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m13031b(checkinSearchQueryLocationExtraData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(CheckinSearchQueryLocationExtraData.class, new CheckinSearchQueryLocationExtraDataSerializer());
    }

    private static void m13031b(CheckinSearchQueryLocationExtraData checkinSearchQueryLocationExtraData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "wifi", checkinSearchQueryLocationExtraData.mWifi);
        AutoGenJsonHelper.a(jsonGenerator, "ble", checkinSearchQueryLocationExtraData.mBle);
    }
}
