package com.facebook.graphql.linkutil;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetRedirectionLinkGraphQL;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetFeedStoryAttachmentFbLinkGraphQLModel.Deserializer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetFeedStoryAttachmentFbLinkGraphQLModel.EmployerModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetFeedStoryAttachmentFbLinkGraphQLModel.SchoolClassModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetFeedStoryAttachmentFbLinkGraphQLModel.SchoolModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetFeedStoryAttachmentFbLinkGraphQLModel.Serializer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetFeedStoryAttachmentFbLinkGraphQLModel.WorkProjectModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetRedirectionLinkGraphQLModel.RedirectionInfoModel;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
@ModelWithFlatBufferFormatHash(a = -1389697021)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: device_total_mem */
public final class C0646xa3ec3e6c extends BaseModel implements GetRedirectionLinkGraphQL, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private GraphQLObjectType f13858d;
    @Nullable
    private EmployerModel f13859e;
    @Nullable
    private String f13860f;
    @Nullable
    private List<RedirectionInfoModel> f13861g;
    @Nullable
    private SchoolModel f13862h;
    @Nullable
    private SchoolClassModel f13863i;
    @Nullable
    private String f13864j;
    @Nullable
    private WorkProjectModel f13865k;

    @Nullable
    public final /* synthetic */ WorkProjectModel bY_() {
        return m14654n();
    }

    @Nullable
    public final /* synthetic */ SchoolModel bZ_() {
        return m14652l();
    }

    @Nullable
    public final /* synthetic */ EmployerModel m14661c() {
        return m14651j();
    }

    @Nullable
    public final /* synthetic */ SchoolClassModel m14663g() {
        return m14653m();
    }

    public C0646xa3ec3e6c() {
        super(8);
    }

    public C0646xa3ec3e6c(MutableFlatBuffer mutableFlatBuffer) {
        super(8);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    public final void m14658a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m14659a(String str, Object obj, boolean z) {
    }

    @Nullable
    public final GraphQLObjectType m14660b() {
        if (this.b != null && this.f13858d == null) {
            this.f13858d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
        }
        return this.f13858d;
    }

    @Nullable
    private EmployerModel m14651j() {
        this.f13859e = (EmployerModel) super.a(this.f13859e, 1, EmployerModel.class);
        return this.f13859e;
    }

    @Nullable
    public final String m14662d() {
        this.f13860f = super.a(this.f13860f, 2);
        return this.f13860f;
    }

    @Nonnull
    public final ImmutableList<RedirectionInfoModel> m14664k() {
        this.f13861g = super.a(this.f13861g, 3, RedirectionInfoModel.class);
        return (ImmutableList) this.f13861g;
    }

    @Nullable
    private SchoolModel m14652l() {
        this.f13862h = (SchoolModel) super.a(this.f13862h, 4, SchoolModel.class);
        return this.f13862h;
    }

    @Nullable
    private SchoolClassModel m14653m() {
        this.f13863i = (SchoolClassModel) super.a(this.f13863i, 5, SchoolClassModel.class);
        return this.f13863i;
    }

    @Nullable
    public final String bX_() {
        this.f13864j = super.a(this.f13864j, 6);
        return this.f13864j;
    }

    @Nullable
    private WorkProjectModel m14654n() {
        this.f13865k = (WorkProjectModel) super.a(this.f13865k, 7, WorkProjectModel.class);
        return this.f13865k;
    }

    @Nullable
    public final String m14657a() {
        return m14662d();
    }

    public final int jK_() {
        return 2433570;
    }

    public final GraphQLVisitableModel m14656a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m14651j() != null) {
            EmployerModel employerModel = (EmployerModel) graphQLModelMutatingVisitor.b(m14651j());
            if (m14651j() != employerModel) {
                graphQLVisitableModel = (C0646xa3ec3e6c) ModelHelper.a(null, this);
                graphQLVisitableModel.f13859e = employerModel;
            }
        }
        if (m14664k() != null) {
            Builder a = ModelHelper.a(m14664k(), graphQLModelMutatingVisitor);
            if (a != null) {
                C0646xa3ec3e6c c0646xa3ec3e6c = (C0646xa3ec3e6c) ModelHelper.a(graphQLVisitableModel, this);
                c0646xa3ec3e6c.f13861g = a.b();
                graphQLVisitableModel = c0646xa3ec3e6c;
            }
        }
        if (m14652l() != null) {
            SchoolModel schoolModel = (SchoolModel) graphQLModelMutatingVisitor.b(m14652l());
            if (m14652l() != schoolModel) {
                graphQLVisitableModel = (C0646xa3ec3e6c) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13862h = schoolModel;
            }
        }
        if (m14653m() != null) {
            SchoolClassModel schoolClassModel = (SchoolClassModel) graphQLModelMutatingVisitor.b(m14653m());
            if (m14653m() != schoolClassModel) {
                graphQLVisitableModel = (C0646xa3ec3e6c) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13863i = schoolClassModel;
            }
        }
        if (m14654n() != null) {
            WorkProjectModel workProjectModel = (WorkProjectModel) graphQLModelMutatingVisitor.b(m14654n());
            if (m14654n() != workProjectModel) {
                graphQLVisitableModel = (C0646xa3ec3e6c) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13865k = workProjectModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m14655a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m14660b());
        int a2 = ModelHelper.a(flatBufferBuilder, m14651j());
        int b = flatBufferBuilder.b(m14662d());
        int a3 = ModelHelper.a(flatBufferBuilder, m14664k());
        int a4 = ModelHelper.a(flatBufferBuilder, m14652l());
        int a5 = ModelHelper.a(flatBufferBuilder, m14653m());
        int b2 = flatBufferBuilder.b(bX_());
        int a6 = ModelHelper.a(flatBufferBuilder, m14654n());
        flatBufferBuilder.c(8);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.b(5, a5);
        flatBufferBuilder.b(6, b2);
        flatBufferBuilder.b(7, a6);
        i();
        return flatBufferBuilder.d();
    }
}
