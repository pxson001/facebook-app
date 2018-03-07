package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: locally_updated_containing_collection_id */
public final class GraphQLCurrencyQuantity extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLCurrencyQuantity> CREATOR = new 1();
    @Deprecated
    public double f16906d;
    @Deprecated
    public int f16907e;
    @Nullable
    public String f16908f;
    @Nullable
    public String f16909g;
    public int f16910h;
    @Nullable
    public String f16911i;

    @FieldOffset
    public final double m23878a() {
        m9949a(0, 0);
        return this.f16906d;
    }

    @FieldOffset
    public final int m23882j() {
        m9949a(0, 1);
        return this.f16907e;
    }

    @FieldOffset
    @Nullable
    public final String m23883k() {
        this.f16908f = super.m9948a(this.f16908f, 2);
        return this.f16908f;
    }

    @FieldOffset
    @Nullable
    public final String m23884l() {
        this.f16909g = super.m9948a(this.f16909g, 3);
        return this.f16909g;
    }

    @FieldOffset
    public final int m23885m() {
        m9949a(0, 4);
        return this.f16910h;
    }

    @FieldOffset
    @Nullable
    public final String m23886n() {
        this.f16911i = super.m9948a(this.f16911i, 5);
        return this.f16911i;
    }

    public final int jK_() {
        return 753818588;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLCurrencyQuantity() {
        super(7);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16906d = mutableFlatBuffer.m21523a(i, 0, 0.0d);
        this.f16907e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f16910h = mutableFlatBuffer.m21524a(i, 4, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23883k());
        int b2 = flatBufferBuilder.m21502b(m23884l());
        int b3 = flatBufferBuilder.m21502b(m23886n());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21492a(0, m23878a(), 0.0d);
        flatBufferBuilder.m21494a(1, m23882j(), 0);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21494a(4, m23885m(), 0);
        flatBufferBuilder.m21507b(5, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLCurrencyQuantity(Parcel parcel) {
        super(7);
        this.f16906d = parcel.readDouble();
        this.f16907e = parcel.readInt();
        this.f16908f = parcel.readString();
        this.f16909g = parcel.readString();
        this.f16910h = parcel.readInt();
        this.f16911i = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(m23878a());
        parcel.writeInt(m23882j());
        parcel.writeString(m23883k());
        parcel.writeString(m23884l());
        parcel.writeInt(m23885m());
        parcel.writeString(m23886n());
    }

    public GraphQLCurrencyQuantity(Builder builder) {
        super(7);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16906d = builder.d;
        this.f16907e = builder.e;
        this.f16908f = builder.f;
        this.f16909g = builder.g;
        this.f16910h = builder.h;
        this.f16911i = builder.i;
    }
}
