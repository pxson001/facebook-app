package com.facebook.placetips.bootstrap.data;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: search_fragment_paused */
public class PulsarRecordDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3836a;

    static {
        GlobalAutoGenDeserializerCache.a(PulsarRecord.class, new PulsarRecordDeserializer());
        m3726e();
    }

    public PulsarRecordDeserializer() {
        a(PulsarRecord.class);
    }

    private static synchronized Map<String, FbJsonField> m3726e() {
        Map<String, FbJsonField> map;
        synchronized (PulsarRecordDeserializer.class) {
            if (f3836a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("company_identifier", FbJsonField.jsonField(PulsarRecord.class.getDeclaredField("mCompanyIdentifier")));
                    builder.b("pulsar_ad_indicator", FbJsonField.jsonField(PulsarRecord.class.getDeclaredField("mPulsarAdvertismentIndicator")));
                    builder.b("uuid", FbJsonField.jsonField(PulsarRecord.class.getDeclaredField("mUUID")));
                    builder.b("major", FbJsonField.jsonField(PulsarRecord.class.getDeclaredField("mMajor")));
                    builder.b("minor", FbJsonField.jsonField(PulsarRecord.class.getDeclaredField("mMinor")));
                    f3836a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3836a;
        }
        return map;
    }

    public final FbJsonField m3727a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m3726e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m3726e().keySet());
    }
}
