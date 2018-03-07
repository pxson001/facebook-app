package com.facebook.places.checkin.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: inline_survey_submit */
public class CheckinSearchQueryLocationExtraDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11057a;

    static {
        GlobalAutoGenDeserializerCache.a(CheckinSearchQueryLocationExtraData.class, new CheckinSearchQueryLocationExtraDataDeserializer());
        m13029e();
    }

    public CheckinSearchQueryLocationExtraDataDeserializer() {
        a(CheckinSearchQueryLocationExtraData.class);
    }

    private static synchronized Map<String, FbJsonField> m13029e() {
        Map<String, FbJsonField> map;
        synchronized (CheckinSearchQueryLocationExtraDataDeserializer.class) {
            if (f11057a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("wifi", FbJsonField.jsonField(CheckinSearchQueryLocationExtraData.class.getDeclaredField("mWifi")));
                    builder.b("ble", FbJsonField.jsonField(CheckinSearchQueryLocationExtraData.class.getDeclaredField("mBle")));
                    f11057a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11057a;
        }
        return map;
    }

    public final FbJsonField m13030a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13029e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13029e().keySet());
    }
}
