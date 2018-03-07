package com.facebook.confirmation.task;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: input_album */
public class PendingContactpointDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10799a;

    static {
        GlobalAutoGenDeserializerCache.a(PendingContactpoint.class, new PendingContactpointDeserializer());
        m12744e();
    }

    public PendingContactpointDeserializer() {
        a(PendingContactpoint.class);
    }

    private static synchronized Map<String, FbJsonField> m12744e() {
        Map<String, FbJsonField> map;
        synchronized (PendingContactpointDeserializer.class) {
            if (f10799a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("pending_contactpoint", FbJsonField.jsonField(PendingContactpoint.class.getDeclaredField("pendingContactpoint")));
                    builder.b("timestamp", FbJsonField.jsonField(PendingContactpoint.class.getDeclaredField("timestamp")));
                    f10799a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10799a;
        }
        return map;
    }

    public final FbJsonField m12745a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12744e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12744e().keySet());
    }
}
