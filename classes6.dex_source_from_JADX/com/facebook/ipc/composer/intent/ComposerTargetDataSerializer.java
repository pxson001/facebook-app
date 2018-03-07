package com.facebook.ipc.composer.intent;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: link_attachment_url */
public class ComposerTargetDataSerializer extends JsonSerializer<ComposerTargetData> {
    public final void m18270a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerTargetData composerTargetData = (ComposerTargetData) obj;
        if (composerTargetData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m18269b(composerTargetData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerTargetData.class, new ComposerTargetDataSerializer());
    }

    private static void m18269b(ComposerTargetData composerTargetData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "target_id", Long.valueOf(composerTargetData.targetId));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "target_type", composerTargetData.targetType);
        AutoGenJsonHelper.a(jsonGenerator, "target_name", composerTargetData.targetName);
        AutoGenJsonHelper.a(jsonGenerator, "target_profile_pic_url", composerTargetData.targetProfilePicUrl);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "target_privacy", composerTargetData.targetPrivacy);
        AutoGenJsonHelper.a(jsonGenerator, "acts_as_target", Boolean.valueOf(composerTargetData.actsAsTarget));
    }
}
