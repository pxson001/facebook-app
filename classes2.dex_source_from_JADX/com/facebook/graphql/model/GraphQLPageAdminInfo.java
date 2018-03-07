package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localsell_location */
public final class GraphQLPageAdminInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPageAdminInfo> CREATOR = new 1();
    @Nullable
    GraphQLAllScheduledPostsConnection f16792d;
    @Nullable
    String f16793e;
    @Nullable
    String f16794f;
    GraphQLBoostedPostAudienceOption f16795g;
    @Nullable
    GraphQLBudgetRecommendationsConnection f16796h;
    boolean f16797i;
    boolean f16798j;
    boolean f16799k;
    boolean f16800l;
    int f16801m;
    boolean f16802n;
    boolean f16803o;
    boolean f16804p;
    boolean f16805q;
    boolean f16806r;
    long f16807s;
    @Nullable
    GraphQLViewer f16808t;
    boolean f16809u;

    @FieldOffset
    @Nullable
    public final GraphQLAllScheduledPostsConnection m23738a() {
        this.f16792d = (GraphQLAllScheduledPostsConnection) super.m9947a(this.f16792d, 0, GraphQLAllScheduledPostsConnection.class);
        return this.f16792d;
    }

    @FieldOffset
    @Nullable
    public final String m23741j() {
        this.f16793e = super.m9948a(this.f16793e, 1);
        return this.f16793e;
    }

    @FieldOffset
    @Nullable
    public final String m23742k() {
        this.f16794f = super.m9948a(this.f16794f, 2);
        return this.f16794f;
    }

    @FieldOffset
    public final GraphQLBoostedPostAudienceOption m23743l() {
        this.f16795g = (GraphQLBoostedPostAudienceOption) super.m9945a(this.f16795g, 3, GraphQLBoostedPostAudienceOption.class, GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16795g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLBudgetRecommendationsConnection m23744m() {
        this.f16796h = (GraphQLBudgetRecommendationsConnection) super.m9947a(this.f16796h, 4, GraphQLBudgetRecommendationsConnection.class);
        return this.f16796h;
    }

    @FieldOffset
    public final boolean m23745n() {
        m9949a(0, 5);
        return this.f16797i;
    }

    @FieldOffset
    public final boolean m23746o() {
        m9949a(0, 6);
        return this.f16798j;
    }

    @FieldOffset
    public final boolean m23747p() {
        m9949a(0, 7);
        return this.f16799k;
    }

    @FieldOffset
    public final boolean m23748q() {
        m9949a(1, 0);
        return this.f16800l;
    }

    @FieldOffset
    public final int m23749r() {
        m9949a(1, 1);
        return this.f16801m;
    }

    @FieldOffset
    public final boolean m23750s() {
        m9949a(1, 2);
        return this.f16802n;
    }

    @FieldOffset
    public final boolean m23751t() {
        m9949a(1, 3);
        return this.f16803o;
    }

    @FieldOffset
    public final boolean m23752u() {
        m9949a(1, 4);
        return this.f16804p;
    }

    @FieldOffset
    public final boolean m23753v() {
        m9949a(1, 5);
        return this.f16805q;
    }

    @FieldOffset
    public final boolean m23754w() {
        m9949a(1, 7);
        return this.f16806r;
    }

    @FieldOffset
    public final long m23755x() {
        m9949a(2, 0);
        return this.f16807s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLViewer m23756y() {
        this.f16808t = (GraphQLViewer) super.m9947a(this.f16808t, 17, GraphQLViewer.class);
        return this.f16808t;
    }

    @FieldOffset
    public final boolean m23757z() {
        m9949a(2, 2);
        return this.f16809u;
    }

    public final int jK_() {
        return 888797870;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23738a() != null) {
            GraphQLAllScheduledPostsConnection graphQLAllScheduledPostsConnection = (GraphQLAllScheduledPostsConnection) graphQLModelMutatingVisitor.mo2928b(m23738a());
            if (m23738a() != graphQLAllScheduledPostsConnection) {
                graphQLVisitableModel = (GraphQLPageAdminInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16792d = graphQLAllScheduledPostsConnection;
            }
        }
        if (m23744m() != null) {
            GraphQLBudgetRecommendationsConnection graphQLBudgetRecommendationsConnection = (GraphQLBudgetRecommendationsConnection) graphQLModelMutatingVisitor.mo2928b(m23744m());
            if (m23744m() != graphQLBudgetRecommendationsConnection) {
                graphQLVisitableModel = (GraphQLPageAdminInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16796h = graphQLBudgetRecommendationsConnection;
            }
        }
        if (m23756y() != null) {
            GraphQLViewer graphQLViewer = (GraphQLViewer) graphQLModelMutatingVisitor.mo2928b(m23756y());
            if (m23756y() != graphQLViewer) {
                graphQLVisitableModel = (GraphQLPageAdminInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16808t = graphQLViewer;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPageAdminInfo() {
        super(20);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16797i = mutableFlatBuffer.m21540a(i, 5);
        this.f16798j = mutableFlatBuffer.m21540a(i, 6);
        this.f16799k = mutableFlatBuffer.m21540a(i, 7);
        this.f16800l = mutableFlatBuffer.m21540a(i, 8);
        this.f16801m = mutableFlatBuffer.m21524a(i, 9, 0);
        this.f16802n = mutableFlatBuffer.m21540a(i, 10);
        this.f16803o = mutableFlatBuffer.m21540a(i, 11);
        this.f16804p = mutableFlatBuffer.m21540a(i, 12);
        this.f16805q = mutableFlatBuffer.m21540a(i, 13);
        this.f16806r = mutableFlatBuffer.m21540a(i, 15);
        this.f16807s = mutableFlatBuffer.m21525a(i, 16, 0);
        this.f16809u = mutableFlatBuffer.m21540a(i, 18);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23738a());
        int b = flatBufferBuilder.m21502b(m23741j());
        int b2 = flatBufferBuilder.m21502b(m23742k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23744m());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23756y());
        flatBufferBuilder.m21510c(19);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21496a(3, m23743l() == GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23743l());
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21498a(5, m23745n());
        flatBufferBuilder.m21498a(6, m23746o());
        flatBufferBuilder.m21498a(7, m23747p());
        flatBufferBuilder.m21498a(8, m23748q());
        flatBufferBuilder.m21494a(9, m23749r(), 0);
        flatBufferBuilder.m21498a(10, m23750s());
        flatBufferBuilder.m21498a(11, m23751t());
        flatBufferBuilder.m21498a(12, m23752u());
        flatBufferBuilder.m21498a(13, m23753v());
        flatBufferBuilder.m21498a(15, m23754w());
        flatBufferBuilder.m21495a(16, m23755x(), 0);
        flatBufferBuilder.m21507b(17, a3);
        flatBufferBuilder.m21498a(18, m23757z());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPageAdminInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(20);
        this.f16792d = (GraphQLAllScheduledPostsConnection) parcel.readValue(GraphQLAllScheduledPostsConnection.class.getClassLoader());
        this.f16793e = parcel.readString();
        this.f16794f = parcel.readString();
        this.f16795g = GraphQLBoostedPostAudienceOption.fromString(parcel.readString());
        this.f16796h = (GraphQLBudgetRecommendationsConnection) parcel.readValue(GraphQLBudgetRecommendationsConnection.class.getClassLoader());
        this.f16797i = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16809u = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16798j = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16799k = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16800l = z;
        this.f16801m = parcel.readInt();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16802n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16803o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16804p = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16805q = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f16806r = z2;
        this.f16807s = parcel.readLong();
        this.f16808t = (GraphQLViewer) parcel.readValue(GraphQLViewer.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m23738a());
        parcel.writeString(m23741j());
        parcel.writeString(m23742k());
        parcel.writeString(m23743l().name());
        parcel.writeValue(m23744m());
        parcel.writeByte((byte) (m23745n() ? 1 : 0));
        if (m23757z()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23746o()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23747p()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23748q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(m23749r());
        if (m23750s()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23751t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23752u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23753v()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m23754w()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeLong(m23755x());
        parcel.writeValue(m23756y());
    }
}
