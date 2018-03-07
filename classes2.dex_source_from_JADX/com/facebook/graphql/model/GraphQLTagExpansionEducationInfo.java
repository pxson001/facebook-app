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
/* compiled from: fetch_nearby_suggestions */
public final class GraphQLTagExpansionEducationInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTagExpansionEducationInfo> CREATOR = new 1();
    @Nullable
    public String f24000d;
    public boolean f24001e;
    public boolean f24002f;

    @FieldOffset
    @Nullable
    public final String m32417a() {
        this.f24000d = super.m9948a(this.f24000d, 0);
        return this.f24000d;
    }

    @FieldOffset
    public final boolean m32419j() {
        m9949a(0, 1);
        return this.f24001e;
    }

    @FieldOffset
    public final boolean m32420k() {
        m9949a(0, 2);
        return this.f24002f;
    }

    public final int jK_() {
        return -446481903;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLTagExpansionEducationInfo() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f24001e = mutableFlatBuffer.m21540a(i, 1);
        this.f24002f = mutableFlatBuffer.m21540a(i, 2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m32417a());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21498a(1, m32419j());
        flatBufferBuilder.m21498a(2, m32420k());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTagExpansionEducationInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(4);
        this.f24000d = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f24001e = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f24002f = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m32417a());
        if (m32419j()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m32420k()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
