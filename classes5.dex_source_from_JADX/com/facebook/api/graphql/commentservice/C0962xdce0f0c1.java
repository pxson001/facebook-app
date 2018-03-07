package com.facebook.api.graphql.commentservice;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.api.graphql.commentservice.CommentsServiceParsers.CommentCreateFeedbackFieldsParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCommentDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: app_id */
public class C0962xdce0f0c1 extends JsonSerializer<CommentCreateShimMutationFragmentModel> {
    public final void m15712a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        CommentCreateShimMutationFragmentModel commentCreateShimMutationFragmentModel = (CommentCreateShimMutationFragmentModel) obj;
        if (commentCreateShimMutationFragmentModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(commentCreateShimMutationFragmentModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            commentCreateShimMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = commentCreateShimMutationFragmentModel.w_();
        int u_ = commentCreateShimMutationFragmentModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("comment");
            GraphQLCommentDeserializer.m4661b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(u_, 1);
        if (g != 0) {
            jsonGenerator.a("feedback");
            CommentCreateFeedbackFieldsParser.m15737a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(CommentCreateShimMutationFragmentModel.class, new C0962xdce0f0c1());
    }
}
