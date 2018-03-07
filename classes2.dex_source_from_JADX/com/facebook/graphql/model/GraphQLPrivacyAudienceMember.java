package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces$PrivacyAudienceMember;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localsell_product_details */
public final class GraphQLPrivacyAudienceMember extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel, PrivacyOptionsGraphQLInterfaces$PrivacyAudienceMember {
    public static final Creator<GraphQLPrivacyAudienceMember> CREATOR = new 1();
    @Nullable
    public GraphQLObjectType f16779d;
    @Nullable
    public String f16780e;
    @Nullable
    public String f16781f;

    @Nullable
    public final GraphQLObjectType mo2954b() {
        if (this.f5823b != null && this.f16779d == null) {
            this.f16779d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16779d == null || this.f16779d.m22301g() != 0) {
            return this.f16779d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String mo2955c() {
        this.f16780e = super.m9948a(this.f16780e, 1);
        return this.f16780e;
    }

    @FieldOffset
    @Nullable
    public final String mo2956d() {
        this.f16781f = super.m9948a(this.f16781f, 2);
        return this.f16781f;
    }

    @Nullable
    public final String mo2834a() {
        return mo2955c();
    }

    public final int jK_() {
        return 1766866758;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLPrivacyAudienceMember() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(mo2954b() != null ? mo2954b().m22299e() : null);
        int b = flatBufferBuilder.m21502b(mo2955c());
        int b2 = flatBufferBuilder.m21502b(mo2956d());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPrivacyAudienceMember(Parcel parcel) {
        super(4);
        this.f16780e = parcel.readString();
        this.f16781f = parcel.readString();
        this.f16779d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2955c());
        parcel.writeString(mo2956d());
        parcel.writeParcelable(this.f16779d, i);
    }

    public GraphQLPrivacyAudienceMember(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16780e = builder.d;
        this.f16781f = builder.e;
        this.f16779d = builder.f;
    }
}
