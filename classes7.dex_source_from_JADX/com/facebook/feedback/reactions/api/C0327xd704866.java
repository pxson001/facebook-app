package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLParsers.FetchFeedbackReactionSettingsQueryParser.FeedbackReactionSettingsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: share_recent_post */
public class C0327xd704866 extends JsonSerializer<FetchFeedbackReactionSettingsQueryModel> {
    public final void m4493a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchFeedbackReactionSettingsQueryModel fetchFeedbackReactionSettingsQueryModel = (FetchFeedbackReactionSettingsQueryModel) obj;
        if (fetchFeedbackReactionSettingsQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchFeedbackReactionSettingsQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchFeedbackReactionSettingsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchFeedbackReactionSettingsQueryModel.w_();
        int u_ = fetchFeedbackReactionSettingsQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("feedback_reaction_settings");
            FeedbackReactionSettingsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchFeedbackReactionSettingsQueryModel.class, new C0327xd704866());
    }
}
