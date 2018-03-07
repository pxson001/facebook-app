package com.facebook.feed.util.story;

import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldRenderOrganicHScrollGraphQLModel.AllSubstoriesModel.NodesModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldRenderOrganicHScrollGraphQLModel.Deserializer;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels$ShouldRenderOrganicHScrollGraphQLModel.Serializer;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1038599823)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: group_feed */
public final class C0868x33f7101d extends BaseModel implements GraphQLVisitableConsistentModel {
    @Nullable
    private AllSubstoriesModel f21758d;
    @Nullable
    private List<GraphQLSubstoriesGroupingReason> f21759e;

    @JsonDeserialize(using = AllSubstoriesModel.Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1203864521)
    @JsonSerialize(using = AllSubstoriesModel.Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: group_feed */
    public final class AllSubstoriesModel extends BaseModel implements GraphQLVisitableModel {
        private int f21760d;
        @Nullable
        private List<NodesModel> f21761e;

        public AllSubstoriesModel() {
            super(2);
        }

        public final int m29459a() {
            m9949a(0, 0);
            return this.f21760d;
        }

        @Nonnull
        public final ImmutableList<NodesModel> m29463b() {
            this.f21761e = super.m9944a(this.f21761e, 1, NodesModel.class);
            return (ImmutableList) this.f21761e;
        }

        public final int jK_() {
            return 1571057009;
        }

        public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            m9958h();
            if (m29463b() != null) {
                Builder a = ModelHelper.m23097a(m29463b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (AllSubstoriesModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f21761e = a.m1068b();
                }
            }
            m9959i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
            m9958h();
            int a = ModelHelper.m23094a(flatBufferBuilder, m29463b());
            flatBufferBuilder.m21510c(2);
            flatBufferBuilder.m21494a(0, this.f21760d, 0);
            flatBufferBuilder.m21507b(1, a);
            m9959i();
            return flatBufferBuilder.m21511d();
        }

        public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.mo1406a(mutableFlatBuffer, i, obj);
            this.f21760d = mutableFlatBuffer.m21524a(i, 0, 0);
        }
    }

    @Nullable
    public final /* synthetic */ AllSubstoriesModel m29454a() {
        return m29452j();
    }

    public C0868x33f7101d() {
        super(2);
    }

    public C0868x33f7101d(MutableFlatBuffer mutableFlatBuffer) {
        super(2);
        mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
    }

    @Nullable
    private AllSubstoriesModel m29452j() {
        this.f21758d = (AllSubstoriesModel) super.m9947a(this.f21758d, 0, AllSubstoriesModel.class);
        return this.f21758d;
    }

    @Nonnull
    public final ImmutableList<GraphQLSubstoriesGroupingReason> m29458b() {
        this.f21759e = super.m9956c(this.f21759e, 1, GraphQLSubstoriesGroupingReason.class);
        return (ImmutableList) this.f21759e;
    }

    public final int jK_() {
        return 80218325;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m29452j() != null) {
            AllSubstoriesModel allSubstoriesModel = (AllSubstoriesModel) graphQLModelMutatingVisitor.mo2928b(m29452j());
            if (m29452j() != allSubstoriesModel) {
                graphQLVisitableModel = (C0868x33f7101d) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21758d = allSubstoriesModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m29452j());
        int d = flatBufferBuilder.m21512d(m29458b());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, d);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
