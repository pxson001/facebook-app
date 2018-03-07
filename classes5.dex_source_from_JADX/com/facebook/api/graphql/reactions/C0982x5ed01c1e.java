package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.ViewerFeedbackReactionModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ViewerFeedbackReactionParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: android_place_picker_long_press_report_duplicates */
public class C0982x5ed01c1e extends JsonSerializer<ViewerFeedbackReactionModel> {
    public final void m17112a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ViewerFeedbackReactionModel viewerFeedbackReactionModel = (ViewerFeedbackReactionModel) obj;
        if (viewerFeedbackReactionModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(viewerFeedbackReactionModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            viewerFeedbackReactionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ViewerFeedbackReactionParser.m17175a(viewerFeedbackReactionModel.w_(), viewerFeedbackReactionModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(ViewerFeedbackReactionModel.class, new C0982x5ed01c1e());
    }
}
