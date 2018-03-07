package com.facebook.devicebasedlogin.nux;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: This method should only be used for the logged-in user's Montage messages */
public class DeviceBasedLoginNuxV2InterstitialFetchResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24163a;

    static {
        GlobalAutoGenDeserializerCache.a(DeviceBasedLoginNuxV2InterstitialFetchResult.class, new DeviceBasedLoginNuxV2InterstitialFetchResultDeserializer());
        m26125e();
    }

    public DeviceBasedLoginNuxV2InterstitialFetchResultDeserializer() {
        a(DeviceBasedLoginNuxV2InterstitialFetchResult.class);
    }

    private static synchronized Map<String, FbJsonField> m26125e() {
        Map<String, FbJsonField> map;
        synchronized (DeviceBasedLoginNuxV2InterstitialFetchResultDeserializer.class) {
            if (f24163a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("targeted_nux", FbJsonField.jsonField(DeviceBasedLoginNuxV2InterstitialFetchResult.class.getDeclaredField("targetedNux")));
                    f24163a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24163a;
        }
        return map;
    }

    public final FbJsonField m26126a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26125e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26125e().keySet());
    }
}
