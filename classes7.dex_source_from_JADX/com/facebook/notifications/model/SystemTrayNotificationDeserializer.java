package com.facebook.notifications.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: negativefeedback_cancel_message_composer */
public class SystemTrayNotificationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8412a;

    static {
        GlobalAutoGenDeserializerCache.a(SystemTrayNotification.class, new SystemTrayNotificationDeserializer());
        m10000e();
    }

    public SystemTrayNotificationDeserializer() {
        a(SystemTrayNotification.class);
    }

    private static synchronized Map<String, FbJsonField> m10000e() {
        Map<String, FbJsonField> map;
        synchronized (SystemTrayNotificationDeserializer.class) {
            if (f8412a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonField(SystemTrayNotification.class.getDeclaredField("mType")));
                    builder.b("time", FbJsonField.jsonField(SystemTrayNotification.class.getDeclaredField("mServerUtcSecs")));
                    builder.b("message", FbJsonField.jsonField(SystemTrayNotification.class.getDeclaredField("mMessage")));
                    builder.b("unread_count", FbJsonField.jsonField(SystemTrayNotification.class.getDeclaredField("mUnreadCount")));
                    builder.b("target_uid", FbJsonField.jsonField(SystemTrayNotification.class.getDeclaredField("mTargetUid")));
                    builder.b("href", FbJsonField.jsonField(SystemTrayNotification.class.getDeclaredField("mHref")));
                    builder.b("params", FbJsonField.jsonField(SystemTrayNotification.class.getDeclaredField("mParams")));
                    builder.b("is_logged_out_push", FbJsonField.jsonField(SystemTrayNotification.class.getDeclaredField("mIsLoggedOutPush")));
                    f8412a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8412a;
        }
        return map;
    }

    public final FbJsonField m10001a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10000e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10000e().keySet());
    }
}
