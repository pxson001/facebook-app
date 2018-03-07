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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces$DefaultVect2Fields;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: install_non_market_apps */
public final class GraphQLVect2 extends BaseModel implements TypeModel, CommonGraphQL2Interfaces$DefaultVect2Fields, GraphQLVisitableModel {
    public static final Creator<GraphQLVect2> CREATOR = new C07881();
    public double f19815d;
    public double f19816e;

    /* compiled from: install_non_market_apps */
    final class C07881 implements Creator<GraphQLVect2> {
        C07881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLVect2(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLVect2[i];
        }
    }

    @FieldOffset
    public final double mo3123a() {
        m9949a(0, 0);
        return this.f19815d;
    }

    @FieldOffset
    public final double mo3124b() {
        m9949a(0, 1);
        return this.f19816e;
    }

    public final int jK_() {
        return 82530482;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLVect2() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19815d = mutableFlatBuffer.m21523a(i, 0, 0.0d);
        this.f19816e = mutableFlatBuffer.m21523a(i, 1, 0.0d);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21492a(0, mo3123a(), 0.0d);
        flatBufferBuilder.m21492a(1, mo3124b(), 0.0d);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLVect2(Parcel parcel) {
        super(3);
        this.f19815d = parcel.readDouble();
        this.f19816e = parcel.readDouble();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(mo3123a());
        parcel.writeDouble(mo3124b());
    }

    public GraphQLVect2(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19815d = builder.d;
        this.f19816e = builder.e;
    }
}
