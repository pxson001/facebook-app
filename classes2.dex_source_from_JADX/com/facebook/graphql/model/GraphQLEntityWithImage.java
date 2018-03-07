package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: fetch_payment_pin_status */
public final class GraphQLEntityWithImage extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLEntityWithImage> CREATOR = new C09791();
    @Nullable
    public GraphQLObjectType f23981d;
    @Nullable
    public String f23982e;
    @Nullable
    public GraphQLImage f23983f;

    /* compiled from: fetch_payment_pin_status */
    final class C09791 implements Creator<GraphQLEntityWithImage> {
        C09791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEntityWithImage(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEntityWithImage[i];
        }
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLImage m32372b() {
        return m32375l();
    }

    @Nullable
    public final GraphQLObjectType m32373j() {
        if (this.f5823b != null && this.f23981d == null) {
            this.f23981d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f23981d == null || this.f23981d.m22301g() != 0) {
            return this.f23981d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m32374k() {
        this.f23982e = super.m9948a(this.f23982e, 1);
        return this.f23982e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m32375l() {
        this.f23983f = (GraphQLImage) super.m9947a(this.f23983f, 2, GraphQLImage.class);
        return this.f23983f;
    }

    @Nullable
    public final String mo2834a() {
        return m32374k();
    }

    public final int jK_() {
        return 463681394;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m32375l() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m32375l());
            if (m32375l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEntityWithImage) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f23983f = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEntityWithImage() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m32373j() != null ? m32373j().m22299e() : null);
        int b = flatBufferBuilder.m21502b(m32374k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m32375l());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEntityWithImage(Parcel parcel) {
        super(4);
        this.f23982e = parcel.readString();
        this.f23983f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f23981d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m32374k());
        parcel.writeValue(m32375l());
        parcel.writeParcelable(this.f23981d, i);
    }

    public GraphQLEntityWithImage(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f23982e = builder.d;
        this.f23983f = builder.e;
        this.f23981d = builder.f;
    }
}
