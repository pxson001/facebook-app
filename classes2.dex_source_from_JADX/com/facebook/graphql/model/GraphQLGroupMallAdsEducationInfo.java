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
/* compiled from: fetch_p2p_send_eligibility */
public final class GraphQLGroupMallAdsEducationInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupMallAdsEducationInfo> CREATOR = new 1();
    @Nullable
    public String f23994d;
    public boolean f23995e;
    public boolean f23996f;

    @FieldOffset
    @Nullable
    public final String m32405a() {
        this.f23994d = super.m9948a(this.f23994d, 0);
        return this.f23994d;
    }

    @FieldOffset
    public final boolean m32407j() {
        m9949a(0, 1);
        return this.f23995e;
    }

    @FieldOffset
    public final boolean m32408k() {
        m9949a(0, 2);
        return this.f23996f;
    }

    public final int jK_() {
        return -166364967;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLGroupMallAdsEducationInfo() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f23995e = mutableFlatBuffer.m21540a(i, 1);
        this.f23996f = mutableFlatBuffer.m21540a(i, 2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m32405a());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21498a(1, m32407j());
        flatBufferBuilder.m21498a(2, m32408k());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGroupMallAdsEducationInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(4);
        this.f23994d = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f23995e = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f23996f = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m32405a());
        if (m32407j()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m32408k()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
