package com.facebook.messaging.blocking.api;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: onMomentumScrollEnd */
public class BlockedPersonDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8302a;

    static {
        GlobalAutoGenDeserializerCache.a(BlockedPerson.class, new BlockedPersonDeserializer());
        m8554e();
    }

    public BlockedPersonDeserializer() {
        a(BlockedPerson.class);
    }

    private static synchronized Map<String, FbJsonField> m8554e() {
        Map<String, FbJsonField> map;
        synchronized (BlockedPersonDeserializer.class) {
            if (f8302a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("fbid", FbJsonField.jsonField(BlockedPerson.class.getDeclaredField("mFbid")));
                    builder.b("name", FbJsonField.jsonField(BlockedPerson.class.getDeclaredField("mName")));
                    builder.b("block_time", FbJsonField.jsonField(BlockedPerson.class.getDeclaredField("mBlockedDate")));
                    builder.b("block_type", FbJsonField.jsonField(BlockedPerson.class.getDeclaredField("mBlockedType")));
                    f8302a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8302a;
        }
        return map;
    }

    public final FbJsonField m8555a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8554e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8554e().keySet());
    }
}
