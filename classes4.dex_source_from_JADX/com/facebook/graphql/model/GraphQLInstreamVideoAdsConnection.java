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
/* compiled from: shipment_id */
public final class GraphQLInstreamVideoAdsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLInstreamVideoAdsConnection> CREATOR = new 1();
    public List<GraphQLStory> f2231d;

    @FieldOffset
    public final ImmutableList<GraphQLStory> m2431a() {
        this.f2231d = super.a(this.f2231d, 0, GraphQLStory.class);
        return (ImmutableList) this.f2231d;
    }

    public final int jK_() {
        return -1224070952;
    }

    public final GraphQLVisitableModel m2430a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2431a() != null) {
            Builder a = ModelHelper.a(m2431a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLInstreamVideoAdsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f2231d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLInstreamVideoAdsConnection() {
        super(2);
    }

    public final int m2429a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2431a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLInstreamVideoAdsConnection(Parcel parcel) {
        super(2);
        this.f2231d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStory.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m2431a());
    }
}
