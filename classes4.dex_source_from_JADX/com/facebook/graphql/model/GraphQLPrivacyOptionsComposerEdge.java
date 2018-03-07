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
/* compiled from: sms/%s */
public final class GraphQLPrivacyOptionsComposerEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPrivacyOptionsComposerEdge> CREATOR = new C01101();
    public boolean f2134d;
    public boolean f2135e;
    public boolean f2136f;
    @Nullable
    public GraphQLPrivacyOption f2137g;
    public GraphQLPrivacyOptionInfoType f2138h;

    /* compiled from: sms/%s */
    final class C01101 implements Creator<GraphQLPrivacyOptionsComposerEdge> {
        C01101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPrivacyOptionsComposerEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPrivacyOptionsComposerEdge[i];
        }
    }

    @FieldOffset
    public final boolean m2250a() {
        a(0, 0);
        return this.f2134d;
    }

    @FieldOffset
    public final boolean m2251j() {
        a(0, 1);
        return this.f2135e;
    }

    @FieldOffset
    public final boolean m2252k() {
        a(0, 2);
        return this.f2136f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOption m2253l() {
        this.f2137g = (GraphQLPrivacyOption) super.a(this.f2137g, 3, GraphQLPrivacyOption.class);
        return this.f2137g;
    }

    @FieldOffset
    public final GraphQLPrivacyOptionInfoType m2254m() {
        this.f2138h = (GraphQLPrivacyOptionInfoType) super.a(this.f2138h, 4, GraphQLPrivacyOptionInfoType.class, GraphQLPrivacyOptionInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f2138h;
    }

    public final int jK_() {
        return -93703117;
    }

    public final GraphQLVisitableModel m2248a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2253l() != null) {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m2253l());
            if (m2253l() != graphQLPrivacyOption) {
                graphQLVisitableModel = (GraphQLPrivacyOptionsComposerEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f2137g = graphQLPrivacyOption;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPrivacyOptionsComposerEdge() {
        super(6);
    }

    public final void m2249a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f2134d = mutableFlatBuffer.a(i, 0);
        this.f2135e = mutableFlatBuffer.a(i, 1);
        this.f2136f = mutableFlatBuffer.a(i, 2);
    }

    public final int m2247a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2253l());
        flatBufferBuilder.c(5);
        flatBufferBuilder.a(0, m2250a());
        flatBufferBuilder.a(1, m2251j());
        flatBufferBuilder.a(2, m2252k());
        flatBufferBuilder.b(3, a);
        flatBufferBuilder.a(4, m2254m() == GraphQLPrivacyOptionInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m2254m());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPrivacyOptionsComposerEdge(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(6);
        this.f2134d = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2135e = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f2136f = z2;
        this.f2137g = (GraphQLPrivacyOption) parcel.readValue(GraphQLPrivacyOption.class.getClassLoader());
        this.f2138h = GraphQLPrivacyOptionInfoType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (m2250a() ? 1 : 0));
        if (m2251j()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m2252k()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(m2253l());
        parcel.writeString(m2254m().name());
    }
}
