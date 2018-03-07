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
/* compiled from: limit_friend_requests */
public final class GraphQLQuestionOptionsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuestionOptionsConnection> CREATOR = new 1();
    public List<GraphQLQuestionOption> f17489d;

    @FieldOffset
    public final ImmutableList<GraphQLQuestionOption> m24605a() {
        this.f17489d = super.m9944a(this.f17489d, 0, GraphQLQuestionOption.class);
        return (ImmutableList) this.f17489d;
    }

    public final int jK_() {
        return -503668554;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24605a() != null) {
            Builder a = ModelHelper.m23097a(m24605a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLQuestionOptionsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17489d = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLQuestionOptionsConnection() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24605a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLQuestionOptionsConnection(Parcel parcel) {
        super(2);
        this.f17489d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLQuestionOption.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24605a());
    }

    public GraphQLQuestionOptionsConnection(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17489d = builder.d;
    }
}
