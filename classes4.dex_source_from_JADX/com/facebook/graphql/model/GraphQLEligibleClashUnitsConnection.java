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
/* compiled from: ship_date */
public final class GraphQLEligibleClashUnitsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEligibleClashUnitsConnection> CREATOR = new 1();
    public List<GraphQLEligibleClashUnitsEdge> f2232d;

    @FieldOffset
    public final ImmutableList<GraphQLEligibleClashUnitsEdge> m2434a() {
        this.f2232d = super.a(this.f2232d, 0, GraphQLEligibleClashUnitsEdge.class);
        return (ImmutableList) this.f2232d;
    }

    public final int jK_() {
        return -1588983017;
    }

    public final GraphQLVisitableModel m2433a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2434a() != null) {
            Builder a = ModelHelper.a(m2434a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEligibleClashUnitsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f2232d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEligibleClashUnitsConnection() {
        super(2);
    }

    public final int m2432a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2434a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEligibleClashUnitsConnection(Parcel parcel) {
        super(2);
        this.f2232d = ImmutableListHelper.a(parcel.readArrayList(GraphQLEligibleClashUnitsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m2434a());
    }
}
