package com.facebook.photos.upload.operation;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: gms_ls_upsell_requested */
public class TranscodeInfoSerializer extends JsonSerializer<TranscodeInfo> {
    public final void m21443a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        TranscodeInfo transcodeInfo = (TranscodeInfo) obj;
        if (transcodeInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m21442b(transcodeInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(TranscodeInfo.class, new TranscodeInfoSerializer());
    }

    private static void m21442b(TranscodeInfo transcodeInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "flowStartCount", Long.valueOf(transcodeInfo.flowStartCount));
        AutoGenJsonHelper.a(jsonGenerator, "transcodeStartCount", Long.valueOf(transcodeInfo.transcodeStartCount));
        AutoGenJsonHelper.a(jsonGenerator, "transcodeSuccessCount", Long.valueOf(transcodeInfo.transcodeSuccessCount));
        AutoGenJsonHelper.a(jsonGenerator, "transcodeFailCount", Long.valueOf(transcodeInfo.transcodeFailCount));
        AutoGenJsonHelper.a(jsonGenerator, "isSegmentedTranscode", Boolean.valueOf(transcodeInfo.isSegmentedTranscode));
        AutoGenJsonHelper.a(jsonGenerator, "isRequestedServerSettings", Boolean.valueOf(transcodeInfo.isRequestedServerSettings));
        AutoGenJsonHelper.a(jsonGenerator, "isServerSettingsAvailable", Boolean.valueOf(transcodeInfo.isServerSettingsAvailable));
        AutoGenJsonHelper.a(jsonGenerator, "serverSpecifiedTranscodeBitrate", Long.valueOf(transcodeInfo.serverSpecifiedTranscodeBitrate));
        AutoGenJsonHelper.a(jsonGenerator, "serverSpecifiedTranscodeDimension", Long.valueOf(transcodeInfo.serverSpecifiedTranscodeDimension));
    }
}
