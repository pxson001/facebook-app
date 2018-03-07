package com.facebook.nearby.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: unreadMessageCount */
public class NearbyTilesMethodResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f391a;

    static {
        GlobalAutoGenDeserializerCache.a(NearbyTilesMethodResult.class, new NearbyTilesMethodResultDeserializer());
        m512e();
    }

    public NearbyTilesMethodResultDeserializer() {
        a(NearbyTilesMethodResult.class);
    }

    private static synchronized Map<String, FbJsonField> m512e() {
        Map<String, FbJsonField> map;
        synchronized (NearbyTilesMethodResultDeserializer.class) {
            if (f391a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("tiles", FbJsonField.jsonField(NearbyTilesMethodResult.class.getDeclaredField("nearbyTiles")));
                    builder.b("search_session_key", FbJsonField.jsonField(NearbyTilesMethodResult.class.getDeclaredField("searchSessionKey")));
                    f391a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f391a;
        }
        return map;
    }

    public final FbJsonField m513a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m512e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m512e().keySet());
    }
}
