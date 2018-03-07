package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: viewport_views */
public class VMSlideDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f298a;

    static {
        GlobalAutoGenDeserializerCache.a(VMSlide.class, new VMSlideDeserializer());
        m277e();
    }

    public VMSlideDeserializer() {
        a(VMSlide.class);
    }

    private static synchronized Map<String, FbJsonField> m277e() {
        Map<String, FbJsonField> map;
        synchronized (VMSlideDeserializer.class) {
            if (f298a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(VMSlide.class.getDeclaredField("name")));
                    builder.b("size", FbJsonField.jsonField(VMSlide.class.getDeclaredField("size"), Float.class));
                    builder.b("views", FbJsonField.jsonField(VMSlide.class.getDeclaredField("views"), VMView.class));
                    builder.b("actions", FbJsonField.jsonField(VMSlide.class.getDeclaredField("actionsMap")));
                    builder.b("master", FbJsonField.jsonField(VMSlide.class.getDeclaredField("master")));
                    builder.b("class", FbJsonField.jsonField(VMSlide.class.getDeclaredField("className")));
                    builder.b("values", FbJsonField.jsonField(VMSlide.class.getDeclaredField("values"), VMSlideValue.class));
                    builder.b("bg-color", FbJsonField.jsonField(VMSlide.class.getDeclaredField("bgColor")));
                    f298a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f298a;
        }
        return map;
    }

    public final FbJsonField m278a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m277e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m277e().keySet());
    }
}
