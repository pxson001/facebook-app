package com.facebook.ipc.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TEST_VIDEOS_FROM_TEST_BROADCASTERS */
public class NuxStepDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14132a;

    static {
        GlobalAutoGenDeserializerCache.a(NuxStep.class, new NuxStepDeserializer());
        m23516e();
    }

    public NuxStepDeserializer() {
        a(NuxStep.class);
    }

    private static synchronized Map<String, FbJsonField> m23516e() {
        Map<String, FbJsonField> map;
        synchronized (NuxStepDeserializer.class) {
            if (f14132a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(NuxStep.class.getDeclaredField("name")));
                    builder.b("is_current", FbJsonField.jsonField(NuxStep.class.getDeclaredField("isCurrent")));
                    f14132a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14132a;
        }
        return map;
    }

    public final FbJsonField m23517a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23516e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23516e().keySet());
    }
}
