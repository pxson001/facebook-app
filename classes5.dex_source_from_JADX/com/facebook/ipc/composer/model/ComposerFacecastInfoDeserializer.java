package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TOGGLE */
public class ComposerFacecastInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13947a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerFacecastInfo.class, new ComposerFacecastInfoDeserializer());
        m23306e();
    }

    public ComposerFacecastInfoDeserializer() {
        a(ComposerFacecastInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m23306e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerFacecastInfoDeserializer.class) {
            if (f13947a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("facecast_camera_index", FbJsonField.jsonField(ComposerFacecastInfo.class.getDeclaredField("facecastCameraIndex")));
                    builder.b("facecast_camera_zoom_level", FbJsonField.jsonField(ComposerFacecastInfo.class.getDeclaredField("facecastCameraZoomLevel")));
                    builder.b("is_facecast_ready", FbJsonField.jsonField(ComposerFacecastInfo.class.getDeclaredField("isFacecastReady")));
                    builder.b("video_broadcast_response", FbJsonField.jsonField(ComposerFacecastInfo.class.getDeclaredField("videoBroadcastInitResponse")));
                    builder.b("refetch_broadcast_id", FbJsonField.jsonField(ComposerFacecastInfo.class.getDeclaredField("shouldRefetchBroadcastId")));
                    f13947a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13947a;
        }
        return map;
    }

    public final FbJsonField m23307a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23306e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23306e().keySet());
    }
}
