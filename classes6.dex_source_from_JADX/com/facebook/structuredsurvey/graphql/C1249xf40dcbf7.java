package com.facebook.structuredsurvey.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.structuredsurvey.graphql.SurveyIntegrationPointQueryModels.SurveyIntegrationPointQueryModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveySessionFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: download_duration */
public class C1249xf40dcbf7 extends JsonSerializer<SurveyIntegrationPointQueryModel> {
    public final void m24825a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        SurveyIntegrationPointQueryModel surveyIntegrationPointQueryModel = (SurveyIntegrationPointQueryModel) obj;
        if (surveyIntegrationPointQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(surveyIntegrationPointQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            surveyIntegrationPointQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = surveyIntegrationPointQueryModel.w_();
        int u_ = surveyIntegrationPointQueryModel.u_();
        jsonGenerator.f();
        if (mutableFlatBuffer.g(u_, 0) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
        }
        if (mutableFlatBuffer.g(u_, 1) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
        }
        int g = mutableFlatBuffer.g(u_, 2);
        if (g != 0) {
            jsonGenerator.a("survey_session");
            StructuredSurveySessionFragmentParser.m25143a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SurveyIntegrationPointQueryModel.class, new C1249xf40dcbf7());
    }
}
