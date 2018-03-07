package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: suggestion_ids */
public class VideoTrimParamsSerializer extends JsonSerializer<VideoTrimParams> {
    public final void m4751a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        VideoTrimParams videoTrimParams = (VideoTrimParams) obj;
        if (videoTrimParams == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4750b(videoTrimParams, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(VideoTrimParams.class, new VideoTrimParamsSerializer());
    }

    private static void m4750b(VideoTrimParams videoTrimParams, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "isTrimSpecified", Boolean.valueOf(videoTrimParams.isTrimSpecified));
        AutoGenJsonHelper.a(jsonGenerator, "videoTirmStartTimeMs", Integer.valueOf(videoTrimParams.videoTrimStartTimeMs));
        AutoGenJsonHelper.a(jsonGenerator, "videoTrimEndTimeMs", Integer.valueOf(videoTrimParams.videoTrimEndTimeMs));
    }
}
