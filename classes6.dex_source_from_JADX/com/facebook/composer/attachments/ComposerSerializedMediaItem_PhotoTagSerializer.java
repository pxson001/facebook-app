package com.facebook.composer.attachments;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: place_picker_cancelled */
public class ComposerSerializedMediaItem_PhotoTagSerializer extends JsonSerializer<PhotoTag> {
    public final void m11246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PhotoTag photoTag = (PhotoTag) obj;
        if (photoTag == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m11245b(photoTag, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PhotoTag.class, new ComposerSerializedMediaItem_PhotoTagSerializer());
    }

    private static void m11245b(PhotoTag photoTag, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "tagged_id", Long.valueOf(photoTag.taggedId));
        AutoGenJsonHelper.a(jsonGenerator, "box_left", Float.valueOf(photoTag.boxLeft));
        AutoGenJsonHelper.a(jsonGenerator, "box_top", Float.valueOf(photoTag.boxTop));
        AutoGenJsonHelper.a(jsonGenerator, "box_right", Float.valueOf(photoTag.boxRight));
        AutoGenJsonHelper.a(jsonGenerator, "box_bottom", Float.valueOf(photoTag.boxBottom));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "tagging_profile_type", photoTag.taggingProfileType);
        AutoGenJsonHelper.a(jsonGenerator, "is_auto_tag", Boolean.valueOf(photoTag.isAutoTag));
        AutoGenJsonHelper.a(jsonGenerator, "created", Long.valueOf(photoTag.created));
        AutoGenJsonHelper.a(jsonGenerator, "text", photoTag.text);
        AutoGenJsonHelper.a(jsonGenerator, "first_name", photoTag.firstName);
    }
}
