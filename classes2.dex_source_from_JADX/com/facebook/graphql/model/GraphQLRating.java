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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: limit is negative */
public final class GraphQLRating extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLRating> CREATOR = new 1();
    public int f17490d;
    public int f17491e;
    public double f17492f;

    @FieldOffset
    public final int m24606a() {
        m9949a(0, 0);
        return this.f17490d;
    }

    @FieldOffset
    public final int m24610j() {
        m9949a(0, 1);
        return this.f17491e;
    }

    @FieldOffset
    public final double m24611k() {
        m9949a(0, 2);
        return this.f17492f;
    }

    public final int jK_() {
        return -1854235203;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLRating() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17490d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17491e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f17492f = mutableFlatBuffer.m21523a(i, 2, 0.0d);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m24606a(), 0);
        flatBufferBuilder.m21494a(1, m24610j(), 0);
        flatBufferBuilder.m21492a(2, m24611k(), 0.0d);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLRating(Parcel parcel) {
        super(4);
        this.f17490d = parcel.readInt();
        this.f17491e = parcel.readInt();
        this.f17492f = parcel.readDouble();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24606a());
        parcel.writeInt(m24610j());
        parcel.writeDouble(m24611k());
    }

    public GraphQLRating(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17490d = builder.d;
        this.f17491e = builder.e;
        this.f17492f = builder.f;
    }
}
