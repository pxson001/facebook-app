package com.facebook.assetdownload;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: profile_step_exposed */
public class AssetDownloadConfigurationSerializer extends JsonSerializer<AssetDownloadConfiguration> {
    public final void m10381a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AssetDownloadConfiguration assetDownloadConfiguration = (AssetDownloadConfiguration) obj;
        if (assetDownloadConfiguration == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m10380b(assetDownloadConfiguration, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(AssetDownloadConfiguration.class, new AssetDownloadConfigurationSerializer());
    }

    private static void m10380b(AssetDownloadConfiguration assetDownloadConfiguration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "identifier", assetDownloadConfiguration.mIdentifier);
        AutoGenJsonHelper.a(jsonGenerator, "source", assetDownloadConfiguration.mStringSource);
        AutoGenJsonHelper.a(jsonGenerator, "priority", Integer.valueOf(assetDownloadConfiguration.mPriority));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "connection_constraint", assetDownloadConfiguration.mConnectionConstraint);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "storage_constraint", assetDownloadConfiguration.mStorageConstraint);
        AutoGenJsonHelper.a(jsonGenerator, "analytics_tag", assetDownloadConfiguration.mAnalyticsTag);
        AutoGenJsonHelper.a(jsonGenerator, "custom_location", assetDownloadConfiguration.mStringCustomLocation);
        AutoGenJsonHelper.a(jsonGenerator, "namespace", assetDownloadConfiguration.mNamespace);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "http_headers", assetDownloadConfiguration.mHttpHeaders);
    }
}
