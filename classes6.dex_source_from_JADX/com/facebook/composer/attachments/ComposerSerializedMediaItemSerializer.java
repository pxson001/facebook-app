package com.facebook.composer.attachments;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: place_picker_dragged_to_refresh */
public class ComposerSerializedMediaItemSerializer extends JsonSerializer<ComposerSerializedMediaItem> {
    public final void m11242a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerSerializedMediaItem composerSerializedMediaItem = (ComposerSerializedMediaItem) obj;
        if (composerSerializedMediaItem == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m11241b(composerSerializedMediaItem, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerSerializedMediaItem.class, new ComposerSerializedMediaItemSerializer());
    }

    private static void m11241b(ComposerSerializedMediaItem composerSerializedMediaItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "photo_tags", composerSerializedMediaItem.mPhotoTags);
    }
}
