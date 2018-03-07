package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
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
/* compiled from: localsell_home */
public final class GraphQLStreetAddress extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStreetAddress> CREATOR = new 1();
    @Nullable
    public String f16859d;
    @Nullable
    public String f16860e;
    @Nullable
    public String f16861f;
    @Nullable
    public String f16862g;
    @Nullable
    public String f16863h;
    @Nullable
    public String f16864i;
    @Nullable
    public String f16865j;
    @Nullable
    public String f16866k;

    @FieldOffset
    @Nullable
    public final String m23810a() {
        this.f16859d = super.m9948a(this.f16859d, 0);
        return this.f16859d;
    }

    @FieldOffset
    @Nullable
    public final String m23812j() {
        this.f16860e = super.m9948a(this.f16860e, 1);
        return this.f16860e;
    }

    @FieldOffset
    @Nullable
    public final String m23813k() {
        this.f16861f = super.m9948a(this.f16861f, 2);
        return this.f16861f;
    }

    @FieldOffset
    @Nullable
    public final String m23814l() {
        this.f16862g = super.m9948a(this.f16862g, 3);
        return this.f16862g;
    }

    @FieldOffset
    @Nullable
    public final String m23815m() {
        this.f16863h = super.m9948a(this.f16863h, 4);
        return this.f16863h;
    }

    final void m23811a(@Nullable String str) {
        this.f16863h = str;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21537a(this.f5824c, 4, str);
        }
    }

    @FieldOffset
    @Nullable
    public final String m23816n() {
        this.f16864i = super.m9948a(this.f16864i, 5);
        return this.f16864i;
    }

    @FieldOffset
    @Nullable
    public final String m23817o() {
        this.f16865j = super.m9948a(this.f16865j, 6);
        return this.f16865j;
    }

    @FieldOffset
    @Nullable
    public final String m23818p() {
        this.f16866k = super.m9948a(this.f16866k, 7);
        return this.f16866k;
    }

    public final int jK_() {
        return 799251025;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLStreetAddress() {
        super(9);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23810a());
        int b2 = flatBufferBuilder.m21502b(m23812j());
        int b3 = flatBufferBuilder.m21502b(m23813k());
        int b4 = flatBufferBuilder.m21502b(m23814l());
        int b5 = flatBufferBuilder.m21502b(m23815m());
        int b6 = flatBufferBuilder.m21502b(m23816n());
        int b7 = flatBufferBuilder.m21502b(m23817o());
        int b8 = flatBufferBuilder.m21502b(m23818p());
        flatBufferBuilder.m21510c(8);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, b3);
        flatBufferBuilder.m21507b(3, b4);
        flatBufferBuilder.m21507b(4, b5);
        flatBufferBuilder.m21507b(5, b6);
        flatBufferBuilder.m21507b(6, b7);
        flatBufferBuilder.m21507b(7, b8);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStreetAddress(Parcel parcel) {
        super(9);
        this.f16859d = parcel.readString();
        this.f16860e = parcel.readString();
        this.f16861f = parcel.readString();
        this.f16862g = parcel.readString();
        this.f16863h = parcel.readString();
        this.f16864i = parcel.readString();
        this.f16865j = parcel.readString();
        this.f16866k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m23810a());
        parcel.writeString(m23812j());
        parcel.writeString(m23813k());
        parcel.writeString(m23814l());
        parcel.writeString(m23815m());
        parcel.writeString(m23816n());
        parcel.writeString(m23817o());
        parcel.writeString(m23818p());
    }

    public GraphQLStreetAddress(Builder builder) {
        super(9);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16859d = builder.d;
        this.f16860e = builder.e;
        this.f16861f = builder.f;
        this.f16862g = builder.g;
        this.f16863h = builder.h;
        this.f16864i = builder.i;
        this.f16865j = builder.j;
        this.f16866k = builder.k;
    }
}
