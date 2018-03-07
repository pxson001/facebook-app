package com.facebook.ipc.composer.intent;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: listener can't be null. */
public class ComposerStickerDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11572a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerStickerData.class, new ComposerStickerDataDeserializer());
        m18257e();
    }

    public ComposerStickerDataDeserializer() {
        a(ComposerStickerData.class);
    }

    private static synchronized Map<String, FbJsonField> m18257e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerStickerDataDeserializer.class) {
            if (f11572a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("sticker_id", FbJsonField.jsonField(ComposerStickerData.class.getDeclaredField("stickerId")));
                    builder.b("pack_id", FbJsonField.jsonField(ComposerStickerData.class.getDeclaredField("packId")));
                    builder.b("static_web_uri", FbJsonField.jsonField(ComposerStickerData.class.getDeclaredField("staticWebUri")));
                    builder.b("static_disk_uri", FbJsonField.jsonField(ComposerStickerData.class.getDeclaredField("staticDiskUri")));
                    builder.b("animated_web_uri", FbJsonField.jsonField(ComposerStickerData.class.getDeclaredField("animatedWebUri")));
                    builder.b("animated_disk_uri", FbJsonField.jsonField(ComposerStickerData.class.getDeclaredField("animatedDiskUri")));
                    f11572a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11572a;
        }
        return map;
    }

    public final FbJsonField m18258a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18257e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18257e().keySet());
    }
}
