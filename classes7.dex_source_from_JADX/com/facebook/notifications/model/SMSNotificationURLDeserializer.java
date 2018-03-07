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

/* compiled from: negativefeedback_open_message_composer */
public class SMSNotificationURLDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8399a;

    static {
        GlobalAutoGenDeserializerCache.a(SMSNotificationURL.class, new SMSNotificationURLDeserializer());
        m9983e();
    }

    public SMSNotificationURLDeserializer() {
        a(SMSNotificationURL.class);
    }

    private static synchronized Map<String, FbJsonField> m9983e() {
        Map<String, FbJsonField> map;
        synchronized (SMSNotificationURLDeserializer.class) {
            if (f8399a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(SMSNotificationURL.class.getDeclaredField("notificationLongUrlList"), NotificationLongURL.class));
                    f8399a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8399a;
        }
        return map;
    }

    public final FbJsonField m9984a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m9983e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m9983e().keySet());
    }
}
