package com.facebook.video.creativeediting.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: contact_create */
public class VideoCreativeEditingDataSerializer extends JsonSerializer<VideoCreativeEditingData> {
    public final void m27398a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        VideoCreativeEditingData videoCreativeEditingData = (VideoCreativeEditingData) obj;
        if (videoCreativeEditingData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m27397b(videoCreativeEditingData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(VideoCreativeEditingData.class, new VideoCreativeEditingDataSerializer());
    }

    private static void m27397b(VideoCreativeEditingData videoCreativeEditingData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "video_trim_params", videoCreativeEditingData.mTrimParams);
        AutoGenJsonHelper.a(jsonGenerator, "rotation_angle", Integer.valueOf(videoCreativeEditingData.mRotationAngle));
        AutoGenJsonHelper.a(jsonGenerator, "is_muted", Boolean.valueOf(videoCreativeEditingData.mIsVideoMuted));
        AutoGenJsonHelper.a(jsonGenerator, "display_uri", videoCreativeEditingData.mDisplayUri);
        AutoGenJsonHelper.a(jsonGenerator, "crop_rect_specified", Boolean.valueOf(videoCreativeEditingData.mCropRectSpecified));
        AutoGenJsonHelper.a(jsonGenerator, "crop_rect_left", Float.valueOf(videoCreativeEditingData.mCropRectLeft));
        AutoGenJsonHelper.a(jsonGenerator, "crop_rect_right", Float.valueOf(videoCreativeEditingData.mCropRectRight));
        AutoGenJsonHelper.a(jsonGenerator, "crop_rect_top", Float.valueOf(videoCreativeEditingData.mCropRectTop));
        AutoGenJsonHelper.a(jsonGenerator, "crop_rect_bottom", Float.valueOf(videoCreativeEditingData.mCropRectBottom));
        AutoGenJsonHelper.a(jsonGenerator, "overlay_uri", videoCreativeEditingData.mOverlayUri);
        AutoGenJsonHelper.a(jsonGenerator, "overlay_id", videoCreativeEditingData.mOverlayId);
        AutoGenJsonHelper.a(jsonGenerator, "should_flip_horizontally", Boolean.valueOf(videoCreativeEditingData.mShouldFlipHorizontally));
    }
}
