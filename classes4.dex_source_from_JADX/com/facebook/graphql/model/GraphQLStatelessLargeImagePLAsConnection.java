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
/* compiled from: shoerack_invitation */
public final class GraphQLStatelessLargeImagePLAsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStatelessLargeImagePLAsConnection> CREATOR = new 1();
    public List<GraphQLStatelessLargeImagePLAsEdge> f2222d;
    @Nullable
    public GraphQLPageInfo f2223e;

    @FieldOffset
    public final ImmutableList<GraphQLStatelessLargeImagePLAsEdge> m2415a() {
        this.f2222d = super.a(this.f2222d, 0, GraphQLStatelessLargeImagePLAsEdge.class);
        return (ImmutableList) this.f2222d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m2416j() {
        this.f2223e = (GraphQLPageInfo) super.a(this.f2223e, 1, GraphQLPageInfo.class);
        return this.f2223e;
    }

    public final int jK_() {
        return 1600803670;
    }

    public final GraphQLVisitableModel m2414a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m2415a() != null) {
            Builder a = ModelHelper.a(m2415a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLStatelessLargeImagePLAsConnection graphQLStatelessLargeImagePLAsConnection = (GraphQLStatelessLargeImagePLAsConnection) ModelHelper.a(null, this);
                graphQLStatelessLargeImagePLAsConnection.f2222d = a.b();
                graphQLVisitableModel = graphQLStatelessLargeImagePLAsConnection;
                if (m2416j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m2416j());
                    if (m2416j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLStatelessLargeImagePLAsConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2223e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m2416j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m2416j());
            if (m2416j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLStatelessLargeImagePLAsConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2223e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLStatelessLargeImagePLAsConnection() {
        super(3);
    }

    public final int m2413a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2415a());
        int a2 = ModelHelper.a(flatBufferBuilder, m2416j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLStatelessLargeImagePLAsConnection(Parcel parcel) {
        super(3);
        this.f2222d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStatelessLargeImagePLAsEdge.class.getClassLoader()));
        this.f2223e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m2415a());
        parcel.writeValue(m2416j());
    }
}
