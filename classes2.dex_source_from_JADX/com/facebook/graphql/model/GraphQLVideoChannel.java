package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
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
/* compiled from: lead_gen/?lead_gen_data_id={%s -1}&ad_id={%s -1} */
public final class GraphQLVideoChannel extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLVideoChannel> CREATOR = new 1();
    @Nullable
    public GraphQLObjectType f17725d;
    @Nullable
    public String f17726e;
    public int f17727f;
    @Nullable
    public GraphQLImage f17728g;
    public boolean f17729h;
    public boolean f17730i;
    public boolean f17731j;
    @Nullable
    public GraphQLProfile f17732k;
    public boolean f17733l;
    public boolean f17734m;
    public boolean f17735n;
    public boolean f17736o;
    public int f17737p;
    public int f17738q;
    @Nullable
    public GraphQLTextWithEntities f17739r;
    @Nullable
    public GraphQLTextWithEntities f17740s;
    @Nullable
    public GraphQLPageLikersConnection f17741t;
    public GraphQLSubscribeStatus f17742u;

    @Nullable
    public final GraphQLObjectType m24938j() {
        if (this.f5823b != null && this.f17725d == null) {
            this.f17725d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f17725d == null || this.f17725d.m22301g() != 0) {
            return this.f17725d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m24939k() {
        this.f17726e = super.m9948a(this.f17726e, 1);
        return this.f17726e;
    }

    @FieldOffset
    public final int m24940l() {
        m9949a(0, 2);
        return this.f17727f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24941m() {
        this.f17728g = (GraphQLImage) super.m9947a(this.f17728g, 3, GraphQLImage.class);
        return this.f17728g;
    }

    @FieldOffset
    public final boolean m24942n() {
        m9949a(0, 4);
        return this.f17729h;
    }

    @FieldOffset
    public final boolean m24943o() {
        m9949a(0, 5);
        return this.f17730i;
    }

    @FieldOffset
    public final boolean m24944p() {
        m9949a(0, 6);
        return this.f17731j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m24945q() {
        this.f17732k = (GraphQLProfile) super.m9947a(this.f17732k, 7, GraphQLProfile.class);
        return this.f17732k;
    }

    @FieldOffset
    public final boolean m24946r() {
        m9949a(1, 0);
        return this.f17733l;
    }

    @FieldOffset
    public final boolean m24947s() {
        m9949a(1, 1);
        return this.f17734m;
    }

    @FieldOffset
    public final boolean m24948t() {
        m9949a(1, 2);
        return this.f17735n;
    }

    @FieldOffset
    public final boolean m24949u() {
        m9949a(1, 3);
        return this.f17736o;
    }

    @FieldOffset
    public final int m24950v() {
        m9949a(1, 4);
        return this.f17737p;
    }

    @FieldOffset
    public final int m24951w() {
        m9949a(1, 5);
        return this.f17738q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24952x() {
        this.f17739r = (GraphQLTextWithEntities) super.m9947a(this.f17739r, 14, GraphQLTextWithEntities.class);
        return this.f17739r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24953y() {
        this.f17740s = (GraphQLTextWithEntities) super.m9947a(this.f17740s, 15, GraphQLTextWithEntities.class);
        return this.f17740s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageLikersConnection m24954z() {
        this.f17741t = (GraphQLPageLikersConnection) super.m9947a(this.f17741t, 16, GraphQLPageLikersConnection.class);
        return this.f17741t;
    }

    @FieldOffset
    public final GraphQLSubscribeStatus m24931A() {
        this.f17742u = (GraphQLSubscribeStatus) super.m9945a(this.f17742u, 17, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17742u;
    }

    @Nullable
    public final String mo2834a() {
        return m24939k();
    }

    public final int jK_() {
        return 756114472;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24954z() != null) {
            GraphQLPageLikersConnection graphQLPageLikersConnection = (GraphQLPageLikersConnection) graphQLModelMutatingVisitor.mo2928b(m24954z());
            if (m24954z() != graphQLPageLikersConnection) {
                graphQLVisitableModel = (GraphQLVideoChannel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17741t = graphQLPageLikersConnection;
            }
        }
        if (m24941m() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24941m());
            if (m24941m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideoChannel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17728g = graphQLImage;
            }
        }
        if (m24945q() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(m24945q());
            if (m24945q() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLVideoChannel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17732k = graphQLProfile;
            }
        }
        if (m24952x() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24952x());
            if (m24952x() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideoChannel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17739r = graphQLTextWithEntities;
            }
        }
        if (m24953y() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24953y());
            if (m24953y() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideoChannel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17740s = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("video_channel_has_viewer_subscribed".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m24947s());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 9;
        } else if ("video_channel_is_viewer_following".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m24948t());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 10;
        } else if ("video_channel_is_viewer_pinned".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m24949u());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 11;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        boolean booleanValue;
        if ("video_channel_has_viewer_subscribed".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f17734m = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 9, booleanValue);
            }
        } else if ("video_channel_is_viewer_following".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f17735n = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 10, booleanValue);
            }
        } else if ("video_channel_is_viewer_pinned".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f17736o = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 11, booleanValue);
            }
        }
    }

    public GraphQLVideoChannel() {
        super(19);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17727f = mutableFlatBuffer.m21524a(i, 2, 0);
        this.f17729h = mutableFlatBuffer.m21540a(i, 4);
        this.f17730i = mutableFlatBuffer.m21540a(i, 5);
        this.f17731j = mutableFlatBuffer.m21540a(i, 6);
        this.f17733l = mutableFlatBuffer.m21540a(i, 8);
        this.f17734m = mutableFlatBuffer.m21540a(i, 9);
        this.f17735n = mutableFlatBuffer.m21540a(i, 10);
        this.f17736o = mutableFlatBuffer.m21540a(i, 11);
        this.f17737p = mutableFlatBuffer.m21524a(i, 12, 0);
        this.f17738q = mutableFlatBuffer.m21524a(i, 13, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        int a = flatBufferBuilder.m21479a(m24938j() != null ? m24938j().m22299e() : null);
        int b = flatBufferBuilder.m21502b(m24939k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24941m());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24945q());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24952x());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24953y());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24954z());
        flatBufferBuilder.m21510c(18);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21494a(2, m24940l(), 0);
        flatBufferBuilder.m21507b(3, a2);
        flatBufferBuilder.m21498a(4, m24942n());
        flatBufferBuilder.m21498a(5, m24943o());
        flatBufferBuilder.m21498a(6, m24944p());
        flatBufferBuilder.m21507b(7, a3);
        flatBufferBuilder.m21498a(8, m24946r());
        flatBufferBuilder.m21498a(9, m24947s());
        flatBufferBuilder.m21498a(10, m24948t());
        flatBufferBuilder.m21498a(11, m24949u());
        flatBufferBuilder.m21494a(12, m24950v(), 0);
        flatBufferBuilder.m21494a(13, m24951w(), 0);
        flatBufferBuilder.m21507b(14, a4);
        flatBufferBuilder.m21507b(15, a5);
        flatBufferBuilder.m21507b(16, a6);
        if (m24931A() != GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m24931A();
        }
        flatBufferBuilder.m21496a(17, enumR);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLVideoChannel(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(19);
        this.f17726e = parcel.readString();
        this.f17727f = parcel.readInt();
        this.f17741t = (GraphQLPageLikersConnection) parcel.readValue(GraphQLPageLikersConnection.class.getClassLoader());
        this.f17728g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17742u = GraphQLSubscribeStatus.fromString(parcel.readString());
        this.f17729h = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17730i = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17731j = z;
        this.f17732k = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17733l = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17734m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17735n = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f17736o = z2;
        this.f17737p = parcel.readInt();
        this.f17738q = parcel.readInt();
        this.f17739r = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17740s = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17725d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m24939k());
        parcel.writeInt(m24940l());
        parcel.writeValue(m24954z());
        parcel.writeValue(m24941m());
        parcel.writeString(m24931A().name());
        parcel.writeByte((byte) (m24942n() ? 1 : 0));
        if (m24943o()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24944p()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24945q());
        if (m24946r()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24947s()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24948t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m24949u()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(m24950v());
        parcel.writeInt(m24951w());
        parcel.writeValue(m24952x());
        parcel.writeValue(m24953y());
        parcel.writeParcelable(this.f17725d, i);
    }
}
