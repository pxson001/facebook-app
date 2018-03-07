package com.facebook.ufiservices.util;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ufiservices.flyout.C0346x25f16e6a;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLModels.UFIProfileListFragmentGraphQLModel.ProfilePictureModel;
import com.facebook.ufiservices.flyout.views.FlyoutLikerViewGraphQLInterfaces$FlyoutLikerViewGraphQL.ProfilePicture;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLModels.ProfileListFriendingControllerGraphQLModel.MutualFriendsModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyAggregatedLinksGraphQLModel$AggregatedRangesModel$SampleEntitiesModel.Deserializer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyAggregatedLinksGraphQLModel$AggregatedRangesModel$SampleEntitiesModel.Serializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1869043182)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: o2i_ul_pl */
public final class C0345xb093e375 extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, C0346x25f16e6a {
    @Nullable
    private GraphQLObjectType f7290d;
    @Nullable
    private GraphQLFriendshipStatus f7291e;
    @Nullable
    private String f7292f;
    @Nullable
    private MutualFriendsModel f7293g;
    @Nullable
    private String f7294h;
    @Nullable
    private ProfilePictureModel f7295i;
    @Nullable
    private String f7296j;

    @Nullable
    public final /* synthetic */ MutualFriendsModel mo606b() {
        return m7604l();
    }

    @Nullable
    public final /* synthetic */ DefaultImageFields dB_() {
        return m7605m();
    }

    @Nullable
    public final /* synthetic */ ProfilePictureModel dF_() {
        return m7605m();
    }

    @Nullable
    public final /* synthetic */ ProfilePicture mo613k() {
        return m7605m();
    }

    public C0345xb093e375() {
        super(7);
    }

    public final void m7609a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m7610a(String str, Object obj, boolean z) {
    }

    @Nullable
    public final GraphQLObjectType mo607c() {
        if (this.b != null && this.f7290d == null) {
            this.f7290d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
        }
        return this.f7290d;
    }

    @Nullable
    public final GraphQLFriendshipStatus mo608d() {
        this.f7291e = (GraphQLFriendshipStatus) super.b(this.f7291e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f7291e;
    }

    @Nullable
    public final String mo611g() {
        this.f7292f = super.a(this.f7292f, 2);
        return this.f7292f;
    }

    @Nullable
    private MutualFriendsModel m7604l() {
        this.f7293g = (MutualFriendsModel) super.a(this.f7293g, 3, MutualFriendsModel.class);
        return this.f7293g;
    }

    @Nullable
    public final String C_() {
        this.f7294h = super.a(this.f7294h, 4);
        return this.f7294h;
    }

    @Nullable
    private ProfilePictureModel m7605m() {
        this.f7295i = (ProfilePictureModel) super.a(this.f7295i, 5, ProfilePictureModel.class);
        return this.f7295i;
    }

    @Nullable
    public final String mo612j() {
        this.f7296j = super.a(this.f7296j, 6);
        return this.f7296j;
    }

    @Nullable
    public final String m7608a() {
        return mo611g();
    }

    public final int jK_() {
        return 2080559107;
    }

    public final GraphQLVisitableModel m7607a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7604l() != null) {
            MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m7604l());
            if (m7604l() != mutualFriendsModel) {
                graphQLVisitableModel = (C0345xb093e375) ModelHelper.a(null, this);
                graphQLVisitableModel.f7293g = mutualFriendsModel;
            }
        }
        if (m7605m() != null) {
            ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m7605m());
            if (m7605m() != profilePictureModel) {
                graphQLVisitableModel = (C0345xb093e375) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f7295i = profilePictureModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m7606a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, mo607c());
        int a2 = flatBufferBuilder.a(mo608d());
        int b = flatBufferBuilder.b(mo611g());
        int a3 = ModelHelper.a(flatBufferBuilder, m7604l());
        int b2 = flatBufferBuilder.b(C_());
        int a4 = ModelHelper.a(flatBufferBuilder, m7605m());
        int b3 = flatBufferBuilder.b(mo612j());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.b(6, b3);
        i();
        return flatBufferBuilder.d();
    }
}
