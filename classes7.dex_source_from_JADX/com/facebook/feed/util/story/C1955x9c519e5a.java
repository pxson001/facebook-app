package com.facebook.feed.util.story;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.ShouldRenderOrganicHScrollGraphQLModel.AllSubstoriesModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldRenderOrganicHScrollGraphQLParser.AllSubstoriesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class C1955x9c519e5a extends JsonSerializer<AllSubstoriesModel> {
    public final void m25178a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AllSubstoriesModel allSubstoriesModel = (AllSubstoriesModel) obj;
        if (allSubstoriesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(allSubstoriesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            allSubstoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        AllSubstoriesParser.m25215a(allSubstoriesModel.w_(), allSubstoriesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(AllSubstoriesModel.class, new C1955x9c519e5a());
    }
}
