package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces$DefaultNamePartFields;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: save_to_facebook */
public final class GraphQLNamePart extends BaseModel implements TypeModel, CommonGraphQL2Interfaces$DefaultNamePartFields, GraphQLVisitableModel {
    public static final Creator<GraphQLNamePart> CREATOR = new C01381();
    public int f2986d;
    public int f2987e;
    public GraphQLStructuredNamePart f2988f;

    /* compiled from: save_to_facebook */
    final class C01381 implements Creator<GraphQLNamePart> {
        C01381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNamePart(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNamePart[i];
        }
    }

    @FieldOffset
    public final int mo139a() {
        a(0, 0);
        return this.f2986d;
    }

    @FieldOffset
    public final int t_() {
        a(0, 1);
        return this.f2987e;
    }

    @FieldOffset
    public final GraphQLStructuredNamePart mo140c() {
        this.f2988f = (GraphQLStructuredNamePart) super.a(this.f2988f, 2, GraphQLStructuredNamePart.class, GraphQLStructuredNamePart.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f2988f;
    }

    public final int jK_() {
        return 1905097022;
    }

    public final GraphQLVisitableModel m3243a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLNamePart() {
        super(4);
    }

    public final void m3244a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f2986d = mutableFlatBuffer.a(i, 0, 0);
        this.f2987e = mutableFlatBuffer.a(i, 1, 0);
    }

    public final int m3242a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, mo139a(), 0);
        flatBufferBuilder.a(1, t_(), 0);
        flatBufferBuilder.a(2, mo140c() == GraphQLStructuredNamePart.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : mo140c());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNamePart(Parcel parcel) {
        super(4);
        this.f2986d = parcel.readInt();
        this.f2987e = parcel.readInt();
        this.f2988f = GraphQLStructuredNamePart.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mo139a());
        parcel.writeInt(t_());
        parcel.writeString(mo140c().name());
    }
}
