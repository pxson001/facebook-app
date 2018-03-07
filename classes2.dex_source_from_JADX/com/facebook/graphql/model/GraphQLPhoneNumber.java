package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLBlockStatus;
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
/* compiled from: getPositionInMutableFlatBuffer is not supported */
public final class GraphQLPhoneNumber extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPhoneNumber> CREATOR = new 1();
    public GraphQLBlockStatus f22525d;
    @Nullable
    public String f22526e;
    @Nullable
    public String f22527f;
    @Nullable
    public String f22528g;
    @Nullable
    public String f22529h;
    @Nullable
    public String f22530i;

    @FieldOffset
    public final GraphQLBlockStatus m30407a() {
        this.f22525d = (GraphQLBlockStatus) super.m9945a(this.f22525d, 0, GraphQLBlockStatus.class, GraphQLBlockStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f22525d;
    }

    @FieldOffset
    @Nullable
    public final String m30409j() {
        this.f22526e = super.m9948a(this.f22526e, 1);
        return this.f22526e;
    }

    @FieldOffset
    @Nullable
    public final String m30410k() {
        this.f22527f = super.m9948a(this.f22527f, 2);
        return this.f22527f;
    }

    @FieldOffset
    @Nullable
    public final String m30411l() {
        this.f22528g = super.m9948a(this.f22528g, 3);
        return this.f22528g;
    }

    @FieldOffset
    @Nullable
    public final String m30412m() {
        this.f22529h = super.m9948a(this.f22529h, 4);
        return this.f22529h;
    }

    @FieldOffset
    @Nullable
    public final String m30413n() {
        this.f22530i = super.m9948a(this.f22530i, 5);
        return this.f22530i;
    }

    public final int jK_() {
        return 474898999;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLPhoneNumber() {
        super(7);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m30409j());
        int b2 = flatBufferBuilder.m21502b(m30410k());
        int b3 = flatBufferBuilder.m21502b(m30411l());
        int b4 = flatBufferBuilder.m21502b(m30412m());
        int b5 = flatBufferBuilder.m21502b(m30413n());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21496a(0, m30407a() == GraphQLBlockStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m30407a());
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, b4);
        flatBufferBuilder.m21507b(5, b5);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPhoneNumber(Parcel parcel) {
        super(7);
        this.f22530i = parcel.readString();
        this.f22525d = GraphQLBlockStatus.fromString(parcel.readString());
        this.f22526e = parcel.readString();
        this.f22527f = parcel.readString();
        this.f22528g = parcel.readString();
        this.f22529h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m30413n());
        parcel.writeString(m30407a().name());
        parcel.writeString(m30409j());
        parcel.writeString(m30410k());
        parcel.writeString(m30411l());
        parcel.writeString(m30412m());
    }
}
