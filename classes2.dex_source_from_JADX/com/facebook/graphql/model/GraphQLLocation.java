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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultLocationFields;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_last_negative_feedback_action_type */
public final class GraphQLLocation extends BaseModel implements TypeModel, CommonGraphQLInterfaces$DefaultLocationFields, GraphQLVisitableModel {
    public static final Creator<GraphQLLocation> CREATOR = new 1();
    public double f17044d;
    public double f17045e;
    @Nullable
    public String f17046f;

    @FieldOffset
    public final double mo2957a() {
        m9949a(0, 0);
        return this.f17044d;
    }

    @FieldOffset
    public final double mo2958b() {
        m9949a(0, 1);
        return this.f17045e;
    }

    @FieldOffset
    @Nullable
    public final String m24048j() {
        this.f17046f = super.m9948a(this.f17046f, 2);
        return this.f17046f;
    }

    public final int jK_() {
        return 1965687765;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLLocation() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17044d = mutableFlatBuffer.m21523a(i, 0, 0.0d);
        this.f17045e = mutableFlatBuffer.m21523a(i, 1, 0.0d);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24048j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21492a(0, mo2957a(), 0.0d);
        flatBufferBuilder.m21492a(1, mo2958b(), 0.0d);
        flatBufferBuilder.m21507b(2, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLLocation(Parcel parcel) {
        super(4);
        this.f17044d = parcel.readDouble();
        this.f17045e = parcel.readDouble();
        this.f17046f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(mo2957a());
        parcel.writeDouble(mo2958b());
        parcel.writeString(m24048j());
    }

    public GraphQLLocation(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17044d = builder.d;
        this.f17045e = builder.e;
        this.f17046f = builder.f;
    }
}
