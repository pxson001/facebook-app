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
/* compiled from: viewer_acts_as_page */
public final class GraphQLDebugFeedConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLDebugFeedConnection> CREATOR = new C00211();
    public List<GraphQLDebugFeedEdge> f222d;
    @Nullable
    public GraphQLPageInfo f223e;

    /* compiled from: viewer_acts_as_page */
    final class C00211 implements Creator<GraphQLDebugFeedConnection> {
        C00211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLDebugFeedConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLDebugFeedConnection[i];
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLDebugFeedEdge> m254a() {
        this.f222d = super.a(this.f222d, 0, GraphQLDebugFeedEdge.class);
        return (ImmutableList) this.f222d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m255j() {
        this.f223e = (GraphQLPageInfo) super.a(this.f223e, 1, GraphQLPageInfo.class);
        return this.f223e;
    }

    public final int jK_() {
        return -1507692497;
    }

    public final GraphQLVisitableModel m253a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m254a() != null) {
            Builder a = ModelHelper.a(m254a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLDebugFeedConnection graphQLDebugFeedConnection = (GraphQLDebugFeedConnection) ModelHelper.a(null, this);
                graphQLDebugFeedConnection.f222d = a.b();
                graphQLVisitableModel = graphQLDebugFeedConnection;
                if (m255j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m255j());
                    if (m255j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLDebugFeedConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f223e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m255j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m255j());
            if (m255j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLDebugFeedConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f223e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLDebugFeedConnection() {
        super(3);
    }

    public final int m252a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m254a());
        int a2 = ModelHelper.a(flatBufferBuilder, m255j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLDebugFeedConnection(Parcel parcel) {
        super(3);
        this.f222d = ImmutableListHelper.a(parcel.readArrayList(GraphQLDebugFeedEdge.class.getClassLoader()));
        this.f223e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m254a());
        parcel.writeValue(m255j());
    }
}
