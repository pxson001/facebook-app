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
/* compiled from: location_manager_provider */
public final class GraphQLLeadGenUserStatus extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLLeadGenUserStatus> CREATOR = new 1();
    public boolean f16580d;
    @Nullable
    public String f16581e;
    @Nullable
    public String f16582f;
    @Nullable
    public String f16583g;
    @Nullable
    public String f16584h;

    @FieldOffset
    public final boolean m23436j() {
        m9949a(0, 0);
        return this.f16580d;
    }

    @FieldOffset
    @Nullable
    public final String m23437k() {
        this.f16581e = super.m9948a(this.f16581e, 1);
        return this.f16581e;
    }

    @FieldOffset
    @Nullable
    public final String m23438l() {
        this.f16582f = super.m9948a(this.f16582f, 2);
        return this.f16582f;
    }

    @FieldOffset
    @Nullable
    public final String m23439m() {
        this.f16583g = super.m9948a(this.f16583g, 3);
        return this.f16583g;
    }

    @FieldOffset
    @Nullable
    public final String m23440n() {
        this.f16584h = super.m9948a(this.f16584h, 4);
        return this.f16584h;
    }

    @Nullable
    public final String mo2834a() {
        return m23437k();
    }

    public final int jK_() {
        return 925012209;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("has_shared_info".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m23436j());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 0;
            return;
        }
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        if ("has_shared_info".equals(str)) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.f16580d = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 0, booleanValue);
            }
        }
    }

    public GraphQLLeadGenUserStatus() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16580d = mutableFlatBuffer.m21540a(i, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23437k());
        int b2 = flatBufferBuilder.m21502b(m23438l());
        int b3 = flatBufferBuilder.m21502b(m23439m());
        int b4 = flatBufferBuilder.m21502b(m23440n());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21498a(0, m23436j());
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLLeadGenUserStatus(Parcel parcel) {
        boolean z = true;
        super(6);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f16580d = z;
        this.f16581e = parcel.readString();
        this.f16582f = parcel.readString();
        this.f16583g = parcel.readString();
        this.f16584h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m23436j() ? 1 : 0));
        parcel.writeString(m23437k());
        parcel.writeString(m23438l());
        parcel.writeString(m23439m());
        parcel.writeString(m23440n());
    }
}
