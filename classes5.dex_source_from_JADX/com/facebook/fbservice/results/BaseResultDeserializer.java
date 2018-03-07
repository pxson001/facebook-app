package com.facebook.fbservice.results;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: retail_new_users */
public class BaseResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3022a;

    static {
        GlobalAutoGenDeserializerCache.a(BaseResult.class, new BaseResultDeserializer());
        m4191e();
    }

    public BaseResultDeserializer() {
        a(BaseResult.class);
    }

    private static synchronized Map<String, FbJsonField> m4191e() {
        Map<String, FbJsonField> map;
        synchronized (BaseResultDeserializer.class) {
            if (f3022a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("freshness", FbJsonField.jsonField(BaseResult.class.getDeclaredField("freshness")));
                    builder.b("clientTimeMs", FbJsonField.jsonField(BaseResult.class.getDeclaredField("clientTimeMs")));
                    f3022a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3022a;
        }
        return map;
    }

    public final FbJsonField m4192a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4191e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4191e().keySet());
    }
}
