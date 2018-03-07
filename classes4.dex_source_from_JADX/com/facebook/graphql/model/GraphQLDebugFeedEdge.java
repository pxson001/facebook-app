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
/* compiled from: viewerImpressions */
public final class GraphQLDebugFeedEdge extends BaseModel implements NewsFeedEdge, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLDebugFeedEdge> CREATOR = new C01271();
    public GraphQLBumpReason f224d;
    @Nullable
    public String f225e;
    @Nullable
    public String f226f;
    public boolean f227g;
    @Nullable
    public String f228h;
    public boolean f229i;
    @Nullable
    public FeedUnit f230j;
    public double f231k;
    @Nullable
    public String f232l;

    /* compiled from: viewerImpressions */
    final class C01271 implements Creator<GraphQLDebugFeedEdge> {
        C01271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLDebugFeedEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLDebugFeedEdge[i];
        }
    }

    @FieldOffset
    public final GraphQLBumpReason m257a() {
        this.f224d = (GraphQLBumpReason) super.a(this.f224d, 0, GraphQLBumpReason.class, GraphQLBumpReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f224d;
    }

    @FieldOffset
    @Nullable
    public final String m260j() {
        this.f225e = super.a(this.f225e, 1);
        return this.f225e;
    }

    @FieldOffset
    @Nullable
    public final String m261k() {
        this.f226f = super.a(this.f226f, 2);
        return this.f226f;
    }

    @FieldOffset
    public final boolean m262l() {
        a(0, 3);
        return this.f227g;
    }

    @FieldOffset
    @Nullable
    public final String m263m() {
        this.f228h = super.a(this.f228h, 4);
        return this.f228h;
    }

    @FieldOffset
    public final boolean m264n() {
        a(0, 5);
        return this.f229i;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m265o() {
        this.f230j = (FeedUnit) super.a(this.f230j, 6, VirtualFlattenableResolverImpl.a);
        return this.f230j;
    }

    @FieldOffset
    public final double m266p() {
        a(0, 7);
        return this.f231k;
    }

    @FieldOffset
    @Nullable
    public final String m267q() {
        this.f232l = super.a(this.f232l, 8);
        return this.f232l;
    }

    public final int jK_() {
        return -1460867122;
    }

    public final GraphQLVisitableModel m258a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m265o() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m265o());
            if (m265o() != feedUnit) {
                graphQLVisitableModel = (GraphQLDebugFeedEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f230j = feedUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLDebugFeedEdge() {
        super(10);
    }

    public final void m259a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f227g = mutableFlatBuffer.a(i, 3);
        this.f229i = mutableFlatBuffer.a(i, 5);
        this.f231k = mutableFlatBuffer.a(i, 7, 0.0d);
    }

    public final int m256a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m260j());
        int b2 = flatBufferBuilder.b(m261k());
        int b3 = flatBufferBuilder.b(m263m());
        int a = flatBufferBuilder.a(m265o(), VirtualFlattenableResolverImpl.a);
        int b4 = flatBufferBuilder.b(m267q());
        flatBufferBuilder.c(9);
        flatBufferBuilder.a(0, m257a() == GraphQLBumpReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m257a());
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.a(3, m262l());
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.a(5, m264n());
        flatBufferBuilder.b(6, a);
        flatBufferBuilder.a(7, m266p(), 0.0d);
        flatBufferBuilder.b(8, b4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLDebugFeedEdge(Parcel parcel) {
        boolean z = true;
        super(10);
        this.f224d = GraphQLBumpReason.fromString(parcel.readString());
        this.f225e = parcel.readString();
        this.f226f = parcel.readString();
        this.f227g = parcel.readByte() == (byte) 1;
        this.f228h = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f229i = z;
        this.f230j = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f231k = parcel.readDouble();
        this.f232l = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(m257a().name());
        parcel.writeString(m260j());
        parcel.writeString(m261k());
        parcel.writeByte((byte) (m262l() ? 1 : 0));
        parcel.writeString(m263m());
        if (!m264n()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m265o());
        parcel.writeDouble(m266p());
        parcel.writeString(m267q());
    }
}
