package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.composer.model.ComposerVideoTaggingInfo.Builder;
import com.facebook.ipc.media.data.MediaData;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TIMELINE_PYMK */
public class ComposerVideoTaggingInfo_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13983a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new ComposerVideoTaggingInfo_BuilderDeserializer());
        m23372e();
    }

    public ComposerVideoTaggingInfo_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m23372e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerVideoTaggingInfo_BuilderDeserializer.class) {
            if (f13983a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("frames", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setFrames", new Class[]{ImmutableList.class}), MediaData.class));
                    builder.b("has_faceboxes", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setHasFaceboxes", new Class[]{Boolean.TYPE})));
                    f13983a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13983a;
        }
        return map;
    }

    public final FbJsonField m23373a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23372e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23372e().keySet());
    }
}
