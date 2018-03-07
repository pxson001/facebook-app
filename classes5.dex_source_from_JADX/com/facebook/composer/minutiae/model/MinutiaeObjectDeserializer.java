package com.facebook.composer.minutiae.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: added_item_state_info */
public class MinutiaeObjectDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11478a;

    static {
        GlobalAutoGenDeserializerCache.a(MinutiaeObject.class, new MinutiaeObjectDeserializer());
        m19636e();
    }

    public MinutiaeObjectDeserializer() {
        a(MinutiaeObject.class);
    }

    private static synchronized Map<String, FbJsonField> m19636e() {
        Map<String, FbJsonField> map;
        synchronized (MinutiaeObjectDeserializer.class) {
            if (f11478a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("verb", FbJsonField.jsonField(MinutiaeObject.class.getDeclaredField("verb")));
                    builder.b("object", FbJsonField.jsonField(MinutiaeObject.class.getDeclaredField("object")));
                    builder.b("custom_icon", FbJsonField.jsonField(MinutiaeObject.class.getDeclaredField("customIcon")));
                    builder.b("suggestion_mechanism", FbJsonField.jsonField(MinutiaeObject.class.getDeclaredField("suggestionMechanism")));
                    builder.b("hide_attachment", FbJsonField.jsonField(MinutiaeObject.class.getDeclaredField("hideAttachment")));
                    f11478a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11478a;
        }
        return map;
    }

    public final FbJsonField m19637a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19636e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19636e().keySet());
    }
}
