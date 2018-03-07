package com.facebook.devicebasedlogin.nux;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: This is supposed to be overridden by subclasses. */
public class DeviceBasedLoginNuxV2InterstitialFetchResultSerializer extends JsonSerializer<DeviceBasedLoginNuxV2InterstitialFetchResult> {
    public final void m26128a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        DeviceBasedLoginNuxV2InterstitialFetchResult deviceBasedLoginNuxV2InterstitialFetchResult = (DeviceBasedLoginNuxV2InterstitialFetchResult) obj;
        if (deviceBasedLoginNuxV2InterstitialFetchResult == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m26127b(deviceBasedLoginNuxV2InterstitialFetchResult, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(DeviceBasedLoginNuxV2InterstitialFetchResult.class, new DeviceBasedLoginNuxV2InterstitialFetchResultSerializer());
    }

    private static void m26127b(DeviceBasedLoginNuxV2InterstitialFetchResult deviceBasedLoginNuxV2InterstitialFetchResult, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "targeted_nux", deviceBasedLoginNuxV2InterstitialFetchResult.targetedNux);
    }
}
