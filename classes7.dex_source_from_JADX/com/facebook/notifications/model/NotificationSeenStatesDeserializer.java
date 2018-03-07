package com.facebook.notifications.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.notifications.model.NotificationSeenStates.NotificationSeenState;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: negativefeedback_start_flow */
public class NotificationSeenStatesDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8397a;

    static {
        GlobalAutoGenDeserializerCache.a(NotificationSeenStates.class, new NotificationSeenStatesDeserializer());
        m9979e();
    }

    public NotificationSeenStatesDeserializer() {
        a(NotificationSeenStates.class);
    }

    private static synchronized Map<String, FbJsonField> m9979e() {
        Map<String, FbJsonField> map;
        synchronized (NotificationSeenStatesDeserializer.class) {
            if (f8397a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(NotificationSeenStates.class.getDeclaredField("notificationSeenStatesList"), NotificationSeenState.class));
                    f8397a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8397a;
        }
        return map;
    }

    public final FbJsonField m9980a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m9979e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m9979e().keySet());
    }
}
