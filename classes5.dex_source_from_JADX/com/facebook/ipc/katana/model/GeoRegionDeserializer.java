package com.facebook.ipc.katana.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: THRIFT_OR_CONSIGNMENT_STORE */
public class GeoRegionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14076a;

    static {
        GlobalAutoGenDeserializerCache.a(GeoRegion.class, new GeoRegionDeserializer());
        m23442e();
    }

    public GeoRegionDeserializer() {
        a(GeoRegion.class);
    }

    private static synchronized Map<String, FbJsonField> m23442e() {
        Map<String, FbJsonField> map;
        synchronized (GeoRegionDeserializer.class) {
            if (f14076a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("abbr_name", FbJsonField.jsonField(GeoRegion.class.getDeclaredField("abbrName")));
                    builder.b("type", FbJsonField.jsonField(GeoRegion.class.getDeclaredField("type")));
                    builder.b("page_fbid", FbJsonField.jsonField(GeoRegion.class.getDeclaredField("id")));
                    f14076a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14076a;
        }
        return map;
    }

    public final FbJsonField m23443a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23442e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23442e().keySet());
    }
}
