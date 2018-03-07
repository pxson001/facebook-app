package com.facebook.katana.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: source_jewel */
public class UserServerSettingDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1965a;

    static {
        GlobalAutoGenDeserializerCache.a(UserServerSetting.class, new UserServerSettingDeserializer());
        m2027e();
    }

    public UserServerSettingDeserializer() {
        a(UserServerSetting.class);
    }

    private static synchronized Map<String, FbJsonField> m2027e() {
        Map<String, FbJsonField> map;
        synchronized (UserServerSettingDeserializer.class) {
            if (f1965a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("project", FbJsonField.jsonField(UserServerSetting.class.getDeclaredField("mProjectName")));
                    builder.b("setting", FbJsonField.jsonField(UserServerSetting.class.getDeclaredField("mSettingName")));
                    builder.b("value", FbJsonField.jsonField(UserServerSetting.class.getDeclaredField("mValue")));
                    f1965a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1965a;
        }
        return map;
    }

    public final FbJsonField m2028a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m2027e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m2027e().keySet());
    }
}
