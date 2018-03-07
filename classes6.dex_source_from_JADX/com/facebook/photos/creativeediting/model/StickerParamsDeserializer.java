package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: survey_config */
public class StickerParamsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3513a;

    static {
        GlobalAutoGenDeserializerCache.a(StickerParams.class, new StickerParamsDeserializer());
        m4701e();
    }

    public StickerParamsDeserializer() {
        a(StickerParams.class);
    }

    private static synchronized Map<String, FbJsonField> m4701e() {
        Map<String, FbJsonField> map;
        synchronized (StickerParamsDeserializer.class) {
            if (f3513a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(StickerParams.class.getDeclaredField("id")));
                    builder.b("uniqueId", FbJsonField.jsonField(StickerParams.class.getDeclaredField("uniqueId")));
                    builder.b("rotation_degrees", FbJsonField.jsonField(StickerParams.class.getDeclaredField("rotateDegrees")));
                    builder.b("sticker_uri", FbJsonField.jsonField(StickerParams.class.getDeclaredField("stickerUri")));
                    builder.b("left", FbJsonField.jsonField(StickerParams.class.getDeclaredField("leftPercentage")));
                    builder.b("top", FbJsonField.jsonField(StickerParams.class.getDeclaredField("topPercentage")));
                    builder.b("width", FbJsonField.jsonField(StickerParams.class.getDeclaredField("widthPercentage")));
                    builder.b("height", FbJsonField.jsonField(StickerParams.class.getDeclaredField("heightPercentage")));
                    builder.b("isFlipped", FbJsonField.jsonField(StickerParams.class.getDeclaredField("isFlipped")));
                    builder.b("isSelectable", FbJsonField.jsonField(StickerParams.class.getDeclaredField("isSelectable")));
                    builder.b("isFrameItem", FbJsonField.jsonField(StickerParams.class.getDeclaredField("isFrameItem")));
                    f3513a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3513a;
        }
        return map;
    }

    public final FbJsonField m4702a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4701e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4701e().keySet());
    }
}
