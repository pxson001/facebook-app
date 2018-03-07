package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.composer.model.ComposerSlideshowData.Builder;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TIZEN */
public class ComposerSlideshowData_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13973a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new ComposerSlideshowData_BuilderDeserializer());
        m23354e();
    }

    public ComposerSlideshowData_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m23354e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerSlideshowData_BuilderDeserializer.class) {
            if (f13973a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("audio_track_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setAudioTrackId", new Class[]{String.class})));
                    f13973a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13973a;
        }
        return map;
    }

    public final FbJsonField m23355a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23354e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23354e().keySet());
    }
}
