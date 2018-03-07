package com.facebook.composer.attachments;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: place_picker_first_keystroke */
public class ComposerAttachmentSerializer extends JsonSerializer<ComposerAttachment> {
    public final void m11237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerAttachment composerAttachment = (ComposerAttachment) obj;
        if (composerAttachment == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m11236b(composerAttachment, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerAttachment.class, new ComposerAttachmentSerializer());
    }

    private static void m11236b(ComposerAttachment composerAttachment, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "serialized_media_item", composerAttachment.mSerializedMediaItemInternal);
        AutoGenJsonHelper.a(jsonGenerator, "uri", composerAttachment.mUri);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "caption", composerAttachment.mCaption);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "creative_editing_data", composerAttachment.mCreativeEditingData);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "video_creative_editing_data", composerAttachment.mVideoCreativeEditingData);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "video_tagging_info", composerAttachment.mVideoTaggingInfo);
        AutoGenJsonHelper.a(jsonGenerator, "id", Integer.valueOf(composerAttachment.mId));
    }
}
