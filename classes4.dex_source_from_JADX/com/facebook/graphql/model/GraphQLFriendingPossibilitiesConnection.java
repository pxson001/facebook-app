package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
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
/* compiled from: short_name */
public final class GraphQLFriendingPossibilitiesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendingPossibilitiesConnection> CREATOR = new 1();
    List<GraphQLFriendingPossibilitiesEdge> f2214d;
    @Nullable
    GraphQLPageInfo f2215e;
    int f2216f;

    @FieldOffset
    public final ImmutableList<GraphQLFriendingPossibilitiesEdge> m2402a() {
        this.f2214d = super.a(this.f2214d, 0, GraphQLFriendingPossibilitiesEdge.class);
        return (ImmutableList) this.f2214d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m2404j() {
        this.f2215e = (GraphQLPageInfo) super.a(this.f2215e, 1, GraphQLPageInfo.class);
        return this.f2215e;
    }

    @FieldOffset
    public final int m2405k() {
        a(0, 2);
        return this.f2216f;
    }

    public final int jK_() {
        return 1085064779;
    }

    public final GraphQLVisitableModel m2401a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m2402a() != null) {
            Builder a = ModelHelper.a(m2402a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFriendingPossibilitiesConnection graphQLFriendingPossibilitiesConnection = (GraphQLFriendingPossibilitiesConnection) ModelHelper.a(null, this);
                graphQLFriendingPossibilitiesConnection.f2214d = a.b();
                graphQLVisitableModel = graphQLFriendingPossibilitiesConnection;
                if (m2404j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m2404j());
                    if (m2404j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLFriendingPossibilitiesConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2215e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m2404j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m2404j());
            if (m2404j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLFriendingPossibilitiesConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2215e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLFriendingPossibilitiesConnection() {
        super(4);
    }

    public final void m2403a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f2216f = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m2400a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2402a());
        int a2 = ModelHelper.a(flatBufferBuilder, m2404j());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.a(2, m2405k(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFriendingPossibilitiesConnection(Parcel parcel) {
        super(4);
        this.f2214d = ImmutableListHelper.a(parcel.readArrayList(GraphQLFriendingPossibilitiesEdge.class.getClassLoader()));
        this.f2215e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f2216f = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m2402a());
        parcel.writeValue(m2404j());
        parcel.writeInt(m2405k());
    }
}
