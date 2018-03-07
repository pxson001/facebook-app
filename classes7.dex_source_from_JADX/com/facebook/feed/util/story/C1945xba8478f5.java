package com.facebook.feed.util.story;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.ShouldDisplayProfilePictureGraphQLModel.ActorsModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class C1945xba8478f5 extends JsonSerializer<ActorsModel> {
    public final void m25124a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ActorsModel actorsModel = (ActorsModel) obj;
        if (actorsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(actorsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            actorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ActorsParser.m25196b(actorsModel.w_(), actorsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ActorsModel.class, new C1945xba8478f5());
    }
}
