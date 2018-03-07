package com.facebook.places.checkin.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.places.checkin.protocol.CheckinSearchQueryLocationExtraData.CheckinSearchQueryLocationExtraDataWifiObject;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: initially_expanded */
public class C0968xec4daeac extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11059a;

    static {
        GlobalAutoGenDeserializerCache.a(CheckinSearchQueryLocationExtraDataWifiObject.class, new C0968xec4daeac());
        C0968xec4daeac.m13035e();
    }

    public C0968xec4daeac() {
        a(CheckinSearchQueryLocationExtraDataWifiObject.class);
    }

    private static synchronized Map<String, FbJsonField> m13035e() {
        Map<String, FbJsonField> map;
        synchronized (C0968xec4daeac.class) {
            if (f11059a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("BSSID", FbJsonField.jsonField(CheckinSearchQueryLocationExtraDataWifiObject.class.getDeclaredField("mBssid")));
                    builder.b("name", FbJsonField.jsonField(CheckinSearchQueryLocationExtraDataWifiObject.class.getDeclaredField("mName")));
                    builder.b("strength", FbJsonField.jsonField(CheckinSearchQueryLocationExtraDataWifiObject.class.getDeclaredField("mStrength")));
                    builder.b("frequency", FbJsonField.jsonField(CheckinSearchQueryLocationExtraDataWifiObject.class.getDeclaredField("mFrequency")));
                    builder.b("stale_time", FbJsonField.jsonField(CheckinSearchQueryLocationExtraDataWifiObject.class.getDeclaredField("mAge")));
                    f11059a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11059a;
        }
        return map;
    }

    public final FbJsonField m13036a(String str) {
        FbJsonField fbJsonField = (FbJsonField) C0968xec4daeac.m13035e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(C0968xec4daeac.m13035e().keySet());
    }
}
