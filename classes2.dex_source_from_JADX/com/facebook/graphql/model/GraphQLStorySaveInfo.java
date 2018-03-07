package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.graphql.enums.GraphQLStorySaveType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: liger_executor_init */
public final class GraphQLStorySaveInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStorySaveInfo> CREATOR = new C08021();
    public int f17606d;
    public int f17607e;
    public GraphQLStorySaveNuxType f17608f;
    public GraphQLStorySaveType f17609g;
    public GraphQLSavedState f17610h;

    /* compiled from: liger_executor_init */
    final class C08021 implements Creator<GraphQLStorySaveInfo> {
        C08021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStorySaveInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStorySaveInfo[i];
        }
    }

    @FieldOffset
    public final int m24770a() {
        m9949a(0, 0);
        return this.f17606d;
    }

    @FieldOffset
    public final int m24775j() {
        m9949a(0, 1);
        return this.f17607e;
    }

    @FieldOffset
    public final GraphQLStorySaveNuxType m24776k() {
        this.f17608f = (GraphQLStorySaveNuxType) super.m9945a(this.f17608f, 2, GraphQLStorySaveNuxType.class, GraphQLStorySaveNuxType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17608f;
    }

    @FieldOffset
    public final GraphQLStorySaveType m24777l() {
        this.f17609g = (GraphQLStorySaveType) super.m9945a(this.f17609g, 3, GraphQLStorySaveType.class, GraphQLStorySaveType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17609g;
    }

    @FieldOffset
    public final GraphQLSavedState m24778m() {
        this.f17610h = (GraphQLSavedState) super.m9945a(this.f17610h, 4, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17610h;
    }

    final void m24774a(GraphQLSavedState graphQLSavedState) {
        this.f17610h = graphQLSavedState;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21536a(this.f5824c, 4, (Enum) graphQLSavedState);
        }
    }

    public final int jK_() {
        return -981705792;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLStorySaveInfo() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17606d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17607e = mutableFlatBuffer.m21524a(i, 1, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21494a(0, m24770a(), 0);
        flatBufferBuilder.m21494a(1, m24775j(), 0);
        flatBufferBuilder.m21496a(2, m24776k() == GraphQLStorySaveNuxType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24776k());
        flatBufferBuilder.m21496a(3, m24777l() == GraphQLStorySaveType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24777l());
        if (m24778m() != GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m24778m();
        }
        flatBufferBuilder.m21496a(4, enumR);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStorySaveInfo(Parcel parcel) {
        super(6);
        this.f17606d = parcel.readInt();
        this.f17607e = parcel.readInt();
        this.f17608f = GraphQLStorySaveNuxType.fromString(parcel.readString());
        this.f17609g = GraphQLStorySaveType.fromString(parcel.readString());
        this.f17610h = GraphQLSavedState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24770a());
        parcel.writeInt(m24775j());
        parcel.writeString(m24776k().name());
        parcel.writeString(m24777l().name());
        parcel.writeString(m24778m().name());
    }

    public GraphQLStorySaveInfo(Builder builder) {
        super(6);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17606d = builder.d;
        this.f17607e = builder.e;
        this.f17608f = builder.f;
        this.f17609g = builder.g;
        this.f17610h = builder.h;
    }
}
