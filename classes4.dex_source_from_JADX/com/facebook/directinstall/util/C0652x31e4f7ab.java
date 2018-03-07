package com.facebook.directinstall.util;

import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsActorGraphQL;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsActorGraphQL.ProfilePicture;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels$GetNativeAppDetailsActorGraphQLModel.Deserializer;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels$GetNativeAppDetailsActorGraphQLModel.ProfilePictureModel;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels$GetNativeAppDetailsActorGraphQLModel.Serializer;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 487813626)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: depends_on */
public final class C0652x31e4f7ab extends BaseModel implements GetNativeAppDetailsActorGraphQL, GraphQLVisitableConsistentModel {
    @Nullable
    private GraphQLObjectType f13983d;
    @Nullable
    private String f13984e;
    @Nullable
    private ProfilePictureModel f13985f;

    @Nullable
    public final /* synthetic */ ProfilePicture m14781l() {
        return m14776j();
    }

    public C0652x31e4f7ab() {
        super(3);
    }

    public C0652x31e4f7ab(MutableFlatBuffer mutableFlatBuffer) {
        super(3);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    public final void m14779a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m14780a(String str, Object obj, boolean z) {
    }

    @Nullable
    private GraphQLObjectType m14775a() {
        if (this.b != null && this.f13983d == null) {
            this.f13983d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
        }
        return this.f13983d;
    }

    @Nullable
    public final String C_() {
        this.f13984e = super.a(this.f13984e, 1);
        return this.f13984e;
    }

    @Nullable
    private ProfilePictureModel m14776j() {
        this.f13985f = (ProfilePictureModel) super.a(this.f13985f, 2, ProfilePictureModel.class);
        return this.f13985f;
    }

    public final int jK_() {
        return 63093205;
    }

    public final GraphQLVisitableModel m14778a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m14776j() != null) {
            ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m14776j());
            if (m14776j() != profilePictureModel) {
                graphQLVisitableModel = (C0652x31e4f7ab) ModelHelper.a(null, this);
                graphQLVisitableModel.f13985f = profilePictureModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m14777a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m14775a());
        int b = flatBufferBuilder.b(C_());
        int a2 = ModelHelper.a(flatBufferBuilder, m14776j());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        i();
        return flatBufferBuilder.d();
    }
}
