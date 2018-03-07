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
/* compiled from: localsell_composer/?assetIDs=%s */
public final class GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection> CREATOR = new 1();
    public List<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> f16896d;
    @Nullable
    public GraphQLPageInfo f16897e;

    @FieldOffset
    public final ImmutableList<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> m23858a() {
        this.f16896d = super.m9944a(this.f16896d, 0, GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.class);
        return (ImmutableList) this.f16896d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m23859j() {
        this.f16897e = (GraphQLPageInfo) super.m9947a(this.f16897e, 1, GraphQLPageInfo.class);
        return this.f16897e;
    }

    public final int jK_() {
        return -1151393553;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m23858a() != null) {
            Builder a = ModelHelper.m23097a(m23858a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.f16896d = a.m1068b();
                graphQLVisitableModel = graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection;
                if (m23859j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23859j());
                    if (m23859j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16897e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23859j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23859j());
            if (m23859j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16897e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23858a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23859j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection(Parcel parcel) {
        super(3);
        this.f16896d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.class.getClassLoader()));
        this.f16897e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m23858a());
        parcel.writeValue(m23859j());
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16896d = builder.d;
        this.f16897e = builder.e;
    }
}
