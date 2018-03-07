package com.facebook.places.checkin.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.places.checkin.protocol.CheckinSearchQueryLocationExtraData.CheckinSearchQueryLocationExtraDataWifi;
import com.facebook.places.checkin.protocol.CheckinSearchQueryLocationExtraData.CheckinSearchQueryLocationExtraDataWifiObject;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: inline_composer_click */
public class C0967x9ef0614d extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11058a;

    static {
        GlobalAutoGenDeserializerCache.a(CheckinSearchQueryLocationExtraDataWifi.class, new C0967x9ef0614d());
        C0967x9ef0614d.m13033e();
    }

    public C0967x9ef0614d() {
        a(CheckinSearchQueryLocationExtraDataWifi.class);
    }

    private static synchronized Map<String, FbJsonField> m13033e() {
        Map<String, FbJsonField> map;
        synchronized (C0967x9ef0614d.class) {
            if (f11058a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("connected_wifi", FbJsonField.jsonField(CheckinSearchQueryLocationExtraDataWifi.class.getDeclaredField("mConnectedWifi")));
                    builder.b("ambient_wifis", FbJsonField.jsonField(CheckinSearchQueryLocationExtraDataWifi.class.getDeclaredField("mAmbientWifis"), CheckinSearchQueryLocationExtraDataWifiObject.class));
                    f11058a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11058a;
        }
        return map;
    }

    public final FbJsonField m13034a(String str) {
        FbJsonField fbJsonField = (FbJsonField) C0967x9ef0614d.m13033e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(C0967x9ef0614d.m13033e().keySet());
    }
}
