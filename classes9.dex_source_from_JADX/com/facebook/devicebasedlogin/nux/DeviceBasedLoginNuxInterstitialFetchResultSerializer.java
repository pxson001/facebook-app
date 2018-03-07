package com.facebook.devicebasedlogin.nux;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: This type does not have extensions. */
public class DeviceBasedLoginNuxInterstitialFetchResultSerializer extends JsonSerializer<DeviceBasedLoginNuxInterstitialFetchResult> {
    public final void m26116a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        DeviceBasedLoginNuxInterstitialFetchResult deviceBasedLoginNuxInterstitialFetchResult = (DeviceBasedLoginNuxInterstitialFetchResult) obj;
        if (deviceBasedLoginNuxInterstitialFetchResult == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m26115b(deviceBasedLoginNuxInterstitialFetchResult, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(DeviceBasedLoginNuxInterstitialFetchResult.class, new DeviceBasedLoginNuxInterstitialFetchResultSerializer());
    }

    private static void m26115b(DeviceBasedLoginNuxInterstitialFetchResult deviceBasedLoginNuxInterstitialFetchResult, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "triggerGeneration", Integer.valueOf(deviceBasedLoginNuxInterstitialFetchResult.triggerGeneration));
    }
}
