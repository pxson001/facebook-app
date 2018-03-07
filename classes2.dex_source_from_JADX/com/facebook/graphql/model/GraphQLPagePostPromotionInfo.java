package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
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
/* compiled from: light */
public final class GraphQLPagePostPromotionInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPagePostPromotionInfo> CREATOR = new 1();
    @Nullable
    GraphQLAdAccount f17539d;
    GraphQLBoostedPostAudienceOption f17540e;
    @Nullable
    GraphQLCurrencyQuantity f17541f;
    @Nullable
    FeedUnit f17542g;
    boolean f17543h;
    @Nullable
    String f17544i;
    int f17545j;
    @Nullable
    String f17546k;
    @Nullable
    GraphQLTextWithEntities f17547l;
    int f17548m;
    GraphQLBoostedPostStatus f17549n;
    long f17550o;

    @FieldOffset
    @Nullable
    public final GraphQLAdAccount m24695a() {
        this.f17539d = (GraphQLAdAccount) super.m9947a(this.f17539d, 0, GraphQLAdAccount.class);
        return this.f17539d;
    }

    @FieldOffset
    public final GraphQLBoostedPostAudienceOption m24698j() {
        this.f17540e = (GraphQLBoostedPostAudienceOption) super.m9945a(this.f17540e, 1, GraphQLBoostedPostAudienceOption.class, GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17540e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m24699k() {
        this.f17541f = (GraphQLCurrencyQuantity) super.m9947a(this.f17541f, 2, GraphQLCurrencyQuantity.class);
        return this.f17541f;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m24700l() {
        this.f17542g = (FeedUnit) super.m9946a(this.f17542g, 3, VirtualFlattenableResolverImpl.f15617a);
        return this.f17542g;
    }

    @FieldOffset
    public final boolean m24701m() {
        m9949a(0, 4);
        return this.f17543h;
    }

    @FieldOffset
    @Nullable
    public final String m24702n() {
        this.f17544i = super.m9948a(this.f17544i, 5);
        return this.f17544i;
    }

    @FieldOffset
    public final int m24703o() {
        m9949a(0, 6);
        return this.f17545j;
    }

    @FieldOffset
    @Nullable
    public final String m24704p() {
        this.f17546k = super.m9948a(this.f17546k, 7);
        return this.f17546k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24705q() {
        this.f17547l = (GraphQLTextWithEntities) super.m9947a(this.f17547l, 8, GraphQLTextWithEntities.class);
        return this.f17547l;
    }

    @FieldOffset
    public final int m24706r() {
        m9949a(1, 1);
        return this.f17548m;
    }

    @FieldOffset
    public final GraphQLBoostedPostStatus m24707s() {
        this.f17549n = (GraphQLBoostedPostStatus) super.m9945a(this.f17549n, 10, GraphQLBoostedPostStatus.class, GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17549n;
    }

    @FieldOffset
    public final long m24708t() {
        m9949a(1, 3);
        return this.f17550o;
    }

    public final int jK_() {
        return 349774914;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24695a() != null) {
            GraphQLAdAccount graphQLAdAccount = (GraphQLAdAccount) graphQLModelMutatingVisitor.mo2928b(m24695a());
            if (m24695a() != graphQLAdAccount) {
                graphQLVisitableModel = (GraphQLPagePostPromotionInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17539d = graphQLAdAccount;
            }
        }
        if (m24699k() != null) {
            GraphQLCurrencyQuantity graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.mo2928b(m24699k());
            if (m24699k() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLPagePostPromotionInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17541f = graphQLCurrencyQuantity;
            }
        }
        if (m24700l() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.mo2928b(m24700l());
            if (m24700l() != feedUnit) {
                graphQLVisitableModel = (GraphQLPagePostPromotionInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17542g = feedUnit;
            }
        }
        if (m24705q() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24705q());
            if (m24705q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPagePostPromotionInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17547l = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPagePostPromotionInfo() {
        super(14);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17543h = mutableFlatBuffer.m21540a(i, 4);
        this.f17545j = mutableFlatBuffer.m21524a(i, 6, 0);
        this.f17548m = mutableFlatBuffer.m21524a(i, 9, 0);
        this.f17550o = mutableFlatBuffer.m21525a(i, 11, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24695a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24699k());
        int a3 = flatBufferBuilder.m21476a(m24700l(), VirtualFlattenableResolverImpl.f15617a);
        int b = flatBufferBuilder.m21502b(m24702n());
        int b2 = flatBufferBuilder.m21502b(m24704p());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24705q());
        flatBufferBuilder.m21510c(13);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21496a(1, m24698j() == GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24698j());
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21498a(4, m24701m());
        flatBufferBuilder.m21507b(5, b);
        flatBufferBuilder.m21494a(6, m24703o(), 0);
        flatBufferBuilder.m21507b(7, b2);
        flatBufferBuilder.m21507b(8, a4);
        flatBufferBuilder.m21494a(9, m24706r(), 0);
        if (m24707s() != GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m24707s();
        }
        flatBufferBuilder.m21496a(10, enumR);
        flatBufferBuilder.m21495a(11, m24708t(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPagePostPromotionInfo(Parcel parcel) {
        super(14);
        this.f17539d = (GraphQLAdAccount) parcel.readValue(GraphQLAdAccount.class.getClassLoader());
        this.f17540e = GraphQLBoostedPostAudienceOption.fromString(parcel.readString());
        this.f17541f = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f17542g = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f17543h = parcel.readByte() == (byte) 1;
        this.f17544i = parcel.readString();
        this.f17545j = parcel.readInt();
        this.f17546k = parcel.readString();
        this.f17547l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17548m = parcel.readInt();
        this.f17549n = GraphQLBoostedPostStatus.fromString(parcel.readString());
        this.f17550o = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24695a());
        parcel.writeString(m24698j().name());
        parcel.writeValue(m24699k());
        parcel.writeValue(m24700l());
        parcel.writeByte((byte) (m24701m() ? 1 : 0));
        parcel.writeString(m24702n());
        parcel.writeInt(m24703o());
        parcel.writeString(m24704p());
        parcel.writeValue(m24705q());
        parcel.writeInt(m24706r());
        parcel.writeString(m24707s().name());
        parcel.writeLong(m24708t());
    }

    public GraphQLPagePostPromotionInfo(Builder builder) {
        super(14);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17539d = builder.d;
        this.f17540e = builder.e;
        this.f17541f = builder.f;
        this.f17542g = builder.g;
        this.f17543h = builder.h;
        this.f17544i = builder.i;
        this.f17545j = builder.j;
        this.f17546k = builder.k;
        this.f17547l = builder.l;
        this.f17548m = builder.m;
        this.f17549n = builder.n;
        this.f17550o = builder.o;
    }
}
