package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultImageFields;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces$PrivacyIconFields;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: loggedInUser */
public final class GraphQLImage extends BaseModel implements HasProperty, TypeModel, CommonGraphQLInterfaces$DefaultImageFields, GraphQLVisitableModel, PrivacyOptionsGraphQLInterfaces$PrivacyIconFields {
    public static final Creator<GraphQLImage> CREATOR = new C07041();
    public int f16208d;
    @Nullable
    public String f16209e;
    public double f16210f;
    @Nullable
    public String f16211g;
    public int f16212h;
    @Nullable
    private PropertyBag f16213i = null;

    /* compiled from: loggedInUser */
    final class C07041 implements Creator<GraphQLImage> {
        C07041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLImage(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLImage[i];
        }
    }

    @FieldOffset
    public final int mo2923a() {
        m9949a(0, 0);
        return this.f16208d;
    }

    @FieldOffset
    @Nullable
    public final String mo2926d() {
        this.f16209e = super.m9948a(this.f16209e, 1);
        return this.f16209e;
    }

    @FieldOffset
    public final double m23050j() {
        m9949a(0, 2);
        return this.f16210f;
    }

    @FieldOffset
    @Nullable
    public final String mo2924b() {
        this.f16211g = super.m9948a(this.f16211g, 3);
        return this.f16211g;
    }

    @FieldOffset
    public final int mo2925c() {
        m9949a(0, 4);
        return this.f16212h;
    }

    public final int jK_() {
        return 70760763;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLImage() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16208d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f16210f = mutableFlatBuffer.m21523a(i, 2, 0.0d);
        this.f16212h = mutableFlatBuffer.m21524a(i, 4, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2926d());
        int b2 = flatBufferBuilder.m21502b(mo2924b());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21494a(0, mo2923a(), 0);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21492a(2, m23050j(), 0.0d);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21494a(4, mo2925c(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLImage(Parcel parcel) {
        super(6);
        this.f16208d = parcel.readInt();
        this.f16209e = parcel.readString();
        this.f16210f = parcel.readDouble();
        this.f16211g = parcel.readString();
        this.f16212h = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mo2923a());
        parcel.writeString(mo2926d());
        parcel.writeDouble(m23050j());
        parcel.writeString(mo2924b());
        parcel.writeInt(mo2925c());
    }

    public GraphQLImage(Builder builder) {
        super(6);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16208d = builder.d;
        this.f16209e = builder.e;
        this.f16210f = builder.f;
        this.f16211g = builder.g;
        this.f16212h = builder.h;
        this.f16213i = builder.i;
    }

    public final PropertyBag U_() {
        if (this.f16213i == null) {
            this.f16213i = new PropertyBag();
        }
        return this.f16213i;
    }
}
