package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPrivacyOptionInfoType;
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
/* compiled from: presence_map_reset_on_mqtt_disconnect */
public final class GraphQLPrivacyOptionsContentEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPrivacyOptionsContentEdge> CREATOR = new C02021();
    boolean f4291d;
    @Nullable
    GraphQLPrivacyOption f4292e;
    GraphQLPrivacyOptionInfoType f4293f;

    /* compiled from: presence_map_reset_on_mqtt_disconnect */
    final class C02021 implements Creator<GraphQLPrivacyOptionsContentEdge> {
        C02021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPrivacyOptionsContentEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPrivacyOptionsContentEdge[i];
        }
    }

    @FieldOffset
    public final boolean m4828a() {
        a(0, 0);
        return this.f4291d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOption m4829j() {
        this.f4292e = (GraphQLPrivacyOption) super.a(this.f4292e, 1, GraphQLPrivacyOption.class);
        return this.f4292e;
    }

    @FieldOffset
    public final GraphQLPrivacyOptionInfoType m4830k() {
        this.f4293f = (GraphQLPrivacyOptionInfoType) super.a(this.f4293f, 2, GraphQLPrivacyOptionInfoType.class, GraphQLPrivacyOptionInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4293f;
    }

    public final int jK_() {
        return -1212476960;
    }

    public final GraphQLVisitableModel m4826a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m4829j() != null) {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m4829j());
            if (m4829j() != graphQLPrivacyOption) {
                graphQLVisitableModel = (GraphQLPrivacyOptionsContentEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4292e = graphQLPrivacyOption;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPrivacyOptionsContentEdge() {
        super(4);
    }

    public final void m4827a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4291d = mutableFlatBuffer.a(i, 0);
    }

    public final int m4825a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m4829j());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, m4828a());
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.a(2, m4830k() == GraphQLPrivacyOptionInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m4830k());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPrivacyOptionsContentEdge(Parcel parcel) {
        boolean z = true;
        super(4);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4291d = z;
        this.f4292e = (GraphQLPrivacyOption) parcel.readValue(GraphQLPrivacyOption.class.getClassLoader());
        this.f4293f = GraphQLPrivacyOptionInfoType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m4828a() ? 1 : 0));
        parcel.writeValue(m4829j());
        parcel.writeString(m4830k().name());
    }

    public GraphQLPrivacyOptionsContentEdge(Builder builder) {
        super(4);
        this.b = builder.a;
        this.c = builder.b;
        this.f4291d = builder.d;
        this.f4292e = builder.e;
        this.f4293f = builder.f;
    }
}
