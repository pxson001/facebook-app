package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: vpvd_start_time */
public class VMColorDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f279a;

    /* compiled from: vpvd_start_time */
    final class C00351 extends TypeReference<ImmutableList<Float>> {
        C00351() {
        }
    }

    static {
        GlobalAutoGenDeserializerCache.a(VMColor.class, new VMColorDeserializer());
        m266e();
    }

    public VMColorDeserializer() {
        a(VMColor.class);
    }

    private static synchronized Map<String, FbJsonField> m266e() {
        Map<String, FbJsonField> map;
        synchronized (VMColorDeserializer.class) {
            if (f279a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonField(VMColor.class.getDeclaredField("type")));
                    builder.b("color", FbJsonField.jsonField(VMColor.class.getDeclaredField("color"), Float.class));
                    builder.b("colors", FbJsonField.jsonField(VMColor.class.getDeclaredField("colors"), new C00351()));
                    builder.b("angle", FbJsonField.jsonField(VMColor.class.getDeclaredField("angle")));
                    builder.b("locations", FbJsonField.jsonField(VMColor.class.getDeclaredField("locations"), Float.class));
                    f279a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f279a;
        }
        return map;
    }

    public final FbJsonField m267a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m266e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m266e().keySet());
    }
}
