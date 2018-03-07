package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
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
/* compiled from: should be passed some notifs */
public final class GraphQLAudienceInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAudienceInfo> CREATOR = new C01601();
    @Nullable
    GraphQLComposerPrivacyGuardrailInfo f2207d;
    boolean f2208e;
    boolean f2209f;
    boolean f2210g;
    boolean f2211h;

    /* compiled from: should be passed some notifs */
    final class C01601 implements Creator<GraphQLAudienceInfo> {
        C01601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAudienceInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAudienceInfo[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLComposerPrivacyGuardrailInfo m2391a() {
        this.f2207d = (GraphQLComposerPrivacyGuardrailInfo) super.a(this.f2207d, 0, GraphQLComposerPrivacyGuardrailInfo.class);
        return this.f2207d;
    }

    @FieldOffset
    public final boolean m2394j() {
        a(0, 1);
        return this.f2208e;
    }

    @FieldOffset
    public final boolean m2395k() {
        a(0, 2);
        return this.f2209f;
    }

    @FieldOffset
    public final boolean m2396l() {
        a(0, 3);
        return this.f2210g;
    }

    @FieldOffset
    public final boolean m2397m() {
        a(0, 4);
        return this.f2211h;
    }

    public final int jK_() {
        return -1563921166;
    }

    public final GraphQLVisitableModel m2392a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2391a() != null) {
            GraphQLComposerPrivacyGuardrailInfo graphQLComposerPrivacyGuardrailInfo = (GraphQLComposerPrivacyGuardrailInfo) graphQLModelMutatingVisitor.b(m2391a());
            if (m2391a() != graphQLComposerPrivacyGuardrailInfo) {
                graphQLVisitableModel = (GraphQLAudienceInfo) ModelHelper.a(null, this);
                graphQLVisitableModel.f2207d = graphQLComposerPrivacyGuardrailInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAudienceInfo() {
        super(6);
    }

    public final void m2393a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f2208e = mutableFlatBuffer.a(i, 1);
        this.f2209f = mutableFlatBuffer.a(i, 2);
        this.f2210g = mutableFlatBuffer.a(i, 3);
        this.f2211h = mutableFlatBuffer.a(i, 4);
    }

    public final int m2390a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2391a());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m2394j());
        flatBufferBuilder.a(2, m2395k());
        flatBufferBuilder.a(3, m2396l());
        flatBufferBuilder.a(4, m2397m());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAudienceInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(6);
        this.f2207d = (GraphQLComposerPrivacyGuardrailInfo) parcel.readValue(GraphQLComposerPrivacyGuardrailInfo.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2208e = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2209f = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2210g = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f2211h = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m2391a());
        if (m2394j()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m2395k()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m2396l()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m2397m()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
