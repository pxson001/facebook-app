package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TL_FR_BOX */
public class ComposerLocationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13958a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerLocation.class, new ComposerLocationDeserializer());
        m23319e();
    }

    public ComposerLocationDeserializer() {
        a(ComposerLocation.class);
    }

    private static synchronized Map<String, FbJsonField> m23319e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerLocationDeserializer.class) {
            if (f13958a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("latitude", FbJsonField.jsonField(ComposerLocation.class.getDeclaredField("latitude")));
                    builder.b("longitude", FbJsonField.jsonField(ComposerLocation.class.getDeclaredField("longitude")));
                    builder.b("accuracy", FbJsonField.jsonField(ComposerLocation.class.getDeclaredField("accuracy")));
                    builder.b("time", FbJsonField.jsonField(ComposerLocation.class.getDeclaredField("time")));
                    f13958a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13958a;
        }
        return map;
    }

    public final FbJsonField m23320a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23319e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23319e().keySet());
    }
}
