package com.facebook.pages.app.data.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: tab_to_show */
public class PagesManagerUriConfigEntryDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1134a;

    static {
        GlobalAutoGenDeserializerCache.a(PagesManagerUriConfigEntry.class, new PagesManagerUriConfigEntryDeserializer());
        m1532e();
    }

    public PagesManagerUriConfigEntryDeserializer() {
        a(PagesManagerUriConfigEntry.class);
    }

    private static synchronized Map<String, FbJsonField> m1532e() {
        Map<String, FbJsonField> map;
        synchronized (PagesManagerUriConfigEntryDeserializer.class) {
            if (f1134a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("setting", FbJsonField.jsonField(PagesManagerUriConfigEntry.class.getDeclaredField("mSetting")));
                    builder.b("value", FbJsonField.jsonField(PagesManagerUriConfigEntry.class.getDeclaredField("mValue")));
                    f1134a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1134a;
        }
        return map;
    }

    public final FbJsonField m1533a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1532e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1532e().keySet());
    }
}
