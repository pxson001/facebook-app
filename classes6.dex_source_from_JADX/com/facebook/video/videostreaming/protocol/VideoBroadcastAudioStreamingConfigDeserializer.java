package com.facebook.video.videostreaming.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: rotation_angle */
public class VideoBroadcastAudioStreamingConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5449a;

    static {
        GlobalAutoGenDeserializerCache.a(VideoBroadcastAudioStreamingConfig.class, new VideoBroadcastAudioStreamingConfigDeserializer());
        m8129e();
    }

    public VideoBroadcastAudioStreamingConfigDeserializer() {
        a(VideoBroadcastAudioStreamingConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m8129e() {
        Map<String, FbJsonField> map;
        synchronized (VideoBroadcastAudioStreamingConfigDeserializer.class) {
            if (f5449a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("sample_rate", FbJsonField.jsonField(VideoBroadcastAudioStreamingConfig.class.getDeclaredField("sampleRate")));
                    builder.b("bit_rate", FbJsonField.jsonField(VideoBroadcastAudioStreamingConfig.class.getDeclaredField("bitRate")));
                    builder.b("channels", FbJsonField.jsonField(VideoBroadcastAudioStreamingConfig.class.getDeclaredField("channels")));
                    f5449a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5449a;
        }
        return map;
    }

    public final FbJsonField m8130a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8129e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8129e().keySet());
    }
}
