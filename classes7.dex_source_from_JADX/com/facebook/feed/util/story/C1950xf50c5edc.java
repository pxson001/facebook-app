package com.facebook.feed.util.story;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.ShouldDisplayProfilePictureGraphQLModel.FeedbackModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.FeedbackParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class C1950xf50c5edc extends JsonSerializer<FeedbackModel> {
    public final void m25149a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FeedbackModel feedbackModel = (FeedbackModel) obj;
        if (feedbackModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(feedbackModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        FeedbackParser.m25204a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(FeedbackModel.class, new C1950xf50c5edc());
    }
}
