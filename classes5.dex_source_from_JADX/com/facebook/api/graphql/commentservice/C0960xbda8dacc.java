package com.facebook.api.graphql.commentservice;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateFeedbackFieldsModel;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.modelutil.ModelHelper;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: app_id */
public final class C0960xbda8dacc {
    @Nullable
    public GraphQLComment f9233a;
    @Nullable
    public CommentCreateFeedbackFieldsModel f9234b;

    public final CommentCreateShimMutationFragmentModel m15710a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, this.f9233a);
        int a2 = ModelHelper.a(flatBufferBuilder, this.f9234b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new CommentCreateShimMutationFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
