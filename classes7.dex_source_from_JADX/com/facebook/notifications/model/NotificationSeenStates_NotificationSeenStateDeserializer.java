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

/* compiled from: negativefeedback_require_confirmation */
public class NotificationSeenStates_NotificationSeenStateDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8398a;

    static {
        GlobalAutoGenDeserializerCache.a(NotificationSeenState.class, new NotificationSeenStates_NotificationSeenStateDeserializer());
        m9981e();
    }

    public NotificationSeenStates_NotificationSeenStateDeserializer() {
        a(NotificationSeenState.class);
    }

    private static synchronized Map<String, FbJsonField> m9981e() {
        Map<String, FbJsonField> map;
        synchronized (NotificationSeenStates_NotificationSeenStateDeserializer.class) {
            if (f8398a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(NotificationSeenState.class.getDeclaredField("id")));
                    builder.b("seen_state", FbJsonField.jsonField(NotificationSeenState.class.getDeclaredField("seenState")));
                    f8398a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8398a;
        }
        return map;
    }

    public final FbJsonField m9982a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m9981e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m9981e().keySet());
    }
}
