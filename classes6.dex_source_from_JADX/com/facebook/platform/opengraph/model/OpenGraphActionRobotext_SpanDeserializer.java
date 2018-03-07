package com.facebook.platform.opengraph.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext.Span;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: storageConstraint */
public class OpenGraphActionRobotext_SpanDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4104a;

    static {
        GlobalAutoGenDeserializerCache.a(Span.class, new OpenGraphActionRobotext_SpanDeserializer());
        m6020e();
    }

    public OpenGraphActionRobotext_SpanDeserializer() {
        a(Span.class);
    }

    private static synchronized Map<String, FbJsonField> m6020e() {
        Map<String, FbJsonField> map;
        synchronized (OpenGraphActionRobotext_SpanDeserializer.class) {
            if (f4104a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("offset", FbJsonField.jsonField(Span.class.getDeclaredField("mOffset")));
                    builder.b("length", FbJsonField.jsonField(Span.class.getDeclaredField("mLength")));
                    f4104a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4104a;
        }
        return map;
    }

    public final FbJsonField m6021a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m6020e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m6020e().keySet());
    }
}
