package com.facebook.aldrin.status;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: layout_ */
public class AldrinUserStatusDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10385a;

    static {
        GlobalAutoGenDeserializerCache.a(AldrinUserStatus.class, new AldrinUserStatusDeserializer());
        m12182e();
    }

    public AldrinUserStatusDeserializer() {
        a(AldrinUserStatus.class);
    }

    private static synchronized Map<String, FbJsonField> m12182e() {
        Map<String, FbJsonField> map;
        synchronized (AldrinUserStatusDeserializer.class) {
            if (f10385a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("effective_region", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("effectiveRegion")));
                    builder.b("current_region", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("currentRegion")));
                    builder.b("tos_transition_type", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("tosTransitionType")));
                    builder.b("is_cu", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("isCu")));
                    builder.b("should_be_cu", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("shouldBeCu")));
                    builder.b("tos_terms_url", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("tosTermsUrl")));
                    builder.b("tos_privacy_url", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("tosPrivacyUrl")));
                    builder.b("tos_cookies_url", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("tosCookiesUrl")));
                    builder.b("tos_version", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("tosVersion")));
                    builder.b("fetch_time", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("fetchTime")));
                    builder.b("user_id", FbJsonField.jsonField(AldrinUserStatus.class.getDeclaredField("userId")));
                    f10385a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10385a;
        }
        return map;
    }

    public final FbJsonField m12183a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12182e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12182e().keySet());
    }
}
