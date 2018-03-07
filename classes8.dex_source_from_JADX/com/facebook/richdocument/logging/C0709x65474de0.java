package com.facebook.richdocument.logging;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: place_picker_place_to_people_start */
public class C0709x65474de0 extends JsonSerializer<RichDocumentBugReportData> {
    public final void m5375a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        RichDocumentBugReportData richDocumentBugReportData = (RichDocumentBugReportData) obj;
        if (richDocumentBugReportData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        C0709x65474de0.m5374b(richDocumentBugReportData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(RichDocumentBugReportData.class, new C0709x65474de0());
    }

    private static void m5374b(RichDocumentBugReportData richDocumentBugReportData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "last_article_debug_info", richDocumentBugReportData.mLastARticleDebugInfo);
    }
}
