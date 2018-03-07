package com.facebook.feed.protocol;

import com.facebook.feed.protocol.QuestionPollUpdateVoteModels.QuestionMutationFragmentModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 262104880)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: feed_fetch_news_feed_before */
public final class QuestionAddPollOptionModels$QuestionAddResponseMutationModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private QuestionMutationFragmentModel f11882d;

    public QuestionAddPollOptionModels$QuestionAddResponseMutationModel() {
        super(1);
    }

    @Nullable
    public final QuestionMutationFragmentModel m12485a() {
        this.f11882d = (QuestionMutationFragmentModel) super.a(this.f11882d, 0, QuestionMutationFragmentModel.class);
        return this.f11882d;
    }

    public final int jK_() {
        return -503404323;
    }

    public final GraphQLVisitableModel m12486a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m12485a() != null) {
            QuestionMutationFragmentModel questionMutationFragmentModel = (QuestionMutationFragmentModel) graphQLModelMutatingVisitor.b(m12485a());
            if (m12485a() != questionMutationFragmentModel) {
                graphQLVisitableModel = (QuestionAddPollOptionModels$QuestionAddResponseMutationModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f11882d = questionMutationFragmentModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m12484a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m12485a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
