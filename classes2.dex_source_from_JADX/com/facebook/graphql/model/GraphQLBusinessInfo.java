package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLBusinessInfoType;
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
/* compiled from: local_serps_android_v51 */
public final class GraphQLBusinessInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLBusinessInfo> CREATOR = new 1();
    @Nullable
    public String f17010d;
    @Deprecated
    public GraphQLBusinessInfoType f17011e;
    @Nullable
    public GraphQLTextWithEntities f17012f;

    @FieldOffset
    @Nullable
    public final String m24000a() {
        this.f17010d = super.m9948a(this.f17010d, 0);
        return this.f17010d;
    }

    @FieldOffset
    public final GraphQLBusinessInfoType m24001j() {
        this.f17011e = (GraphQLBusinessInfoType) super.m9945a(this.f17011e, 1, GraphQLBusinessInfoType.class, GraphQLBusinessInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17011e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24002k() {
        this.f17012f = (GraphQLTextWithEntities) super.m9947a(this.f17012f, 2, GraphQLTextWithEntities.class);
        return this.f17012f;
    }

    public final int jK_() {
        return -508752722;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24002k() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24002k());
            if (m24002k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLBusinessInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17012f = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLBusinessInfo() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24000a());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24002k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21496a(1, m24001j() == GraphQLBusinessInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24001j());
        flatBufferBuilder.m21507b(2, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLBusinessInfo(Parcel parcel) {
        super(4);
        this.f17010d = parcel.readString();
        this.f17011e = GraphQLBusinessInfoType.fromString(parcel.readString());
        this.f17012f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24000a());
        parcel.writeString(m24001j().name());
        parcel.writeValue(m24002k());
    }
}
