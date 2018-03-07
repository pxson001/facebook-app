package com.facebook.growth.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: element_text */
public class ContactpointDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14890a;

    static {
        GlobalAutoGenDeserializerCache.a(Contactpoint.class, new ContactpointDeserializer());
        m17346e();
    }

    public ContactpointDeserializer() {
        a(Contactpoint.class);
    }

    private static synchronized Map<String, FbJsonField> m17346e() {
        Map<String, FbJsonField> map;
        synchronized (ContactpointDeserializer.class) {
            if (f14890a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("normalized_contactpoint", FbJsonField.jsonField(Contactpoint.class.getDeclaredField("normalized")));
                    builder.b("contactpoint_type", FbJsonField.jsonFieldWithCreator(Contactpoint.class.getDeclaredField("type")));
                    builder.b("iso_country_code", FbJsonField.jsonField(Contactpoint.class.getDeclaredField("isoCountryCode")));
                    f14890a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14890a;
        }
        return map;
    }

    public final FbJsonField m17347a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m17346e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m17346e().keySet());
    }
}
