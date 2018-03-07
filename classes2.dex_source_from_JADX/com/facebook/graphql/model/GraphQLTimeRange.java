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
/* compiled from: live_video_invite_friends */
public final class GraphQLTimeRange extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTimeRange> CREATOR = new 1();
    public long f17311d;
    public long f17312e;

    @FieldOffset
    public final long m24373a() {
        m9949a(0, 0);
        return this.f17311d;
    }

    @FieldOffset
    public final long m24376j() {
        m9949a(0, 1);
        return this.f17312e;
    }

    public final int jK_() {
        return 2028064336;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLTimeRange() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17311d = mutableFlatBuffer.m21525a(i, 0, 0);
        this.f17312e = mutableFlatBuffer.m21525a(i, 1, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21495a(0, m24373a(), 0);
        flatBufferBuilder.m21495a(1, m24376j(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTimeRange(Parcel parcel) {
        super(3);
        this.f17311d = parcel.readLong();
        this.f17312e = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(m24373a());
        parcel.writeLong(m24376j());
    }
}
