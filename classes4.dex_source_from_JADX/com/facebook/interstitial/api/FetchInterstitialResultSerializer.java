package com.facebook.interstitial.api;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: recordTime */
public class FetchInterstitialResultSerializer extends JsonSerializer<FetchInterstitialResult> {
    public final void m3954a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FetchInterstitialResult fetchInterstitialResult = (FetchInterstitialResult) obj;
        if (fetchInterstitialResult == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3953b(fetchInterstitialResult, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(FetchInterstitialResult.class, new FetchInterstitialResultSerializer());
    }

    private static void m3953b(FetchInterstitialResult fetchInterstitialResult, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10232a(jsonGenerator, "rank", Integer.valueOf(fetchInterstitialResult.rank));
        AutoGenJsonHelper.m10234a(jsonGenerator, "nux_id", fetchInterstitialResult.interstitialId);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "nux_data", fetchInterstitialResult.data);
        AutoGenJsonHelper.m10233a(jsonGenerator, "fetchTimeMs", Long.valueOf(fetchInterstitialResult.fetchTimeMs));
    }
}
