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
/* compiled from: install_action */
public final class GraphQLFaceBoxTagSuggestionsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFaceBoxTagSuggestionsConnection> CREATOR = new 1();
    public List<GraphQLFaceBoxTagSuggestionsEdge> f19817d;

    @FieldOffset
    public final ImmutableList<GraphQLFaceBoxTagSuggestionsEdge> m27538a() {
        this.f19817d = super.m9944a(this.f19817d, 0, GraphQLFaceBoxTagSuggestionsEdge.class);
        return (ImmutableList) this.f19817d;
    }

    public final int jK_() {
        return -1652092959;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27538a() != null) {
            Builder a = ModelHelper.m23097a(m27538a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLFaceBoxTagSuggestionsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19817d = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFaceBoxTagSuggestionsConnection() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m27538a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFaceBoxTagSuggestionsConnection(Parcel parcel) {
        super(2);
        this.f19817d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFaceBoxTagSuggestionsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m27538a());
    }

    public GraphQLFaceBoxTagSuggestionsConnection(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19817d = builder.d;
    }
}
