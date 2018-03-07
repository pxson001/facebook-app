package com.facebook.feed.util.story;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.ShouldRenderOrganicHScrollGraphQLModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldRenderOrganicHScrollGraphQLParser.AllSubstoriesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class C1957xb8752099 extends JsonSerializer<ShouldRenderOrganicHScrollGraphQLModel> {
    public final void m25180a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        ShouldRenderOrganicHScrollGraphQLModel shouldRenderOrganicHScrollGraphQLModel = (ShouldRenderOrganicHScrollGraphQLModel) obj;
        if (shouldRenderOrganicHScrollGraphQLModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(shouldRenderOrganicHScrollGraphQLModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            shouldRenderOrganicHScrollGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = shouldRenderOrganicHScrollGraphQLModel.w_();
        int u_ = shouldRenderOrganicHScrollGraphQLModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("all_substories");
            AllSubstoriesParser.m25215a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(u_, 1) != 0) {
            jsonGenerator.a("substories_grouping_reasons");
            SerializerHelpers.a(mutableFlatBuffer.f(u_, 1), jsonGenerator);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ShouldRenderOrganicHScrollGraphQLModel.class, new C1957xb8752099());
    }
}
