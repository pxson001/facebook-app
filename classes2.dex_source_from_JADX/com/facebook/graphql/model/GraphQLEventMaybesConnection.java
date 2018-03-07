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
/* compiled from: loading_indicator_allowed_delta_ms */
public final class GraphQLEventMaybesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventMaybesConnection> CREATOR = new 1();
    int f17185d;
    List<GraphQLEventMaybesEdge> f17186e;
    @Nullable
    GraphQLPageInfo f17187f;
    int f17188g;
    int f17189h;

    @FieldOffset
    public final int m24215a() {
        m9949a(0, 0);
        return this.f17185d;
    }

    final void mo2908a(int i) {
        this.f17185d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLEventMaybesEdge> m24220j() {
        this.f17186e = super.m9944a(this.f17186e, 1, GraphQLEventMaybesEdge.class);
        return (ImmutableList) this.f17186e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24221k() {
        this.f17187f = (GraphQLPageInfo) super.m9947a(this.f17187f, 2, GraphQLPageInfo.class);
        return this.f17187f;
    }

    @FieldOffset
    public final int m24222l() {
        m9949a(0, 3);
        return this.f17188g;
    }

    @FieldOffset
    public final int m24223m() {
        m9949a(0, 4);
        return this.f17189h;
    }

    public final int jK_() {
        return 2065431779;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m24220j() != null) {
            Builder a = ModelHelper.m23097a(m24220j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLEventMaybesConnection graphQLEventMaybesConnection = (GraphQLEventMaybesConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLEventMaybesConnection.f17186e = a.m1068b();
                graphQLVisitableModel = graphQLEventMaybesConnection;
                if (m24221k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24221k());
                    if (m24221k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLEventMaybesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17187f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24221k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24221k());
            if (m24221k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLEventMaybesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17187f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLEventMaybesConnection() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17185d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17188g = mutableFlatBuffer.m21524a(i, 3, 0);
        this.f17189h = mutableFlatBuffer.m21524a(i, 4, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24220j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24221k());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21494a(0, m24215a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21494a(3, m24222l(), 0);
        flatBufferBuilder.m21494a(4, m24223m(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEventMaybesConnection(Parcel parcel) {
        super(6);
        this.f17185d = parcel.readInt();
        this.f17186e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEventMaybesEdge.class.getClassLoader()));
        this.f17187f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f17188g = parcel.readInt();
        this.f17189h = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24215a());
        parcel.writeList(m24220j());
        parcel.writeValue(m24221k());
        parcel.writeInt(m24222l());
        parcel.writeInt(m24223m());
    }

    public GraphQLEventMaybesConnection(Builder builder) {
        super(6);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17185d = builder.d;
        this.f17186e = builder.e;
        this.f17187f = builder.f;
        this.f17188g = builder.g;
        this.f17189h = builder.h;
    }
}
