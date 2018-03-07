package com.facebook.rtc.campon;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: audio_clips */
public class RtcCamperModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f19301a;

    static {
        GlobalAutoGenDeserializerCache.a(RtcCamperModel.class, new RtcCamperModelDeserializer());
        m19332e();
    }

    public RtcCamperModelDeserializer() {
        a(RtcCamperModel.class);
    }

    private static synchronized Map<String, FbJsonField> m19332e() {
        Map<String, FbJsonField> map;
        synchronized (RtcCamperModelDeserializer.class) {
            if (f19301a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("camp_type", FbJsonField.jsonField(RtcCamperModel.class.getDeclaredField("mCampType")));
                    builder.b("peer_id", FbJsonField.jsonField(RtcCamperModel.class.getDeclaredField("mPeerId")));
                    builder.b("peer_first_name", FbJsonField.jsonField(RtcCamperModel.class.getDeclaredField("mPeerFirstName")));
                    builder.b("peer_name", FbJsonField.jsonField(RtcCamperModel.class.getDeclaredField("mPeerName")));
                    builder.b("start_time_ms", FbJsonField.jsonField(RtcCamperModel.class.getDeclaredField("mStartTimeMs")));
                    builder.b("wait_time_ms", FbJsonField.jsonField(RtcCamperModel.class.getDeclaredField("mWaitTimeMs")));
                    f19301a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f19301a;
        }
        return map;
    }

    public final FbJsonField m19333a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19332e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19332e().keySet());
    }
}
