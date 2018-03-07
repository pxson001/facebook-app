package com.facebook.composer.publish;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: photos_uploaded */
public class PostFailureDialogController_PostFailedBugReportDataSerializer extends JsonSerializer<PostFailedBugReportData> {
    public final void m11577a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PostFailedBugReportData postFailedBugReportData = (PostFailedBugReportData) obj;
        if (postFailedBugReportData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m11576b(postFailedBugReportData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PostFailedBugReportData.class, new PostFailureDialogController_PostFailedBugReportDataSerializer());
    }

    private static void m11576b(PostFailedBugReportData postFailedBugReportData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "error_details", postFailedBugReportData.mErrorDetails);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "post_params", postFailedBugReportData.mPostParamsWrapper);
    }
}
