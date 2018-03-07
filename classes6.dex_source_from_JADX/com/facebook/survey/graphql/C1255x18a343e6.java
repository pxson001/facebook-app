package com.facebook.survey.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveySessionFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveySessionFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: direct_next_page_index_int */
public class C1255x18a343e6 extends JsonSerializer<StructuredSurveySessionFragmentModel> {
    public final void m25093a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        StructuredSurveySessionFragmentModel structuredSurveySessionFragmentModel = (StructuredSurveySessionFragmentModel) obj;
        if (structuredSurveySessionFragmentModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(structuredSurveySessionFragmentModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            structuredSurveySessionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        StructuredSurveySessionFragmentParser.m25143a(structuredSurveySessionFragmentModel.w_(), structuredSurveySessionFragmentModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(StructuredSurveySessionFragmentModel.class, new C1255x18a343e6());
    }
}
