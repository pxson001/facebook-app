package com.facebook.interstitial.manager;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TOPIC_CONCERT_VENUE */
public class InterstitialTriggerDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13878a;

    static {
        GlobalAutoGenDeserializerCache.a(InterstitialTrigger.class, new InterstitialTriggerDeserializer());
        m23257e();
    }

    public InterstitialTriggerDeserializer() {
        a(InterstitialTrigger.class);
    }

    private static synchronized Map<String, FbJsonField> m23257e() {
        Map<String, FbJsonField> map;
        synchronized (InterstitialTriggerDeserializer.class) {
            if (f13878a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("action", FbJsonField.jsonFieldWithCreator(InterstitialTrigger.class.getDeclaredField("action")));
                    builder.b("activity_class", FbJsonField.jsonField(InterstitialTrigger.class.getDeclaredField("activityClass")));
                    f13878a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13878a;
        }
        return map;
    }

    public final FbJsonField m23258a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23257e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23257e().keySet());
    }
}
