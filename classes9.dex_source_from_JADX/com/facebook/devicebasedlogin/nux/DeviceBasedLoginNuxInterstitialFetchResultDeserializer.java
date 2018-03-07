package com.facebook.devicebasedlogin.nux;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: Thread  */
public class DeviceBasedLoginNuxInterstitialFetchResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24156a;

    static {
        GlobalAutoGenDeserializerCache.a(DeviceBasedLoginNuxInterstitialFetchResult.class, new DeviceBasedLoginNuxInterstitialFetchResultDeserializer());
        m26113e();
    }

    public DeviceBasedLoginNuxInterstitialFetchResultDeserializer() {
        a(DeviceBasedLoginNuxInterstitialFetchResult.class);
    }

    private static synchronized Map<String, FbJsonField> m26113e() {
        Map<String, FbJsonField> map;
        synchronized (DeviceBasedLoginNuxInterstitialFetchResultDeserializer.class) {
            if (f24156a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("triggerGeneration", FbJsonField.jsonField(DeviceBasedLoginNuxInterstitialFetchResult.class.getDeclaredField("triggerGeneration")));
                    f24156a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24156a;
        }
        return map;
    }

    public final FbJsonField m26114a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26113e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26113e().keySet());
    }
}
