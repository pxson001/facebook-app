package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBumpReason;
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
/* compiled from: mFragmentId=# */
public final class GraphQLNewsFeedEdge extends BaseModel implements NewsFeedEdge, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNewsFeedEdge> CREATOR = new C06721();
    public GraphQLBumpReason f15608d;
    @Nullable
    public String f15609e;
    @Nullable
    public String f15610f;
    public boolean f15611g;
    @Nullable
    public String f15612h;
    public boolean f15613i;
    @Nullable
    public FeedUnit f15614j;
    public double f15615k;
    @Nullable
    public String f15616l;

    /* compiled from: mFragmentId=# */
    final class C06721 implements Creator<GraphQLNewsFeedEdge> {
        C06721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNewsFeedEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNewsFeedEdge[i];
        }
    }

    @FieldOffset
    public final GraphQLBumpReason mo2860a() {
        this.f15608d = (GraphQLBumpReason) super.m9945a(this.f15608d, 0, GraphQLBumpReason.class, GraphQLBumpReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f15608d;
    }

    @FieldOffset
    @Nullable
    public final String mo2861j() {
        this.f15609e = super.m9948a(this.f15609e, 1);
        return this.f15609e;
    }

    @FieldOffset
    @Nullable
    public final String mo2862k() {
        this.f15610f = super.m9948a(this.f15610f, 2);
        return this.f15610f;
    }

    @FieldOffset
    public final boolean mo2863l() {
        m9949a(0, 3);
        return this.f15611g;
    }

    @FieldOffset
    @Nullable
    public final String mo2864m() {
        this.f15612h = super.m9948a(this.f15612h, 4);
        return this.f15612h;
    }

    @FieldOffset
    public final boolean m22236n() {
        m9949a(0, 5);
        return this.f15613i;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit mo2865o() {
        this.f15614j = (FeedUnit) super.m9946a(this.f15614j, 6, VirtualFlattenableResolverImpl.f15617a);
        return this.f15614j;
    }

    @FieldOffset
    public final double mo2866p() {
        m9949a(0, 7);
        return this.f15615k;
    }

    @FieldOffset
    @Nullable
    public final String mo2867q() {
        this.f15616l = super.m9948a(this.f15616l, 8);
        return this.f15616l;
    }

    public final int jK_() {
        return 933202062;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (mo2865o() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.mo2928b(mo2865o());
            if (mo2865o() != feedUnit) {
                graphQLVisitableModel = (GraphQLNewsFeedEdge) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15614j = feedUnit;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNewsFeedEdge() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15611g = mutableFlatBuffer.m21540a(i, 3);
        this.f15613i = mutableFlatBuffer.m21540a(i, 5);
        this.f15615k = mutableFlatBuffer.m21523a(i, 7, 0.0d);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2861j());
        int b2 = flatBufferBuilder.m21502b(mo2862k());
        int b3 = flatBufferBuilder.m21502b(mo2864m());
        int a = flatBufferBuilder.m21476a(mo2865o(), VirtualFlattenableResolverImpl.f15617a);
        int b4 = flatBufferBuilder.m21502b(mo2867q());
        flatBufferBuilder.m21510c(9);
        flatBufferBuilder.m21496a(0, mo2860a() == GraphQLBumpReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : mo2860a());
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21498a(3, mo2863l());
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21498a(5, m22236n());
        flatBufferBuilder.m21507b(6, a);
        flatBufferBuilder.m21492a(7, mo2866p(), 0.0d);
        flatBufferBuilder.m21507b(8, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLNewsFeedEdge(Parcel parcel) {
        boolean z = true;
        super(10);
        this.f15608d = GraphQLBumpReason.fromString(parcel.readString());
        this.f15609e = parcel.readString();
        this.f15610f = parcel.readString();
        this.f15611g = parcel.readByte() == (byte) 1;
        this.f15612h = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f15613i = z;
        this.f15614j = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f15615k = parcel.readDouble();
        this.f15616l = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(mo2860a().name());
        parcel.writeString(mo2861j());
        parcel.writeString(mo2862k());
        parcel.writeByte((byte) (mo2863l() ? 1 : 0));
        parcel.writeString(mo2864m());
        if (!m22236n()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(mo2865o());
        parcel.writeDouble(mo2866p());
        parcel.writeString(mo2867q());
    }
}
