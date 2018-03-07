package com.facebook.video.videostreaming.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: reviews_post_review_failure */
public class VideoBroadcastVideoStreamingConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5476a;

    static {
        GlobalAutoGenDeserializerCache.a(VideoBroadcastVideoStreamingConfig.class, new VideoBroadcastVideoStreamingConfigDeserializer());
        m8153e();
    }

    public VideoBroadcastVideoStreamingConfigDeserializer() {
        a(VideoBroadcastVideoStreamingConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m8153e() {
        Map<String, FbJsonField> map;
        synchronized (VideoBroadcastVideoStreamingConfigDeserializer.class) {
            if (f5476a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("width", FbJsonField.jsonField(VideoBroadcastVideoStreamingConfig.class.getDeclaredField("width")));
                    builder.b("height", FbJsonField.jsonField(VideoBroadcastVideoStreamingConfig.class.getDeclaredField("height")));
                    builder.b("bit_rate", FbJsonField.jsonField(VideoBroadcastVideoStreamingConfig.class.getDeclaredField("bitRate")));
                    builder.b("frame_rate", FbJsonField.jsonField(VideoBroadcastVideoStreamingConfig.class.getDeclaredField("frameRate")));
                    builder.b("allow_b_frames", FbJsonField.jsonField(VideoBroadcastVideoStreamingConfig.class.getDeclaredField("allowBFrames")));
                    builder.b("video_profile", FbJsonField.jsonField(VideoBroadcastVideoStreamingConfig.class.getDeclaredField("videoProfile")));
                    f5476a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5476a;
        }
        return map;
    }

    public final FbJsonField m8154a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8153e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8153e().keySet());
    }
}
