package com.facebook.notifications.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: neko/ */
public class FacebookNotificationSettingDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8396a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookNotificationSetting.class, new FacebookNotificationSettingDeserializer());
        m9977e();
    }

    public FacebookNotificationSettingDeserializer() {
        a(FacebookNotificationSetting.class);
    }

    private static synchronized Map<String, FbJsonField> m9977e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookNotificationSettingDeserializer.class) {
            if (f8396a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("setting_id", FbJsonField.jsonField(FacebookNotificationSetting.class.getDeclaredField("settingId")));
                    builder.b("setting_value", FbJsonField.jsonField(FacebookNotificationSetting.class.getDeclaredField("settingValue")));
                    f8396a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8396a;
        }
        return map;
    }

    public final FbJsonField m9978a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m9977e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m9977e().keySet());
    }
}
