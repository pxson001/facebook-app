package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel.FeedbackReactionSettingsModel.ReactionInfosModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLParsers.FetchFeedbackReactionSettingsQueryParser.FeedbackReactionSettingsParser.ReactionInfosParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: share_recent_post */
public class C0325xabc8f989 extends JsonSerializer<ReactionInfosModel> {
    public final void m4491a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ReactionInfosModel reactionInfosModel = (ReactionInfosModel) obj;
        if (reactionInfosModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(reactionInfosModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            reactionInfosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ReactionInfosParser.b(reactionInfosModel.w_(), reactionInfosModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ReactionInfosModel.class, new C0325xabc8f989());
    }
}
