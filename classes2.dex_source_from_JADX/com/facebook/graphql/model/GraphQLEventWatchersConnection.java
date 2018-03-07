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
/* compiled from: loaded  */
public final class GraphQLEventWatchersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventWatchersConnection> CREATOR = new 1();
    int f17190d;
    List<GraphQLEventWatchersEdge> f17191e;
    List<GraphQLActor> f17192f;
    @Nullable
    GraphQLPageInfo f17193g;
    int f17194h;
    int f17195i;

    @FieldOffset
    public final int m24224a() {
        m9949a(0, 0);
        return this.f17190d;
    }

    final void mo2908a(int i) {
        this.f17190d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLEventWatchersEdge> m24229j() {
        this.f17191e = super.m9944a(this.f17191e, 1, GraphQLEventWatchersEdge.class);
        return (ImmutableList) this.f17191e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m24230k() {
        this.f17192f = super.m9944a(this.f17192f, 2, GraphQLActor.class);
        return (ImmutableList) this.f17192f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24231l() {
        this.f17193g = (GraphQLPageInfo) super.m9947a(this.f17193g, 3, GraphQLPageInfo.class);
        return this.f17193g;
    }

    @FieldOffset
    public final int m24232m() {
        m9949a(0, 4);
        return this.f17194h;
    }

    @FieldOffset
    public final int m24233n() {
        m9949a(0, 5);
        return this.f17195i;
    }

    public final int jK_() {
        return 2050421903;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24229j() != null) {
            a = ModelHelper.m23097a(m24229j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEventWatchersConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17191e = a.m1068b();
            }
        }
        if (m24230k() != null) {
            a = ModelHelper.m23097a(m24230k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEventWatchersConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17192f = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m24231l() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24231l());
            if (m24231l() != graphQLPageInfo) {
                graphQLVisitableModel2 = (GraphQLEventWatchersConnection) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17193g = graphQLPageInfo;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLEventWatchersConnection() {
        super(7);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17190d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17194h = mutableFlatBuffer.m21524a(i, 4, 0);
        this.f17195i = mutableFlatBuffer.m21524a(i, 5, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24229j());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24230k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24231l());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21494a(0, m24224a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21494a(4, m24232m(), 0);
        flatBufferBuilder.m21494a(5, m24233n(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEventWatchersConnection(Parcel parcel) {
        super(7);
        this.f17190d = parcel.readInt();
        this.f17191e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEventWatchersEdge.class.getClassLoader()));
        this.f17192f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f17193g = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f17194h = parcel.readInt();
        this.f17195i = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24224a());
        parcel.writeList(m24229j());
        parcel.writeList(m24230k());
        parcel.writeValue(m24231l());
        parcel.writeInt(m24232m());
        parcel.writeInt(m24233n());
    }

    public GraphQLEventWatchersConnection(Builder builder) {
        super(7);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17190d = builder.d;
        this.f17191e = builder.e;
        this.f17192f = builder.f;
        this.f17193g = builder.g;
        this.f17194h = builder.h;
        this.f17195i = builder.i;
    }
}
