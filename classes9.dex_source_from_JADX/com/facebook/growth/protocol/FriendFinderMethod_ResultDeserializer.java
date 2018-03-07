package com.facebook.growth.protocol;

import com.facebook.api.growth.contactimporter.PhonebookLookupResultContact;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.growth.protocol.FriendFinderMethod.Result;
import com.facebook.growth.protocol.FriendFinderMethod.Result.Invites;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: p2p_platform_context_set_shipping_address */
public class FriendFinderMethod_ResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7516a;

    static {
        GlobalAutoGenDeserializerCache.a(Result.class, new FriendFinderMethod_ResultDeserializer());
        m7813e();
    }

    public FriendFinderMethod_ResultDeserializer() {
        a(Result.class);
    }

    private static synchronized Map<String, FbJsonField> m7813e() {
        Map<String, FbJsonField> map;
        synchronized (FriendFinderMethod_ResultDeserializer.class) {
            if (f7516a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("friendable", FbJsonField.jsonField(Result.class.getDeclaredField("mContacts"), PhonebookLookupResultContact.class));
                    builder.b("invitable", FbJsonField.jsonField(Result.class.getDeclaredField("mInvites"), Invites.class));
                    builder.b("cursor", FbJsonField.jsonField(Result.class.getDeclaredField("mCursor")));
                    f7516a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7516a;
        }
        return map;
    }

    public final FbJsonField m7814a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7813e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7813e().keySet());
    }
}
