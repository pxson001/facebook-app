package com.facebook.placetips.bootstrap;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: search_results_loader_more_task */
public class PresenceSourceDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3823a;

    static {
        GlobalAutoGenDeserializerCache.a(PresenceSource.class, new PresenceSourceDeserializer());
        m3716e();
    }

    public PresenceSourceDeserializer() {
        a(PresenceSource.class);
    }

    private static synchronized Map<String, FbJsonField> m3716e() {
        Map<String, FbJsonField> map;
        synchronized (PresenceSourceDeserializer.class) {
            if (f3823a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonField(PresenceSource.class.getDeclaredField("mPresenceSourceType")));
                    builder.b("pulsar_rssi", FbJsonField.jsonField(PresenceSource.class.getDeclaredField("mPulsarRssi")));
                    builder.b("latitude", FbJsonField.jsonField(PresenceSource.class.getDeclaredField("mLatitude")));
                    builder.b("longitude", FbJsonField.jsonField(PresenceSource.class.getDeclaredField("mLongitude")));
                    builder.b("accuracy", FbJsonField.jsonField(PresenceSource.class.getDeclaredField("mAccuracy")));
                    f3823a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3823a;
        }
        return map;
    }

    public final FbJsonField m3717a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m3716e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m3716e().keySet());
    }
}
