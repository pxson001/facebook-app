package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: logVideoPlayerStopEvent */
public final class GraphQLLeadGenErrorNode extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenErrorNode> CREATOR = new 1();
    @Nullable
    public String f16291d;
    public GraphQLLeadGenInfoFieldInputType f16292e;

    @FieldOffset
    @Nullable
    public final String m23127a() {
        this.f16291d = super.m9948a(this.f16291d, 0);
        return this.f16291d;
    }

    @FieldOffset
    public final GraphQLLeadGenInfoFieldInputType m23128j() {
        this.f16292e = (GraphQLLeadGenInfoFieldInputType) super.m9945a(this.f16292e, 1, GraphQLLeadGenInfoFieldInputType.class, GraphQLLeadGenInfoFieldInputType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16292e;
    }

    public final int jK_() {
        return -1908897706;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLLeadGenErrorNode() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23127a());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21496a(1, m23128j() == GraphQLLeadGenInfoFieldInputType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23128j());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLLeadGenErrorNode(Parcel parcel) {
        super(3);
        this.f16291d = parcel.readString();
        this.f16292e = GraphQLLeadGenInfoFieldInputType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m23127a());
        parcel.writeString(m23128j().name());
    }
}
