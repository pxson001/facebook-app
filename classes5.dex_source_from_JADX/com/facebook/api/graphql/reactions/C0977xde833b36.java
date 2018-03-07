package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.LikersModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.LikersParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: android_place_picker_long_press_report_duplicates */
public class C0977xde833b36 extends JsonSerializer<LikersModel> {
    public final void m17107a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        LikersModel likersModel = (LikersModel) obj;
        if (likersModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(likersModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        LikersParser.m17171a(likersModel.w_(), likersModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(LikersModel.class, new C0977xde833b36());
    }
}
