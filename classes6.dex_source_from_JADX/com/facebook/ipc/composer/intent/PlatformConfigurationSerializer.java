package com.facebook.ipc.composer.intent;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: likelihood */
public class PlatformConfigurationSerializer extends JsonSerializer<PlatformConfiguration> {
    public final void m18281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PlatformConfiguration platformConfiguration = (PlatformConfiguration) obj;
        if (platformConfiguration == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m18280b(platformConfiguration, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PlatformConfiguration.class, new PlatformConfigurationSerializer());
    }

    private static void m18280b(PlatformConfiguration platformConfiguration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "data_failures_fatal", Boolean.valueOf(platformConfiguration.dataFailuresFatal));
        AutoGenJsonHelper.a(jsonGenerator, "insights_platform_ref", platformConfiguration.insightsPlatformRef);
        AutoGenJsonHelper.a(jsonGenerator, "hashtag", platformConfiguration.hashtag);
        AutoGenJsonHelper.a(jsonGenerator, "og_action_json_for_robotext", platformConfiguration.ogActionJsonForRobotext);
        AutoGenJsonHelper.a(jsonGenerator, "og_action_type", platformConfiguration.ogActionType);
        AutoGenJsonHelper.a(jsonGenerator, "name_for_share_link", platformConfiguration.nameForShareLink);
        AutoGenJsonHelper.a(jsonGenerator, "caption_for_share_link", platformConfiguration.captionForShareLink);
        AutoGenJsonHelper.a(jsonGenerator, "picture_for_share_link", platformConfiguration.pictureForShareLink);
        AutoGenJsonHelper.a(jsonGenerator, "description_for_share_link", platformConfiguration.descriptionForShareLink);
    }
}
