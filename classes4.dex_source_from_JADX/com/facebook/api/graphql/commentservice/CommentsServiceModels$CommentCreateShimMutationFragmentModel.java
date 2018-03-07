package com.facebook.api.graphql.commentservice;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateFeedbackFieldsModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1748970008)
@JsonSerialize(using = Serializer.class)
/* compiled from: feed_mark_impression_logged */
public final class CommentsServiceModels$CommentCreateShimMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private GraphQLComment f11877d;
    @Nullable
    private CommentCreateFeedbackFieldsModel f11878e;

    public CommentsServiceModels$CommentCreateShimMutationFragmentModel() {
        super(2);
    }

    public CommentsServiceModels$CommentCreateShimMutationFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
        super(2);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final GraphQLComment m12474a() {
        this.f11877d = (GraphQLComment) super.a(this.f11877d, 0, GraphQLComment.class);
        return this.f11877d;
    }

    @Nullable
    public final CommentCreateFeedbackFieldsModel m12476j() {
        this.f11878e = (CommentCreateFeedbackFieldsModel) super.a(this.f11878e, 1, CommentCreateFeedbackFieldsModel.class);
        return this.f11878e;
    }

    public final int jK_() {
        return -1696429447;
    }

    public final GraphQLVisitableModel m12475a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m12474a() != null) {
            GraphQLComment graphQLComment = (GraphQLComment) graphQLModelMutatingVisitor.b(m12474a());
            if (m12474a() != graphQLComment) {
                graphQLVisitableModel = (CommentsServiceModels$CommentCreateShimMutationFragmentModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f11877d = graphQLComment;
            }
        }
        if (m12476j() != null) {
            CommentCreateFeedbackFieldsModel commentCreateFeedbackFieldsModel = (CommentCreateFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m12476j());
            if (m12476j() != commentCreateFeedbackFieldsModel) {
                graphQLVisitableModel = (CommentsServiceModels$CommentCreateShimMutationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f11878e = commentCreateFeedbackFieldsModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m12473a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m12474a());
        int a2 = ModelHelper.a(flatBufferBuilder, m12476j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }
}
