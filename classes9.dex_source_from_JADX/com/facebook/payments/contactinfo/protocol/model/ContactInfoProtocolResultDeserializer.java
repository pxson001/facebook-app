package com.facebook.payments.contactinfo.protocol.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: border */
public class ContactInfoProtocolResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f18703a;

    static {
        GlobalAutoGenDeserializerCache.a(ContactInfoProtocolResult.class, new ContactInfoProtocolResultDeserializer());
        m18714e();
    }

    public ContactInfoProtocolResultDeserializer() {
        a(ContactInfoProtocolResult.class);
    }

    private static synchronized Map<String, FbJsonField> m18714e() {
        Map<String, FbJsonField> map;
        synchronized (ContactInfoProtocolResultDeserializer.class) {
            if (f18703a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(ContactInfoProtocolResult.class.getDeclaredField("mContactInfoId")));
                    f18703a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f18703a;
        }
        return map;
    }

    public final FbJsonField m18715a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18714e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18714e().keySet());
    }
}
