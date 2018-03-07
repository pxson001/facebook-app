package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLRedSpaceVisibilityState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: liger_init */
public final class GraphQLRedSpaceStoryInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLRedSpaceStoryInfo> CREATOR = new 1();
    public GraphQLRedSpaceVisibilityState f17556d;

    @FieldOffset
    public final GraphQLRedSpaceVisibilityState m24721a() {
        this.f17556d = (GraphQLRedSpaceVisibilityState) super.m9945a(this.f17556d, 0, GraphQLRedSpaceVisibilityState.class, GraphQLRedSpaceVisibilityState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17556d;
    }

    public final int jK_() {
        return 1073821614;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLRedSpaceStoryInfo() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21496a(0, m24721a() == GraphQLRedSpaceVisibilityState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24721a());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLRedSpaceStoryInfo(Parcel parcel) {
        super(2);
        this.f17556d = GraphQLRedSpaceVisibilityState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24721a().name());
    }

    public GraphQLRedSpaceStoryInfo(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17556d = builder.d;
    }
}
