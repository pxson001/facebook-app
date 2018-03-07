package com.facebook.platform.webdialogs;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.platform.webdialogs.PlatformWebDialogsCache.CacheWrapper;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: from_oncomplete */
public class PlatformWebDialogsCache_CacheWrapperDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11347a;

    static {
        GlobalAutoGenDeserializerCache.a(CacheWrapper.class, new PlatformWebDialogsCache_CacheWrapperDeserializer());
        m11793e();
    }

    public PlatformWebDialogsCache_CacheWrapperDeserializer() {
        a(CacheWrapper.class);
    }

    private static synchronized Map<String, FbJsonField> m11793e() {
        Map<String, FbJsonField> map;
        synchronized (PlatformWebDialogsCache_CacheWrapperDeserializer.class) {
            if (f11347a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("urlMapCache", FbJsonField.jsonField(CacheWrapper.class.getDeclaredField("mCache")));
                    f11347a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11347a;
        }
        return map;
    }

    public final FbJsonField m11794a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11793e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11793e().keySet());
    }
}
