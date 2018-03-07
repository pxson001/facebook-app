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
/* compiled from: lead_gen_seamless_continued_flow */
public final class GraphQLTopReactionsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTopReactionsConnection> CREATOR = new C07911();
    public List<GraphQLTopReactionsEdge> f17703d;

    /* compiled from: lead_gen_seamless_continued_flow */
    final class C07911 implements Creator<GraphQLTopReactionsConnection> {
        C07911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTopReactionsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTopReactionsConnection[i];
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLTopReactionsEdge> m24899a() {
        this.f17703d = super.m9944a(this.f17703d, 0, GraphQLTopReactionsEdge.class);
        return (ImmutableList) this.f17703d;
    }

    public final int jK_() {
        return 1791249011;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24899a() != null) {
            Builder a = ModelHelper.m23097a(m24899a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTopReactionsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17703d = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTopReactionsConnection() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24899a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTopReactionsConnection(Parcel parcel) {
        super(2);
        this.f17703d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTopReactionsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24899a());
    }

    public GraphQLTopReactionsConnection(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17703d = builder.d;
    }
}
