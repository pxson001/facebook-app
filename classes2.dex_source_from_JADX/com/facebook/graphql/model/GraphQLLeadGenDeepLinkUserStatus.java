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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location_manager_throwable */
public final class GraphQLLeadGenDeepLinkUserStatus extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLLeadGenDeepLinkUserStatus> CREATOR = new 1();
    public boolean f16573d;
    @Nullable
    public String f16574e;
    @Nullable
    public String f16575f;
    @Nullable
    public String f16576g;
    @Nullable
    public String f16577h;

    @FieldOffset
    public final boolean m23425j() {
        m9949a(0, 0);
        return this.f16573d;
    }

    @FieldOffset
    @Nullable
    public final String m23426k() {
        this.f16574e = super.m9948a(this.f16574e, 1);
        return this.f16574e;
    }

    @FieldOffset
    @Nullable
    public final String m23427l() {
        this.f16575f = super.m9948a(this.f16575f, 2);
        return this.f16575f;
    }

    @FieldOffset
    @Nullable
    public final String m23428m() {
        this.f16576g = super.m9948a(this.f16576g, 3);
        return this.f16576g;
    }

    @FieldOffset
    @Nullable
    public final String m23429n() {
        this.f16577h = super.m9948a(this.f16577h, 4);
        return this.f16577h;
    }

    @Nullable
    public final String mo2834a() {
        return m23426k();
    }

    public final int jK_() {
        return 771298455;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("has_shared_info".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m23425j());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 0;
            return;
        }
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        if ("has_shared_info".equals(str)) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.f16573d = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 0, booleanValue);
            }
        }
    }

    public GraphQLLeadGenDeepLinkUserStatus() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16573d = mutableFlatBuffer.m21540a(i, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23426k());
        int b2 = flatBufferBuilder.m21502b(m23427l());
        int b3 = flatBufferBuilder.m21502b(m23428m());
        int b4 = flatBufferBuilder.m21502b(m23429n());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21498a(0, m23425j());
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLLeadGenDeepLinkUserStatus(Parcel parcel) {
        boolean z = true;
        super(6);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f16573d = z;
        this.f16574e = parcel.readString();
        this.f16575f = parcel.readString();
        this.f16576g = parcel.readString();
        this.f16577h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m23425j() ? 1 : 0));
        parcel.writeString(m23426k());
        parcel.writeString(m23427l());
        parcel.writeString(m23428m());
        parcel.writeString(m23429n());
    }
}
