package com.facebook.platform.webdialogs;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: disabled_reason_id */
public class PlatformWebViewActionManifestDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13789a;

    static {
        GlobalAutoGenDeserializerCache.a(PlatformWebViewActionManifest.class, new PlatformWebViewActionManifestDeserializer());
        m14539e();
    }

    public PlatformWebViewActionManifestDeserializer() {
        a(PlatformWebViewActionManifest.class);
    }

    private static synchronized Map<String, FbJsonField> m14539e() {
        Map<String, FbJsonField> map;
        synchronized (PlatformWebViewActionManifestDeserializer.class) {
            if (f13789a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("action", FbJsonField.jsonField(PlatformWebViewActionManifest.class.getDeclaredField("mAction")));
                    builder.b("resultAction", FbJsonField.jsonField(PlatformWebViewActionManifest.class.getDeclaredField("mResultAction")));
                    builder.b("version", FbJsonField.jsonField(PlatformWebViewActionManifest.class.getDeclaredField("mVersion")));
                    builder.b("uri", FbJsonField.jsonField(PlatformWebViewActionManifest.class.getDeclaredField("mUri")));
                    builder.b("fetchState", FbJsonField.jsonField(PlatformWebViewActionManifest.class.getDeclaredField("mFetchState")));
                    f13789a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13789a;
        }
        return map;
    }

    public final FbJsonField m14540a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m14539e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m14539e().keySet());
    }
}
