package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: viewer_group_purpose_modal_seen */
public class VMSlideValueDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f301a;

    static {
        GlobalAutoGenDeserializerCache.a(VMSlideValue.class, new VMSlideValueDeserializer());
        m283e();
    }

    public VMSlideValueDeserializer() {
        a(VMSlideValue.class);
    }

    private static synchronized Map<String, FbJsonField> m283e() {
        Map<String, FbJsonField> map;
        synchronized (VMSlideValueDeserializer.class) {
            if (f301a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(VMSlideValue.class.getDeclaredField("name")));
                    builder.b("type", FbJsonField.jsonField(VMSlideValue.class.getDeclaredField("mType")));
                    builder.b("src", FbJsonField.jsonField(VMSlideValue.class.getDeclaredField("src")));
                    builder.b("text", FbJsonField.jsonField(VMSlideValue.class.getDeclaredField("text")));
                    builder.b("title", FbJsonField.jsonField(VMSlideValue.class.getDeclaredField("title")));
                    builder.b("subviews", FbJsonField.jsonField(VMSlideValue.class.getDeclaredField("subviews"), VMView.class));
                    builder.b("duration", FbJsonField.jsonField(VMSlideValue.class.getDeclaredField("duration")));
                    f301a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f301a;
        }
        return map;
    }

    public final FbJsonField m284a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m283e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m283e().keySet());
    }
}
