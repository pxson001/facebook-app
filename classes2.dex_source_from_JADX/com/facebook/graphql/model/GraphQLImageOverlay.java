package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: location_list */
public final class GraphQLImageOverlay extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLImageOverlay> CREATOR = new 1();
    @Nullable
    GraphQLObjectType f16672d;
    List<GraphQLProfile> f16673e;
    @Nullable
    String f16674f;
    @Nullable
    GraphQLImage f16675g;

    @Nullable
    public final GraphQLObjectType m23546j() {
        if (this.f5823b != null && this.f16672d == null) {
            this.f16672d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16672d == null || this.f16672d.m22301g() != 0) {
            return this.f16672d;
        }
        return null;
    }

    @FieldOffset
    public final ImmutableList<GraphQLProfile> m23547k() {
        this.f16673e = super.m9944a(this.f16673e, 1, GraphQLProfile.class);
        return (ImmutableList) this.f16673e;
    }

    @FieldOffset
    @Nullable
    public final String m23548l() {
        this.f16674f = super.m9948a(this.f16674f, 2);
        return this.f16674f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23549m() {
        this.f16675g = (GraphQLImage) super.m9947a(this.f16675g, 3, GraphQLImage.class);
        return this.f16675g;
    }

    @Nullable
    public final String mo2834a() {
        return m23548l();
    }

    public final int jK_() {
        return -328705387;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLImage graphQLImage;
        m9958h();
        if (m23547k() != null) {
            Builder a = ModelHelper.m23097a(m23547k(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLImageOverlay graphQLImageOverlay = (GraphQLImageOverlay) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLImageOverlay.f16673e = a.m1068b();
                graphQLVisitableModel = graphQLImageOverlay;
                if (m23549m() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23549m());
                    if (m23549m() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLImageOverlay) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16675g = graphQLImage;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23549m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23549m());
            if (m23549m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLImageOverlay) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16675g = graphQLImage;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLImageOverlay() {
        super(5);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m23546j() != null ? m23546j().m22299e() : null);
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m23547k());
        int b = flatBufferBuilder.m21502b(m23548l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23549m());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, a3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLImageOverlay(Parcel parcel) {
        super(5);
        this.f16673e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLProfile.class.getClassLoader()));
        this.f16674f = parcel.readString();
        this.f16675g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16672d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m23547k());
        parcel.writeString(m23548l());
        parcel.writeValue(m23549m());
        parcel.writeParcelable(this.f16672d, i);
    }

    public GraphQLImageOverlay(Builder builder) {
        super(5);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16673e = builder.d;
        this.f16674f = builder.e;
        this.f16675g = builder.f;
        this.f16672d = builder.g;
    }
}
