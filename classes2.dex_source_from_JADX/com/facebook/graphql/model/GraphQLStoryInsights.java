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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: live_comment_log_delay */
public final class GraphQLStoryInsights extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStoryInsights> CREATOR = new 1();
    public int f17319d;
    public int f17320e;
    public int f17321f;
    public int f17322g;
    public int f17323h;
    public int f17324i;
    public int f17325j;
    public int f17326k;
    public int f17327l;
    public int f17328m;

    @FieldOffset
    public final int m24390a() {
        m9949a(0, 0);
        return this.f17319d;
    }

    @FieldOffset
    public final int m24394j() {
        m9949a(0, 1);
        return this.f17320e;
    }

    @FieldOffset
    public final int m24395k() {
        m9949a(0, 2);
        return this.f17321f;
    }

    @FieldOffset
    public final int m24396l() {
        m9949a(0, 3);
        return this.f17322g;
    }

    @FieldOffset
    public final int m24397m() {
        m9949a(0, 4);
        return this.f17323h;
    }

    @FieldOffset
    public final int m24398n() {
        m9949a(0, 5);
        return this.f17324i;
    }

    @FieldOffset
    public final int m24399o() {
        m9949a(0, 6);
        return this.f17325j;
    }

    @FieldOffset
    public final int m24400p() {
        m9949a(0, 7);
        return this.f17326k;
    }

    @FieldOffset
    public final int m24401q() {
        m9949a(1, 0);
        return this.f17327l;
    }

    @FieldOffset
    public final int m24402r() {
        m9949a(1, 1);
        return this.f17328m;
    }

    public final int jK_() {
        return 1636368336;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLStoryInsights() {
        super(11);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17319d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17320e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f17321f = mutableFlatBuffer.m21524a(i, 2, 0);
        this.f17322g = mutableFlatBuffer.m21524a(i, 3, 0);
        this.f17323h = mutableFlatBuffer.m21524a(i, 4, 0);
        this.f17324i = mutableFlatBuffer.m21524a(i, 5, 0);
        this.f17325j = mutableFlatBuffer.m21524a(i, 6, 0);
        this.f17326k = mutableFlatBuffer.m21524a(i, 7, 0);
        this.f17327l = mutableFlatBuffer.m21524a(i, 8, 0);
        this.f17328m = mutableFlatBuffer.m21524a(i, 9, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(10);
        flatBufferBuilder.m21494a(0, m24390a(), 0);
        flatBufferBuilder.m21494a(1, m24394j(), 0);
        flatBufferBuilder.m21494a(2, m24395k(), 0);
        flatBufferBuilder.m21494a(3, m24396l(), 0);
        flatBufferBuilder.m21494a(4, m24397m(), 0);
        flatBufferBuilder.m21494a(5, m24398n(), 0);
        flatBufferBuilder.m21494a(6, m24399o(), 0);
        flatBufferBuilder.m21494a(7, m24400p(), 0);
        flatBufferBuilder.m21494a(8, m24401q(), 0);
        flatBufferBuilder.m21494a(9, m24402r(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStoryInsights(Parcel parcel) {
        super(11);
        this.f17319d = parcel.readInt();
        this.f17320e = parcel.readInt();
        this.f17321f = parcel.readInt();
        this.f17322g = parcel.readInt();
        this.f17323h = parcel.readInt();
        this.f17324i = parcel.readInt();
        this.f17325j = parcel.readInt();
        this.f17326k = parcel.readInt();
        this.f17327l = parcel.readInt();
        this.f17328m = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24390a());
        parcel.writeInt(m24394j());
        parcel.writeInt(m24395k());
        parcel.writeInt(m24396l());
        parcel.writeInt(m24397m());
        parcel.writeInt(m24398n());
        parcel.writeInt(m24399o());
        parcel.writeInt(m24400p());
        parcel.writeInt(m24401q());
        parcel.writeInt(m24402r());
    }
}
