package com.facebook.growth.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.growth.protocol.FriendFinderMethod.Result.Invites;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: p2p_platform_context_id */
public class FriendFinderMethod_Result_InvitesDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7517a;

    static {
        GlobalAutoGenDeserializerCache.a(Invites.class, new FriendFinderMethod_Result_InvitesDeserializer());
        m7815e();
    }

    public FriendFinderMethod_Result_InvitesDeserializer() {
        a(Invites.class);
    }

    private static synchronized Map<String, FbJsonField> m7815e() {
        Map<String, FbJsonField> map;
        synchronized (FriendFinderMethod_Result_InvitesDeserializer.class) {
            if (f7517a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("record_id", FbJsonField.jsonField(Invites.class.getDeclaredField("mRecordId")));
                    f7517a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7517a;
        }
        return map;
    }

    public final FbJsonField m7816a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7815e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7815e().keySet());
    }
}
