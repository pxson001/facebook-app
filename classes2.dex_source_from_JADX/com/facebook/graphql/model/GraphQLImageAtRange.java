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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location_area_code */
public final class GraphQLImageAtRange extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLImageAtRange> CREATOR = new C09781();
    @Nullable
    GraphQLEntityWithImage f16698d;
    int f16699e;
    int f16700f;

    /* compiled from: location_area_code */
    final class C09781 implements Creator<GraphQLImageAtRange> {
        C09781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLImageAtRange(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLImageAtRange[i];
        }
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLEntityWithImage m23591a() {
        return m23596j();
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntityWithImage m23596j() {
        this.f16698d = (GraphQLEntityWithImage) super.m9947a(this.f16698d, 0, GraphQLEntityWithImage.class);
        return this.f16698d;
    }

    @FieldOffset
    public final int m23594b() {
        m9949a(0, 1);
        return this.f16699e;
    }

    @FieldOffset
    public final int m23595c() {
        m9949a(0, 2);
        return this.f16700f;
    }

    public final int jK_() {
        return 55835407;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23596j() != null) {
            GraphQLEntityWithImage graphQLEntityWithImage = (GraphQLEntityWithImage) graphQLModelMutatingVisitor.mo2928b(m23596j());
            if (m23596j() != graphQLEntityWithImage) {
                graphQLVisitableModel = (GraphQLImageAtRange) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16698d = graphQLEntityWithImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLImageAtRange() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16699e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f16700f = mutableFlatBuffer.m21524a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23596j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21494a(1, m23594b(), 0);
        flatBufferBuilder.m21494a(2, m23595c(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLImageAtRange(Parcel parcel) {
        super(4);
        this.f16698d = (GraphQLEntityWithImage) parcel.readValue(GraphQLEntityWithImage.class.getClassLoader());
        this.f16699e = parcel.readInt();
        this.f16700f = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m23596j());
        parcel.writeInt(m23594b());
        parcel.writeInt(m23595c());
    }

    public GraphQLImageAtRange(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16698d = builder.d;
        this.f16699e = builder.e;
        this.f16700f = builder.f;
    }
}
