package com.facebook.vault.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: threads_fetch_archived */
public class BlacklistedSyncPathsGroupDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1711a;

    static {
        GlobalAutoGenDeserializerCache.a(BlacklistedSyncPathsGroup.class, new BlacklistedSyncPathsGroupDeserializer());
        m1743e();
    }

    public BlacklistedSyncPathsGroupDeserializer() {
        a(BlacklistedSyncPathsGroup.class);
    }

    private static synchronized Map<String, FbJsonField> m1743e() {
        Map<String, FbJsonField> map;
        synchronized (BlacklistedSyncPathsGroupDeserializer.class) {
            if (f1711a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(BlacklistedSyncPathsGroup.class.getDeclaredField("paths"), BlacklistedSyncPath.class));
                    f1711a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1711a;
        }
        return map;
    }

    public final FbJsonField m1744a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1743e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1743e().keySet());
    }
}
