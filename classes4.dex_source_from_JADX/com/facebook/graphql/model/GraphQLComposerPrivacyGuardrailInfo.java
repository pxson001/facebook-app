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
/* compiled from: refetch_calling_class */
public final class GraphQLComposerPrivacyGuardrailInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLComposerPrivacyGuardrailInfo> CREATOR = new C01611();
    @Nullable
    GraphQLPrivacyOption f3533d;
    boolean f3534e;
    long f3535f;
    @Nullable
    GraphQLPrivacyOption f3536g;

    /* compiled from: refetch_calling_class */
    final class C01611 implements Creator<GraphQLComposerPrivacyGuardrailInfo> {
        C01611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLComposerPrivacyGuardrailInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLComposerPrivacyGuardrailInfo[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOption m3920a() {
        this.f3533d = (GraphQLPrivacyOption) super.a(this.f3533d, 0, GraphQLPrivacyOption.class);
        return this.f3533d;
    }

    @FieldOffset
    public final boolean m3923j() {
        a(0, 1);
        return this.f3534e;
    }

    @FieldOffset
    public final long m3924k() {
        a(0, 2);
        return this.f3535f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOption m3925l() {
        this.f3536g = (GraphQLPrivacyOption) super.a(this.f3536g, 3, GraphQLPrivacyOption.class);
        return this.f3536g;
    }

    public final int jK_() {
        return 1464137661;
    }

    public final GraphQLVisitableModel m3921a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPrivacyOption graphQLPrivacyOption;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3920a() != null) {
            graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m3920a());
            if (m3920a() != graphQLPrivacyOption) {
                graphQLVisitableModel = (GraphQLComposerPrivacyGuardrailInfo) ModelHelper.a(null, this);
                graphQLVisitableModel.f3533d = graphQLPrivacyOption;
            }
        }
        if (m3925l() != null) {
            graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m3925l());
            if (m3925l() != graphQLPrivacyOption) {
                graphQLVisitableModel = (GraphQLComposerPrivacyGuardrailInfo) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3536g = graphQLPrivacyOption;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLComposerPrivacyGuardrailInfo() {
        super(5);
    }

    public final void m3922a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3534e = mutableFlatBuffer.a(i, 1);
        this.f3535f = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m3919a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3920a());
        int a2 = ModelHelper.a(flatBufferBuilder, m3925l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m3923j());
        flatBufferBuilder.a(2, m3924k(), 0);
        flatBufferBuilder.b(3, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLComposerPrivacyGuardrailInfo(Parcel parcel) {
        super(5);
        this.f3533d = (GraphQLPrivacyOption) parcel.readValue(GraphQLPrivacyOption.class.getClassLoader());
        this.f3534e = parcel.readByte() == (byte) 1;
        this.f3535f = parcel.readLong();
        this.f3536g = (GraphQLPrivacyOption) parcel.readValue(GraphQLPrivacyOption.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m3920a());
        parcel.writeByte((byte) (m3923j() ? 1 : 0));
        parcel.writeLong(m3924k());
        parcel.writeValue(m3925l());
    }
}
