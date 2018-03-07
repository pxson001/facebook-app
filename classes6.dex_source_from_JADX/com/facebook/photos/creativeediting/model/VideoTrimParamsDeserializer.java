package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: suggestions */
public class VideoTrimParamsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3542a;

    static {
        GlobalAutoGenDeserializerCache.a(VideoTrimParams.class, new VideoTrimParamsDeserializer());
        m4748e();
    }

    public VideoTrimParamsDeserializer() {
        a(VideoTrimParams.class);
    }

    private static synchronized Map<String, FbJsonField> m4748e() {
        Map<String, FbJsonField> map;
        synchronized (VideoTrimParamsDeserializer.class) {
            if (f3542a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("isTrimSpecified", FbJsonField.jsonField(VideoTrimParams.class.getDeclaredField("isTrimSpecified")));
                    builder.b("videoTirmStartTimeMs", FbJsonField.jsonField(VideoTrimParams.class.getDeclaredField("videoTrimStartTimeMs")));
                    builder.b("videoTrimEndTimeMs", FbJsonField.jsonField(VideoTrimParams.class.getDeclaredField("videoTrimEndTimeMs")));
                    f3542a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3542a;
        }
        return map;
    }

    public final FbJsonField m4749a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4748e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4748e().keySet());
    }
}
