package com.facebook.notifications.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.notifications.model.SMSNotificationURL.NotificationLongURL;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: negativefeedback_message_action */
public class SMSNotificationURL_NotificationLongURLDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8400a;

    static {
        GlobalAutoGenDeserializerCache.a(NotificationLongURL.class, new SMSNotificationURL_NotificationLongURLDeserializer());
        m9985e();
    }

    public SMSNotificationURL_NotificationLongURLDeserializer() {
        a(NotificationLongURL.class);
    }

    private static synchronized Map<String, FbJsonField> m9985e() {
        Map<String, FbJsonField> map;
        synchronized (SMSNotificationURL_NotificationLongURLDeserializer.class) {
            if (f8400a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("long_url", FbJsonField.jsonField(NotificationLongURL.class.getDeclaredField("longUrl")));
                    f8400a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8400a;
        }
        return map;
    }

    public final FbJsonField m9986a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m9985e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m9985e().keySet());
    }
}
