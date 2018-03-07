package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.querybuilder.common.C0684xa39e08da.AggregatedRanges;
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
/* compiled from: location_category */
public final class GraphQLAggregatedEntitiesAtRange extends BaseModel implements TypeModel, AggregatedRanges, GraphQLVisitableModel {
    public static final Creator<GraphQLAggregatedEntitiesAtRange> CREATOR = new C09351();
    public int f16694d;
    public int f16695e;
    public int f16696f;
    public List<GraphQLEntity> f16697g;

    /* compiled from: location_category */
    final class C09351 implements Creator<GraphQLAggregatedEntitiesAtRange> {
        C09351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAggregatedEntitiesAtRange(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAggregatedEntitiesAtRange[i];
        }
    }

    @FieldOffset
    public final int mo2939a() {
        m9949a(0, 0);
        return this.f16694d;
    }

    @FieldOffset
    public final int mo2940b() {
        m9949a(0, 1);
        return this.f16695e;
    }

    @FieldOffset
    public final int mo2941c() {
        m9949a(0, 2);
        return this.f16696f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLEntity> m23586j() {
        this.f16697g = super.m9944a(this.f16697g, 3, GraphQLEntity.class);
        return (ImmutableList) this.f16697g;
    }

    public final int jK_() {
        return 1563462756;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23586j() != null) {
            Builder a = ModelHelper.m23097a(m23586j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLAggregatedEntitiesAtRange) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16697g = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAggregatedEntitiesAtRange() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16694d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f16695e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f16696f = mutableFlatBuffer.m21524a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23586j());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21494a(0, mo2939a(), 0);
        flatBufferBuilder.m21494a(1, mo2940b(), 0);
        flatBufferBuilder.m21494a(2, mo2941c(), 0);
        flatBufferBuilder.m21507b(3, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAggregatedEntitiesAtRange(Parcel parcel) {
        super(5);
        this.f16694d = parcel.readInt();
        this.f16695e = parcel.readInt();
        this.f16696f = parcel.readInt();
        this.f16697g = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEntity.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mo2939a());
        parcel.writeInt(mo2940b());
        parcel.writeInt(mo2941c());
        parcel.writeList(m23586j());
    }

    public GraphQLAggregatedEntitiesAtRange(Builder builder) {
        super(5);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16694d = builder.d;
        this.f16695e = builder.e;
        this.f16696f = builder.f;
        this.f16697g = builder.g;
    }
}
