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
/* compiled from: local_group_did_pin */
public final class GraphQLGoodwillThrowbackDataPointsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackDataPointsConnection> CREATOR = new 1();
    public List<GraphQLGoodwillThrowbackDataPoint> f17096d;

    @FieldOffset
    public final ImmutableList<GraphQLGoodwillThrowbackDataPoint> m24100a() {
        this.f17096d = super.m9944a(this.f17096d, 0, GraphQLGoodwillThrowbackDataPoint.class);
        return (ImmutableList) this.f17096d;
    }

    public final int jK_() {
        return 608055401;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24100a() != null) {
            Builder a = ModelHelper.m23097a(m24100a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackDataPointsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17096d = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackDataPointsConnection() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24100a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGoodwillThrowbackDataPointsConnection(Parcel parcel) {
        super(2);
        this.f17096d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLGoodwillThrowbackDataPoint.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24100a());
    }
}
