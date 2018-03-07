package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localphotometadata */
public final class GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection> CREATOR = new 1();
    public List<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> f16904d;
    @Nullable
    public GraphQLPageInfo f16905e;

    @FieldOffset
    public final ImmutableList<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> m23876a() {
        this.f16904d = super.m9944a(this.f16904d, 0, GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.class);
        return (ImmutableList) this.f16904d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m23877j() {
        this.f16905e = (GraphQLPageInfo) super.m9947a(this.f16905e, 1, GraphQLPageInfo.class);
        return this.f16905e;
    }

    public final int jK_() {
        return 565356151;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m23876a() != null) {
            Builder a = ModelHelper.m23097a(m23876a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.f16904d = a.m1068b();
                graphQLVisitableModel = graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection;
                if (m23877j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23877j());
                    if (m23877j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16905e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23877j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23877j());
            if (m23877j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16905e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23876a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23877j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection(Parcel parcel) {
        super(3);
        this.f16904d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.class.getClassLoader()));
        this.f16905e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m23876a());
        parcel.writeValue(m23877j());
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16904d = builder.d;
        this.f16905e = builder.e;
    }
}
