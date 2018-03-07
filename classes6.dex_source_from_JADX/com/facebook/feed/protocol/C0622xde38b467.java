package com.facebook.feed.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feed.protocol.QuestionAddPollOptionModels.QuestionAddResponseMutationModel;
import com.facebook.feed.protocol.QuestionPollUpdateVoteParsers.QuestionMutationFragmentParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: messenger_user */
public class C0622xde38b467 extends JsonSerializer<QuestionAddResponseMutationModel> {
    public final void m16404a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        QuestionAddResponseMutationModel questionAddResponseMutationModel = (QuestionAddResponseMutationModel) obj;
        if (questionAddResponseMutationModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(questionAddResponseMutationModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            questionAddResponseMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = questionAddResponseMutationModel.w_();
        int u_ = questionAddResponseMutationModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("question");
            QuestionMutationFragmentParser.m16492a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(QuestionAddResponseMutationModel.class, new C0622xde38b467());
    }
}
