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
/* compiled from: original_calling_class */
public final class GraphQLEventInviteesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventInviteesConnection> CREATOR = new 1();
    int f5903d;
    List<GraphQLEventInviteesEdge> f5904e;
    List<GraphQLActor> f5905f;
    @Nullable
    GraphQLPageInfo f5906g;
    int f5907h;
    int f5908i;

    @FieldOffset
    public final int m6359a() {
        a(0, 0);
        return this.f5903d;
    }

    final void m6362a(int i) {
        this.f5903d = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLEventInviteesEdge> m6364j() {
        this.f5904e = super.a(this.f5904e, 1, GraphQLEventInviteesEdge.class);
        return (ImmutableList) this.f5904e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m6365k() {
        this.f5905f = super.a(this.f5905f, 2, GraphQLActor.class);
        return (ImmutableList) this.f5905f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m6366l() {
        this.f5906g = (GraphQLPageInfo) super.a(this.f5906g, 3, GraphQLPageInfo.class);
        return this.f5906g;
    }

    @FieldOffset
    public final int m6367m() {
        a(0, 4);
        return this.f5907h;
    }

    @FieldOffset
    public final int m6368n() {
        a(0, 5);
        return this.f5908i;
    }

    public final int jK_() {
        return -477813809;
    }

    public final GraphQLVisitableModel m6361a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6364j() != null) {
            a = ModelHelper.a(m6364j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEventInviteesConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f5904e = a.b();
            }
        }
        if (m6365k() != null) {
            a = ModelHelper.a(m6365k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEventInviteesConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f5905f = a.b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m6366l() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m6366l());
            if (m6366l() != graphQLPageInfo) {
                graphQLVisitableModel2 = (GraphQLEventInviteesConnection) ModelHelper.a(graphQLVisitableModel2, this);
                graphQLVisitableModel2.f5906g = graphQLPageInfo;
            }
        }
        i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLEventInviteesConnection() {
        super(7);
    }

    public final void m6363a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f5903d = mutableFlatBuffer.a(i, 0, 0);
        this.f5907h = mutableFlatBuffer.a(i, 4, 0);
        this.f5908i = mutableFlatBuffer.a(i, 5, 0);
    }

    public final int m6360a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6364j());
        int a2 = ModelHelper.a(flatBufferBuilder, m6365k());
        int a3 = ModelHelper.a(flatBufferBuilder, m6366l());
        flatBufferBuilder.c(6);
        flatBufferBuilder.a(0, m6359a(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.a(4, m6367m(), 0);
        flatBufferBuilder.a(5, m6368n(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventInviteesConnection(Parcel parcel) {
        super(7);
        this.f5903d = parcel.readInt();
        this.f5904e = ImmutableListHelper.a(parcel.readArrayList(GraphQLEventInviteesEdge.class.getClassLoader()));
        this.f5905f = ImmutableListHelper.a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f5906g = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f5907h = parcel.readInt();
        this.f5908i = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m6359a());
        parcel.writeList(m6364j());
        parcel.writeList(m6365k());
        parcel.writeValue(m6366l());
        parcel.writeInt(m6367m());
        parcel.writeInt(m6368n());
    }
}
