package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: visits_limit */
public class VMDeckDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f288a;

    static {
        GlobalAutoGenDeserializerCache.a(VMDeck.class, new VMDeckDeserializer());
        m270e();
    }

    public VMDeckDeserializer() {
        a(VMDeck.class);
    }

    private static synchronized Map<String, FbJsonField> m270e() {
        Map<String, FbJsonField> map;
        synchronized (VMDeckDeserializer.class) {
            if (f288a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("size", FbJsonField.jsonField(VMDeck.class.getDeclaredField("size"), Float.class));
                    builder.b("slides", FbJsonField.jsonField(VMDeck.class.getDeclaredField("slides"), VMSlide.class));
                    builder.b("resources", FbJsonField.jsonField(VMDeck.class.getDeclaredField("resources")));
                    builder.b("initial-slide", FbJsonField.jsonField(VMDeck.class.getDeclaredField("initialSlide")));
                    builder.b("styles", FbJsonField.jsonField(VMDeck.class.getDeclaredField("styles"), VMView.class));
                    builder.b("theme", FbJsonField.jsonField(VMDeck.class.getDeclaredField("theme")));
                    builder.b("bg-color", FbJsonField.jsonField(VMDeck.class.getDeclaredField("bgColor")));
                    f288a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f288a;
        }
        return map;
    }

    public final FbJsonField m271a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m270e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m270e().keySet());
    }
}
