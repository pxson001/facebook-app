package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: android_place_picker_long_press_report_duplicates */
public class C0980x9fac7403 extends JsonSerializer<FeedbackModel> {
    public final void m17110a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FeedbackModel feedbackModel = (FeedbackModel) obj;
        if (feedbackModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(feedbackModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        FeedbackParser.m17177a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(FeedbackModel.class, new C0980x9fac7403());
    }
}
