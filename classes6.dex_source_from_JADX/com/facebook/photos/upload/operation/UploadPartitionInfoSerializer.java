package com.facebook.photos.upload.operation;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: glCullFace */
public class UploadPartitionInfoSerializer extends JsonSerializer<UploadPartitionInfo> {
    public final void m21592a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        UploadPartitionInfo uploadPartitionInfo = (UploadPartitionInfo) obj;
        if (uploadPartitionInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m21591b(uploadPartitionInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(UploadPartitionInfo.class, new UploadPartitionInfoSerializer());
    }

    private static void m21591b(UploadPartitionInfo uploadPartitionInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "partitionStartOffset", Long.valueOf(uploadPartitionInfo.partitionStartOffset));
        AutoGenJsonHelper.a(jsonGenerator, "partitionEndOffset", Long.valueOf(uploadPartitionInfo.partitionEndOffset));
        AutoGenJsonHelper.a(jsonGenerator, "chunkedUploadOffset", Long.valueOf(uploadPartitionInfo.chunkedUploadOffset));
        AutoGenJsonHelper.a(jsonGenerator, "chunkedUploadChunkLength", Long.valueOf(uploadPartitionInfo.chunkedUploadChunkLength));
    }
}
