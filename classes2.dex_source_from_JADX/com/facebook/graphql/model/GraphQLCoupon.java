package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCouponClaimLocation;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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
/* compiled from: logVideoStartCancelled */
public final class GraphQLCoupon extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLCoupon> CREATOR = new 1();
    public int f16268d;
    public GraphQLCouponClaimLocation f16269e;
    @Nullable
    public GraphQLStory f16270f;
    public long f16271g;
    public int f16272h;
    public boolean f16273i;
    @Nullable
    public String f16274j;
    public boolean f16275k;
    public boolean f16276l;
    public boolean f16277m;
    @Nullable
    public GraphQLTextWithEntities f16278n;
    @Nullable
    public String f16279o;
    @Nullable
    public String f16280p;
    @Nullable
    public GraphQLPage f16281q;
    @Nullable
    public GraphQLPhoto f16282r;
    @Nullable
    public String f16283s;
    @Nullable
    public String f16284t;
    public long f16285u;
    @Nullable
    public String f16286v;
    @Nullable
    public String f16287w;

    @FieldOffset
    public final int m23108j() {
        m9949a(0, 0);
        return this.f16268d;
    }

    @FieldOffset
    public final GraphQLCouponClaimLocation m23109k() {
        this.f16269e = (GraphQLCouponClaimLocation) super.m9945a(this.f16269e, 1, GraphQLCouponClaimLocation.class, GraphQLCouponClaimLocation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16269e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m23110l() {
        this.f16270f = (GraphQLStory) super.m9947a(this.f16270f, 2, GraphQLStory.class);
        return this.f16270f;
    }

    @FieldOffset
    public final long m23111m() {
        m9949a(0, 3);
        return this.f16271g;
    }

    @FieldOffset
    public final int m23112n() {
        m9949a(0, 4);
        return this.f16272h;
    }

    @FieldOffset
    public final boolean m23113o() {
        m9949a(0, 5);
        return this.f16273i;
    }

    public final void m23107a(boolean z) {
        this.f16273i = z;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21538a(this.f5824c, 5, z);
        }
    }

    @FieldOffset
    @Nullable
    public final String m23114p() {
        this.f16274j = super.m9948a(this.f16274j, 6);
        return this.f16274j;
    }

    @FieldOffset
    public final boolean m23115q() {
        m9949a(0, 7);
        return this.f16275k;
    }

    @FieldOffset
    public final boolean m23116r() {
        m9949a(1, 0);
        return this.f16276l;
    }

    @FieldOffset
    public final boolean m23117s() {
        m9949a(1, 1);
        return this.f16277m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23118t() {
        this.f16278n = (GraphQLTextWithEntities) super.m9947a(this.f16278n, 10, GraphQLTextWithEntities.class);
        return this.f16278n;
    }

    @FieldOffset
    @Nullable
    public final String m23119u() {
        this.f16279o = super.m9948a(this.f16279o, 11);
        return this.f16279o;
    }

    @FieldOffset
    @Nullable
    public final String m23120v() {
        this.f16280p = super.m9948a(this.f16280p, 12);
        return this.f16280p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m23121w() {
        this.f16281q = (GraphQLPage) super.m9947a(this.f16281q, 13, GraphQLPage.class);
        return this.f16281q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m23122x() {
        this.f16282r = (GraphQLPhoto) super.m9947a(this.f16282r, 14, GraphQLPhoto.class);
        return this.f16282r;
    }

    @FieldOffset
    @Nullable
    public final String m23123y() {
        this.f16283s = super.m9948a(this.f16283s, 15);
        return this.f16283s;
    }

    @FieldOffset
    @Nullable
    public final String m23124z() {
        this.f16284t = super.m9948a(this.f16284t, 16);
        return this.f16284t;
    }

    @FieldOffset
    public final long m23098A() {
        m9949a(2, 1);
        return this.f16285u;
    }

    @FieldOffset
    @Nullable
    public final String m23099B() {
        this.f16286v = super.m9948a(this.f16286v, 18);
        return this.f16286v;
    }

    @FieldOffset
    @Nullable
    public final String m23100C() {
        this.f16287w = super.m9948a(this.f16287w, 19);
        return this.f16287w;
    }

    @Nullable
    public final String mo2834a() {
        return m23114p();
    }

    public final int jK_() {
        return 2024260678;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23110l() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m23110l());
            if (m23110l() != graphQLStory) {
                graphQLVisitableModel = (GraphQLCoupon) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16270f = graphQLStory;
            }
        }
        if (m23118t() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23118t());
            if (m23118t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCoupon) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16278n = graphQLTextWithEntities;
            }
        }
        if (m23121w() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m23121w());
            if (m23121w() != graphQLPage) {
                graphQLVisitableModel = (GraphQLCoupon) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16281q = graphQLPage;
            }
        }
        if (m23122x() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m23122x());
            if (m23122x() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLCoupon) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16282r = graphQLPhoto;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("has_viewer_claimed".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m23113o());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 5;
            return;
        }
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        if ("has_viewer_claimed".equals(str)) {
            m23107a(((Boolean) obj).booleanValue());
        }
    }

    public GraphQLCoupon() {
        super(21);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16268d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f16271g = mutableFlatBuffer.m21525a(i, 3, 0);
        this.f16272h = mutableFlatBuffer.m21524a(i, 4, 0);
        this.f16273i = mutableFlatBuffer.m21540a(i, 5);
        this.f16275k = mutableFlatBuffer.m21540a(i, 7);
        this.f16276l = mutableFlatBuffer.m21540a(i, 8);
        this.f16277m = mutableFlatBuffer.m21540a(i, 9);
        this.f16285u = mutableFlatBuffer.m21525a(i, 17, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23110l());
        int b = flatBufferBuilder.m21502b(m23114p());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23118t());
        int b2 = flatBufferBuilder.m21502b(m23119u());
        int b3 = flatBufferBuilder.m21502b(m23120v());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23121w());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23122x());
        int b4 = flatBufferBuilder.m21502b(m23123y());
        int b5 = flatBufferBuilder.m21502b(m23124z());
        int b6 = flatBufferBuilder.m21502b(m23099B());
        int b7 = flatBufferBuilder.m21502b(m23100C());
        flatBufferBuilder.m21510c(20);
        flatBufferBuilder.m21494a(0, m23108j(), 0);
        flatBufferBuilder.m21496a(1, m23109k() == GraphQLCouponClaimLocation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23109k());
        flatBufferBuilder.m21507b(2, a);
        flatBufferBuilder.m21495a(3, m23111m(), 0);
        flatBufferBuilder.m21494a(4, m23112n(), 0);
        flatBufferBuilder.m21498a(5, m23113o());
        flatBufferBuilder.m21507b(6, b);
        flatBufferBuilder.m21498a(7, m23115q());
        flatBufferBuilder.m21498a(8, m23116r());
        flatBufferBuilder.m21498a(9, m23117s());
        flatBufferBuilder.m21507b(10, a2);
        flatBufferBuilder.m21507b(11, b2);
        flatBufferBuilder.m21507b(12, b3);
        flatBufferBuilder.m21507b(13, a3);
        flatBufferBuilder.m21507b(14, a4);
        flatBufferBuilder.m21507b(15, b4);
        flatBufferBuilder.m21507b(16, b5);
        flatBufferBuilder.m21495a(17, m23098A(), 0);
        flatBufferBuilder.m21507b(18, b6);
        flatBufferBuilder.m21507b(19, b7);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLCoupon(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(21);
        this.f16268d = parcel.readInt();
        this.f16269e = GraphQLCouponClaimLocation.fromString(parcel.readString());
        this.f16270f = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f16271g = parcel.readLong();
        this.f16272h = parcel.readInt();
        this.f16273i = parcel.readByte() == (byte) 1;
        this.f16274j = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16275k = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16276l = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f16277m = z2;
        this.f16278n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16279o = parcel.readString();
        this.f16280p = parcel.readString();
        this.f16281q = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f16282r = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f16283s = parcel.readString();
        this.f16284t = parcel.readString();
        this.f16285u = parcel.readLong();
        this.f16286v = parcel.readString();
        this.f16287w = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(m23108j());
        parcel.writeString(m23109k().name());
        parcel.writeValue(m23110l());
        parcel.writeLong(m23111m());
        parcel.writeInt(m23112n());
        parcel.writeByte((byte) (m23113o() ? 1 : 0));
        parcel.writeString(m23114p());
        if (m23115q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23116r()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m23117s()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(m23118t());
        parcel.writeString(m23119u());
        parcel.writeString(m23120v());
        parcel.writeValue(m23121w());
        parcel.writeValue(m23122x());
        parcel.writeString(m23123y());
        parcel.writeString(m23124z());
        parcel.writeLong(m23098A());
        parcel.writeString(m23099B());
        parcel.writeString(m23100C());
    }
}
