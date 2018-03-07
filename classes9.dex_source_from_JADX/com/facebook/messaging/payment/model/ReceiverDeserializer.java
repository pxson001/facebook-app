package com.facebook.messaging.payment.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: httpSocketTimeout */
public class ReceiverDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13259a;

    static {
        GlobalAutoGenDeserializerCache.a(Receiver.class, new ReceiverDeserializer());
        m13546e();
    }

    public ReceiverDeserializer() {
        a(Receiver.class);
    }

    private static synchronized Map<String, FbJsonField> m13546e() {
        Map<String, FbJsonField> map;
        synchronized (ReceiverDeserializer.class) {
            if (f13259a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(Receiver.class.getDeclaredField("mId")));
                    builder.b("name", FbJsonField.jsonField(Receiver.class.getDeclaredField("mName")));
                    builder.b("is_messenger_user", FbJsonField.jsonField(Receiver.class.getDeclaredField("mIsMessengerUser")));
                    f13259a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13259a;
        }
        return map;
    }

    public final FbJsonField m13547a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13546e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13546e().keySet());
    }
}
