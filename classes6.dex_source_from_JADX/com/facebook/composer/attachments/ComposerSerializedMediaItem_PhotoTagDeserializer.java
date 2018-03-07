package com.facebook.composer.attachments;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: place_picker_configuration */
public class ComposerSerializedMediaItem_PhotoTagDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7810a;

    static {
        GlobalAutoGenDeserializerCache.a(PhotoTag.class, new ComposerSerializedMediaItem_PhotoTagDeserializer());
        m11243e();
    }

    public ComposerSerializedMediaItem_PhotoTagDeserializer() {
        a(PhotoTag.class);
    }

    private static synchronized Map<String, FbJsonField> m11243e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerSerializedMediaItem_PhotoTagDeserializer.class) {
            if (f7810a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("tagged_id", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("taggedId")));
                    builder.b("box_left", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("boxLeft")));
                    builder.b("box_top", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("boxTop")));
                    builder.b("box_right", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("boxRight")));
                    builder.b("box_bottom", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("boxBottom")));
                    builder.b("tagging_profile_type", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("taggingProfileType")));
                    builder.b("is_auto_tag", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("isAutoTag")));
                    builder.b("created", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("created")));
                    builder.b("text", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("text")));
                    builder.b("first_name", FbJsonField.jsonField(PhotoTag.class.getDeclaredField("firstName")));
                    f7810a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7810a;
        }
        return map;
    }

    public final FbJsonField m11244a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11243e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11243e().keySet());
    }
}
