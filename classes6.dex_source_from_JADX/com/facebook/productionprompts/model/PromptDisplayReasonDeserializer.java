package com.facebook.productionprompts.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: ss_see_more_link */
public class PromptDisplayReasonDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4260a;

    static {
        GlobalAutoGenDeserializerCache.a(PromptDisplayReason.class, new PromptDisplayReasonDeserializer());
        m6344e();
    }

    public PromptDisplayReasonDeserializer() {
        a(PromptDisplayReason.class);
    }

    private static synchronized Map<String, FbJsonField> m6344e() {
        Map<String, FbJsonField> map;
        synchronized (PromptDisplayReasonDeserializer.class) {
            if (f4260a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("reason_with_entities", FbJsonField.jsonField(PromptDisplayReason.class.getDeclaredField("textWithEntities")));
                    f4260a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4260a;
        }
        return map;
    }

    public final FbJsonField m6345a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m6344e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m6344e().keySet());
    }
}
