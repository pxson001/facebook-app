package com.facebook.messaging.payment.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: homekey */
public class SenderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13261a;

    static {
        GlobalAutoGenDeserializerCache.a(Sender.class, new SenderDeserializer());
        m13554e();
    }

    public SenderDeserializer() {
        a(Sender.class);
    }

    private static synchronized Map<String, FbJsonField> m13554e() {
        Map<String, FbJsonField> map;
        synchronized (SenderDeserializer.class) {
            if (f13261a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(Sender.class.getDeclaredField("mId")));
                    builder.b("name", FbJsonField.jsonField(Sender.class.getDeclaredField("mName")));
                    builder.b("is_messenger_user", FbJsonField.jsonField(Sender.class.getDeclaredField("mIsMessengerUser")));
                    f13261a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13261a;
        }
        return map;
    }

    public final FbJsonField m13555a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13554e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13554e().keySet());
    }
}
