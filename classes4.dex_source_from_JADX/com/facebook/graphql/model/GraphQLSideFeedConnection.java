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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: shipping_cost */
public final class GraphQLSideFeedConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSideFeedConnection> CREATOR = new 1();
    public List<GraphQLSideFeedEdge> f2230d;

    @FieldOffset
    public final ImmutableList<GraphQLSideFeedEdge> m2428a() {
        this.f2230d = super.a(this.f2230d, 0, GraphQLSideFeedEdge.class);
        return (ImmutableList) this.f2230d;
    }

    public final int jK_() {
        return -1193470861;
    }

    public final GraphQLVisitableModel m2427a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2428a() != null) {
            Builder a = ModelHelper.a(m2428a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSideFeedConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f2230d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSideFeedConnection() {
        super(2);
    }

    public final int m2426a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2428a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSideFeedConnection(Parcel parcel) {
        super(2);
        this.f2230d = ImmutableListHelper.a(parcel.readArrayList(GraphQLSideFeedEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m2428a());
    }
}
