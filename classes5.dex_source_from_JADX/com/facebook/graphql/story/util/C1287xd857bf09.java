package com.facebook.graphql.story.util;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels.ShouldDisplaySubStoryGalleryGraphQLModel;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser.ActorsParser;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser.AllSubstoriesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TRIGHT;TKEY;>; */
public class C1287xd857bf09 extends JsonSerializer<ShouldDisplaySubStoryGalleryGraphQLModel> {
    public final void m22695a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        ShouldDisplaySubStoryGalleryGraphQLModel shouldDisplaySubStoryGalleryGraphQLModel = (ShouldDisplaySubStoryGalleryGraphQLModel) obj;
        if (shouldDisplaySubStoryGalleryGraphQLModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(shouldDisplaySubStoryGalleryGraphQLModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            shouldDisplaySubStoryGalleryGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = shouldDisplaySubStoryGalleryGraphQLModel.w_();
        int u_ = shouldDisplaySubStoryGalleryGraphQLModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("actors");
            jsonGenerator.d();
            for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                ActorsParser.m22699a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(u_, 1);
        if (g != 0) {
            jsonGenerator.a("all_substories");
            AllSubstoriesParser.m22708a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(u_, 2);
        if (a) {
            jsonGenerator.a("has_comprehensive_title");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ShouldDisplaySubStoryGalleryGraphQLModel.class, new C1287xd857bf09());
    }
}
