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
/* compiled from: linked_hash */
public final class GraphQLPageMenuInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPageMenuInfo> CREATOR = new 1();
    public boolean f17401d;
    public boolean f17402e;
    public boolean f17403f;
    public boolean f17404g;
    @Nullable
    public String f17405h;

    @FieldOffset
    public final boolean m24492a() {
        m9949a(0, 0);
        return this.f17401d;
    }

    @FieldOffset
    public final boolean m24493j() {
        m9949a(0, 1);
        return this.f17402e;
    }

    @FieldOffset
    public final boolean m24494k() {
        m9949a(0, 2);
        return this.f17403f;
    }

    @FieldOffset
    public final boolean m24495l() {
        m9949a(0, 3);
        return this.f17404g;
    }

    @FieldOffset
    @Nullable
    public final String m24496m() {
        this.f17405h = super.m9948a(this.f17405h, 4);
        return this.f17405h;
    }

    public final int jK_() {
        return 2056274556;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLPageMenuInfo() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17401d = mutableFlatBuffer.m21540a(i, 0);
        this.f17402e = mutableFlatBuffer.m21540a(i, 1);
        this.f17403f = mutableFlatBuffer.m21540a(i, 2);
        this.f17404g = mutableFlatBuffer.m21540a(i, 3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24496m());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21498a(0, m24492a());
        flatBufferBuilder.m21498a(1, m24493j());
        flatBufferBuilder.m21498a(2, m24494k());
        flatBufferBuilder.m21498a(3, m24495l());
        flatBufferBuilder.m21507b(4, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPageMenuInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(6);
        this.f17401d = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17402e = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17403f = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f17404g = z2;
        this.f17405h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (m24492a() ? 1 : 0));
        if (m24493j()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24494k()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m24495l()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(m24496m());
    }
}
