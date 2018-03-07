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
/* compiled from: list_name */
public final class GraphQLFriendListFeedConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendListFeedConnection> CREATOR = new 1();
    public List<GraphQLFriendListFeedEdge> f17393d;
    @Nullable
    public GraphQLPageInfo f17394e;

    @FieldOffset
    public final ImmutableList<GraphQLFriendListFeedEdge> m24472a() {
        this.f17393d = super.m9944a(this.f17393d, 0, GraphQLFriendListFeedEdge.class);
        return (ImmutableList) this.f17393d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24473j() {
        this.f17394e = (GraphQLPageInfo) super.m9947a(this.f17394e, 1, GraphQLPageInfo.class);
        return this.f17394e;
    }

    public final int jK_() {
        return -904584520;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m24472a() != null) {
            Builder a = ModelHelper.m23097a(m24472a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFriendListFeedConnection graphQLFriendListFeedConnection = (GraphQLFriendListFeedConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLFriendListFeedConnection.f17393d = a.m1068b();
                graphQLVisitableModel = graphQLFriendListFeedConnection;
                if (m24473j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24473j());
                    if (m24473j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLFriendListFeedConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17394e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24473j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24473j());
            if (m24473j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLFriendListFeedConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17394e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLFriendListFeedConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24472a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24473j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFriendListFeedConnection(Parcel parcel) {
        super(3);
        this.f17393d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFriendListFeedEdge.class.getClassLoader()));
        this.f17394e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24472a());
        parcel.writeValue(m24473j());
    }
}
