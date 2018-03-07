package com.facebook.notifications.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: lastFullUpdateTimestamp */
public class FetchJewelCountsResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f9602a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchJewelCountsResult.class, new FetchJewelCountsResultDeserializer());
        m10003e();
    }

    public FetchJewelCountsResultDeserializer() {
        a(FetchJewelCountsResult.class);
    }

    private static synchronized Map<String, FbJsonField> m10003e() {
        Map<String, FbJsonField> map;
        synchronized (FetchJewelCountsResultDeserializer.class) {
            if (f9602a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("messages", FbJsonField.jsonField(FetchJewelCountsResult.class.getDeclaredField("mMessagesCounts")));
                    builder.b("notification_counts", FbJsonField.jsonField(FetchJewelCountsResult.class.getDeclaredField("mNotificationsCounts")));
                    builder.b("friend_requests_counts", FbJsonField.jsonField(FetchJewelCountsResult.class.getDeclaredField("mRequestsCounts")));
                    f9602a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f9602a;
        }
        return map;
    }

    public final FbJsonField m10004a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10003e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10003e().keySet());
    }
}
