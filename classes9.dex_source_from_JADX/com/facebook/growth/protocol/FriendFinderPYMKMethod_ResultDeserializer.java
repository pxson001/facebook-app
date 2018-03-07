package com.facebook.growth.protocol;

import com.facebook.api.growth.contactimporter.PhonebookLookupResultContact;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.growth.protocol.FriendFinderPYMKMethod.Result;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: p2p_platform_banner_mark_as_sold */
public class FriendFinderPYMKMethod_ResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7522a;

    static {
        GlobalAutoGenDeserializerCache.a(Result.class, new FriendFinderPYMKMethod_ResultDeserializer());
        m7820e();
    }

    public FriendFinderPYMKMethod_ResultDeserializer() {
        a(Result.class);
    }

    private static synchronized Map<String, FbJsonField> m7820e() {
        Map<String, FbJsonField> map;
        synchronized (FriendFinderPYMKMethod_ResultDeserializer.class) {
            if (f7522a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("friendable", FbJsonField.jsonField(Result.class.getDeclaredField("mPymk"), PhonebookLookupResultContact.class));
                    f7522a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7522a;
        }
        return map;
    }

    public final FbJsonField m7821a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7820e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7820e().keySet());
    }
}
