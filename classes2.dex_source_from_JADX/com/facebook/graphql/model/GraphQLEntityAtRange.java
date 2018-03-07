package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.querybuilder.common.C0676xf1a7a49c;
import com.facebook.graphql.querybuilder.common.C0683x60b8f875.Ranges;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location/ */
public final class GraphQLEntityAtRange extends BaseModel implements TypeModel, Ranges, GraphQLVisitableModel {
    public static final Creator<GraphQLEntityAtRange> CREATOR = new C08051();
    @Nullable
    GraphQLEntity f16708d;
    int f16709e;
    int f16710f;

    /* compiled from: location/ */
    final class C08051 implements Creator<GraphQLEntityAtRange> {
        C08051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEntityAtRange(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEntityAtRange[i];
        }
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ C0676xf1a7a49c mo2942a() {
        return m23616j();
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLEntity m23615d() {
        return m23616j();
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntity m23616j() {
        this.f16708d = (GraphQLEntity) super.m9947a(this.f16708d, 0, GraphQLEntity.class);
        return this.f16708d;
    }

    @FieldOffset
    public final int mo2943b() {
        m9949a(0, 1);
        return this.f16709e;
    }

    @FieldOffset
    public final int mo2944c() {
        m9949a(0, 2);
        return this.f16710f;
    }

    public final int jK_() {
        return -1024511161;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23616j() != null) {
            GraphQLEntity graphQLEntity = (GraphQLEntity) graphQLModelMutatingVisitor.mo2928b(m23616j());
            if (m23616j() != graphQLEntity) {
                graphQLVisitableModel = (GraphQLEntityAtRange) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16708d = graphQLEntity;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEntityAtRange() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16709e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f16710f = mutableFlatBuffer.m21524a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23616j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21494a(1, mo2943b(), 0);
        flatBufferBuilder.m21494a(2, mo2944c(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEntityAtRange(Parcel parcel) {
        super(4);
        this.f16708d = (GraphQLEntity) parcel.readValue(GraphQLEntity.class.getClassLoader());
        this.f16709e = parcel.readInt();
        this.f16710f = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m23616j());
        parcel.writeInt(mo2943b());
        parcel.writeInt(mo2944c());
    }

    public GraphQLEntityAtRange(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16708d = builder.d;
        this.f16709e = builder.e;
        this.f16710f = builder.f;
    }
}
