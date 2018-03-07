package com.facebook.ipc.katana.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: THREAD_SETTINGS */
public class GeoRegion_ImplicitLocationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14077a;

    static {
        GlobalAutoGenDeserializerCache.a(ImplicitLocation.class, new GeoRegion_ImplicitLocationDeserializer());
        m23444e();
    }

    public GeoRegion_ImplicitLocationDeserializer() {
        a(ImplicitLocation.class);
    }

    private static synchronized Map<String, FbJsonField> m23444e() {
        Map<String, FbJsonField> map;
        synchronized (GeoRegion_ImplicitLocationDeserializer.class) {
            if (f14077a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("label", FbJsonField.jsonField(ImplicitLocation.class.getDeclaredField("label")));
                    builder.b("page_id", FbJsonField.jsonField(ImplicitLocation.class.getDeclaredField("pageId")));
                    f14077a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14077a;
        }
        return map;
    }

    public final FbJsonField m23445a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23444e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23444e().keySet());
    }
}
