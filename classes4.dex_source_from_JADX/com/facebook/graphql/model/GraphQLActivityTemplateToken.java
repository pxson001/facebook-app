package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLActivityTemplateTokenType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: user turned off master setting */
public final class GraphQLActivityTemplateToken extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLActivityTemplateToken> CREATOR = new C00431();
    public int f437d;
    public GraphQLActivityTemplateTokenType f438e;

    /* compiled from: user turned off master setting */
    final class C00431 implements Creator<GraphQLActivityTemplateToken> {
        C00431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLActivityTemplateToken(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLActivityTemplateToken[i];
        }
    }

    @FieldOffset
    public final int m735a() {
        a(0, 0);
        return this.f437d;
    }

    @FieldOffset
    public final GraphQLActivityTemplateTokenType m739j() {
        this.f438e = (GraphQLActivityTemplateTokenType) super.a(this.f438e, 1, GraphQLActivityTemplateTokenType.class, GraphQLActivityTemplateTokenType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f438e;
    }

    public final int jK_() {
        return -400689488;
    }

    public final GraphQLVisitableModel m737a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLActivityTemplateToken() {
        super(3);
    }

    public final void m738a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f437d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m736a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, m735a(), 0);
        flatBufferBuilder.a(1, m739j() == GraphQLActivityTemplateTokenType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m739j());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLActivityTemplateToken(Parcel parcel) {
        super(3);
        this.f437d = parcel.readInt();
        this.f438e = GraphQLActivityTemplateTokenType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m735a());
        parcel.writeString(m739j().name());
    }

    public GraphQLActivityTemplateToken(Builder builder) {
        super(3);
        this.b = builder.a;
        this.c = builder.b;
        this.f437d = builder.d;
        this.f438e = builder.e;
    }
}
