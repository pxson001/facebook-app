package com.facebook.ipc.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TEXT_WITH_ENTITIES */
public class FacebookEventDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14121a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookEvent.class, new FacebookEventDeserializer());
        m23495e();
    }

    public FacebookEventDeserializer() {
        a(FacebookEvent.class);
    }

    private static synchronized Map<String, FbJsonField> m23495e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookEventDeserializer.class) {
            if (f14121a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("eid", FbJsonField.jsonField(FacebookEvent.class.getDeclaredField("mEventId")));
                    builder.b("name", FbJsonField.jsonField(FacebookEvent.class.getDeclaredField("mName")));
                    builder.b("pic_square", FbJsonField.jsonField(FacebookEvent.class.getDeclaredField("mPicSquare")));
                    builder.b("start_time", FbJsonField.jsonField(FacebookEvent.class.getDeclaredField("mStartTime")));
                    builder.b("end_time", FbJsonField.jsonField(FacebookEvent.class.getDeclaredField("mEndTime")));
                    f14121a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14121a;
        }
        return map;
    }

    public final FbJsonField m23496a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23495e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23495e().keySet());
    }
}
