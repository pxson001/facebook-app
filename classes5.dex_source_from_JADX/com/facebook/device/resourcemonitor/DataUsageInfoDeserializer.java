package com.facebook.device.resourcemonitor;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: scopes */
public class DataUsageInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f2915a;

    static {
        GlobalAutoGenDeserializerCache.a(DataUsageInfo.class, new DataUsageInfoDeserializer());
        m4047e();
    }

    public DataUsageInfoDeserializer() {
        a(DataUsageInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m4047e() {
        Map<String, FbJsonField> map;
        synchronized (DataUsageInfoDeserializer.class) {
            if (f2915a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("WifiReceivedBytes", FbJsonField.jsonField(DataUsageInfo.class.getDeclaredField("mWifiReceivedBytes")));
                    builder.b("WifiSentBytes", FbJsonField.jsonField(DataUsageInfo.class.getDeclaredField("mWifiSentBytes")));
                    builder.b("MobileReceivedBytes", FbJsonField.jsonField(DataUsageInfo.class.getDeclaredField("mMobileReceivedBytes")));
                    builder.b("MobileSentBytes", FbJsonField.jsonField(DataUsageInfo.class.getDeclaredField("mMobileSentBytes")));
                    f2915a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f2915a;
        }
        return map;
    }

    public final FbJsonField m4048a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4047e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4047e().keySet());
    }
}
