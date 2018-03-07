package com.facebook.privacy.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: featured */
public class PrivacyParameter_SettingsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15101a;

    static {
        GlobalAutoGenDeserializerCache.a(Settings.class, new PrivacyParameter_SettingsDeserializer());
        m22692e();
    }

    public PrivacyParameter_SettingsDeserializer() {
        a(Settings.class);
    }

    private static synchronized Map<String, FbJsonField> m22692e() {
        Map<String, FbJsonField> map;
        synchronized (PrivacyParameter_SettingsDeserializer.class) {
            if (f15101a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("no_tag_expansion", FbJsonField.jsonField(Settings.class.getDeclaredField("noTagExpansion")));
                    f15101a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15101a;
        }
        return map;
    }

    public final FbJsonField m22693a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22692e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22692e().keySet());
    }
}
