package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDateGranularity;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: inline_responded */
public final class GraphQLBackdatedTime extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLBackdatedTime> CREATOR = new 1();
    public GraphQLDateGranularity f19879d;
    public long f19880e;

    @FieldOffset
    public final GraphQLDateGranularity m27638a() {
        this.f19879d = (GraphQLDateGranularity) super.m9945a(this.f19879d, 0, GraphQLDateGranularity.class, GraphQLDateGranularity.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f19879d;
    }

    @FieldOffset
    public final long m27641j() {
        m9949a(0, 1);
        return this.f19880e;
    }

    public final int jK_() {
        return 144531772;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLBackdatedTime() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19880e = mutableFlatBuffer.m21525a(i, 1, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21496a(0, m27638a() == GraphQLDateGranularity.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m27638a());
        flatBufferBuilder.m21495a(1, m27641j(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLBackdatedTime(Parcel parcel) {
        super(3);
        this.f19879d = GraphQLDateGranularity.fromString(parcel.readString());
        this.f19880e = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m27638a().name());
        parcel.writeLong(m27641j());
    }
}
