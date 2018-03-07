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
/* compiled from: load_local_media */
public final class GraphQLFriendsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendsConnection> CREATOR = new 1();
    List<GraphQLUser> f17196d;
    int f17197e;
    List<GraphQLFriendsEdge> f17198f;
    int f17199g;
    int f17200h;
    List<GraphQLUser> f17201i;
    @Nullable
    GraphQLPageInfo f17202j;

    @FieldOffset
    public final ImmutableList<GraphQLUser> m24236a() {
        this.f17196d = super.m9944a(this.f17196d, 0, GraphQLUser.class);
        return (ImmutableList) this.f17196d;
    }

    @FieldOffset
    public final int m24238j() {
        m9949a(0, 1);
        return this.f17197e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFriendsEdge> m24239k() {
        this.f17198f = super.m9944a(this.f17198f, 2, GraphQLFriendsEdge.class);
        return (ImmutableList) this.f17198f;
    }

    @FieldOffset
    public final int m24240l() {
        m9949a(0, 3);
        return this.f17199g;
    }

    @FieldOffset
    public final int m24241m() {
        m9949a(0, 4);
        return this.f17200h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m24242n() {
        this.f17201i = super.m9944a(this.f17201i, 5, GraphQLUser.class);
        return (ImmutableList) this.f17201i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24243o() {
        this.f17202j = (GraphQLPageInfo) super.m9947a(this.f17202j, 6, GraphQLPageInfo.class);
        return this.f17202j;
    }

    public final int jK_() {
        return 569028147;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24236a() != null) {
            a = ModelHelper.m23097a(m24236a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLFriendsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17196d = a.m1068b();
            }
        }
        if (m24239k() != null) {
            a = ModelHelper.m23097a(m24239k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLFriendsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17198f = a.m1068b();
            }
        }
        if (m24242n() != null) {
            a = ModelHelper.m23097a(m24242n(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLFriendsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17201i = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m24243o() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24243o());
            if (m24243o() != graphQLPageInfo) {
                graphQLVisitableModel2 = (GraphQLFriendsConnection) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17202j = graphQLPageInfo;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLFriendsConnection() {
        super(8);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17197e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f17199g = mutableFlatBuffer.m21524a(i, 3, 0);
        this.f17200h = mutableFlatBuffer.m21524a(i, 4, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24236a());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24239k());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m24242n());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24243o());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21494a(1, m24238j(), 0);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21494a(3, m24240l(), 0);
        flatBufferBuilder.m21494a(4, m24241m(), 0);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, a4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFriendsConnection(Parcel parcel) {
        super(8);
        this.f17196d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f17197e = parcel.readInt();
        this.f17198f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFriendsEdge.class.getClassLoader()));
        this.f17199g = parcel.readInt();
        this.f17200h = parcel.readInt();
        this.f17201i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f17202j = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24236a());
        parcel.writeInt(m24238j());
        parcel.writeList(m24239k());
        parcel.writeInt(m24240l());
        parcel.writeInt(m24241m());
        parcel.writeList(m24242n());
        parcel.writeValue(m24243o());
    }
}
