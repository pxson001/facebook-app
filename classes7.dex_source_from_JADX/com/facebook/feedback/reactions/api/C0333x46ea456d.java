package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLParsers.FetchFeedbackReactionsVectorDataQueryParser.FeedbackReactionSettingsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: share_recent_post */
public class C0333x46ea456d extends JsonSerializer<FeedbackReactionSettingsModel> {
    public final void m4499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FeedbackReactionSettingsModel feedbackReactionSettingsModel = (FeedbackReactionSettingsModel) obj;
        if (feedbackReactionSettingsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(feedbackReactionSettingsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            feedbackReactionSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        FeedbackReactionSettingsParser.a(feedbackReactionSettingsModel.w_(), feedbackReactionSettingsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(FeedbackReactionSettingsModel.class, new C0333x46ea456d());
    }
}
