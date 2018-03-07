package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: wallet */
public class VMActionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f278a;

    static {
        GlobalAutoGenDeserializerCache.a(VMAction.class, new VMActionDeserializer());
        m264e();
    }

    public VMActionDeserializer() {
        a(VMAction.class);
    }

    private static synchronized Map<String, FbJsonField> m264e() {
        Map<String, FbJsonField> map;
        synchronized (VMActionDeserializer.class) {
            if (f278a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonField(VMAction.class.getDeclaredField("type")));
                    builder.b("arg", FbJsonField.jsonField(VMAction.class.getDeclaredField("arg")));
                    f278a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f278a;
        }
        return map;
    }

    public final FbJsonField m265a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m264e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m264e().keySet());
    }
}
