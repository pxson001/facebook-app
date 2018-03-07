package com.facebook.video.creativeediting.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: contact_id */
public class VideoCreativeEditingDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f18631a;

    static {
        GlobalAutoGenDeserializerCache.a(VideoCreativeEditingData.class, new VideoCreativeEditingDataDeserializer());
        m27395e();
    }

    public VideoCreativeEditingDataDeserializer() {
        a(VideoCreativeEditingData.class);
    }

    private static synchronized Map<String, FbJsonField> m27395e() {
        Map<String, FbJsonField> map;
        synchronized (VideoCreativeEditingDataDeserializer.class) {
            if (f18631a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("video_trim_params", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mTrimParams")));
                    builder.b("rotation_angle", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mRotationAngle")));
                    builder.b("is_muted", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mIsVideoMuted")));
                    builder.b("display_uri", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mDisplayUri")));
                    builder.b("crop_rect_specified", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mCropRectSpecified")));
                    builder.b("crop_rect_left", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mCropRectLeft")));
                    builder.b("crop_rect_right", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mCropRectRight")));
                    builder.b("crop_rect_top", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mCropRectTop")));
                    builder.b("crop_rect_bottom", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mCropRectBottom")));
                    builder.b("overlay_uri", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mOverlayUri")));
                    builder.b("overlay_id", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mOverlayId")));
                    builder.b("should_flip_horizontally", FbJsonField.jsonField(VideoCreativeEditingData.class.getDeclaredField("mShouldFlipHorizontally")));
                    f18631a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f18631a;
        }
        return map;
    }

    public final FbJsonField m27396a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m27395e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m27395e().keySet());
    }
}
