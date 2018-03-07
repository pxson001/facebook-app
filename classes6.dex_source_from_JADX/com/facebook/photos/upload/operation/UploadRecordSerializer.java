package com.facebook.photos.upload.operation;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: glBindTexture mTextureID */
public class UploadRecordSerializer extends JsonSerializer<UploadRecord> {
    public final void m21598a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        UploadRecord uploadRecord = (UploadRecord) obj;
        if (uploadRecord == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m21597b(uploadRecord, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(UploadRecord.class, new UploadRecordSerializer());
    }

    private static void m21597b(UploadRecord uploadRecord, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "fbid", Long.valueOf(uploadRecord.fbid));
        AutoGenJsonHelper.a(jsonGenerator, "uploadTime", Long.valueOf(uploadRecord.uploadTime));
        AutoGenJsonHelper.a(jsonGenerator, "isRawUpload", Boolean.valueOf(uploadRecord.isRawUpload));
        AutoGenJsonHelper.a(jsonGenerator, "sameHashExist", Boolean.valueOf(uploadRecord.sameHashExist));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "partitionInfo", uploadRecord.partitionInfo);
        AutoGenJsonHelper.a(jsonGenerator, "videoId", uploadRecord.videoId);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "transcodeInfo", uploadRecord.transcodeInfo);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "multimediaInfo", uploadRecord.multimediaInfo);
    }
}
