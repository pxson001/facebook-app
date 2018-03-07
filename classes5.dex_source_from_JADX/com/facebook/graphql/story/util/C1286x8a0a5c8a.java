package com.facebook.graphql.story.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels.ShouldDisplaySubStoryGalleryGraphQLModel;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: TRIGHT;TKEY;>; */
public class C1286x8a0a5c8a extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ShouldDisplaySubStoryGalleryGraphQLModel.class, new C1286x8a0a5c8a());
    }

    public Object m22694a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(ShouldDisplaySubStoryGalleryGraphQLParser.m22709a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object shouldDisplaySubStoryGalleryGraphQLModel = new ShouldDisplaySubStoryGalleryGraphQLModel();
        ((BaseModel) shouldDisplaySubStoryGalleryGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (shouldDisplaySubStoryGalleryGraphQLModel instanceof Postprocessable) {
            return ((Postprocessable) shouldDisplaySubStoryGalleryGraphQLModel).a();
        }
        return shouldDisplaySubStoryGalleryGraphQLModel;
    }
}
