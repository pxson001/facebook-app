package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
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
/* compiled from: localsell_forsalegroupshome */
public final class GraphQLAlbumsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAlbumsConnection> CREATOR = new 1();
    public List<GraphQLAlbum> f16892d;
    @Nullable
    public GraphQLPageInfo f16893e;

    @FieldOffset
    public final ImmutableList<GraphQLAlbum> m23850a() {
        this.f16892d = super.m9944a(this.f16892d, 0, GraphQLAlbum.class);
        return (ImmutableList) this.f16892d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m23851j() {
        this.f16893e = (GraphQLPageInfo) super.m9947a(this.f16893e, 1, GraphQLPageInfo.class);
        return this.f16893e;
    }

    public final int jK_() {
        return 425288194;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m23850a() != null) {
            Builder a = ModelHelper.m23097a(m23850a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLAlbumsConnection.f16892d = a.m1068b();
                graphQLVisitableModel = graphQLAlbumsConnection;
                if (m23851j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23851j());
                    if (m23851j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLAlbumsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16893e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23851j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23851j());
            if (m23851j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLAlbumsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16893e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLAlbumsConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23850a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23851j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAlbumsConnection(Parcel parcel) {
        super(3);
        this.f16892d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLAlbum.class.getClassLoader()));
        this.f16893e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m23850a());
        parcel.writeValue(m23851j());
    }

    public GraphQLAlbumsConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16892d = builder.d;
        this.f16893e = builder.e;
    }
}
