package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1848791573)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: push_reg_status */
public final class AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private AdminedPagesModel f4007d;

    /* compiled from: push_reg_status */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.class, new Deserializer());
        }

        public Object m4507a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = C0188x5318698e.m4508a(jsonParser);
            Object adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel = new AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel();
            ((BaseModel) adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
            if (adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel instanceof Postprocessable) {
                return ((Postprocessable) adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel).a();
            }
            return adminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 974773611)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: push_reg_status */
    public final class AdminedPagesModel extends BaseModel implements GraphQLVisitableModel {
        private int f4012d;
        @Nullable
        private List<NodesModel> f4013e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 742077459)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: push_reg_status */
        public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private AdminInfoModel f4014d;
            @Nullable
            private String f4015e;
            @Nullable
            private String f4016f;
            @Nullable
            private ProfilePictureModel f4017g;
            @Nullable
            private List<String> f4018h;

            @Nullable
            public final /* synthetic */ AdminInfoModel m4523b() {
                return m4527j();
            }

            @Nullable
            public final /* synthetic */ ProfilePictureModel km_() {
                return m4528k();
            }

            public NodesModel() {
                super(5);
            }

            public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(5);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m4521a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m4522a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final AdminInfoModel m4527j() {
                this.f4014d = (AdminInfoModel) super.a(this.f4014d, 0, AdminInfoModel.class);
                return this.f4014d;
            }

            @Nullable
            public final String m4524c() {
                this.f4015e = super.a(this.f4015e, 1);
                return this.f4015e;
            }

            @Nullable
            public final String m4525d() {
                this.f4016f = super.a(this.f4016f, 2);
                return this.f4016f;
            }

            @Nullable
            public final ProfilePictureModel m4528k() {
                this.f4017g = (ProfilePictureModel) super.a(this.f4017g, 3, ProfilePictureModel.class);
                return this.f4017g;
            }

            @Nonnull
            public final ImmutableList<String> m4526g() {
                this.f4018h = super.a(this.f4018h, 4);
                return (ImmutableList) this.f4018h;
            }

            @Nullable
            public final String m4520a() {
                return m4524c();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m4519a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m4527j() != null) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m4527j());
                    if (m4527j() != adminInfoModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4014d = adminInfoModel;
                    }
                }
                if (m4528k() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m4528k());
                    if (m4528k() != profilePictureModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4017g = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m4518a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4527j());
                int b = flatBufferBuilder.b(m4524c());
                int b2 = flatBufferBuilder.b(m4525d());
                int a2 = ModelHelper.a(flatBufferBuilder, m4528k());
                int c = flatBufferBuilder.c(m4526g());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, c);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AdminedPagesModel() {
            super(2);
        }

        public AdminedPagesModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m4513a() {
            a(0, 0);
            return this.f4012d;
        }

        @Nonnull
        public final ImmutableList<NodesModel> m4517b() {
            this.f4013e = super.a(this.f4013e, 1, NodesModel.class);
            return (ImmutableList) this.f4013e;
        }

        public final int jK_() {
            return 1239953364;
        }

        public final GraphQLVisitableModel m4515a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4517b() != null) {
                Builder a = ModelHelper.a(m4517b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (AdminedPagesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4013e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4514a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4517b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f4012d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4516a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4012d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @Nullable
    public final /* synthetic */ AdminedPagesModel m4504a() {
        return m4501j();
    }

    public AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel() {
        super(1);
    }

    public AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    private AdminedPagesModel m4501j() {
        this.f4007d = (AdminedPagesModel) super.a(this.f4007d, 0, AdminedPagesModel.class);
        return this.f4007d;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel m4503a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m4501j() != null) {
            AdminedPagesModel adminedPagesModel = (AdminedPagesModel) graphQLModelMutatingVisitor.b(m4501j());
            if (m4501j() != adminedPagesModel) {
                graphQLVisitableModel = (AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f4007d = adminedPagesModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m4502a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m4501j());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
