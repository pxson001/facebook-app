package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLParsers.FetchFeedbackReactionsVectorDataQueryParser.FeedbackReactionSettingsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: share_recent_post */
public class C0334x28e10801 extends JsonSerializer<FetchFeedbackReactionsVectorDataQueryModel> {
    public final void m4500a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchFeedbackReactionsVectorDataQueryModel fetchFeedbackReactionsVectorDataQueryModel = (FetchFeedbackReactionsVectorDataQueryModel) obj;
        if (fetchFeedbackReactionsVectorDataQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchFeedbackReactionsVectorDataQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchFeedbackReactionsVectorDataQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchFeedbackReactionsVectorDataQueryModel.w_();
        int u_ = fetchFeedbackReactionsVectorDataQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("feedback_reaction_settings");
            FeedbackReactionSettingsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchFeedbackReactionsVectorDataQueryModel.class, new C0334x28e10801());
    }
}
