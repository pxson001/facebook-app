package com.facebook.privacy.nux;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fbtlsx_rtmp.store */
public class PrivacyEducationBannerConfigSerializer extends JsonSerializer<PrivacyEducationBannerConfig> {
    public final void m22718a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PrivacyEducationBannerConfig privacyEducationBannerConfig = (PrivacyEducationBannerConfig) obj;
        if (privacyEducationBannerConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m22717b(privacyEducationBannerConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PrivacyEducationBannerConfig.class, new PrivacyEducationBannerConfigSerializer());
    }

    private static void m22717b(PrivacyEducationBannerConfig privacyEducationBannerConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "seen_counts", privacyEducationBannerConfig.mSeenCounts);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "banner_expanded", privacyEducationBannerConfig.mBannersExpanded);
    }
}
