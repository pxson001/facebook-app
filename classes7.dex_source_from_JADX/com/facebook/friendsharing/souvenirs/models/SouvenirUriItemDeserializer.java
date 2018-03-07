package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: RIGHT */
public class SouvenirUriItemDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24072a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirUriItem.class, new SouvenirUriItemDeserializer());
        m26189e();
    }

    public SouvenirUriItemDeserializer() {
        a(SouvenirUriItem.class);
    }

    private static synchronized Map<String, FbJsonField> m26189e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirUriItemDeserializer.class) {
            if (f24072a == null) {
                try {
                    f24072a = new Builder().b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24072a;
        }
        return map;
    }

    public FbJsonField mo1600a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26189e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26189e().keySet());
    }
}
