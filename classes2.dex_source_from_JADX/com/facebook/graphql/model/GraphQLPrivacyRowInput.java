package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localsell_message/?threadID=%s&assetIDs=%s */
public final class GraphQLPrivacyRowInput extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPrivacyRowInput> CREATOR = new 1();
    public List<String> f16782d;
    public GraphQLPrivacyBaseState f16783e;
    public List<String> f16784f;
    public GraphQLPrivacyTagExpansionState f16785g;

    @FieldOffset
    public final ImmutableList<String> m23724a() {
        this.f16782d = super.m9943a(this.f16782d, 0);
        return (ImmutableList) this.f16782d;
    }

    @FieldOffset
    public final GraphQLPrivacyBaseState m23725j() {
        this.f16783e = (GraphQLPrivacyBaseState) super.m9945a(this.f16783e, 1, GraphQLPrivacyBaseState.class, GraphQLPrivacyBaseState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16783e;
    }

    @FieldOffset
    public final ImmutableList<String> m23726k() {
        this.f16784f = super.m9943a(this.f16784f, 2);
        return (ImmutableList) this.f16784f;
    }

    @FieldOffset
    public final GraphQLPrivacyTagExpansionState m23727l() {
        this.f16785g = (GraphQLPrivacyTagExpansionState) super.m9945a(this.f16785g, 3, GraphQLPrivacyTagExpansionState.class, GraphQLPrivacyTagExpansionState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16785g;
    }

    public final int jK_() {
        return 93912472;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLPrivacyRowInput() {
        super(5);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        int c = flatBufferBuilder.m21509c(m23724a());
        int c2 = flatBufferBuilder.m21509c(m23726k());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, c);
        flatBufferBuilder.m21496a(1, m23725j() == GraphQLPrivacyBaseState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23725j());
        flatBufferBuilder.m21507b(2, c2);
        if (m23727l() != GraphQLPrivacyTagExpansionState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m23727l();
        }
        flatBufferBuilder.m21496a(3, enumR);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPrivacyRowInput(Parcel parcel) {
        super(5);
        this.f16782d = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16783e = GraphQLPrivacyBaseState.fromString(parcel.readString());
        this.f16784f = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16785g = GraphQLPrivacyTagExpansionState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m23724a());
        parcel.writeString(m23725j().name());
        parcel.writeList(m23726k());
        parcel.writeString(m23727l().name());
    }

    public GraphQLPrivacyRowInput(Builder builder) {
        super(5);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16782d = builder.d;
        this.f16783e = builder.e;
        this.f16784f = builder.f;
        this.f16785g = builder.g;
    }
}
