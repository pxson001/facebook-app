package com.facebook.places.checkin.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.places.checkin.protocol.CheckinSearchQueryLocationExtraData.CheckinSearchQueryLocationExtraDataWifi;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: initializeBridge */
public class C0970xd96e188c extends JsonSerializer<CheckinSearchQueryLocationExtraDataWifi> {
    public final void m13040a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        CheckinSearchQueryLocationExtraDataWifi checkinSearchQueryLocationExtraDataWifi = (CheckinSearchQueryLocationExtraDataWifi) obj;
        if (checkinSearchQueryLocationExtraDataWifi == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        C0970xd96e188c.m13039b(checkinSearchQueryLocationExtraDataWifi, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(CheckinSearchQueryLocationExtraDataWifi.class, new C0970xd96e188c());
    }

    private static void m13039b(CheckinSearchQueryLocationExtraDataWifi checkinSearchQueryLocationExtraDataWifi, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "connected_wifi", checkinSearchQueryLocationExtraDataWifi.mConnectedWifi);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "ambient_wifis", checkinSearchQueryLocationExtraDataWifi.mAmbientWifis);
    }
}
