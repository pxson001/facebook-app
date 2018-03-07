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
/* compiled from: fetch_page_info */
public final class GraphQLFullIndexEducationInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFullIndexEducationInfo> CREATOR = new 1();
    @Nullable
    public String f23990d;
    public boolean f23991e;
    @Nullable
    public String f23992f;
    public boolean f23993g;

    @FieldOffset
    @Nullable
    public final String m32398a() {
        this.f23990d = super.m9948a(this.f23990d, 0);
        return this.f23990d;
    }

    @FieldOffset
    public final boolean m32400j() {
        m9949a(0, 1);
        return this.f23991e;
    }

    @FieldOffset
    @Nullable
    public final String m32401k() {
        this.f23992f = super.m9948a(this.f23992f, 2);
        return this.f23992f;
    }

    @FieldOffset
    public final boolean m32402l() {
        m9949a(0, 3);
        return this.f23993g;
    }

    public final int jK_() {
        return -1285866029;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLFullIndexEducationInfo() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f23991e = mutableFlatBuffer.m21540a(i, 1);
        this.f23993g = mutableFlatBuffer.m21540a(i, 3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m32398a());
        int b2 = flatBufferBuilder.m21502b(m32401k());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21498a(1, m32400j());
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21498a(3, m32402l());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFullIndexEducationInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(5);
        this.f23990d = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f23991e = z;
        this.f23992f = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f23993g = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m32398a());
        if (m32400j()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m32401k());
        if (!m32402l()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
