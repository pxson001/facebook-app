package com.facebook.api.growth.contactimporter;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: send_confirmation_code_error_message */
public class PhonebookLookupResultContactDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4034a;

    static {
        GlobalAutoGenDeserializerCache.a(PhonebookLookupResultContact.class, new PhonebookLookupResultContactDeserializer());
        m3918e();
    }

    public PhonebookLookupResultContactDeserializer() {
        a(PhonebookLookupResultContact.class);
    }

    private static synchronized Map<String, FbJsonField> m3918e() {
        Map<String, FbJsonField> map;
        synchronized (PhonebookLookupResultContactDeserializer.class) {
            if (f4034a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("name")));
                    builder.b("record_id", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("recordId")));
                    builder.b("email", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("email")));
                    builder.b("cell", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("phone")));
                    builder.b("uid", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("userId")));
                    builder.b("is_friend", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("isFriend")));
                    builder.b("pic_square_with_logo", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("profilePic")));
                    builder.b("ordinal", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("ordinal")));
                    builder.b("native_name", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("nativeName")));
                    builder.b("mutual_friends", FbJsonField.jsonField(PhonebookLookupResultContact.class.getDeclaredField("mutualFriends")));
                    f4034a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4034a;
        }
        return map;
    }

    public final FbJsonField m3919a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m3918e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m3918e().keySet());
    }
}
