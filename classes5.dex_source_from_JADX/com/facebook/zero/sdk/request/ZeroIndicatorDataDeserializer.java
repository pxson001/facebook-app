package com.facebook.zero.sdk.request;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: com.facebook.analytics2.logger.UPLOAD_NOW */
public class ZeroIndicatorDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5902a;

    static {
        GlobalAutoGenDeserializerCache.a(ZeroIndicatorData.class, new ZeroIndicatorDataDeserializer());
        m10684e();
    }

    public ZeroIndicatorDataDeserializer() {
        a(ZeroIndicatorData.class);
    }

    private static synchronized Map<String, FbJsonField> m10684e() {
        Map<String, FbJsonField> map;
        synchronized (ZeroIndicatorDataDeserializer.class) {
            if (f5902a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(ZeroIndicatorData.class.getDeclaredField("mId")));
                    builder.b("title", FbJsonField.jsonField(ZeroIndicatorData.class.getDeclaredField("mTitle")));
                    builder.b("content", FbJsonField.jsonField(ZeroIndicatorData.class.getDeclaredField("mContent")));
                    builder.b("action_title", FbJsonField.jsonField(ZeroIndicatorData.class.getDeclaredField("mActionTitle")));
                    builder.b("action_url", FbJsonField.jsonField(ZeroIndicatorData.class.getDeclaredField("mActionUrl")));
                    f5902a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5902a;
        }
        return map;
    }

    public final FbJsonField m10685a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10684e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10684e().keySet());
    }
}
