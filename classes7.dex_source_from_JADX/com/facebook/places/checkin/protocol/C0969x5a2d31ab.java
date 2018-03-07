package com.facebook.places.checkin.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.places.checkin.protocol.CheckinSearchQueryLocationExtraData.CheckinSearchQueryLocationExtraDataWifiObject;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: initializeBridge should be called once */
public class C0969x5a2d31ab extends JsonSerializer<CheckinSearchQueryLocationExtraDataWifiObject> {
    public final void m13038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        CheckinSearchQueryLocationExtraDataWifiObject checkinSearchQueryLocationExtraDataWifiObject = (CheckinSearchQueryLocationExtraDataWifiObject) obj;
        if (checkinSearchQueryLocationExtraDataWifiObject == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        C0969x5a2d31ab.m13037b(checkinSearchQueryLocationExtraDataWifiObject, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(CheckinSearchQueryLocationExtraDataWifiObject.class, new C0969x5a2d31ab());
    }

    private static void m13037b(CheckinSearchQueryLocationExtraDataWifiObject checkinSearchQueryLocationExtraDataWifiObject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "BSSID", checkinSearchQueryLocationExtraDataWifiObject.mBssid);
        AutoGenJsonHelper.a(jsonGenerator, "name", checkinSearchQueryLocationExtraDataWifiObject.mName);
        AutoGenJsonHelper.a(jsonGenerator, "strength", Integer.valueOf(checkinSearchQueryLocationExtraDataWifiObject.mStrength));
        AutoGenJsonHelper.a(jsonGenerator, "frequency", Integer.valueOf(checkinSearchQueryLocationExtraDataWifiObject.mFrequency));
        AutoGenJsonHelper.a(jsonGenerator, "stale_time", checkinSearchQueryLocationExtraDataWifiObject.mAge);
    }
}
