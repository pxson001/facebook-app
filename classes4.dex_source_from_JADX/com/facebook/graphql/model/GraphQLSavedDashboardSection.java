package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: user_fbids */
public final class GraphQLSavedDashboardSection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSavedDashboardSection> CREATOR = new C00401();
    public GraphQLSavedDashboardSectionType f410d;

    /* compiled from: user_fbids */
    final class C00401 implements Creator<GraphQLSavedDashboardSection> {
        C00401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSavedDashboardSection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSavedDashboardSection[i];
        }
    }

    @FieldOffset
    public final GraphQLSavedDashboardSectionType m697a() {
        this.f410d = (GraphQLSavedDashboardSectionType) super.a(this.f410d, 0, GraphQLSavedDashboardSectionType.class, GraphQLSavedDashboardSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f410d;
    }

    public final int jK_() {
        return -1926237640;
    }

    public final GraphQLVisitableModel m698a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLSavedDashboardSection() {
        super(2);
    }

    public final int m696a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, m697a() == GraphQLSavedDashboardSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m697a());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSavedDashboardSection(Parcel parcel) {
        super(2);
        this.f410d = GraphQLSavedDashboardSectionType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m697a().name());
    }

    public GraphQLSavedDashboardSection(Builder builder) {
        super(2);
        this.b = builder.a;
        this.c = builder.b;
        this.f410d = builder.d;
    }
}
