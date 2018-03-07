package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem.OverlayItemType;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: tag_expansion_education_type */
public class CreativeEditingDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3380a;

    static {
        GlobalAutoGenDeserializerCache.a(CreativeEditingData.class, new CreativeEditingDataDeserializer());
        m4454e();
    }

    public CreativeEditingDataDeserializer() {
        a(CreativeEditingData.class);
    }

    private static synchronized Map<String, FbJsonField> m4454e() {
        Map<String, FbJsonField> map;
        synchronized (CreativeEditingDataDeserializer.class) {
            if (f3380a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("filter_name", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("filterName")));
                    builder.b("edited_uri", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("editedUri")));
                    builder.b("display_uri", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("displayUri")));
                    builder.b("crop_box", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("cropBox"), Float.class));
                    builder.b("stickers_list", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("stickerParams"), StickerParams.class));
                    builder.b("text_list", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("textParams"), TextParams.class));
                    builder.b("doodle_list", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("doodleParams"), DoodleParams.class));
                    builder.b("ordering_list", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("orderingList"), OverlayItemType.class));
                    builder.b("is_rotated", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("isRotated")));
                    builder.b("frames_overlayitem_list", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("framesOverlayItems"), StickerParams.class));
                    builder.b("frame_packs", FbJsonField.jsonField(CreativeEditingData.class.getDeclaredField("framePacks"), FramePackModel.class));
                    f3380a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3380a;
        }
        return map;
    }

    public final FbJsonField m4455a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4454e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4454e().keySet());
    }
}
