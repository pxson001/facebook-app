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
/* compiled from: lte_info */
public final class GraphQLSubstoriesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSubstoriesConnection> CREATOR = new C06821();
    int f15867d;
    List<GraphQLStory> f15868e;
    @Nullable
    GraphQLPageInfo f15869f;
    int f15870g;

    /* compiled from: lte_info */
    final class C06821 implements Creator<GraphQLSubstoriesConnection> {
        C06821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSubstoriesConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSubstoriesConnection[i];
        }
    }

    @FieldOffset
    public final int m22604a() {
        m9949a(0, 0);
        return this.f15867d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStory> m22608j() {
        this.f15868e = super.m9944a(this.f15868e, 2, GraphQLStory.class);
        return (ImmutableList) this.f15868e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22609k() {
        this.f15869f = (GraphQLPageInfo) super.m9947a(this.f15869f, 3, GraphQLPageInfo.class);
        return this.f15869f;
    }

    @FieldOffset
    public final int m22610l() {
        m9949a(0, 4);
        return this.f15870g;
    }

    public final int jK_() {
        return 1571057009;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m22608j() != null) {
            Builder a = ModelHelper.m23097a(m22608j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLSubstoriesConnection graphQLSubstoriesConnection = (GraphQLSubstoriesConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLSubstoriesConnection.f15868e = a.m1068b();
                graphQLVisitableModel = graphQLSubstoriesConnection;
                if (m22609k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22609k());
                    if (m22609k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLSubstoriesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15869f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22609k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22609k());
            if (m22609k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLSubstoriesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15869f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLSubstoriesConnection() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15867d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f15870g = mutableFlatBuffer.m21524a(i, 4, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22608j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22609k());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21494a(0, m22604a(), 0);
        flatBufferBuilder.m21507b(2, a);
        flatBufferBuilder.m21507b(3, a2);
        flatBufferBuilder.m21494a(4, m22610l(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSubstoriesConnection(Parcel parcel) {
        super(6);
        this.f15867d = parcel.readInt();
        this.f15868e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStory.class.getClassLoader()));
        this.f15869f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f15870g = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22604a());
        parcel.writeList(m22608j());
        parcel.writeValue(m22609k());
        parcel.writeInt(m22610l());
    }

    public GraphQLSubstoriesConnection(Builder builder) {
        super(6);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15867d = builder.d;
        this.f15868e = builder.e;
        this.f15869f = builder.f;
        this.f15870g = builder.g;
    }
}
