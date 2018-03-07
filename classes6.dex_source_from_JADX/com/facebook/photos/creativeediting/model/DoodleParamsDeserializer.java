package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: sync_sequence_id */
public class DoodleParamsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3390a;

    static {
        GlobalAutoGenDeserializerCache.a(DoodleParams.class, new DoodleParamsDeserializer());
        m4489e();
    }

    public DoodleParamsDeserializer() {
        a(DoodleParams.class);
    }

    private static synchronized Map<String, FbJsonField> m4489e() {
        Map<String, FbJsonField> map;
        synchronized (DoodleParamsDeserializer.class) {
            if (f3390a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(DoodleParams.class.getDeclaredField("id")));
                    builder.b("uri", FbJsonField.jsonField(DoodleParams.class.getDeclaredField("uri")));
                    builder.b("left", FbJsonField.jsonField(DoodleParams.class.getDeclaredField("leftPercentage")));
                    builder.b("top", FbJsonField.jsonField(DoodleParams.class.getDeclaredField("topPercentage")));
                    builder.b("width", FbJsonField.jsonField(DoodleParams.class.getDeclaredField("widthPercentage")));
                    builder.b("height", FbJsonField.jsonField(DoodleParams.class.getDeclaredField("heightPercentage")));
                    builder.b("rotation_degrees", FbJsonField.jsonField(DoodleParams.class.getDeclaredField("rotateDegrees")));
                    f3390a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3390a;
        }
        return map;
    }

    public final FbJsonField m4490a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4489e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4489e().keySet());
    }
}
