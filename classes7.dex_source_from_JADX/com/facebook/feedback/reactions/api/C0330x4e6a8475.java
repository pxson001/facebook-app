package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel.AnimationModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLParsers.FetchFeedbackReactionsVectorDataQueryParser.FeedbackReactionSettingsParser.ReactionInfosParser.AnimationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: share_recent_post */
public class C0330x4e6a8475 extends JsonSerializer<AnimationModel> {
    public final void m4496a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AnimationModel animationModel = (AnimationModel) obj;
        if (animationModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(animationModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            animationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        AnimationParser.a(animationModel.w_(), animationModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(AnimationModel.class, new C0330x4e6a8475());
    }
}
