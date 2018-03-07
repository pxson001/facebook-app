package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_db_read */
public final class GraphQLEventViewerCapability extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventViewerCapability> CREATOR = new 1();
    public boolean f17156d;
    public boolean f17157e;
    public boolean f17158f;
    public boolean f17159g;
    public boolean f17160h;
    public boolean f17161i;
    public boolean f17162j;
    public boolean f17163k;
    public boolean f17164l;
    public boolean f17165m;
    public boolean f17166n;
    public boolean f17167o;
    public boolean f17168p;
    public int f17169q;
    @Deprecated
    public GraphQLEventSeenState f17170r;
    public boolean f17171s;

    @FieldOffset
    public final boolean m24177a() {
        m9949a(0, 0);
        return this.f17156d;
    }

    @FieldOffset
    public final boolean m24178j() {
        m9949a(0, 1);
        return this.f17157e;
    }

    @FieldOffset
    public final boolean m24179k() {
        m9949a(0, 2);
        return this.f17158f;
    }

    @FieldOffset
    public final boolean m24180l() {
        m9949a(0, 3);
        return this.f17159g;
    }

    @FieldOffset
    public final boolean m24181m() {
        m9949a(0, 4);
        return this.f17160h;
    }

    @FieldOffset
    public final boolean m24182n() {
        m9949a(0, 5);
        return this.f17161i;
    }

    @FieldOffset
    public final boolean m24183o() {
        m9949a(0, 6);
        return this.f17162j;
    }

    @FieldOffset
    public final boolean m24184p() {
        m9949a(0, 7);
        return this.f17163k;
    }

    @FieldOffset
    public final boolean m24185q() {
        m9949a(1, 0);
        return this.f17164l;
    }

    @FieldOffset
    public final boolean m24186r() {
        m9949a(1, 1);
        return this.f17165m;
    }

    @FieldOffset
    public final boolean m24187s() {
        m9949a(1, 2);
        return this.f17166n;
    }

    @FieldOffset
    public final boolean m24188t() {
        m9949a(1, 3);
        return this.f17167o;
    }

    @FieldOffset
    public final boolean m24189u() {
        m9949a(1, 4);
        return this.f17168p;
    }

    @FieldOffset
    public final int m24190v() {
        m9949a(1, 5);
        return this.f17169q;
    }

    @FieldOffset
    public final GraphQLEventSeenState m24191w() {
        this.f17170r = (GraphQLEventSeenState) super.m9945a(this.f17170r, 14, GraphQLEventSeenState.class, GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17170r;
    }

    @FieldOffset
    public final boolean m24192x() {
        m9949a(2, 0);
        return this.f17171s;
    }

    public final int jK_() {
        return -1910188188;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLEventViewerCapability() {
        super(18);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17156d = mutableFlatBuffer.m21540a(i, 0);
        this.f17157e = mutableFlatBuffer.m21540a(i, 1);
        this.f17158f = mutableFlatBuffer.m21540a(i, 2);
        this.f17159g = mutableFlatBuffer.m21540a(i, 3);
        this.f17160h = mutableFlatBuffer.m21540a(i, 4);
        this.f17161i = mutableFlatBuffer.m21540a(i, 5);
        this.f17162j = mutableFlatBuffer.m21540a(i, 6);
        this.f17163k = mutableFlatBuffer.m21540a(i, 7);
        this.f17164l = mutableFlatBuffer.m21540a(i, 8);
        this.f17165m = mutableFlatBuffer.m21540a(i, 9);
        this.f17166n = mutableFlatBuffer.m21540a(i, 10);
        this.f17167o = mutableFlatBuffer.m21540a(i, 11);
        this.f17168p = mutableFlatBuffer.m21540a(i, 12);
        this.f17169q = mutableFlatBuffer.m21524a(i, 13, 0);
        this.f17171s = mutableFlatBuffer.m21540a(i, 16);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(17);
        flatBufferBuilder.m21498a(0, m24177a());
        flatBufferBuilder.m21498a(1, m24178j());
        flatBufferBuilder.m21498a(2, m24179k());
        flatBufferBuilder.m21498a(3, m24180l());
        flatBufferBuilder.m21498a(4, m24181m());
        flatBufferBuilder.m21498a(5, m24182n());
        flatBufferBuilder.m21498a(6, m24183o());
        flatBufferBuilder.m21498a(7, m24184p());
        flatBufferBuilder.m21498a(8, m24185q());
        flatBufferBuilder.m21498a(9, m24186r());
        flatBufferBuilder.m21498a(10, m24187s());
        flatBufferBuilder.m21498a(11, m24188t());
        flatBufferBuilder.m21498a(12, m24189u());
        flatBufferBuilder.m21494a(13, m24190v(), 0);
        flatBufferBuilder.m21496a(14, m24191w() == GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24191w());
        flatBufferBuilder.m21498a(16, m24192x());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEventViewerCapability(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(18);
        this.f17156d = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17157e = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17158f = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17159g = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17160h = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17161i = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17162j = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17171s = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17163k = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17164l = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17165m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17166n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17167o = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f17168p = z2;
        this.f17169q = parcel.readInt();
        this.f17170r = GraphQLEventSeenState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (m24177a() ? 1 : 0));
        if (m24178j()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24179k()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24180l()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24181m()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24182n()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24183o()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24192x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24184p()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24185q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24186r()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24187s()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24188t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m24189u()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(m24190v());
        parcel.writeString(m24191w().name());
    }
}
