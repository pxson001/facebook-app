package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLRedirectionReason;
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
/* compiled from: liger_network_status_monitor_android */
public final class GraphQLRedirectionInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLRedirectionInfo> CREATOR = new 1();
    @Nullable
    GraphQLNode f17553d;
    GraphQLRedirectionReason f17554e;
    @Nullable
    String f17555f;

    @FieldOffset
    @Nullable
    public final GraphQLNode m24716a() {
        this.f17553d = (GraphQLNode) super.m9947a(this.f17553d, 0, GraphQLNode.class);
        return this.f17553d;
    }

    @FieldOffset
    public final GraphQLRedirectionReason m24718j() {
        this.f17554e = (GraphQLRedirectionReason) super.m9945a(this.f17554e, 1, GraphQLRedirectionReason.class, GraphQLRedirectionReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17554e;
    }

    @FieldOffset
    @Nullable
    public final String m24719k() {
        this.f17555f = super.m9948a(this.f17555f, 2);
        return this.f17555f;
    }

    public final int jK_() {
        return -986866342;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24716a() != null) {
            GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.mo2928b(m24716a());
            if (m24716a() != graphQLNode) {
                graphQLVisitableModel = (GraphQLRedirectionInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17553d = graphQLNode;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLRedirectionInfo() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24716a());
        int b = flatBufferBuilder.m21502b(m24719k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21496a(1, m24718j() == GraphQLRedirectionReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24718j());
        flatBufferBuilder.m21507b(2, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLRedirectionInfo(Parcel parcel) {
        super(4);
        this.f17553d = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f17554e = GraphQLRedirectionReason.fromString(parcel.readString());
        this.f17555f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24716a());
        parcel.writeString(m24718j().name());
        parcel.writeString(m24719k());
    }

    public GraphQLRedirectionInfo(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17553d = builder.d;
        this.f17554e = builder.e;
        this.f17555f = builder.f;
    }
}
