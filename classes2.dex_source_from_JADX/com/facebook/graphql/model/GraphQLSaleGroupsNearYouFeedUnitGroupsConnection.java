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
/* compiled from: localsell_category_search */
public final class GraphQLSaleGroupsNearYouFeedUnitGroupsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSaleGroupsNearYouFeedUnitGroupsConnection> CREATOR = new 1();
    public List<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> f16898d;
    @Nullable
    public GraphQLPageInfo f16899e;

    @FieldOffset
    public final ImmutableList<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> m23862a() {
        this.f16898d = super.m9944a(this.f16898d, 0, GraphQLSaleGroupsNearYouFeedUnitGroupsEdge.class);
        return (ImmutableList) this.f16898d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m23863j() {
        this.f16899e = (GraphQLPageInfo) super.m9947a(this.f16899e, 1, GraphQLPageInfo.class);
        return this.f16899e;
    }

    public final int jK_() {
        return 569329040;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m23862a() != null) {
            Builder a = ModelHelper.m23097a(m23862a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLSaleGroupsNearYouFeedUnitGroupsConnection graphQLSaleGroupsNearYouFeedUnitGroupsConnection = (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLSaleGroupsNearYouFeedUnitGroupsConnection.f16898d = a.m1068b();
                graphQLVisitableModel = graphQLSaleGroupsNearYouFeedUnitGroupsConnection;
                if (m23863j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23863j());
                    if (m23863j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16899e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23863j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23863j());
            if (m23863j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLSaleGroupsNearYouFeedUnitGroupsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16899e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLSaleGroupsNearYouFeedUnitGroupsConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23862a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23863j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSaleGroupsNearYouFeedUnitGroupsConnection(Parcel parcel) {
        super(3);
        this.f16898d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge.class.getClassLoader()));
        this.f16899e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m23862a());
        parcel.writeValue(m23863j());
    }

    public GraphQLSaleGroupsNearYouFeedUnitGroupsConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16898d = builder.d;
        this.f16899e = builder.e;
    }
}
