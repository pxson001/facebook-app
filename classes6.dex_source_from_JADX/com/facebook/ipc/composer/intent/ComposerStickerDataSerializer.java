package com.facebook.ipc.composer.intent;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: list_prompt */
public class ComposerStickerDataSerializer extends JsonSerializer<ComposerStickerData> {
    public final void m18260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerStickerData composerStickerData = (ComposerStickerData) obj;
        if (composerStickerData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m18259b(composerStickerData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerStickerData.class, new ComposerStickerDataSerializer());
    }

    private static void m18259b(ComposerStickerData composerStickerData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "sticker_id", composerStickerData.stickerId);
        AutoGenJsonHelper.a(jsonGenerator, "pack_id", composerStickerData.packId);
        AutoGenJsonHelper.a(jsonGenerator, "static_web_uri", composerStickerData.staticWebUri);
        AutoGenJsonHelper.a(jsonGenerator, "static_disk_uri", composerStickerData.staticDiskUri);
        AutoGenJsonHelper.a(jsonGenerator, "animated_web_uri", composerStickerData.animatedWebUri);
        AutoGenJsonHelper.a(jsonGenerator, "animated_disk_uri", composerStickerData.animatedDiskUri);
    }
}
