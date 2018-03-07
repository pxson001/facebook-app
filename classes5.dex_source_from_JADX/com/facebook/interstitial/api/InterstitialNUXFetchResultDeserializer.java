package com.facebook.interstitial.api;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.model.NuxStep;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TOPIC_FOOD_GROCERY */
public class InterstitialNUXFetchResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13860a;

    static {
        GlobalAutoGenDeserializerCache.a(InterstitialNUXFetchResult.class, new InterstitialNUXFetchResultDeserializer());
        m23231e();
    }

    public InterstitialNUXFetchResultDeserializer() {
        a(InterstitialNUXFetchResult.class);
    }

    private static synchronized Map<String, FbJsonField> m23231e() {
        Map<String, FbJsonField> map;
        synchronized (InterstitialNUXFetchResultDeserializer.class) {
            if (f13860a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("steps", FbJsonField.jsonField(InterstitialNUXFetchResult.class.getDeclaredField("steps"), NuxStep.class));
                    builder.b("extra_data", FbJsonField.jsonField(InterstitialNUXFetchResult.class.getDeclaredField("extraData")));
                    f13860a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13860a;
        }
        return map;
    }

    public final FbJsonField m23232a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23231e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23231e().keySet());
    }
}
