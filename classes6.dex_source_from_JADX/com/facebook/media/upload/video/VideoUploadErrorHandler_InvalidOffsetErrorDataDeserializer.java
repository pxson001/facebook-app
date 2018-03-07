package com.facebook.media.upload.video;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: keyMutations */
public class VideoUploadErrorHandler_InvalidOffsetErrorDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11921a;

    static {
        GlobalAutoGenDeserializerCache.a(InvalidOffsetErrorData.class, new VideoUploadErrorHandler_InvalidOffsetErrorDataDeserializer());
        m18868e();
    }

    public VideoUploadErrorHandler_InvalidOffsetErrorDataDeserializer() {
        a(InvalidOffsetErrorData.class);
    }

    private static synchronized Map<String, FbJsonField> m18868e() {
        Map<String, FbJsonField> map;
        synchronized (VideoUploadErrorHandler_InvalidOffsetErrorDataDeserializer.class) {
            if (f11921a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("start_offset", FbJsonField.jsonField(InvalidOffsetErrorData.class.getDeclaredField("startOffset")));
                    builder.b("end_offset", FbJsonField.jsonField(InvalidOffsetErrorData.class.getDeclaredField("endOffset")));
                    f11921a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11921a;
        }
        return map;
    }

    public final FbJsonField m18869a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18868e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18868e().keySet());
    }
}
