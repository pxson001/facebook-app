package com.facebook.productionprompts.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels$FetchProductionPromptsQueryModel.Deserializer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels$FetchProductionPromptsQueryModel.Serializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -91742882)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: messenger_image_pipeline_onidle_executors */
public final class C0582x78ef048a extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private ClientProductionPromptsModel f13944d;
    @Nullable
    private ProductionPromptsModel f13945e;

    @JsonDeserialize(using = ProductionPromptsModel.Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1489071393)
    @JsonSerialize(using = ProductionPromptsModel.Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messenger_image_pipeline_onidle_executors */
    public final class ProductionPromptsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel> f15072d;

        public ProductionPromptsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel> m21605a() {
            this.f15072d = super.m9944a(this.f15072d, 0, FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel.class);
            return (ImmutableList) this.f15072d;
        }

        public final int jK_() {
            return -1861490700;
        }

        public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            m9958h();
            if (m21605a() != null) {
                Builder a = ModelHelper.m23097a(m21605a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ProductionPromptsModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f15072d = a.m1068b();
                }
            }
            m9959i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
            m9958h();
            int a = ModelHelper.m23094a(flatBufferBuilder, m21605a());
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, a);
            m9959i();
            return flatBufferBuilder.m21511d();
        }
    }

    @JsonDeserialize(using = ClientProductionPromptsModel.Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -342569025)
    @JsonSerialize(using = ClientProductionPromptsModel.Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messenger_image_pipeline_onidle_executors */
    public final class ClientProductionPromptsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<C0658x37f5d27d> f15085d;

        public ClientProductionPromptsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<C0658x37f5d27d> m21629a() {
            this.f15085d = super.m9944a(this.f15085d, 0, C0658x37f5d27d.class);
            return (ImmutableList) this.f15085d;
        }

        public final int jK_() {
            return -1417515735;
        }

        public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            m9958h();
            if (m21629a() != null) {
                Builder a = ModelHelper.m23097a(m21629a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ClientProductionPromptsModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f15085d = a.m1068b();
                }
            }
            m9959i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
            m9958h();
            int a = ModelHelper.m23094a(flatBufferBuilder, m21629a());
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, a);
            m9959i();
            return flatBufferBuilder.m21511d();
        }
    }

    public C0582x78ef048a() {
        super(2);
    }

    @Nullable
    public final ClientProductionPromptsModel m20285a() {
        this.f13944d = (ClientProductionPromptsModel) super.m9947a(this.f13944d, 0, ClientProductionPromptsModel.class);
        return this.f13944d;
    }

    @Nullable
    public final ProductionPromptsModel m20286j() {
        this.f13945e = (ProductionPromptsModel) super.m9947a(this.f13945e, 1, ProductionPromptsModel.class);
        return this.f13945e;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m20285a() != null) {
            ClientProductionPromptsModel clientProductionPromptsModel = (ClientProductionPromptsModel) graphQLModelMutatingVisitor.mo2928b(m20285a());
            if (m20285a() != clientProductionPromptsModel) {
                graphQLVisitableModel = (C0582x78ef048a) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f13944d = clientProductionPromptsModel;
            }
        }
        if (m20286j() != null) {
            ProductionPromptsModel productionPromptsModel = (ProductionPromptsModel) graphQLModelMutatingVisitor.mo2928b(m20286j());
            if (m20286j() != productionPromptsModel) {
                graphQLVisitableModel = (C0582x78ef048a) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f13945e = productionPromptsModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m20285a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m20286j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
