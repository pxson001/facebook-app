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
/* compiled from: legacy */
public final class GraphQLEventTimeRange extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventTimeRange> CREATOR = new 1();
    @Nullable
    public String f17691d;
    @Nullable
    public String f17692e;
    @Nullable
    public String f17693f;

    @FieldOffset
    @Nullable
    public final String m24891a() {
        this.f17691d = super.m9948a(this.f17691d, 0);
        return this.f17691d;
    }

    final void m24892a(@Nullable String str) {
        this.f17691d = str;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21537a(this.f5824c, 0, str);
        }
    }

    @FieldOffset
    @Nullable
    public final String m24895j() {
        this.f17692e = super.m9948a(this.f17692e, 1);
        return this.f17692e;
    }

    final void m24893b(@Nullable String str) {
        this.f17692e = str;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21537a(this.f5824c, 1, str);
        }
    }

    @FieldOffset
    @Nullable
    public final String m24896k() {
        this.f17693f = super.m9948a(this.f17693f, 2);
        return this.f17693f;
    }

    final void m24894c(@Nullable String str) {
        this.f17693f = str;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21537a(this.f5824c, 2, str);
        }
    }

    public final int jK_() {
        return -21990122;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLEventTimeRange() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24891a());
        int b2 = flatBufferBuilder.m21502b(m24895j());
        int b3 = flatBufferBuilder.m21502b(m24896k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEventTimeRange(Parcel parcel) {
        super(4);
        this.f17691d = parcel.readString();
        this.f17692e = parcel.readString();
        this.f17693f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24891a());
        parcel.writeString(m24895j());
        parcel.writeString(m24896k());
    }
}
