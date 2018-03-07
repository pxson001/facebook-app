package com.facebook.composer.attachments;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: place_picker_error_location_disabled */
public class ComposerSerializedMediaItemDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7809a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerSerializedMediaItem.class, new ComposerSerializedMediaItemDeserializer());
        m11239e();
    }

    public ComposerSerializedMediaItemDeserializer() {
        a(ComposerSerializedMediaItem.class);
    }

    private static synchronized Map<String, FbJsonField> m11239e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerSerializedMediaItemDeserializer.class) {
            if (f7809a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("photo_tags", FbJsonField.jsonField(ComposerSerializedMediaItem.class.getDeclaredField("mPhotoTags"), PhotoTag.class));
                    f7809a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7809a;
        }
        return map;
    }

    public final FbJsonField m11240a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11239e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11239e().keySet());
    }
}
