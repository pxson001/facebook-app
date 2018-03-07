package com.facebook.survey.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveySessionFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsParsers.StructuredSurveySessionFragmentParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: direct_next_page_index_int */
public class C1254xe5881e27 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(StructuredSurveySessionFragmentModel.class, new C1254xe5881e27());
    }

    public Object m25092a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(StructuredSurveySessionFragmentParser.m25142a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object structuredSurveySessionFragmentModel = new StructuredSurveySessionFragmentModel();
        ((BaseModel) structuredSurveySessionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (structuredSurveySessionFragmentModel instanceof Postprocessable) {
            return ((Postprocessable) structuredSurveySessionFragmentModel).a();
        }
        return structuredSurveySessionFragmentModel;
    }
}
