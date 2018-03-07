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
/* compiled from: loom_state */
public final class GraphQLReactorsOfContentConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLReactorsOfContentConnection> CREATOR = new C06911();
    public int f15926d;
    public List<GraphQLReactorsOfContentEdge> f15927e;
    @Nullable
    public GraphQLPageInfo f15928f;

    /* compiled from: loom_state */
    final class C06911 implements Creator<GraphQLReactorsOfContentConnection> {
        C06911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLReactorsOfContentConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLReactorsOfContentConnection[i];
        }
    }

    @FieldOffset
    public final int m22671a() {
        m9949a(0, 0);
        return this.f15926d;
    }

    final void mo2908a(int i) {
        this.f15926d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLReactorsOfContentEdge> m22676j() {
        this.f15927e = super.m9944a(this.f15927e, 1, GraphQLReactorsOfContentEdge.class);
        return (ImmutableList) this.f15927e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22677k() {
        this.f15928f = (GraphQLPageInfo) super.m9947a(this.f15928f, 2, GraphQLPageInfo.class);
        return this.f15928f;
    }

    public final int jK_() {
        return 256909871;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m22676j() != null) {
            Builder a = ModelHelper.m23097a(m22676j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection = (GraphQLReactorsOfContentConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLReactorsOfContentConnection.f15927e = a.m1068b();
                graphQLVisitableModel = graphQLReactorsOfContentConnection;
                if (m22677k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22677k());
                    if (m22677k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLReactorsOfContentConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15928f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22677k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22677k());
            if (m22677k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLReactorsOfContentConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15928f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLReactorsOfContentConnection() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15926d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22676j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22677k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m22671a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLReactorsOfContentConnection(Parcel parcel) {
        super(4);
        this.f15926d = parcel.readInt();
        this.f15927e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLReactorsOfContentEdge.class.getClassLoader()));
        this.f15928f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22671a());
        parcel.writeList(m22676j());
        parcel.writeValue(m22677k());
    }

    public GraphQLReactorsOfContentConnection(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15926d = builder.d;
        this.f15927e = builder.e;
        this.f15928f = builder.f;
    }
}
