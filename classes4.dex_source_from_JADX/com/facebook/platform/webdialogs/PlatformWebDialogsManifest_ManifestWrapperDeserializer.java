package com.facebook.platform.webdialogs;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.platform.webdialogs.PlatformWebDialogsManifest.ManifestWrapper;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: dismissAction */
public class PlatformWebDialogsManifest_ManifestWrapperDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13781a;

    static {
        GlobalAutoGenDeserializerCache.a(ManifestWrapper.class, new PlatformWebDialogsManifest_ManifestWrapperDeserializer());
        m14491e();
    }

    public PlatformWebDialogsManifest_ManifestWrapperDeserializer() {
        a(ManifestWrapper.class);
    }

    private static synchronized Map<String, FbJsonField> m14491e() {
        Map<String, FbJsonField> map;
        synchronized (PlatformWebDialogsManifest_ManifestWrapperDeserializer.class) {
            if (f13781a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("actionManifests", FbJsonField.jsonField(ManifestWrapper.class.getDeclaredField("mActionManifests"), PlatformWebViewActionManifest.class));
                    builder.b("timestamp", FbJsonField.jsonField(ManifestWrapper.class.getDeclaredField("mLastRefreshTimestamp")));
                    builder.b("manifestUrl", FbJsonField.jsonField(ManifestWrapper.class.getDeclaredField("mLastManifestUrl")));
                    f13781a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13781a;
        }
        return map;
    }

    public final FbJsonField m14492a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m14491e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m14491e().keySet());
    }
}
