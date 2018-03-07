package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: tab_view */
public class CreativeEditingDataSerializer extends JsonSerializer<CreativeEditingData> {
    public final void m4457a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        CreativeEditingData creativeEditingData = (CreativeEditingData) obj;
        if (creativeEditingData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4456b(creativeEditingData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(CreativeEditingData.class, new CreativeEditingDataSerializer());
    }

    private static void m4456b(CreativeEditingData creativeEditingData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "filter_name", creativeEditingData.filterName);
        AutoGenJsonHelper.a(jsonGenerator, "edited_uri", creativeEditingData.editedUri);
        AutoGenJsonHelper.a(jsonGenerator, "display_uri", creativeEditingData.displayUri);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "crop_box", creativeEditingData.cropBox);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "stickers_list", creativeEditingData.stickerParams);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "text_list", creativeEditingData.textParams);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "doodle_list", creativeEditingData.doodleParams);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "ordering_list", creativeEditingData.orderingList);
        AutoGenJsonHelper.a(jsonGenerator, "is_rotated", Boolean.valueOf(creativeEditingData.isRotated));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "frames_overlayitem_list", creativeEditingData.framesOverlayItems);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "frame_packs", creativeEditingData.framePacks);
    }
}
