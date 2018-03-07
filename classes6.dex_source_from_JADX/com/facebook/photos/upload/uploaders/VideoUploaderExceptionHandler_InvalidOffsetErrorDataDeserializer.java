package com.facebook.photos.upload.uploaders;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: friend_request_waterfall */
public class VideoUploaderExceptionHandler_InvalidOffsetErrorDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14565a;

    static {
        GlobalAutoGenDeserializerCache.a(InvalidOffsetErrorData.class, new VideoUploaderExceptionHandler_InvalidOffsetErrorDataDeserializer());
        m22152e();
    }

    public VideoUploaderExceptionHandler_InvalidOffsetErrorDataDeserializer() {
        a(InvalidOffsetErrorData.class);
    }

    private static synchronized Map<String, FbJsonField> m22152e() {
        Map<String, FbJsonField> map;
        synchronized (VideoUploaderExceptionHandler_InvalidOffsetErrorDataDeserializer.class) {
            if (f14565a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("start_offset", FbJsonField.jsonField(InvalidOffsetErrorData.class.getDeclaredField("startOffset")));
                    builder.b("end_offset", FbJsonField.jsonField(InvalidOffsetErrorData.class.getDeclaredField("endOffset")));
                    f14565a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14565a;
        }
        return map;
    }

    public final FbJsonField m22153a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22152e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22152e().keySet());
    }
}
