package com.facebook.privacy.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: featured_photos */
public class PrivacyParameterDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15100a;

    static {
        GlobalAutoGenDeserializerCache.a(PrivacyParameter.class, new PrivacyParameterDeserializer());
        m22688e();
    }

    public PrivacyParameterDeserializer() {
        a(PrivacyParameter.class);
    }

    private static synchronized Map<String, FbJsonField> m22688e() {
        Map<String, FbJsonField> map;
        synchronized (PrivacyParameterDeserializer.class) {
            if (f15100a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("value", FbJsonField.jsonField(PrivacyParameter.class.getDeclaredField("value")));
                    builder.b("deny", FbJsonField.jsonField(PrivacyParameter.class.getDeclaredField("deny")));
                    builder.b("allow", FbJsonField.jsonField(PrivacyParameter.class.getDeclaredField("allow")));
                    builder.b("friends", FbJsonField.jsonField(PrivacyParameter.class.getDeclaredField("friends")));
                    builder.b("settings", FbJsonField.jsonField(PrivacyParameter.class.getDeclaredField("settings")));
                    f15100a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15100a;
        }
        return map;
    }

    public final FbJsonField m22689a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22688e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22688e().keySet());
    }
}
