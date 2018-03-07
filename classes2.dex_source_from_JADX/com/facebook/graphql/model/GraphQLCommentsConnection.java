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
/* compiled from: low_memory_optimization_threshold_mb */
public final class GraphQLCommentsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLCommentsConnection> CREATOR = new C06891();
    public int f15920d;
    public List<GraphQLComment> f15921e;
    @Nullable
    public GraphQLPageInfo f15922f;

    /* compiled from: low_memory_optimization_threshold_mb */
    final class C06891 implements Creator<GraphQLCommentsConnection> {
        C06891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLCommentsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLCommentsConnection[i];
        }
    }

    @FieldOffset
    public final int m22656a() {
        m9949a(0, 0);
        return this.f15920d;
    }

    final void mo2908a(int i) {
        this.f15920d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLComment> m22661j() {
        this.f15921e = super.m9944a(this.f15921e, 1, GraphQLComment.class);
        return (ImmutableList) this.f15921e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22662k() {
        this.f15922f = (GraphQLPageInfo) super.m9947a(this.f15922f, 2, GraphQLPageInfo.class);
        return this.f15922f;
    }

    public final int jK_() {
        return -100920302;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m22661j() != null) {
            Builder a = ModelHelper.m23097a(m22661j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLCommentsConnection graphQLCommentsConnection = (GraphQLCommentsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLCommentsConnection.f15921e = a.m1068b();
                graphQLVisitableModel = graphQLCommentsConnection;
                if (m22662k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22662k());
                    if (m22662k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLCommentsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15922f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22662k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22662k());
            if (m22662k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLCommentsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15922f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLCommentsConnection() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15920d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22661j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22662k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m22656a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLCommentsConnection(Parcel parcel) {
        super(4);
        this.f15920d = parcel.readInt();
        this.f15921e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLComment.class.getClassLoader()));
        this.f15922f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22656a());
        parcel.writeList(m22661j());
        parcel.writeValue(m22662k());
    }

    public GraphQLCommentsConnection(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15920d = builder.d;
        this.f15921e = builder.e;
        this.f15922f = builder.f;
    }
}
