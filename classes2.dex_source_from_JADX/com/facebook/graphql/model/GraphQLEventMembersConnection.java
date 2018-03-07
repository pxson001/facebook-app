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
/* compiled from: local_default_group */
public final class GraphQLEventMembersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventMembersConnection> CREATOR = new 1();
    int f17103d;
    List<GraphQLEventMembersEdge> f17104e;
    List<GraphQLActor> f17105f;
    @Nullable
    GraphQLPageInfo f17106g;
    int f17107h;
    int f17108i;

    @FieldOffset
    public final int m24115a() {
        m9949a(0, 0);
        return this.f17103d;
    }

    final void mo2908a(int i) {
        this.f17103d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLEventMembersEdge> m24120j() {
        this.f17104e = super.m9944a(this.f17104e, 1, GraphQLEventMembersEdge.class);
        return (ImmutableList) this.f17104e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m24121k() {
        this.f17105f = super.m9944a(this.f17105f, 2, GraphQLActor.class);
        return (ImmutableList) this.f17105f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24122l() {
        this.f17106g = (GraphQLPageInfo) super.m9947a(this.f17106g, 3, GraphQLPageInfo.class);
        return this.f17106g;
    }

    @FieldOffset
    public final int m24123m() {
        m9949a(0, 4);
        return this.f17107h;
    }

    @FieldOffset
    public final int m24124n() {
        m9949a(0, 5);
        return this.f17108i;
    }

    public final int jK_() {
        return -1848764035;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24120j() != null) {
            a = ModelHelper.m23097a(m24120j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEventMembersConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17104e = a.m1068b();
            }
        }
        if (m24121k() != null) {
            a = ModelHelper.m23097a(m24121k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEventMembersConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17105f = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m24122l() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24122l());
            if (m24122l() != graphQLPageInfo) {
                graphQLVisitableModel2 = (GraphQLEventMembersConnection) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17106g = graphQLPageInfo;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLEventMembersConnection() {
        super(7);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17103d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17107h = mutableFlatBuffer.m21524a(i, 4, 0);
        this.f17108i = mutableFlatBuffer.m21524a(i, 5, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24120j());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24121k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24122l());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21494a(0, m24115a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21494a(4, m24123m(), 0);
        flatBufferBuilder.m21494a(5, m24124n(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEventMembersConnection(Parcel parcel) {
        super(7);
        this.f17103d = parcel.readInt();
        this.f17104e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEventMembersEdge.class.getClassLoader()));
        this.f17105f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f17106g = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f17107h = parcel.readInt();
        this.f17108i = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24115a());
        parcel.writeList(m24120j());
        parcel.writeList(m24121k());
        parcel.writeValue(m24122l());
        parcel.writeInt(m24123m());
        parcel.writeInt(m24124n());
    }

    public GraphQLEventMembersConnection(Builder builder) {
        super(7);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17103d = builder.d;
        this.f17104e = builder.e;
        this.f17105f = builder.f;
        this.f17106g = builder.g;
        this.f17107h = builder.h;
        this.f17108i = builder.i;
    }
}
