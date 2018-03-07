package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.ReactionImageFragmentModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLParsers.ReactionImageFragmentParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: share_recent_post */
public class C0336xdd570533 extends JsonSerializer<ReactionImageFragmentModel> {
    public final void m4502a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ReactionImageFragmentModel reactionImageFragmentModel = (ReactionImageFragmentModel) obj;
        if (reactionImageFragmentModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(reactionImageFragmentModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            reactionImageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ReactionImageFragmentParser.a(reactionImageFragmentModel.w_(), reactionImageFragmentModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(ReactionImageFragmentModel.class, new C0336xdd570533());
    }
}
