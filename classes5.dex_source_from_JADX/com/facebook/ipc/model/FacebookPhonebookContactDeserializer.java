package com.facebook.ipc.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TEXT_WITH_BUTTON */
public class FacebookPhonebookContactDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14125a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookPhonebookContact.class, new FacebookPhonebookContactDeserializer());
        m23499e();
    }

    public FacebookPhonebookContactDeserializer() {
        a(FacebookPhonebookContact.class);
    }

    private static synchronized Map<String, FbJsonField> m23499e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookPhonebookContactDeserializer.class) {
            if (f14125a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(FacebookPhonebookContact.class.getDeclaredField("name")));
                    builder.b("record_id", FbJsonField.jsonField(FacebookPhonebookContact.class.getDeclaredField("recordId")));
                    builder.b("email", FbJsonField.jsonField(FacebookPhonebookContact.class.getDeclaredField("email")));
                    builder.b("cell", FbJsonField.jsonField(FacebookPhonebookContact.class.getDeclaredField("phone")));
                    builder.b("uid", FbJsonField.jsonField(FacebookPhonebookContact.class.getDeclaredField("userId")));
                    builder.b("is_friend", FbJsonField.jsonField(FacebookPhonebookContact.class.getDeclaredField("isFriend")));
                    builder.b("ordinal", FbJsonField.jsonField(FacebookPhonebookContact.class.getDeclaredField("ordinal")));
                    builder.b("native_name", FbJsonField.jsonField(FacebookPhonebookContact.class.getDeclaredField("nativeName")));
                    f14125a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14125a;
        }
        return map;
    }

    public final FbJsonField m23500a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23499e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23499e().keySet());
    }
}
