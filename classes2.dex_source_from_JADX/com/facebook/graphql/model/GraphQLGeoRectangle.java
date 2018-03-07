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
/* compiled from: input */
public final class GraphQLGeoRectangle extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGeoRectangle> CREATOR = new 1();
    public double f19872d;
    public double f19873e;
    public double f19874f;
    public double f19875g;

    @FieldOffset
    public final double m27625a() {
        m9949a(0, 0);
        return this.f19872d;
    }

    @FieldOffset
    public final double m27629j() {
        m9949a(0, 1);
        return this.f19873e;
    }

    @FieldOffset
    public final double m27630k() {
        m9949a(0, 2);
        return this.f19874f;
    }

    @FieldOffset
    public final double m27631l() {
        m9949a(0, 3);
        return this.f19875g;
    }

    public final int jK_() {
        return -2036384450;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLGeoRectangle() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19872d = mutableFlatBuffer.m21523a(i, 0, 0.0d);
        this.f19873e = mutableFlatBuffer.m21523a(i, 1, 0.0d);
        this.f19874f = mutableFlatBuffer.m21523a(i, 2, 0.0d);
        this.f19875g = mutableFlatBuffer.m21523a(i, 3, 0.0d);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21492a(0, m27625a(), 0.0d);
        flatBufferBuilder.m21492a(1, m27629j(), 0.0d);
        flatBufferBuilder.m21492a(2, m27630k(), 0.0d);
        flatBufferBuilder.m21492a(3, m27631l(), 0.0d);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGeoRectangle(Parcel parcel) {
        super(5);
        this.f19872d = parcel.readDouble();
        this.f19873e = parcel.readDouble();
        this.f19874f = parcel.readDouble();
        this.f19875g = parcel.readDouble();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(m27625a());
        parcel.writeDouble(m27629j());
        parcel.writeDouble(m27630k());
        parcel.writeDouble(m27631l());
    }

    public GraphQLGeoRectangle(Builder builder) {
        super(5);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19872d = builder.d;
        this.f19873e = builder.e;
        this.f19874f = builder.f;
        this.f19875g = builder.g;
    }
}
