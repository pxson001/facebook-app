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
/* compiled from: lead_gen_require_continued_flow */
public final class GraphQLStoryTopicsContext extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStoryTopicsContext> CREATOR = new 1();
    public List<GraphQLTopic> f17704d;
    public List<GraphQLTopic> f17705e;

    @FieldOffset
    public final ImmutableList<GraphQLTopic> m24902a() {
        this.f17704d = super.m9944a(this.f17704d, 0, GraphQLTopic.class);
        return (ImmutableList) this.f17704d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTopic> m24903j() {
        this.f17705e = super.m9944a(this.f17705e, 1, GraphQLTopic.class);
        return (ImmutableList) this.f17705e;
    }

    public final int jK_() {
        return 1741557014;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24902a() != null) {
            a = ModelHelper.m23097a(m24902a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLStoryTopicsContext) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17704d = a.m1068b();
            }
        }
        if (m24903j() != null) {
            a = ModelHelper.m23097a(m24903j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLStoryTopicsContext) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17705e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStoryTopicsContext() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24902a());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24903j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStoryTopicsContext(Parcel parcel) {
        super(3);
        this.f17704d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTopic.class.getClassLoader()));
        this.f17705e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTopic.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24902a());
        parcel.writeList(m24903j());
    }
}
