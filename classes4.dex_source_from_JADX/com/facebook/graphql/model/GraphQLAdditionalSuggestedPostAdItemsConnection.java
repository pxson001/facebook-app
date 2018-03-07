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
/* compiled from: should not run on UI thread */
public final class GraphQLAdditionalSuggestedPostAdItemsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAdditionalSuggestedPostAdItemsConnection> CREATOR = new 1();
    public List<GraphQLAdditionalSuggestedPostAdItemsEdge> f2205d;
    @Nullable
    public GraphQLPageInfo f2206e;

    @FieldOffset
    public final ImmutableList<GraphQLAdditionalSuggestedPostAdItemsEdge> m2388a() {
        this.f2205d = super.a(this.f2205d, 0, GraphQLAdditionalSuggestedPostAdItemsEdge.class);
        return (ImmutableList) this.f2205d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m2389j() {
        this.f2206e = (GraphQLPageInfo) super.a(this.f2206e, 1, GraphQLPageInfo.class);
        return this.f2206e;
    }

    public final int jK_() {
        return -1355611617;
    }

    public final GraphQLVisitableModel m2387a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m2388a() != null) {
            Builder a = ModelHelper.a(m2388a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLAdditionalSuggestedPostAdItemsConnection graphQLAdditionalSuggestedPostAdItemsConnection = (GraphQLAdditionalSuggestedPostAdItemsConnection) ModelHelper.a(null, this);
                graphQLAdditionalSuggestedPostAdItemsConnection.f2205d = a.b();
                graphQLVisitableModel = graphQLAdditionalSuggestedPostAdItemsConnection;
                if (m2389j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m2389j());
                    if (m2389j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLAdditionalSuggestedPostAdItemsConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2206e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m2389j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m2389j());
            if (m2389j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLAdditionalSuggestedPostAdItemsConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2206e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLAdditionalSuggestedPostAdItemsConnection() {
        super(3);
    }

    public final int m2386a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2388a());
        int a2 = ModelHelper.a(flatBufferBuilder, m2389j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAdditionalSuggestedPostAdItemsConnection(Parcel parcel) {
        super(3);
        this.f2205d = ImmutableListHelper.a(parcel.readArrayList(GraphQLAdditionalSuggestedPostAdItemsEdge.class.getClassLoader()));
        this.f2206e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m2388a());
        parcel.writeValue(m2389j());
    }
}
