package com.facebook.nux;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: isRetryable */
public class NuxHistoryDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f12217a;

    static {
        GlobalAutoGenDeserializerCache.a(NuxHistory.class, new NuxHistoryDeserializer());
        m19140e();
    }

    public NuxHistoryDeserializer() {
        a(NuxHistory.class);
    }

    private static synchronized Map<String, FbJsonField> m19140e() {
        Map<String, FbJsonField> map;
        synchronized (NuxHistoryDeserializer.class) {
            if (f12217a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("lastAppearanceTime", FbJsonField.jsonField(NuxHistory.class.getDeclaredField("lastAppearanceTime")));
                    builder.b("isCompleted", FbJsonField.jsonField(NuxHistory.class.getDeclaredField("isCompleted")));
                    builder.b("numAppearances", FbJsonField.jsonField(NuxHistory.class.getDeclaredField("numAppearances")));
                    f12217a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f12217a;
        }
        return map;
    }

    public final FbJsonField m19141a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19140e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19140e().keySet());
    }
}
