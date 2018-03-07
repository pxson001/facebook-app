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
import com.facebook.graphql.querybuilder.common.C0683x60b8f875;
import com.facebook.graphql.querybuilder.common.C0684xa39e08da;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces$DefaultTextWithEntitiesFields;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: low_pri_ineedinits_disable */
public final class GraphQLTextWithEntities extends BaseModel implements TypeModel, TextWithEntitiesGraphQLInterfaces$DefaultTextWithEntitiesFields, C0683x60b8f875, C0684xa39e08da, GraphQLVisitableModel {
    public static final Creator<GraphQLTextWithEntities> CREATOR = new C06851();
    List<GraphQLAggregatedEntitiesAtRange> f15878d;
    List<GraphQLImageAtRange> f15879e;
    List<GraphQLInlineStyleAtRange> f15880f;
    List<GraphQLEntityAtRange> f15881g;
    @Nullable
    String f15882h;
    @Nullable
    String f15883i;

    /* compiled from: low_pri_ineedinits_disable */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f15872d;
        public ImmutableList<GraphQLAggregatedEntitiesAtRange> f15873e;
        public ImmutableList<GraphQLImageAtRange> f15874f;
        public ImmutableList<GraphQLInlineStyleAtRange> f15875g;
        public ImmutableList<GraphQLEntityAtRange> f15876h;
        @Nullable
        public String f15877i;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public static Builder m22612a(GraphQLTextWithEntities graphQLTextWithEntities) {
            com.facebook.graphql.modelutil.BaseModel.Builder builder = new Builder();
            graphQLTextWithEntities.m9958h();
            builder.f15872d = graphQLTextWithEntities.m22621k();
            builder.f15873e = graphQLTextWithEntities.mo2913c();
            builder.f15874f = graphQLTextWithEntities.m22619d();
            builder.f15875g = graphQLTextWithEntities.m22620j();
            builder.f15876h = graphQLTextWithEntities.mo2912b();
            builder.f15877i = graphQLTextWithEntities.mo2911a();
            com.facebook.graphql.modelutil.BaseModel.Builder.m22419a(builder, graphQLTextWithEntities);
            return builder;
        }

        public final GraphQLTextWithEntities m22613a() {
            return new GraphQLTextWithEntities(this);
        }
    }

    /* compiled from: low_pri_ineedinits_disable */
    final class C06851 implements Creator<GraphQLTextWithEntities> {
        C06851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTextWithEntities(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTextWithEntities[i];
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLAggregatedEntitiesAtRange> mo2913c() {
        this.f15878d = super.m9944a(this.f15878d, 0, GraphQLAggregatedEntitiesAtRange.class);
        return (ImmutableList) this.f15878d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImageAtRange> m22619d() {
        this.f15879e = super.m9944a(this.f15879e, 1, GraphQLImageAtRange.class);
        return (ImmutableList) this.f15879e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLInlineStyleAtRange> m22620j() {
        this.f15880f = super.m9944a(this.f15880f, 2, GraphQLInlineStyleAtRange.class);
        return (ImmutableList) this.f15880f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLEntityAtRange> mo2912b() {
        this.f15881g = super.m9944a(this.f15881g, 3, GraphQLEntityAtRange.class);
        return (ImmutableList) this.f15881g;
    }

    @FieldOffset
    @Nullable
    public final String mo2911a() {
        this.f15882h = super.m9948a(this.f15882h, 4);
        return this.f15882h;
    }

    @FieldOffset
    @Nullable
    public final String m22621k() {
        this.f15883i = super.m9948a(this.f15883i, 5);
        return this.f15883i;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        com.google.common.collect.ImmutableList.Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (mo2913c() != null) {
            a = ModelHelper.m23097a(mo2913c(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTextWithEntities) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15878d = a.m1068b();
            }
        }
        if (m22619d() != null) {
            a = ModelHelper.m23097a(m22619d(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTextWithEntities) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15879e = a.m1068b();
            }
        }
        if (m22620j() != null) {
            a = ModelHelper.m23097a(m22620j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTextWithEntities) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15880f = a.m1068b();
            }
        }
        if (mo2912b() != null) {
            a = ModelHelper.m23097a(mo2912b(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTextWithEntities) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15881g = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTextWithEntities() {
        super(7);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, mo2913c());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m22619d());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m22620j());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, mo2912b());
        int b = flatBufferBuilder.m21502b(mo2911a());
        int b2 = flatBufferBuilder.m21502b(m22621k());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21507b(5, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTextWithEntities(Parcel parcel) {
        super(7);
        this.f15883i = parcel.readString();
        this.f15878d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLAggregatedEntitiesAtRange.class.getClassLoader()));
        this.f15879e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLImageAtRange.class.getClassLoader()));
        this.f15880f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLInlineStyleAtRange.class.getClassLoader()));
        this.f15881g = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEntityAtRange.class.getClassLoader()));
        this.f15882h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22621k());
        parcel.writeList(mo2913c());
        parcel.writeList(m22619d());
        parcel.writeList(m22620j());
        parcel.writeList(mo2912b());
        parcel.writeString(mo2911a());
    }

    public GraphQLTextWithEntities(Builder builder) {
        super(7);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15883i = builder.f15872d;
        this.f15878d = builder.f15873e;
        this.f15879e = builder.f15874f;
        this.f15880f = builder.f15875g;
        this.f15881g = builder.f15876h;
        this.f15882h = builder.f15877i;
    }
}
