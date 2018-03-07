package com.facebook.feed.util.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.ShouldRenderOrganicHScrollGraphQLModel.AllSubstoriesModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldRenderOrganicHScrollGraphQLParser.AllSubstoriesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class C1953x3709ab9b extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(AllSubstoriesModel.class, new C1953x3709ab9b());
    }

    public Object m25156a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(AllSubstoriesParser.m25214a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object allSubstoriesModel = new AllSubstoriesModel();
        ((BaseModel) allSubstoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (allSubstoriesModel instanceof Postprocessable) {
            return ((Postprocessable) allSubstoriesModel).a();
        }
        return allSubstoriesModel;
    }
}
