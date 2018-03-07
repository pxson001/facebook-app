package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: phonetic_tokens_generated */
public class ContactPhoneDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8208a;

    static {
        GlobalAutoGenDeserializerCache.a(ContactPhone.class, new ContactPhoneDeserializer());
        m12033e();
    }

    public ContactPhoneDeserializer() {
        a(ContactPhone.class);
    }

    private static synchronized Map<String, FbJsonField> m12033e() {
        Map<String, FbJsonField> map;
        synchronized (ContactPhoneDeserializer.class) {
            if (f8208a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(ContactPhone.class.getDeclaredField("mId")));
                    builder.b("label", FbJsonField.jsonField(ContactPhone.class.getDeclaredField("mLabel")));
                    builder.b("displayNumber", FbJsonField.jsonField(ContactPhone.class.getDeclaredField("mDisplayNumber")));
                    builder.b("universalNumber", FbJsonField.jsonField(ContactPhone.class.getDeclaredField("mUniversalNumber")));
                    builder.b("isVerified", FbJsonField.jsonField(ContactPhone.class.getDeclaredField("mIsVerified")));
                    f8208a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8208a;
        }
        return map;
    }

    public final FbJsonField m12034a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12033e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12033e().keySet());
    }
}
